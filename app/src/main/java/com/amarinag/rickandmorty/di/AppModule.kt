package com.amarinag.rickandmorty.di

import com.amarinag.data.source.CharacterRemoteDataSource
import com.amarinag.domain.AppDispatchers
import com.amarinag.rickandmorty.data.network.RickAndMortyService
import com.amarinag.rickandmorty.data.source.RickAndMortyCharacterRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideAppDispatchers(): AppDispatchers = AppDispatchers()

    @Singleton
    @Provides
    fun provideCharacterRemoteDataSource(
        rickAndMortyService: RickAndMortyService,
        appDispatchers: AppDispatchers
    ): CharacterRemoteDataSource =
        RickAndMortyCharacterRemoteDataSource(rickAndMortyService, appDispatchers)

}