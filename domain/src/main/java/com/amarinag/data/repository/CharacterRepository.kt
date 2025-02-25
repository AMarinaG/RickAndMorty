package com.amarinag.data.repository

import com.amarinag.domain.model.Character

interface CharacterRepository {
    suspend fun getAll(): Result<List<Character>>
    suspend fun getCharacterById(characterId: Int): Result<Character>
    suspend fun findMatchCharacter(character: Character): Result<Character>
    suspend fun getByQueryFilter(query: String): Result<List<Character>>
}
