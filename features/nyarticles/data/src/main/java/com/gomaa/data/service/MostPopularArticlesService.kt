package com.gomaa.data.service

import com.gomaa.data.BuildConfig
import com.gomaa.core.remote.EndPointConfig.FETCH_POPULAR_ARTICLES
import com.gomaa.data.model.ArticlesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MostPopularArticlesService {
    @GET(FETCH_POPULAR_ARTICLES)
    suspend fun getMostPopularArticles(
        @Path("period") period: Int,
        @Query("api-key") apiKey: String = BuildConfig.API_KEY
    ): ArticlesResponse
}