package com.gomaa.nytimesarticles.features.populararticles.domain.usecase

import com.gomaa.core.remote.Resource
import com.gomaa.core.usecase.SuspendableUseCase
import com.gomaa.nytimesarticles.features.populararticles.data.model.ArticlesResponse
import com.gomaa.nytimesarticles.features.populararticles.domain.repository.PopularArticlesRepository
import javax.inject.Inject

open class FetchPopularArticlesUseCase @Inject constructor(private val repository: PopularArticlesRepository) :
    SuspendableUseCase<Int, Resource<ArticlesResponse>> {
    override suspend fun execute(input: Int): Resource<ArticlesResponse> =
        repository.fetchPopularArticles(input)
}
