package com.amarinag.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.amarinag.rickandmorty.ui.RickAndMortyApp
import com.amarinag.rickandmorty.ui.theme.RickAndMortyTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyTheme {
                val windowSize = calculateWindowSizeClass(this)
                RickAndMortyApp(windowSize.widthSizeClass)
            }
        }
    }

}