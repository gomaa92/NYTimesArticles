package com.gomaa.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.gomaa.presentation.ui.components.CoinLoader
import com.gomaa.presentation.ui.components.CoinLoaderConstants.COIN_LOADER_TEST_TAG
import org.junit.Rule
import org.junit.Test

class CoinLoaderTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun verifyCoinLoaderIsDisplayed() {
        composeTestRule.setContent {
           CoinLoader()
        }
        composeTestRule.onNodeWithTag(
            COIN_LOADER_TEST_TAG,
        ).assertIsDisplayed()
    }
}
