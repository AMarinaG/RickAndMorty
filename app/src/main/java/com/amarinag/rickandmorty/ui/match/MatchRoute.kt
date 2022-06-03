package com.amarinag.rickandmorty.ui.match

import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable

@Composable
fun MatchRoute(windowSize: WindowWidthSizeClass) {
    when (windowSize) {
        WindowWidthSizeClass.Compact,
        WindowWidthSizeClass.Medium -> {
            Text(text = "Match Medium Size")
        }
        else -> {
            Text(text = "Match Expanded Size")
        }
    }
}