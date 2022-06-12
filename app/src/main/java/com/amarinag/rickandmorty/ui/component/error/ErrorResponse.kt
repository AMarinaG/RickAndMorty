package com.amarinag.rickandmorty.ui.component.error

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.amarinag.rickandmorty.R

@Composable
fun ErrorResponse(errorMessage: String) {
    Column(Modifier.fillMaxSize()) {
        Text(text = stringResource(id = R.string.error_server_down))
        Text(text = errorMessage)
    }
}
