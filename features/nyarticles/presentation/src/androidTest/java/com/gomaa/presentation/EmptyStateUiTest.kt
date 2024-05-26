package com.gomaa.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.gomaa.presentation.ui.components.EmptyStateUi
import com.gomaa.presentation.ui.components.EmptyStateUiConstants.EMPTY_STATE_TEST_TAG
import org.junit.Rule
import org.junit.Test

class EmptyStateUiTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun verifyEmptyStateIsDisplayed() {
        composeTestRule.setContent {
           EmptyStateUi()
        }
        composeTestRule.onNodeWithTag(
            EMPTY_STATE_TEST_TAG,
        ).assertIsDisplayed()
    }
}
