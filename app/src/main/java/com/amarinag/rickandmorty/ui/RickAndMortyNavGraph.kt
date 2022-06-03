package com.amarinag.rickandmorty.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.amarinag.rickandmorty.ui.character.CharacterRoute
import com.amarinag.rickandmorty.ui.character.CharacterViewModel
import com.amarinag.rickandmorty.ui.match.MatchRoute

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
            val vm: CharacterViewModel = hiltViewModel()
            CharacterRoute(characterViewModel = vm, windowSize = windowSize)
        }
        composable(RickAndMortyDestinations.MATCH_ROUTE) {
            val vm: CharacterViewModel = hiltViewModel()
            MatchRoute(windowSize = windowSize)
        }
    }
}