package com.amarinag.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.amarinag.rickandmorty.ui.RickAndMortyApp
import com.amarinag.rickandmorty.ui.navigation.NavigationManager
import com.amarinag.rickandmorty.ui.theme.RickAndMortyTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navigationManager: NavigationManager

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyTheme {
                val windowSize = calculateWindowSizeClass(this)
                RickAndMortyApp(
                    windowSize = windowSize.widthSizeClass,
                    navigationManager = navigationManager
                )
            }
        }
    }

}