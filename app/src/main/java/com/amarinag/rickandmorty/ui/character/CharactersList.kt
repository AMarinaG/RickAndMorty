package com.amarinag.rickandmorty.ui.character

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.amarinag.rickandmorty.ui.theme.spacing

@Composable
fun CharactersList(uiState: CharacterViewModel.CharactersUiState) {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(MaterialTheme.spacing.normal)
    ) {
        items(uiState.characters ?: emptyList()) { character ->
            CharacterCardRow(character = character)
        }
    }
}