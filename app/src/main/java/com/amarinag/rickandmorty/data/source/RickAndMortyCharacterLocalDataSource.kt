package com.amarinag.rickandmorty.data.source

import com.amarinag.data.source.CharacterLocalDataSource
import com.amarinag.domain.AppDispatchers
import com.amarinag.domain.model.Character
import com.amarinag.error.DatabaseException
import com.amarinag.rickandmorty.data.db.dao.CharacterDao
import com.amarinag.rickandmorty.data.db.entity.toDomain
import com.amarinag.rickandmorty.data.db.entity.toEntity
import kotlinx.coroutines.withContext

class RickAndMortyCharacterLocalDataSource(
    private val characterDao: CharacterDao,
    private val appDispatchers: AppDispatchers
) : CharacterLocalDataSource {
    override suspend fun getCharacter(): Result<List<Character>> = withContext(appDispatchers.io) {
        try {
            val response = characterDao.getAll()
            Result.success(response.toDomain())
        } catch (ex: Exception) {
            Result.failure(DatabaseException)
        }
    }

    override suspend fun getCharacterById(characterId: Int): Result<Character> =
        withContext(appDispatchers.io) {
            try {
                val response = characterDao.getCharacterById(characterId)
                Result.success(response.toDomain())
            } catch (ex: Exception) {
                Result.failure(DatabaseException)
            }
        }

    override suspend fun saveCharacters(characters: List<Character>) {
        characterDao.insertAll(characters.toEntity())
    }
}