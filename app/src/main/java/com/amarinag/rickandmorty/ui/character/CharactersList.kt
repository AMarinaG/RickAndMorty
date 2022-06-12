package com.amarinag.rickandmorty.ui.character

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.amarinag.rickandmorty.ui.component.error.ErrorGeneric

@Composable
fun CharactersList(uiState: CharacterViewModel.UiState) {
    if (uiState.throwable != null) {
        ErrorGeneric(throwable = uiState.throwable)
    } else {
        LazyColumn(Modifier.fillMaxSize()) {
            items(uiState.characters ?: emptyList()) { character ->
                CharacterCardRow(characterUiState = character)
            }
        }
    }
}