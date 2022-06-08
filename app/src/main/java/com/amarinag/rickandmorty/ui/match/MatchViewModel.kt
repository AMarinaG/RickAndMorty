package com.amarinag.rickandmorty.ui.match

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amarinag.domain.model.Character
import com.amarinag.domain.usecase.GetMatchCharacterUseCase
import com.amarinag.rickandmorty.ui.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchViewModel @Inject constructor(
    private val stateHandle: SavedStateHandle,
    private val getMatchCharacterUseCase: GetMatchCharacterUseCase,
    navigationManager: NavigationManager
) : ViewModel(), NavigationManager by navigationManager {
    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val characterId: Int? = stateHandle.get<Int>("characterId")
            if (characterId == null) {
                _uiState.update { it.copy(hasError = true) }
                return@launch
            }
            getMatchCharacterUseCase(characterId).map {
                _uiState.update { state ->
                    state.copy(
                        loading = false,
                        characterSelected = it.character,
                        characterMatched = it.match
                    )
                }
            }.collect()
        }
    }
}


data class UiState(
    val loading: Boolean = true,
    val characterSelected: Character? = null,
    val characterMatched: Character? = null,
    val matchLocation: String? = null,
    val matchSharedEpisodes: String? = null,
    val matchDate: String? = null,
    val lastEpisodeDate: String? = null,
    val hasError: Boolean = false
)