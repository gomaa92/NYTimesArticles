package com.gomaa.nyarticles.domain.repository

import com.gomaa.core.remote.Resource
import com.gomaa.nyarticles.data.model.ArticlesResponse

interface PopularArticlesRepository {
    suspend fun fetchPopularArticles(period: Int): Resource<ArticlesResponse>
}