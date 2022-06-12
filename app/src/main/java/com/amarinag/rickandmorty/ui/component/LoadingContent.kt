package com.amarinag.rickandmorty.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.amarinag.rickandmorty.R

@Composable
fun LoadingContent(
    loading: Boolean,
    modifier: Modifier = Modifier,
    loadingContent: @Composable () -> Unit = { DefaultLoading(modifier) },
    content: @Composable () -> Unit
) {
    if (loading) {
        loadingContent()
    } else {
        content()
    }
}


@Composable
fun DefaultLoading(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading2))
        val progress by animateLottieCompositionAsState(composition)
        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = Modifier.fillMaxSize(5F)
        )
    }
}