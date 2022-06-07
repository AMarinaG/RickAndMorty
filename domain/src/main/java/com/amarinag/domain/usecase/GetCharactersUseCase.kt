package com.amarinag.domain.usecase

import com.amarinag.domain.AppDispatchers
import com.amarinag.domain.model.Character
import com.amarinag.domain.repository.CharacterRepository
import kotlinx.coroutines.withContext

class GetCharactersUseCase(
    private val appDispatchers: AppDispatchers,
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(): Result<List<Character>> = withContext(appDispatchers.default) {
        characterRepository.getAll()
    }
}