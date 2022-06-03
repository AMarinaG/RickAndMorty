package com.amarinag.rickandmorty.di

import com.amarinag.domain.AppDispatchers
import com.amarinag.repository.CharacterRepository
import com.amarinag.usecase.GetCharactersUseCase
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
    ): GetCharactersUseCase =
        GetCharactersUseCase(appDispatchers, characterRepository)
}