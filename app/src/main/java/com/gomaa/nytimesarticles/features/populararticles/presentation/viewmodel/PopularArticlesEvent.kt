package com.gomaa.nytimesarticles.features.populararticles.presentation.viewmodel

import com.gomaa.nytimesarticles.core.presentation.UiEvent

sealed class PopularArticlesEvent : UiEvent {
    data class FetchPopularArticles(val period: Int) : PopularArticlesEvent()
}