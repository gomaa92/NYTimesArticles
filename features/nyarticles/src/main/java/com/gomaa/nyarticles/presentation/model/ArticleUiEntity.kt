package com.gomaa.nyarticles.presentation.model

data class ArticleUiEntity(
    val title: String,
    val publishedDate: String,
    val byLine: String,
    val url: String,
    val smallThumbnail:String,
    val mediumThumbnail:String,
    val largeThumbnail:String,
    val publishedAgo:String
)