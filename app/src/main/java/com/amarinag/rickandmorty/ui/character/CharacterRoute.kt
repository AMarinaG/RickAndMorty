package com.amarinag.rickandmorty.ui.character

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.amarinag.rickandmorty.ui.component.LoadingContent
import com.amarinag.rickandmorty.ui.component.SearchTopBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterRoute(characterViewModel: CharacterViewModel, windowSize: WindowWidthSizeClass) {
    val uiState by characterViewModel.uiState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val (showSearch, onShowSearch) = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            SearchTopBar(
                showSearch = showSearch,
                onShowSearch = onShowSearch,
                onExitSearchMode = {
                    coroutineScope.launch { characterViewModel.getAll() }
                },
                onSearch = { coroutineScope.launch { characterViewModel.query(it) } },
            )
        }
    ) { padding ->
        LoadingContent(loading = uiState.loading, Modifier.padding(padding)) {
            when (windowSize) {
                WindowWidthSizeClass.Compact,
                WindowWidthSizeClass.Medium -> {
                    CharactersList(uiState)
                }
                else -> {
                    CharactersGrid(uiState)
                }
            }
        }
    }
}