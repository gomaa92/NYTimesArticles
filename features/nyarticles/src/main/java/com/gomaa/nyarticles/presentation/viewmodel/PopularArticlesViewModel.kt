package com.gomaa.nyarticles.presentation.viewmodel

import com.gomaa.core.remote.Resource
import com.gomaa.core.presentation.BaseViewModel
import com.gomaa.core.presentation.UiEffect
import com.gomaa.nyarticles.domain.usecase.FetchPopularArticlesUseCase
import com.gomaa.nyarticles.presentation.mapper.ArticlesUIMapper.mapDataArticlesToUiArticles
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
