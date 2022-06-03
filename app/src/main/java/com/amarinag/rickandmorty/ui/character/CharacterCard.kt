package com.amarinag.rickandmorty.ui.character

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.amarinag.domain.model.Character
import com.amarinag.rickandmorty.R
import com.amarinag.rickandmorty.ui.common.LabelValueOnColumn
import com.amarinag.rickandmorty.ui.theme.spacing

@Composable
fun CharacterCardRow(character: Character) {
    Row(Modifier.fillMaxWidth()) {
        AsyncImage(
            model = character.imageUrl,
            contentDescription = character.name,
            modifier = Modifier.size(112.dp)
        )
        Spacer(modifier = Modifier.size(MaterialTheme.spacing.normal))
        Column(
            Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.small)
        ) {
            Text(text = character.name, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.size(MaterialTheme.spacing.normal))
            Row {
                LabelValueOnColumn(
                    labelRes = R.string.label_species,
                    value = character.species ?: stringResource(id = R.string.label_unknown),
                    modifier = Modifier.weight(1F)
                )
                LabelValueOnColumn(
                    labelRes = R.string.label_type,
                    value = character.type ?: stringResource(id = R.string.label_unknown),
                    modifier = Modifier.weight(1F)
                )
            }
        }
    }
}

@Composable
fun CharacterCardGrid(character: Character) {
    Column(Modifier.fillMaxWidth()) {
        AsyncImage(
            model = character.imageUrl,
            contentDescription = character.name,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(MaterialTheme.spacing.normal))
        Text(text = character.name)
        Spacer(modifier = Modifier.size(MaterialTheme.spacing.normal))
        Row {
            LabelValueOnColumn(
                labelRes = R.string.label_species,
                value = character.species ?: stringResource(id = R.string.label_unknown),
                modifier = Modifier.weight(1F)
            )
            LabelValueOnColumn(
                labelRes = R.string.label_type,
                value = character.type ?: stringResource(id = R.string.label_unknown),
                modifier = Modifier.weight(1F)
            )
        }

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
    val character = Character(1, "Alberto", "Sauce", "no type", "hello")
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
    val character = Character(1, "Alberto", "Sauce", "no type", "hello")
    CharacterCardGrid(character = character)
}