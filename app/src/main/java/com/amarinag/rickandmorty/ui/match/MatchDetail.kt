package com.amarinag.rickandmorty.ui.match

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun MatchDetail() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.normal)) {
        Card(
            onClick = {},
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Row(
                modifier = Modifier.padding(MaterialTheme.spacing.normal),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AvatarNameColumn(
                    imageUrl = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                    name = "Rick Sanchez",
                    modifier = Modifier.weight(CharacterCardWeight)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_link_24),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface)
                )
                AvatarNameColumn(
                    imageUrl = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
                    name = "Morty Smith",
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
                value = "Planeta AMG",
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
                labelRes = R.string.label_shared_episodies, value = "11",
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
                value = "01/06/2022",
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
                value = "01/06/2022",
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
    MatchDetail()
}