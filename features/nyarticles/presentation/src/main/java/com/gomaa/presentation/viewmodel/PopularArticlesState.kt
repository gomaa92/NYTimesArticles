package com.gomaa.presentation.viewmodel

import com.gomaa.core.presentation.UiState
import com.gomaa.presentation.model.ArticleUiEntity

data class PopularArticlesState(
    val isLoading: Boolean = false,
    val articles: List<ArticleUiEntity> = emptyList(),
    val isEmptyResponse: Boolean = false,
    val isError: Boolean = false,
) : UiState
