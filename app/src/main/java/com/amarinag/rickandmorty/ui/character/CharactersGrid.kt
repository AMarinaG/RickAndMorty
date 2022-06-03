package com.amarinag.rickandmorty.ui.character

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

private const val GridCount = 5

@Composable
fun CharactersGrid(uiState: CharacterViewModel.CharactersUiState) {
    LazyVerticalGrid(columns = GridCells.Fixed(GridCount), modifier = Modifier.fillMaxSize()) {
        items(uiState.characters ?: emptyList()) { character ->
            CharacterCardGrid(character = character)
        }
    }
}