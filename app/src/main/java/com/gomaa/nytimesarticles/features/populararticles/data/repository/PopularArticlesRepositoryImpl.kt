package com.gomaa.nytimesarticles.features.populararticles.data.repository

import com.gomaa.core.remote.NetworkRemoteServiceCall
import com.gomaa.core.remote.Resource
import com.gomaa.nytimesarticles.features.populararticles.data.model.ArticlesResponse
import com.gomaa.nytimesarticles.features.populararticles.data.service.MostPopularArticlesService
import com.gomaa.nytimesarticles.features.populararticles.domain.repository.PopularArticlesRepository
import javax.inject.Inject

class PopularArticlesRepositoryImpl @Inject constructor(private val apiService: MostPopularArticlesService) :
    PopularArticlesRepository, NetworkRemoteServiceCall {
    override suspend fun fetchPopularArticles(period: Int): Resource<ArticlesResponse> =
        safeRemoteCall {
            apiService.getMostPopularArticles(period = period)
        }
}
