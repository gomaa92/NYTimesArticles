package com.gomaa.nyarticles.data.repository

import com.gomaa.core.remote.NetworkRemoteServiceCall
import com.gomaa.core.remote.Resource
import com.gomaa.nyarticles.data.model.ArticlesResponse
import com.gomaa.nyarticles.data.service.MostPopularArticlesService
import com.gomaa.nyarticles.domain.repository.PopularArticlesRepository

import javax.inject.Inject

class PopularArticlesRepositoryImpl @Inject constructor(private val apiService: MostPopularArticlesService) :
    PopularArticlesRepository, NetworkRemoteServiceCall {
    override suspend fun fetchPopularArticles(period: Int): Resource<ArticlesResponse> =
        safeRemoteCall {
            apiService.getMostPopularArticles(period = period)
        }
}
