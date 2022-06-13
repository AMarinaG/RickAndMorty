package com.amarinag.rickandmorty.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SearchTopBar(
    showSearch: Boolean,
    onShowSearch: (Boolean) -> Unit,
    onSearch: (String) -> Unit,
    onExitSearchMode: () -> Unit,
    modifier: Modifier = Modifier
) {
    val (value, onValueChange) = remember { mutableStateOf("") }
    AnimatedVisibility(
        visible = showSearch,
        enter = slideInVertically(),
        exit = shrinkVertically(shrinkTowards = Alignment.Top) { 0 }
    ) {
        SearchView(
            value = value,
            onValueChange = onValueChange,
            onExitSearchMode = {
                onValueChange("")
                onShowSearch(showSearch.not())
                onExitSearchMode()
            },
            onSearch = { onSearch(it) }
        )
    }
    AnimatedVisibility(
        visible = showSearch.not(),
        enter = slideInVertically(),
        exit = shrinkVertically(shrinkTowards = Alignment.Top) { 0 }
    ) {
        CenterAlignedTopAppBar(
            title = { Text(text = "Rick And Morty") },
            modifier = modifier,
            actions = {
                IconButton(onClick = { onShowSearch(showSearch.not()) }) {
                    Icon(Icons.Default.Search, contentDescription = "Search Action")
                }
            })
    }
}
