package com.gomaa.nytimesarticles.features.populararticles.data.model

import com.google.gson.annotations.SerializedName

data class Media(
    val caption: String,
    val copyright: String,
    @SerializedName("media-metadata") val mediaMetadata: List<MediaMetadata>,
    val subtype: String,
    val type: String
)