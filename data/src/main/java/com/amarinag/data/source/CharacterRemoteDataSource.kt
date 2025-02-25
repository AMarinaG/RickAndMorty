package com.amarinag.data.source

import com.amarinag.domain.model.Character

interface CharacterRemoteDataSource {
    suspend fun getCharacter(): Result<List<Character>>
    suspend fun getCharacterById(characterId: Int): Result<Character>
}