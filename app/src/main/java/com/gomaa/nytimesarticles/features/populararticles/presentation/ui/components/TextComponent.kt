package com.gomaa.nytimesarticles.features.populararticles.presentation.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import com.gomaa.nytimesarticles.ui.theme.NYTextStyle
import androidx.compose.material3.LocalContentColor as MaterialLocalContentColor

@Composable
fun NYText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface,
    nyTextStyle: NYTextStyle = NYTextStyle.BodyLarge,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    softWrap: Boolean = true,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    onTextLayout: (TextLayoutResult) -> Unit = {}
) {
    val modifiedText = if (nyTextStyle == NYTextStyle.Overline) {
        text.uppercase()
    } else text

    CompositionLocalProvider(
        MaterialLocalContentColor provides color,
    ) {
        Text(
            text = modifiedText,
            modifier = modifier,
            style = nyTextStyle.styleRef,
            overflow = overflow,
            maxLines = maxLines,
            softWrap = softWrap,
            textDecoration = textDecoration,
            textAlign = textAlign,
            onTextLayout = onTextLayout
        )
    }
}
