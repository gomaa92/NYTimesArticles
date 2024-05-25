package com.gomaa.nytimesarticles.features.populararticles.presentation.mapper

import com.gomaa.nyarticles.data.model.Article
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.time.LocalDate

class ArticlesUIMapperTest {
    private lateinit var currentDate: LocalDate
    @Before
    fun setUp() {
        // Mock current date as today
        currentDate = LocalDate.now()
    }
    @Test
    fun `mapDataArticlesToUiArticles maps data articles to UI articles`() {
        // Given
        val articles = listOf(
            com.gomaa.nyarticles.data.model.Article(
                id = 1,
                media = null,
                publishedDate = "2024-05-24", // Assuming a date for testing
                section = null,
                source = null,
                subsection = null,
                title = "Title 1",
                type = null,
                updated = null,
                uri = null,
                url = "url1",
                byline = "Byline 1"
            ),
            com.gomaa.nyarticles.data.model.Article(
                id = 2,
                media = null,
                publishedDate = "2024-05-23", // Assuming a date for testing
                section = null,
                source = null,
                subsection = null,
                title = "Title 2",
                type = null,
                updated = null,
                uri = null,
                url = "url2",
                byline = "Byline 2"
            )
        )

        // When
        val uiArticles = ArticlesUIMapper.mapDataArticlesToUiArticles(articles)

        // Then
        assertEquals(2, uiArticles.size)

        assertEquals("Title 1", uiArticles[0].title)
        assertEquals("Byline 1", uiArticles[0].byLine)
        assertEquals("2024-05-24", uiArticles[0].publishedDate) // Date remains unchanged in this test

        assertEquals("Title 2", uiArticles[1].title)
        assertEquals("Byline 2", uiArticles[1].byLine)
        assertEquals("2024-05-23", uiArticles[1].publishedDate) // Date remains unchanged in this test
    }

    @Test
    fun `calculateDaysBetween returns correct string for positive days difference`() {
        // Given a published date 5 days ago
        val publishedDate = "2024-05-20" // Assuming a date for testing

        // When
        val result = ArticlesUIMapper.calculateDaysBetween(publishedDate)

        // Then
        assertEquals("5 day(s) ago", result)
    }

    @Test
    fun `calculateDaysBetween returns correct string for negative days difference`() {
        // Given a published date 5 days from now
        val publishedDate = "2024-05-30" // Assuming a date for testing

        // When
        val result = ArticlesUIMapper.calculateDaysBetween(publishedDate)

        // Then
        assertEquals("5 day(s) from now", result)
    }
    @Test
    fun `calculateDaysBetween returns correct string for today`() {
        // Given a published date as today
        val publishedDate = currentDate.toString()

        // When
        val result = ArticlesUIMapper.calculateDaysBetween(publishedDate)

        // Then
        assertEquals("Today", result)
    }
}
