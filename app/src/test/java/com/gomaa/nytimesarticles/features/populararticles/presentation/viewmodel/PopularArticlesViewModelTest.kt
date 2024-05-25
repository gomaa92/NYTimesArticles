package com.gomaa.nytimesarticles.features.populararticles.presentation.viewmodel

import com.gomaa.core.remote.RemoteError
import com.gomaa.core.remote.Resource
import com.gomaa.nytimesarticles.features.populararticles.data.model.Article
import com.gomaa.nytimesarticles.features.populararticles.data.model.ArticlesResponse
import com.gomaa.nytimesarticles.features.populararticles.domain.usecase.FetchPopularArticlesUseCase
import com.gomaa.nytimesarticles.features.populararticles.presentation.mapper.ArticlesUIMapper.mapDataArticlesToUiArticles
import com.gomaa.nytimesarticles.features.populararticles.presentation.model.ArticleUiEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import kotlin.time.ExperimentalTime

@ExperimentalCoroutinesApi
class PopularArticlesViewModelTest {

    private lateinit var viewModel: PopularArticlesViewModel

    @Mock
    private lateinit var useCase: FetchPopularArticlesUseCase
    private val testDispatcher = StandardTestDispatcher()
    private val testCoroutineScope = TestScope(testDispatcher)

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        viewModel = PopularArticlesViewModel(useCase)
    }

    @Before
    fun setupDispatcher() {
        Dispatchers.setMain(testDispatcher)
    }

    @ExperimentalTime
    @Test
    fun `fetchPopularArticles success`() = testCoroutineScope.runTest {
        // Given
        val articles = listOf(
            Article(
                id = 1,
                media = null,
                publishedDate = "2024-05-30",
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
                publishedDate = "2024-05-30",
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
        whenever(useCase.execute(any())).thenReturn(
            Resource.Success(
                ArticlesResponse(
                    articles = articles,
                    numResults = 1,
                    status = "1"
                )
            )
        )

        // When
        viewModel.handleEvent(PopularArticlesEvent.FetchPopularArticles(1))

        // Then
        assertEquals(mapDataArticlesToUiArticles(articles), viewModel.currentState.articles)
        assertEquals(false, viewModel.currentState.isLoading)
        assertEquals(false, viewModel.currentState.isError)
        assertEquals(false, viewModel.currentState.isEmptyResponse)
    }

    @ExperimentalTime
    @Test
    fun `fetchPopularArticles error`() = testCoroutineScope.runTest {
        val articles = listOf(
            Article(
                id = 1,
                media = null,
                publishedDate = "2024-05-30",
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
                publishedDate = "2024-05-30",
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
        // Given
        whenever(useCase.execute(any())).thenReturn(
            Resource.Error(
                remoteError = RemoteError.GeneralError, data = ArticlesResponse(
                    articles = articles,
                    numResults = 1,
                    status = "1"
                ), code = -1
            )
        )

        // When
        viewModel.handleEvent(PopularArticlesEvent.FetchPopularArticles(1))

        // Then
        assertEquals(emptyList<ArticleUiEntity>(), viewModel.currentState.articles)
        assertEquals(false, viewModel.currentState.isLoading)
        assertEquals(true, viewModel.currentState.isError)
        assertEquals(false, viewModel.currentState.isEmptyResponse)
    }

    @ExperimentalTime
    @Test
    fun `fetchPopularArticles empty response`() = testCoroutineScope.runTest {
        // Given
        whenever(useCase.execute(any())).thenReturn(
            Resource.Success(
                ArticlesResponse(
                    articles = emptyList(), numResults = 1,
                    status = "1"
                )
            )
        )

        // When
        viewModel.handleEvent(PopularArticlesEvent.FetchPopularArticles(1))

        // Then
        assertEquals(emptyList<ArticleUiEntity>(), viewModel.currentState.articles)
        assertEquals(false, viewModel.currentState.isLoading)
        assertEquals(false, viewModel.currentState.isError)
        assertEquals(true, viewModel.currentState.isEmptyResponse)
    }

}