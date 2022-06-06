package com.amarinag.rickandmorty.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.amarinag.rickandmorty.ui.navigation.NavigationManager
import com.amarinag.rickandmorty.ui.navigation.RickAndMortyNavigationState

@Composable
fun RickAndMortyApp(windowSize: WindowWidthSizeClass, navigationManager: NavigationManager) {
    val navController = rememberNavController()
    LaunchedEffect(key1 = "navigation") {
        navigationManager.navState.collect {
            updateNavigationState(navController, it)
        }
    }

    when (windowSize) {
        WindowWidthSizeClass.Compact,
        WindowWidthSizeClass.Medium,
        WindowWidthSizeClass.Expanded -> {
            //add navigation
            RickAndMortyNavGraph(
                navController = navController,
                windowSize = windowSize
            )
        }
    }

}

private fun updateNavigationState(
    navController: NavHostController,
    navState: RickAndMortyNavigationState
) {
    when (navState) {
        RickAndMortyNavigationState.Idle -> {}
        is RickAndMortyNavigationState.NavigationToRoute -> {
            navController.navigate(navState.direction.destination)
        }
    }
}

