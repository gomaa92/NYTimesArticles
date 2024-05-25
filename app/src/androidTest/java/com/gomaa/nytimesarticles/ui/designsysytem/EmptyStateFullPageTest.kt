package com.gomaa.nytimesarticles.ui.designsysytem

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.gomaa.nytimesarticles.features.populararticles.presentation.ui.designsystem.EmptyStateFullPage
import org.junit.Rule
import org.junit.Test

class EmptyStateFullPageTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun verifyEmptyStateFullPageIsDisplayed() {
        composeTestRule.setContent {
            EmptyStateFullPage(headerText = "header", descriptionText = "description")

        }
        composeTestRule.onNodeWithText("header").assertIsDisplayed()
        composeTestRule.onNodeWithText("description").assertIsDisplayed()

    }
}