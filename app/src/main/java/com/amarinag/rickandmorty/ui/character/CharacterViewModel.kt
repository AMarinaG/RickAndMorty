package com.amarinag.rickandmorty.ui.character

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amarinag.domain.model.Character
import com.amarinag.usecase.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {
    private val _uiState: MutableStateFlow<CharactersUiState> =
        MutableStateFlow(CharactersUiState(true))
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val response = getCharactersUseCase()
            Log.d("AMG", "response: $response")
            response.fold(::onSuccess, ::onFailure)
        }
    }

    private fun onSuccess(characters: List<Character>?) {
        _uiState.update {
            it.copy(loading = false, error = null, characters = characters)
        }
    }

    private fun onFailure(throwable: Throwable) {
        _uiState.update {
            it.copy(loading = false, error = throwable.localizedMessage, characters = null)
        }
    }

    data class CharactersUiState(
        val loading: Boolean = false,
        val error: String? = null,
        val characters: List<Character>? = null
    )
}