package com.amarinag.rickandmorty.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.amarinag.rickandmorty.ui.character.CharacterRoute

@Composable
fun RickAndMortyNavGraph(
    navigationActions: RickAndMortyActions,
    navController: NavHostController,
    windowSize: WindowWidthSizeClass
) {
    NavHost(
        navController = navController,
        startDestination = RickAndMortyDestinations.CHARACTER_ROUTE
    ) {
        composable(RickAndMortyDestinations.CHARACTER_ROUTE) {
            CharacterRoute(windowSize = windowSize)
        }
    }
}