package com.amarinag.rickandmorty.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun AvatarNameColumn(
    imageUrl: String?,
    name: String?,
    modifier: Modifier = Modifier,
    imageDescription: String? = null
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(model = imageUrl, contentDescription = imageDescription, modifier = Modifier.size(168.dp))
        Text(text = name ?: "")
    }
}