package com.amarinag.rickandmorty.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

@Composable
fun AvatarNameColumn(
    imageUrl: String,
    name: String,
    modifier: Modifier = Modifier,
    imageDescription: String? = null
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(model = imageUrl, contentDescription = imageDescription)
        Text(text = name)
    }
}