package com.amarinag.rickandmorty.ui.navigation

import java.util.*

sealed interface RickAndMortyNavigationState {
    object Idle : RickAndMortyNavigationState
    data class NavigationToRoute(
        val direction: NavigationCommand,
        val id: UUID = UUID.randomUUID()
    ) : RickAndMortyNavigationState
}
