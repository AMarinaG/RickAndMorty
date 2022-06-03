package com.amarinag.rickandmorty.ui.character

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CharactersList(uiState: CharacterViewModel.CharactersUiState) {
    LazyColumn(Modifier.fillMaxSize()) {
        items(uiState.characters ?: emptyList()) { character ->
            CharacterCardRow(character = character)
        }
    }
}