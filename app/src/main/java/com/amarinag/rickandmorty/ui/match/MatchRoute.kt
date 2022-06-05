package com.amarinag.rickandmorty.ui.match

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun MatchRoute(
    matchViewModel: MatchViewModel,
    windowSize: WindowWidthSizeClass
) {
    val uiState by matchViewModel.uiState.collectAsState()
    when (windowSize) {
        WindowWidthSizeClass.Compact,
        WindowWidthSizeClass.Medium,
        WindowWidthSizeClass.Expanded -> {
            MatchDetail(uiState)
        }
    }
}