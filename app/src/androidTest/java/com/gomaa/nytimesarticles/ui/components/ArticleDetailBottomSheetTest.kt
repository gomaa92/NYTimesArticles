package com.gomaa.nytimesarticles.ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.gomaa.nytimesarticles.features.populararticles.presentation.model.ArticleUiEntity
import com.gomaa.nytimesarticles.features.populararticles.presentation.ui.components.ArticleDetailBottomSheet
import org.junit.Rule
import org.junit.Test

class ArticleDetailBottomSheetTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun verifyArticleDetailsBottomSheetIsDisplayed() {
        val article = ArticleUiEntity(
            title = "title",
            publishedDate = "date",
            byLine = "author",
            url = "url",
            smallThumbnail = "small",
            mediumThumbnail = "medium",
            largeThumbnail = "large",
            publishedAgo = "2"
        )
        composeTestRule.setContent {
            ArticleDetailBottomSheet(article = article) {}
        }
        composeTestRule.onNodeWithContentDescription("articleImage").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("close").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Open in browser").assertIsDisplayed()
        composeTestRule.onNodeWithText("title").assertIsDisplayed()
        composeTestRule.onNodeWithText("author").assertIsDisplayed()
        composeTestRule.onNodeWithText("Open in browser").assertIsDisplayed()
    }
}