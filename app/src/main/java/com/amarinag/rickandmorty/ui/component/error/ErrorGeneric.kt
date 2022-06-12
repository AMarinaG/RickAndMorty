package com.amarinag.rickandmorty.ui.component.error

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.amarinag.error.NoMatchException
import com.amarinag.error.ResponseErrorException
import com.amarinag.rickandmorty.R

@Composable
fun ErrorGeneric(throwable: Throwable) {
    when (throwable) {
        is ResponseErrorException -> {
            ErrorResponse(errorMessage = stringResource(id = R.string.try_again_after_few_mins))
        }
        is NoMatchException -> {
            ErrorNoMatch(
                characterName = throwable.characterName,
                characterId = throwable.characterId
            )
        }
        else -> {
            Column(Modifier.fillMaxSize()) {
                Text(text = stringResource(id = R.string.error_network))
                Text(text = throwable.localizedMessage)
            }
        }
    }
}
