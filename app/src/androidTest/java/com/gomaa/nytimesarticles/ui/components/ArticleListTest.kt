package com.gomaa.nytimesarticles.ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.gomaa.presentation.model.ArticleUiEntity
import com.gomaa.presentation.ui.components.ArticleItem
import com.gomaa.presentation.ui.components.ArticlesList
import com.gomaa.presentation.ui.components.ArticlesListConstants.ARTICLES_LIST_TEST_TAG
import org.junit.Rule
import org.junit.Test

class ArticleListTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun verifyArticlesListIsDisplayed() {
        val articles = listOf(
           ArticleUiEntity(
                title = "title",
                publishedDate = "date",
                byLine = "author",
                url = "url",
                smallThumbnail = "small",
                mediumThumbnail = "medium",
                largeThumbnail = "large",
                publishedAgo = "2"
            )
        )

        composeTestRule.setContent {
           ArticlesList(articles = articles, onItemClick = {})
        }
        composeTestRule.onNodeWithTag(
            ARTICLES_LIST_TEST_TAG,
        ).assertIsDisplayed()
    }

    @Test
    fun verifyArticleItemIsDisplayed() {
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
            ArticleItem(item = article, onItemClick = {})
        }
        composeTestRule.onNodeWithContentDescription("articleImage").assertIsDisplayed()
        composeTestRule.onNodeWithText("title").assertIsDisplayed()
        composeTestRule.onNodeWithText("author").assertIsDisplayed()
    }
}