package com.amarinag.rickandmorty.ui.navigation

import androidx.annotation.VisibleForTesting
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

interface NavigationManager {
    val navState: SharedFlow<RickAndMortyNavigationState>
    fun navigateToRoute(destination: NavigationCommand)
}

class RickAndMortyNavigationManager : NavigationManager {
    private val _navState = MutableSharedFlow<RickAndMortyNavigationState>(extraBufferCapacity = 1)
    override val navState = _navState.asSharedFlow()

    override fun navigateToRoute(destination: NavigationCommand) {
        navigate(RickAndMortyNavigationState.NavigationToRoute(destination))
    }

    @VisibleForTesting
    fun navigate(navigationState: RickAndMortyNavigationState) {
        _navState.tryEmit(navigationState)
    }
}