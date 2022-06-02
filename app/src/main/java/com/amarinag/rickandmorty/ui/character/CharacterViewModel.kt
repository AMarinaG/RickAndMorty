package com.amarinag.rickandmorty.ui.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amarinag.domain.model.Character
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<CharactersUiState> =
        MutableStateFlow(CharactersUiState(true))
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            delay(5000)
            _uiState.update {
                it.copy(
                    loading = false,
                    characters = List(100) { index ->
                        Character(
                            index,
                            "Character #$index",
                            "Species #it",
                            "type #$index"
                        )
                    })
            }

        }
    }

    data class CharactersUiState(
        val loading: Boolean = false,
        val error: String? = null,
        val characters: List<Character>? = null
    )
}