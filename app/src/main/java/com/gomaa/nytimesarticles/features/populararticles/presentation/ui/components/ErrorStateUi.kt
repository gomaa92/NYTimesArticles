package com.gomaa.nytimesarticles.features.populararticles.presentation.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.gomaa.nytimesarticles.R
import com.gomaa.nytimesarticles.features.populararticles.presentation.ui.designsystem.EmptyStateFullPage
import com.gomaa.nytimesarticles.features.populararticles.presentation.ui.designsystem.Illustrations

@Composable
internal fun ErrorStateUi(ctaButtonOnClick: (() -> Unit)? = null) {
    EmptyStateFullPage(
        headerText = stringResource(R.string.something_went_wrong),
        descriptionText = stringResource(R.string.error_state_desc),
        illustration = Illustrations.Error,
        modifier = Modifier.padding(top = 24.dp),
        ctaButtonText = stringResource(id = R.string.try_again),
        ctaButtonOnClick = ctaButtonOnClick
    )
}
