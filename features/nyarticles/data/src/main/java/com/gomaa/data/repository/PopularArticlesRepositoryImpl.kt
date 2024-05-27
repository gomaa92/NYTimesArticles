package com.gomaa.data.repository

import com.gomaa.core.remote.NetworkRemoteServiceCall
import com.gomaa.core.remote.Resource
import com.gomaa.data.model.ArticlesResponse
import com.gomaa.data.service.MostPopularArticlesService

import javax.inject.Inject

class PopularArticlesRepositoryImpl @Inject constructor(private val apiService: MostPopularArticlesService) :
    PopularArticlesRepository, NetworkRemoteServiceCall {
    override suspend fun fetchPopularArticles(period: Int): Resource<ArticlesResponse> =
        safeRemoteCall {
            apiService.getMostPopularArticles(period = period)
        }
}
