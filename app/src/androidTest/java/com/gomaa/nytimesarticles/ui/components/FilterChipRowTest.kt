package com.gomaa.nytimesarticles.ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.gomaa.presentation.ui.components.FilterChipRow
import com.gomaa.presentation.ui.components.FilterComponentConstants
import com.gomaa.utils.initializeFilterOptions
import org.junit.Rule
import org.junit.Test

class FilterChipRowTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun verifyFilterChipsIsDisplayed() {
        composeTestRule.setContent {
            FilterChipRow(
                filterOptions = initializeFilterOptions(),
                {})

        }
        composeTestRule.onNodeWithTag(
            FilterComponentConstants.FILTER_ROW_TEST_TAG,
        ).assertIsDisplayed()
    }
}