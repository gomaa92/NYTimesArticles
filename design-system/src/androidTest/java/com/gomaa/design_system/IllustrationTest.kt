package com.gomaa.design_system

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import org.junit.Rule
import org.junit.Test

class IllustrationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun verifyEmptyStateFullPageIsDisplayed() {
        composeTestRule.setContent {
            Illustration(
                illustration = Illustrations.Error,
                contentDescription = "contentDes"
            )
        }
        composeTestRule.onNodeWithContentDescription("contentDes").assertIsDisplayed()
    }
}