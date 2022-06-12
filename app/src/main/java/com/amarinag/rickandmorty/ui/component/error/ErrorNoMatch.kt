package com.amarinag.rickandmorty.ui.component.error

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.amarinag.rickandmorty.R

@Composable
fun ErrorNoMatch(characterName: String, characterId: Int) {
    Column(Modifier.fillMaxSize()) {
        Text(
            text = stringResource(id = R.string.error_no_match_for_character),
            style = MaterialTheme.typography.bodyLarge.copy(MaterialTheme.colorScheme.error)
        )
        Text(text = stringResource(id = R.string.error_no_match_with_character_name, characterName))
    }
}