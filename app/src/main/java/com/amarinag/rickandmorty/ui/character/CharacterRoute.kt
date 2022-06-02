package com.amarinag.rickandmorty.ui.character

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable

@Composable
fun CharacterRoute(windowSize: WindowWidthSizeClass) {
    when (windowSize) {
        WindowWidthSizeClass.Compact,
        WindowWidthSizeClass.Medium -> {
            CharactersList()
        }
        else -> {
            CharactersGrid()
        }
    }
}