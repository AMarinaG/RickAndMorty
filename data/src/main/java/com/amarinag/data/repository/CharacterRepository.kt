package com.amarinag.data.repository

import com.amarinag.data.source.CharacterRemoteDataSource
import com.amarinag.domain.AppDispatchers
import com.amarinag.domain.model.Character
import com.amarinag.error.NoMatchException
import com.amarinag.error.NotFoundCharactersException
import kotlinx.coroutines.withContext

class CharacterRepositoryImpl(
    private val appDispatchers: AppDispatchers,
    private val characterRemoteDataSource: CharacterRemoteDataSource
) : CharacterRepository {
    override suspend fun getAll(): Result<List<Character>> = withContext(appDispatchers.default) {
        characterRemoteDataSource.getCharacter()
    }

    override suspend fun getCharacterById(characterId: Int): Result<Character> =
        withContext(appDispatchers.default) {
            characterRemoteDataSource.getCharacterById(characterId)
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
                }
                .sortedBy { it.id }
                .firstOrNull()
            matchedCharacter?.let {
                Result.success(it)
            } ?: Result.failure(NoMatchException(character.id, character.name))
        }

}