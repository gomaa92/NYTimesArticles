package com.gomaa.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.gomaa.presentation.ui.components.ErrorStateUi
import com.gomaa.presentation.ui.components.ErrorStateUiConstants.ERROR_STATE_TEST_TAG
import org.junit.Rule
import org.junit.Test

class ErrorStateUiTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun verifyErrorStateIsDisplayed() {
        composeTestRule.setContent {
            ErrorStateUi()
        }
        composeTestRule.onNodeWithTag(
            ERROR_STATE_TEST_TAG,
        ).assertIsDisplayed()
    }
}