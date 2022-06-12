package com.amarinag.rickandmorty.data.source

import com.amarinag.data.source.CharacterRemoteDataSource
import com.amarinag.domain.AppDispatchers
import com.amarinag.domain.model.Character
import com.amarinag.error.NetworkException
import com.amarinag.error.ResponseErrorException
import com.amarinag.rickandmorty.data.network.RickAndMortyService
import com.amarinag.rickandmorty.data.network.model.toDomain
import kotlinx.coroutines.withContext

class RickAndMortyCharacterRemoteDataSource(
    private val rickAndMortyService: RickAndMortyService,
    private val appDispatchers: AppDispatchers
) : CharacterRemoteDataSource {
    override suspend fun getCharacter(): Result<List<Character>> = withContext(appDispatchers.io) {
        try {
            val response = rickAndMortyService.getCharacters()
            response.results?.let {
                Result.success(it.toDomain())
            } ?: Result.failure(ResponseErrorException)
        } catch (ex: Exception) {
            Result.failure(NetworkException(ex.localizedMessage, ex))
        }
    }

    override suspend fun getCharacterById(characterId: Int): Result<Character> =
        withContext(appDispatchers.io) {
            try {
                val response = rickAndMortyService.getCharactersById(characterId)
                Result.success(response.toDomain())
            } catch (ex: Exception) {
                Result.failure(NetworkException(ex.localizedMessage, ex))
            }
        }
}