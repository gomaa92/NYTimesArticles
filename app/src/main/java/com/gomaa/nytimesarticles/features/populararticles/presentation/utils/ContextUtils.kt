package com.gomaa.nytimesarticles.features.populararticles.presentation.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

interface UriParser {
    fun parse(uriString: String): Uri
}

object DefaultUriParser : UriParser {
    override fun parse(uriString: String): Uri {
        return Uri.parse(uriString)
    }
}
fun openInBrowser(url: String, context: Context, uriParser: UriParser = DefaultUriParser) {
    val intent = Intent(Intent.ACTION_VIEW, uriParser.parse(url))
    context.startActivity(intent)
}