package com.amarinag.rickandmorty.ui.match

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.amarinag.rickandmorty.R
import com.amarinag.rickandmorty.ui.component.AvatarNameColumn
import com.amarinag.rickandmorty.ui.component.LabelValueOnColumn
import com.amarinag.rickandmorty.ui.theme.spacing

private const val CharacterCardWeight = 3F

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MatchDetail(uiState: UiState) {
    val scrollState = rememberScrollState()
    Column(
        Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.normal)
            .scrollable(state = scrollState, orientation = Orientation.Vertical)
    ) {
        Card(
            onClick = {},
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(MaterialTheme.spacing.normal),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AvatarNameColumn(
                    imageUrl = uiState.characterSelected?.imageUrl,
                    name = uiState.characterSelected?.name,
                    modifier = Modifier.weight(CharacterCardWeight)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_link_24),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface)
                )
                AvatarNameColumn(
                    imageUrl = uiState.characterMatched?.imageUrl,
                    name = uiState.characterMatched?.name,
                    modifier = Modifier.weight(CharacterCardWeight)
                )
            }
        }
        Spacer(modifier = Modifier.size(MaterialTheme.spacing.normal))
        Card(
            onClick = {},
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            LabelValueOnColumn(
                labelRes = R.string.label_location,
                value = uiState.matchLocation,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MaterialTheme.spacing.normal)
            )
        }
        Spacer(modifier = Modifier.size(MaterialTheme.spacing.normal))
        Card(
            onClick = {},
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        ) {
            LabelValueOnColumn(
                labelRes = R.string.label_shared_episodies,
                value = uiState.matchSharedEpisodes,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MaterialTheme.spacing.normal)
            )
        }
        Spacer(modifier = Modifier.size(MaterialTheme.spacing.normal))
        Card(
            onClick = {},
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            LabelValueOnColumn(
                labelRes = R.string.label_met_date,
                value = uiState.matchDate,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MaterialTheme.spacing.normal)
            )
        }
        Spacer(modifier = Modifier.size(MaterialTheme.spacing.normal))
        Card(
            onClick = {},
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        ) {
            LabelValueOnColumn(
                labelRes = R.string.label_last_time_date,
                value = uiState.lastEpisodeDate,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MaterialTheme.spacing.normal)
            )
        }
    }
}

@Preview
@Composable
fun MatchDetailPrev() {
    val uiState = UiState(true)
    MatchDetail(uiState)
}