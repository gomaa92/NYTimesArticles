package com.gomaa.nyarticles.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.gomaa.nyarticles.presentation.ui.components.FilterComponentConstants.FILTER_ROW_TEST_TAG
import com.gomaa.utils.FilterOption

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChipRow(
    filterOptions: List<FilterOption>,
    onFilterSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(16.dp)
            .testTag(FILTER_ROW_TEST_TAG),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        filterOptions.forEach { filter ->
            FilterChip(
                selected = filter.isSelected,
                onClick = { onFilterSelected(filter.period) },
                label = { Text(stringResource(id = filter.title)) },
                shape = CircleShape,
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = MaterialTheme.colorScheme.primary,
                    selectedLabelColor = MaterialTheme.colorScheme.onPrimary,
                    containerColor = MaterialTheme.colorScheme.surface,
                    labelColor = MaterialTheme.colorScheme.onSurface
                )
            )
        }
    }
}

object FilterComponentConstants {
    const val FILTER_ROW_TEST_TAG = "FILTER_ROW_TEST_TAG"
}
