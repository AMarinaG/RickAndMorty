package com.amarinag.rickandmorty.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.amarinag.rickandmorty.data.db.dao.CharacterDao
import com.amarinag.rickandmorty.data.db.entity.LocalCharacter

@Database(entities = [LocalCharacter::class], version = 1)
@TypeConverters(EpisodesConverter::class)
abstract class RickAndMortyDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}