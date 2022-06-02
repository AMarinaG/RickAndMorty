package com.amarinag.rickandmorty.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.amarinag.rickandmorty.ui.character.CharacterRoute
import com.amarinag.rickandmorty.ui.character.CharacterViewModel

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
            val vm: CharacterViewModel =
                ViewModelProvider { ViewModelStore() }.get(CharacterViewModel::class.java)
            CharacterRoute(characterViewModel = vm, windowSize = windowSize)
        }
    }
}