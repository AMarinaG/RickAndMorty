package com.amarinag.rickandmorty.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun LabelValueOnColumnExpandable(
    @StringRes labelRes: Int,
    value: String?,
    expanded: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = labelRes),
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = value ?: "",
            style = MaterialTheme.typography.bodyMedium
        )
        if (expanded) {
            content()
        }
    }

}