package com.gomaa.nytimesarticles.features.populararticles.presentation.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.gomaa.design_system.EmptyStateFullPage
import com.gomaa.design_system.Illustrations
import com.gomaa.nytimesarticles.R
import com.gomaa.nytimesarticles.features.populararticles.presentation.ui.components.EmptyStateUiConstants.EMPTY_STATE_TEST_TAG

@Composable
internal fun EmptyStateUi(modifier: Modifier = Modifier) {
    EmptyStateFullPage(
        headerText = stringResource(R.string.empty_state_title),
        descriptionText = stringResource(R.string.empty_state_subtitle),
        illustration = Illustrations.Search,
        modifier = modifier
            .padding(top = 24.dp)
            .testTag(EMPTY_STATE_TEST_TAG)
    )
}

object EmptyStateUiConstants {
    const val EMPTY_STATE_TEST_TAG = "EMPTY_STATE_TEST_TAG"
}
