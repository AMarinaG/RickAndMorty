package com.amarinag.rickandmorty.ui.character

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amarinag.domain.model.Character
import com.amarinag.domain.usecase.GetCharactersUseCase
import com.amarinag.rickandmorty.ui.navigation.NavigationManager
import com.amarinag.rickandmorty.ui.navigation.RickAndMortyDestinations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    navigationManager: NavigationManager
) : ViewModel(), NavigationManager by navigationManager {
    private val _uiState: MutableStateFlow<UiState> =
        MutableStateFlow(UiState(true))
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
            it.copy(
                loading = false,
                throwable = null,
                characters = characters?.map { character -> character.toUiState() })

        }
    }

    private fun onFailure(throwable: Throwable) {
        _uiState.update {
            it.copy(loading = false, throwable = throwable, characters = null)
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val throwable: Throwable? = null,
        val characters: List<CharacterUiState>? = null
    )

    data class CharacterUiState(
        val character: Character,
        val onClick: (Int) -> Unit
    )

    private fun Character.toUiState() = CharacterUiState(this, onClick = {
        navigateToRoute(RickAndMortyDestinations.match(it))
    })
}