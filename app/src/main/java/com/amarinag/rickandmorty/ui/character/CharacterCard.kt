package com.amarinag.rickandmorty.ui.character

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.amarinag.domain.model.Character

@Composable
fun CharacterCardRow(character: Character) {
    Row(Modifier.fillMaxWidth()) {
        Text(text = character.name)
        Text(text = character.species)
        Text(text = character.type)
    }
}

@Composable
fun CharacterCardGrid(character: Character) {
    Column(Modifier.fillMaxWidth()) {
        Text(text = character.name)
        Text(text = character.species)
        Text(text = character.type)
    }
}

@Preview(
    name = "Character Row",
    device = Devices.PIXEL_XL,
    showSystemUi = true,
    showBackground = true
)
@Composable
fun CharacterCardRowPrev() {
    val character = Character(1, "Alberto", "Sauce", "no type")
    CharacterCardRow(character = character)
}

@Preview(
    name = "Character Grid",
    device = Devices.PIXEL_XL,
    showSystemUi = true,
    showBackground = true
)
@Composable
fun CharacterCardGridPrev() {
    val character = Character(1, "Alberto", "Sauce", "no type")
    CharacterCardGrid(character = character)
}