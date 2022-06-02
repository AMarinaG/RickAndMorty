package com.amarinag.rickandmorty.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController

@Composable
fun RickAndMortyApp(windowSize: WindowWidthSizeClass) {
    val navController = rememberNavController()
    val navigationActions = remember(navController) {
        RickAndMortyActions(navController)
    }
    when (windowSize) {
        WindowWidthSizeClass.Compact,
        WindowWidthSizeClass.Medium,
        WindowWidthSizeClass.Expanded -> {
            //add navigation
            RickAndMortyNavGraph(
                navController = navController,
                navigationActions = navigationActions
            )
        }
    }

}