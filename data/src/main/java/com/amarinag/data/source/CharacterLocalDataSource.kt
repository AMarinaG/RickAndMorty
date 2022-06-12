package com.amarinag.data.source

import com.amarinag.domain.model.Character

interface CharacterLocalDataSource {
    suspend fun getCharacter(): Result<List<Character>>
    suspend fun getCharacterById(characterId: Int): Result<Character>
    suspend fun saveCharacters(characters: List<Character>)
}