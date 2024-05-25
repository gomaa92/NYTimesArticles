package com.gomaa.nyarticles.presentation.viewmodel

import com.gomaa.core.presentation.UiEvent

sealed class PopularArticlesEvent : UiEvent {
    data class FetchPopularArticles(val period: Int) : PopularArticlesEvent()
}