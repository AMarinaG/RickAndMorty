package com.amarinag.data.repository

import com.amarinag.data.source.CharacterLocalDataSource
import com.amarinag.data.source.CharacterRemoteDataSource
import com.amarinag.domain.AppDispatchers
import com.amarinag.domain.model.Character
import com.amarinag.error.NoMatchException
import com.amarinag.error.NotFoundCharactersException
import kotlinx.coroutines.withContext

class CharacterRepositoryImpl(
    private val appDispatchers: AppDispatchers,
    private val characterRemoteDataSource: CharacterRemoteDataSource,
    private val characterLocalDataSource: CharacterLocalDataSource
) : CharacterRepository {
    override suspend fun getAll(): Result<List<Character>> = withContext(appDispatchers.default) {
        characterRemoteDataSource.getCharacter().apply {
            characterLocalDataSource.saveCharacters(getOrNull() ?: emptyList())
        }
    }

    override suspend fun getCharacterById(characterId: Int): Result<Character> =
        withContext(appDispatchers.default) {
            characterLocalDataSource.getCharacterById(characterId)
        }

    override suspend fun findMatchCharacter(character: Character): Result<Character> =
        withContext(appDispatchers.default) {
            val allCharacter = characterRemoteDataSource.getCharacter().getOrNull()
            val seq = allCharacter?.asSequence() ?: kotlin.run {
                return@withContext Result.failure(NotFoundCharactersException)
            }
            val matchedCharacter = seq
                .filter {
                    it.id != character.id
                }
                .filter {
                    it.locationName == character.locationName
                }.filter {
                    val matchEpisode = allCharacter.calculateSharedEpisodes(it)
                    matchEpisode?.firstCharacter == it || matchEpisode?.secondCharacter == it
                }
                .sortedBy { it.id }
                .firstOrNull()
            matchedCharacter?.let {
                Result.success(it)
            } ?: Result.failure(NoMatchException(character.id, character.name))
        }

    override suspend fun getByQueryFilter(query: String): Result<List<Character>> =
        withContext(appDispatchers.default) {
            characterLocalDataSource.getByQueryFilter(query)
        }

    private fun List<Character>?.calculateSharedEpisodes(character: Character): SharedEpisodesByCharacter? {
        val allCharacters = this
        val sharedEpisodes = mutableListOf<SharedEpisodesByCharacter>()
        allCharacters?.groupBy { first ->
            allCharacters.filter { second -> first.id < second.id }.apply {
                println("first: ${first.id} <> second: ${this.map { it.id }.joinToString(",")}")
            }.groupBy(keySelector = {
                val s: List<String> = (it.episode ?: emptyList()) + (first.episode ?: emptyList())
                s.groupingBy { g -> g }.eachCount().values.count { ss -> ss == 2 }
            }, valueTransform = { first to it })
                .filter { it.key != 0 }
                .maxByOrNull { it.key }.apply {
                    println("lucky: $this")
                    this?.value?.forEach { pair ->
                        sharedEpisodes.add(
                            SharedEpisodesByCharacter(
                                pair.first,
                                pair.second,
                                this.key
                            )
                        )

                    }
                }
        }
        println("Character: ${sharedEpisodes.map { "${it.totalShared} >> ${it.firstCharacter.id} >> ${it.secondCharacter.id}" }}")
        return sharedEpisodes
            .filter { it.firstCharacter.id == character.id || it.secondCharacter.id == character.id }
            .maxByOrNull { it.totalShared }
//            .map { if (it.firstCharacter.id == character.id) it.firstCharacter else it.secondCharacter }
    }
}

data class SharedEpisodesByCharacter(
    val firstCharacter: Character,
    val secondCharacter: Character,
    val totalShared: Int
)