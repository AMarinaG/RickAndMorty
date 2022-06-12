package com.amarinag.rickandmorty.di

import com.amarinag.data.source.CharacterRemoteDataSource
import com.amarinag.domain.AppDispatchers
import com.amarinag.data.repository.CharacterRepository
import com.amarinag.data.repository.CharacterRepositoryImpl
import com.amarinag.rickandmorty.data.network.RickAndMortyService
import com.amarinag.rickandmorty.data.source.RickAndMortyCharacterRemoteDataSource
import com.amarinag.rickandmorty.ui.navigation.NavigationManager
import com.amarinag.rickandmorty.ui.navigation.RickAndMortyNavigationManager
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
    fun provideNavigationManager(): NavigationManager = RickAndMortyNavigationManager()

    @Singleton
    @Provides
    fun provideCharacterRemoteDataSource(
        rickAndMortyService: RickAndMortyService,
        appDispatchers: AppDispatchers
    ): CharacterRemoteDataSource =
        RickAndMortyCharacterRemoteDataSource(rickAndMortyService, appDispatchers)

    @Singleton
    @Provides
    fun provideCharacterRepository(
        appDispatchers: AppDispatchers,
        characterRemoteDataSource: CharacterRemoteDataSource
    ): CharacterRepository = CharacterRepositoryImpl(appDispatchers, characterRemoteDataSource)
}