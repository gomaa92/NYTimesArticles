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
import com.gomaa.nytimesarticles.features.populararticles.presentation.ui.components.ErrorStateUiConstants.ERROR_STATE_TEST_TAG

@Composable
internal fun ErrorStateUi(modifier: Modifier = Modifier, ctaButtonOnClick: (() -> Unit)? = null) {
    EmptyStateFullPage(
        headerText = stringResource(R.string.something_went_wrong),
        descriptionText = stringResource(R.string.error_state_desc),
        illustration = Illustrations.Error,
        modifier = modifier
            .padding(top = 24.dp)
            .testTag(ERROR_STATE_TEST_TAG),
        ctaButtonText = stringResource(id = R.string.try_again),
        ctaButtonOnClick = ctaButtonOnClick
    )
}

object ErrorStateUiConstants {
    const val ERROR_STATE_TEST_TAG = "ERROR_STATE_TEST_TAG"
}
