package com.amarinag.rickandmorty.ui.character

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.amarinag.domain.model.Character

@Composable
fun CharactersGrid() {
    val fakeCharacters = List(100) { Character(it, "Character #$it", "Species #it", "type #$it") }
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
        items(fakeCharacters) { character ->
            CharacterCardGrid(character = character)
        }
    }
}