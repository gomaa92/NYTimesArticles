package com.gomaa.design_system

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

/**
 * Loader is one of the elements for user engagement and feedback.
 * The dynamic animation indicates ongoing processes.
 */
@Composable
fun Loader() {
    val infiniteTransition = rememberInfiniteTransition(label = "coinLoaderTransition")

    val rotationValue by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "coinLoaderAnimation"
    )
    Image(
        painter = painterResource(id = R.drawable.loader),
        contentDescription = stringResource(
            id = R.string.loading
        ),
        modifier = Modifier
            .padding(16.dp)
            .size(56.dp)
            .semantics { drawableId = R.drawable.loader }
            .graphicsLayer {
                rotationZ = rotationValue
            }
    )
}