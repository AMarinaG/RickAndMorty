package com.amarinag.domain.usecase

import com.amarinag.domain.AppDispatchers
import com.amarinag.domain.model.CharacterWithMatch
import com.amarinag.domain.repository.CharacterRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class GetMatchCharacterUseCase(
    private val appDispatchers: AppDispatchers,
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(characterId: Int): Flow<CharacterWithMatch> =
        withContext(appDispatchers.default) {
            flow {
                val response = characterRepository.getCharacterById(characterId = characterId)
                response
                    .onSuccess {
                        val model = CharacterWithMatch(character = it, match = null)
                        emit(model)
                        val matchResponse = characterRepository.findMatchCharacter(it)
                        matchResponse
                            .onSuccess { matchCharacter -> emit(model.copy(match = matchCharacter)) }
                            .onFailure { th -> emit(model.copy(throwable = th)) }
                    }.onFailure {
                        cancel(CancellationException("Pum"))
                    }

            }
        }

}