package com.gomaa.nytimesarticles.features.populararticles.presentation.viewmodel

import com.gomaa.nytimesarticles.core.presentation.UiState
import com.gomaa.nytimesarticles.features.populararticles.presentation.model.ArticleUiEntity

data class PopularArticlesState(
    val isLoading: Boolean = false,
    val articles: List<ArticleUiEntity> = emptyList(),
    val isEmptyResponse: Boolean = false,
    val isError: Boolean = false,
) : UiState
