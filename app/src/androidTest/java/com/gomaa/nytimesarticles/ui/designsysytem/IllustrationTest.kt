package com.gomaa.nytimesarticles.ui.designsysytem

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import com.gomaa.design_system.Illustration
import com.gomaa.design_system.Illustrations
import org.junit.Rule
import org.junit.Test

class IllustrationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun verifyEmptyStateFullPageIsDisplayed() {
        composeTestRule.setContent {
            com.gomaa.design_system.Illustration(
                illustration = com.gomaa.design_system.Illustrations.Error,
                contentDescription = "contentDes"
            )

        }
        composeTestRule.onNodeWithContentDescription("contentDes").assertIsDisplayed()

    }
}