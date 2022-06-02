package com.amarinag.rickandmorty.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RickAndMortyApp(windowSize: WindowWidthSizeClass) {
    when (windowSize) {
        WindowWidthSizeClass.Compact,
        WindowWidthSizeClass.Medium,
        WindowWidthSizeClass.Expanded -> {
            //add navigation
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Text("Android")
            }
        }
    }

}