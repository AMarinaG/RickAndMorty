package com.amarinag.rickandmorty.ui.character

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun CharacterRoute(characterViewModel: CharacterViewModel, windowSize: WindowWidthSizeClass) {
    val uiState by characterViewModel.uiState.collectAsState()
    when (windowSize) {
        WindowWidthSizeClass.Compact,
        WindowWidthSizeClass.Medium -> {
            CharactersList(uiState)
        }
        else -> {
            CharactersGrid(uiState)
        }
    }
}