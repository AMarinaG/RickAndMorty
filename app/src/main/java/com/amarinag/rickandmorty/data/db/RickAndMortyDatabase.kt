package com.amarinag.rickandmorty.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amarinag.rickandmorty.data.db.dao.CharacterDao
import com.amarinag.rickandmorty.data.db.entity.LocalCharacter

@Database(entities = [LocalCharacter::class], version = 1)
abstract class RickAndMortyDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}