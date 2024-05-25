package com.gomaa.nytimesarticles.features.populararticles.data.model

import com.google.gson.annotations.SerializedName

data class ArticlesResponse(
    @SerializedName("numResults") val numResults: Int?,
    @SerializedName("results") val articles: List<Article>,
    @SerializedName("status") val status: String?
)
