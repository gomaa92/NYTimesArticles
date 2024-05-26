package com.gomaa.data.repository

import com.gomaa.core.remote.Resource
import com.gomaa.data.model.ArticlesResponse

interface PopularArticlesRepository {
    suspend fun fetchPopularArticles(period: Int): Resource<ArticlesResponse>
}