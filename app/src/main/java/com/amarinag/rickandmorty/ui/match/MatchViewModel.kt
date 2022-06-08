package com.amarinag.rickandmorty.ui.match

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amarinag.domain.model.Character
import com.amarinag.rickandmorty.ui.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchViewModel @Inject constructor(
    private val stateHandle: SavedStateHandle,
    navigationManager: NavigationManager
) : ViewModel(), NavigationManager by navigationManager {
    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            stateHandle.get<Int>("characterId")?.let {
                Log.d("AMG", "CharacterId: $it")
            } ?: _uiState.update { UiState(hasError = true) }
            delay(5000)
            _uiState.update {
                it.copy(
                    loading = false,
                    characterSelected = Character(
                        1,
                        "Rick",
                        "Species",
                        "Type",
                        "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
                    )
                )
            }
            delay(3000)
            _uiState.update {
                it.copy(
                    loading = false,
                    characterMatched = Character(
                        2,
                        "Morty Smith",
                        "Species",
                        "Type",
                        "https://rickandmortyapi.com/api/character/avatar/2.jpeg"
                    ),
                    matchDate = "matchDate",
                    matchLocation = "matchLocation",
                    matchSharedEpisodes = "matchSharedEpisodes",
                    lastEpisodeDate = "lastEpisodeDate"
                )
            }
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