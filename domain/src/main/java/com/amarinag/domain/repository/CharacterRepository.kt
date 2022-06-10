package com.amarinag.domain.repository

import com.amarinag.domain.model.Character

interface CharacterRepository {
    suspend fun getAll(): Result<List<Character>>
    suspend fun getCharacterById(characterId: Int): Result<Character>
    suspend fun findMatchCharacter(character: Character): Result<Character>
}
