package com.gomaa.nytimesarticles.features.populararticles.domain

import com.gomaa.core.remote.RemoteError
import com.gomaa.core.remote.Resource
import com.gomaa.nytimesarticles.features.populararticles.data.model.Article
import com.gomaa.nytimesarticles.features.populararticles.data.model.ArticlesResponse
import com.gomaa.nytimesarticles.features.populararticles.domain.repository.PopularArticlesRepository
import com.gomaa.nytimesarticles.features.populararticles.domain.usecase.FetchPopularArticlesUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class FetchPopularArticlesUseCaseTest {
    @Mock
    private lateinit var repository: PopularArticlesRepository

    private lateinit var useCase: FetchPopularArticlesUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = FetchPopularArticlesUseCase(repository)
    }

    @Test
    fun `fetch popular articles success`() = runBlocking {
        val period = 7
        val articles = listOf(
            Article(
                id = 1,
                media = null,
                publishedDate = "date",
                section = null,
                source = null,
                subsection = null,
                title = "title",
                type = null,
                updated = null,
                uri = null,
                url = "url",
                byline = "byline"
            ),
            Article(
                id = 1,
                media = null,
                publishedDate = "date",
                section = null,
                source = null,
                subsection = null,
                title = "title",
                type = null,
                updated = null,
                uri = null,
                url = "url",
                byline = "byline"
            )
        )

        val successResource =
            Resource.Success(ArticlesResponse(articles = articles, numResults = 1, status = "12"))

        // Mock repository method
        `when`(repository.fetchPopularArticles(period)).thenReturn(successResource)

        // Execute the use case
        val result = useCase.execute(period)

        // Verify the result
        assertEquals(successResource, result)
    }

    @Test
    fun `fetch popular articles error`() = runBlocking {
        val period = 7
        val articles = listOf(
            Article(
                id = 1,
                media = null,
                publishedDate = "date",
                section = null,
                source = null,
                subsection = null,
                title = "title",
                type = null,
                updated = null,
                uri = null,
                url = "url",
                byline = "byline"
            ),
            Article(
                id = 1,
                media = null,
                publishedDate = "date",
                section = null,
                source = null,
                subsection = null,
                title = "title",
                type = null,
                updated = null,
                uri = null,
                url = "url",
                byline = "byline"
            )
        )
        val remoteError = RemoteError.ConnectionError
        val errorResource = Resource.Error(
            remoteError,
            code = 404,
            data = ArticlesResponse(articles = articles, numResults = 1, status = "12")
        )

        // Mock repository method
        `when`(repository.fetchPopularArticles(period)).thenReturn(errorResource)

        // Execute the use case
        val result = useCase.execute(period)

        // Verify the result
        assertEquals(errorResource, result)
    }
}