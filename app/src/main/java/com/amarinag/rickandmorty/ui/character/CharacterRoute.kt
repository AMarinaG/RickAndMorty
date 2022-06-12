package com.amarinag.rickandmorty.ui.character

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.amarinag.rickandmorty.ui.component.LoadingContent

@Composable
fun CharacterRoute(characterViewModel: CharacterViewModel, windowSize: WindowWidthSizeClass) {
    val uiState by characterViewModel.uiState.collectAsState()
    LoadingContent(loading = uiState.loading, Modifier.fillMaxSize()) {
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
}