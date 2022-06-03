package com.amarinag.repository

import com.amarinag.domain.model.Character

interface CharacterRepository {
    suspend fun getAll(): Result<List<Character>>
}
