package com.amarinag.rickandmorty.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.amarinag.rickandmorty.data.db.entity.LocalCharacter

@Dao
interface CharacterDao {
    @Query("SELECT * FROM character")
    suspend fun getAll(): List<LocalCharacter>

    @Query("SELECT * FROM character WHERE id = :characterId")
    suspend fun getCharacterById(characterId: Int): LocalCharacter

    @Query("SELECT * FROM character WHERE name LIKE :query")
    suspend fun filterByQuery(query: String): List<LocalCharacter>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(characters: List<LocalCharacter>)
}