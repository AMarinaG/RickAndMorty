package com.amarinag.rickandmorty.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.amarinag.rickandmorty.ui.character.CharacterRoute
import com.amarinag.rickandmorty.ui.character.CharacterViewModel
import com.amarinag.rickandmorty.ui.match.MatchRoute
import com.amarinag.rickandmorty.ui.match.MatchViewModel
import com.amarinag.rickandmorty.ui.navigation.RickAndMortyDestinations

@Composable
fun RickAndMortyNavGraph(
    navController: NavHostController,
    windowSize: WindowWidthSizeClass
) {
    val uri = "amg://rickandmorty"
    NavHost(
        navController = navController,
        startDestination = RickAndMortyDestinations.CHARACTER_ROUTE
    ) {
        composable(RickAndMortyDestinations.CHARACTER_ROUTE) {
            val vm: CharacterViewModel = hiltViewModel()
            CharacterRoute(characterViewModel = vm, windowSize = windowSize)
        }
        composable(
            "${RickAndMortyDestinations.MATCH_ROUTE}/{characterId}",
            arguments = listOf(navArgument("characterId") { type = NavType.IntType }),
            deepLinks = listOf(navDeepLink {
                uriPattern =
                    "$uri/${RickAndMortyDestinations.MATCH_ROUTE}/{characterId}"
            })
        ) {
            val vm: MatchViewModel = hiltViewModel()
            MatchRoute(matchViewModel = vm, windowSize = windowSize)
        }
    }
}