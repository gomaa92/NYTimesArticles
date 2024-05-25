package com.gomaa.nytimesarticles.features.populararticles.data

import com.gomaa.core.remote.RemoteError
import com.gomaa.core.remote.Resource
import com.gomaa.nyarticles.data.model.Article
import com.gomaa.nyarticles.data.model.ArticlesResponse
import com.gomaa.nyarticles.data.model.Media
import com.gomaa.nyarticles.data.model.MediaMetadata
import com.gomaa.nyarticles.data.repository.PopularArticlesRepositoryImpl
import com.gomaa.nyarticles.data.service.MostPopularArticlesService
import com.gomaa.nyarticles.domain.repository.PopularArticlesRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.HttpException
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class PopularArticlesRepositoryImplTest {
    private lateinit var repository: PopularArticlesRepository

    @Mock
    lateinit var remoteDataSource: MostPopularArticlesService

    @Before
    fun setUp() {

        MockitoAnnotations.openMocks(this)
        repository = PopularArticlesRepositoryImpl(remoteDataSource)
    }

    @Test
    fun getArticleListReturnSuccess() {
        runBlocking {
            val response = ArticlesResponse(
                numResults = 1,
                articles = listOf(
                    Article(
                        id = 1,
                        publishedDate = "text",
                        section = "text",
                        subsection = "text",
                        source = "text",
                        title = "title",
                        type = "text",
                        updated = "text",
                        url = "text",
                        uri = "text",
                        byline = "text",
                        media = listOf(
                            Media(
                                caption = "text",
                                copyright = "text",
                                subtype = "text",
                                type = "text",
                                mediaMetadata = listOf(
                                    MediaMetadata(
                                        format = "text",
                                        height = 1,
                                        width = 1,
                                        url = "text"
                                    )
                                )
                            )
                        )
                    )
                ),
                status = "some text"
            )

            `when`(remoteDataSource.getMostPopularArticles(1)).thenReturn(response)

            Assert.assertEquals(response, repository.fetchPopularArticles(1)._data)
        }
    }

    @Test
    fun getArticleListReturnGeneralError() {
        runBlocking {
            val networkException = RuntimeException("Network error")

            `when`(remoteDataSource.getMostPopularArticles(1)).thenThrow(networkException)

            val result = repository.fetchPopularArticles(1)

            Assert.assertTrue(result is Resource.Error)
            val errorResult = result as Resource.Error
            Assert.assertEquals(RemoteError.GeneralError, errorResult._remoteError)
            Assert.assertEquals(-1, errorResult.code)
        }
    }

    @Test
    fun getArticleListReturnServerError() {
        runBlocking {
            val errorResponse = Response.error<ArticlesResponse>(
                404,
                okhttp3.ResponseBody.create(null, "Not Found")
            )
            val httpException = HttpException(errorResponse)

            `when`(remoteDataSource.getMostPopularArticles(1)).thenThrow(httpException)

            val result = repository.fetchPopularArticles(1)

            Assert.assertTrue(result is Resource.Error)
            val errorResult = result as Resource.Error
            Assert.assertTrue(errorResult._remoteError is RemoteError.ServerError)
            Assert.assertEquals(404, errorResult.code)
        }
    }
}
