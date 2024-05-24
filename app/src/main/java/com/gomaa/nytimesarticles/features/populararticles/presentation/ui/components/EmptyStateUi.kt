package com.gomaa.nytimesarticles.features.populararticles.presentation.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.gomaa.nytimesarticles.R

@Composable
internal fun EmptyStateUi() {
    EmptyStateFullPage(
        headerText = stringResource(R.string.empty_state_title),
        descriptionText = stringResource(R.string.empty_state_subtitle),
        illustration = Illustrations.Search,
        modifier = Modifier.padding(top = 24.dp)
    )
}
