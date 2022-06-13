package com.amarinag.rickandmorty.di

import com.amarinag.data.repository.CharacterRepository
import com.amarinag.domain.AppDispatchers
import com.amarinag.domain.usecase.GetCharacterByQueryFilterUseCase
import com.amarinag.domain.usecase.GetCharacterDetailUseCase
import com.amarinag.domain.usecase.GetCharactersUseCase
import com.amarinag.domain.usecase.GetMatchCharacterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {
    @Provides
    @ViewModelScoped
    fun provideGetCharactersUseCase(
        appDispatchers: AppDispatchers,
        characterRepository: CharacterRepository
    ): GetCharactersUseCase = GetCharactersUseCase(appDispatchers, characterRepository)

    @Provides
    @ViewModelScoped
    fun provideGetCharacterDetailUseCase(
        appDispatchers: AppDispatchers,
        characterRepository: CharacterRepository
    ): GetCharacterDetailUseCase = GetCharacterDetailUseCase(appDispatchers, characterRepository)

    @Provides
    @ViewModelScoped
    fun provideGetMatchCharacterUseCase(
        appDispatchers: AppDispatchers,
        characterRepository: CharacterRepository
    ): GetMatchCharacterUseCase = GetMatchCharacterUseCase(appDispatchers, characterRepository)

    @Provides
    @ViewModelScoped
    fun provideGetCharacterByQueryFilterUseCase(
        appDispatchers: AppDispatchers,
        characterRepository: CharacterRepository
    ): GetCharacterByQueryFilterUseCase =
        GetCharacterByQueryFilterUseCase(appDispatchers, characterRepository)
}