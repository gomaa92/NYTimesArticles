package com.gomaa.nytimesarticles.features.populararticles.domain.repository

import com.gomaa.nytimesarticles.core.data.remote.Resource
import com.gomaa.nytimesarticles.features.populararticles.data.model.ArticlesResponse

interface PopularArticlesRepository {
    suspend fun fetchPopularArticles(period: Int): Resource<ArticlesResponse>
}