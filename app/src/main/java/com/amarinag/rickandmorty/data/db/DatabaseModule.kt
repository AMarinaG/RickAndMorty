package com.amarinag.rickandmorty.data.db

import android.content.Context
import androidx.room.Room
import com.amarinag.rickandmorty.data.db.dao.CharacterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context): RickAndMortyDatabase =
        Room.databaseBuilder(context, RickAndMortyDatabase::class.java, "rick-and-morty.db").build()

    @Provides
    @Singleton
    fun provideCharacterDao(database: RickAndMortyDatabase): CharacterDao = database.characterDao()


}