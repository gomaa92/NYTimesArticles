package com.gomaa.nytimesarticles.features.populararticles.domain.usecase

import com.gomaa.nytimesarticles.core.data.remote.Resource
import com.gomaa.nytimesarticles.core.domain.usecase.SuspendableUseCase
import com.gomaa.nytimesarticles.features.populararticles.data.model.ArticlesResponse
import com.gomaa.nytimesarticles.features.populararticles.domain.repository.PopularArticlesRepository
import javax.inject.Inject

open class FetchPopularArticlesUseCase @Inject constructor(private val repository: PopularArticlesRepository) :
    SuspendableUseCase<Int, Resource<ArticlesResponse>> {
    override suspend fun execute(input: Int): Resource<ArticlesResponse> =
        repository.fetchPopularArticles(input)
}
