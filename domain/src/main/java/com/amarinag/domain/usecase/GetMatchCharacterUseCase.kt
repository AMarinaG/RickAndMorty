package com.amarinag.domain.usecase

import com.amarinag.domain.AppDispatchers
import com.amarinag.domain.model.Match
import com.amarinag.data.repository.CharacterRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class GetMatchCharacterUseCase(
    private val appDispatchers: AppDispatchers,
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(characterId: Int): Flow<Match> =
        withContext(appDispatchers.default) {
            flow {
                val response = characterRepository.getCharacterById(characterId = characterId)
                response
                    .onSuccess {
                        val model = Match(character = it, match = null)
                        emit(model)
                        val matchResponse = characterRepository.findMatchCharacter(it)
                        matchResponse
                            .onSuccess { matchCharacter ->
                                val matchLocation = matchCharacter.locationName
                                val allEp: List<String> =
                                    (it.episode ?: emptyList()) + (matchCharacter.episode
                                        ?: emptyList())
                                val groupingBy = (allEp).groupingBy { ep -> ep }.eachCount()
                                val sharedEpisodesList =
                                    groupingBy.filter { entry -> entry.value == 2 }
                                        .map { entry -> entry.key }
                                val sharedEpisodeCount = sharedEpisodesList.size
                                val metDate = "20220601"
                                val lastMetDate = "20250601"
                                emit(
                                    model.copy(
                                        match = matchCharacter,
                                        matchLocation = matchLocation,
                                        sharedEpisodeCount = sharedEpisodeCount,
                                        sharedEpisodesList = sharedEpisodesList,
                                        lastMetDate = lastMetDate,
                                        metDate = metDate
                                    )
                                )
                            }
                            .onFailure { th -> emit(model.copy(throwable = th)) }
                    }.onFailure {
                        cancel(CancellationException("Pum", it))
                    }

            }
        }

}