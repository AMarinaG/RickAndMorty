package com.amarinag.repository

import com.amarinag.data.source.CharacterRemoteDataSource
import com.amarinag.domain.AppDispatchers
import com.amarinag.domain.model.Character
import kotlinx.coroutines.withContext

interface CharacterRepository {
    suspend fun getAll(): Result<List<Character>>
}

class CharacterRepositoryImpl(
    private val appDispatchers: AppDispatchers,
    private val characterRemoteDataSource: CharacterRemoteDataSource
) : CharacterRepository {
    override suspend fun getAll(): Result<List<Character>> = withContext(appDispatchers.default) {
        characterRemoteDataSource.getCharacter()
    }

}