package com.amarinag.rickandmorty.ui

import androidx.navigation.NavController

object RickAndMortyDestinations {
    const val CHARACTER_ROUTE = "character"
    const val MATCH_ROUTE = "match"
}

class RickAndMortyActions(navController: NavController) {
    val navigationToMatch: (Int) -> Unit = {
        navController.navigate("${RickAndMortyDestinations.MATCH_ROUTE}/$it")
    }
}