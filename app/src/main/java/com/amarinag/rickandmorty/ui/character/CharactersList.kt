package com.amarinag.rickandmorty.ui.character

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.amarinag.domain.model.Character
import com.amarinag.rickandmorty.ui.theme.spacing

@Composable
fun CharactersList() {
    val fakeCharacters = List(100) { Character(it, "Character #$it", "Species #it", "type #$it") }
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(MaterialTheme.spacing.normal)
    ) {
        items(fakeCharacters) { character ->
            CharacterCardRow(character = character)
        }
    }
}