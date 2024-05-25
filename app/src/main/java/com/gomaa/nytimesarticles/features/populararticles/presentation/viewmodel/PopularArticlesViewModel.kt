package com.gomaa.nytimesarticles.features.populararticles.presentation.viewmodel

import com.gomaa.nytimesarticles.core.data.remote.Resource
import com.gomaa.nytimesarticles.core.presentation.BaseViewModel
import com.gomaa.nytimesarticles.core.presentation.UiEffect
import com.gomaa.nytimesarticles.features.populararticles.domain.usecase.FetchPopularArticlesUseCase
import com.gomaa.nytimesarticles.features.populararticles.presentation.mapper.ArticlesUIMapper.mapDataArticlesToUiArticles
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PopularArticlesViewModel @Inject constructor(private val useCase: FetchPopularArticlesUseCase) :
    BaseViewModel<PopularArticlesEvent, PopularArticlesState, UiEffect>() {
    override fun createInitialState() = PopularArticlesState()

    override suspend fun handleEvent(event: PopularArticlesEvent) = when (event) {
        is PopularArticlesEvent.FetchPopularArticles -> fetchPopularArticles(event.period)
    }

    init {
        dispatch(PopularArticlesEvent.FetchPopularArticles(1))
    }

    private suspend fun fetchPopularArticles(period: Int) {
        setState {
            currentState.copy(
                isLoading = true
            )
        }
        when (val result = useCase.execute(input = period)) {
            is Resource.Error -> setState {
                currentState.copy(isLoading = false, isError = true, articles = emptyList())
            }

            is Resource.Success -> {
                val articles = mapDataArticlesToUiArticles(result.data.articles)
                if (articles.isEmpty()) {
                    setState {
                        currentState.copy(
                            isLoading = false,
                            isEmptyResponse = true,
                            isError = false
                        )
                    }
                } else {
                    setState {
                        currentState.copy(isLoading = false, articles = articles, isError = false)
                    }
                }
            }
        }
    }
}
