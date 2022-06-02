package com.amarinag.rickandmorty.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val zero: Dp = 0.dp,
    val tiny: Dp = 4.dp,
    val small: Dp = 8.dp,
    val normal: Dp = 16.dp,
    val large: Dp = 24.dp,
    val largest: Dp = 32.dp,
    val huge: Dp = 48.dp,
    val hugest: Dp = 56.dp
)

val LocalSpacing = compositionLocalOf { Spacing() }
val MaterialTheme.spacing: Spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacing.current