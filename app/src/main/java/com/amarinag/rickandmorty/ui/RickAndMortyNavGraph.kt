package com.amarinag.rickandmorty.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RickAndMortyNavGraph(navigationActions: RickAndMortyActions, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = RickAndMortyDestinations.CHARACTER_ROUTE
    ) {
        composable(RickAndMortyDestinations.CHARACTER_ROUTE) {
            Text(text = "Estamos en 'Character'")
        }
    }
}