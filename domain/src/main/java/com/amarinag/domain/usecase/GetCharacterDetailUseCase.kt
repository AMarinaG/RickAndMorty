package com.amarinag.domain.usecase

import com.amarinag.domain.AppDispatchers
import com.amarinag.domain.repository.CharacterRepository
import kotlinx.coroutines.withContext


class GetCharacterDetailUseCase(
    private val appDispatchers: AppDispatchers,
    private val characterRepository: CharacterRepository
) {
    suspend fun invoke(characterId: Int) = withContext(appDispatchers.default) {
        characterRepository.getCharacterById(characterId)
    }
}