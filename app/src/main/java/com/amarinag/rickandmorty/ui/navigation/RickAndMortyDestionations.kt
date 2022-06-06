package com.amarinag.rickandmorty.ui.navigation

import androidx.navigation.NamedNavArgument

interface NavigationCommand {
    val destination: String
    val arguments: List<NamedNavArgument>

}

object RickAndMortyDestinations {
    const val CHARACTER_ROUTE = "character"
    const val MATCH_ROUTE = "match"

    val home = object : NavigationCommand {
        override val destination: String = CHARACTER_ROUTE
        override val arguments: List<NamedNavArgument> = emptyList()
    }

    fun match(characterId: Int) = object : NavigationCommand {
        override val destination: String = "$MATCH_ROUTE/$characterId"
        override val arguments: List<NamedNavArgument> = emptyList()

    }
}
