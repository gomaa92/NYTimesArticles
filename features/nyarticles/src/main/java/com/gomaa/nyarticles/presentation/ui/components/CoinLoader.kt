package com.gomaa.nyarticles.presentation.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.gomaa.design_system.Loader
import com.gomaa.nyarticles.presentation.ui.components.CoinLoaderConstants.COIN_LOADER_TEST_TAG

@Composable
fun CoinLoader(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .testTag(COIN_LOADER_TEST_TAG),
        contentAlignment = Alignment.Center,
    ) {
        Loader()
    }
}

object CoinLoaderConstants {
    const val COIN_LOADER_TEST_TAG = "COIN_LOADER_TEST_TAG"
}

