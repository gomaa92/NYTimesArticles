package com.gomaa.nytimesarticles.features.populararticles.presentation.utils

import android.content.Context
import com.gomaa.utils.UriParser
import com.gomaa.utils.openInBrowser
import org.junit.Test
import org.mockito.Mockito

class ContextUtilTest {
    @Test
    fun `openInBrowser creates intent with correct URL`() {
        // Given
        val url = "https://example.com"
        val context = Mockito.mock(Context::class.java)
        val uriParser = Mockito.mock(UriParser::class.java)

        // When
        openInBrowser(url, context, uriParser)

        // Then
        Mockito.verify(uriParser).parse(url)
    }
}