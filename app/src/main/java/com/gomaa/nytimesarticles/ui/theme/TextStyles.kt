package com.gomaa.nytimesarticles.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp

private val letterSpacing = TextUnit(value = -0.4f, type = TextUnitType.Sp)

@Immutable
internal data object Title : NYTextStyle {
    override val styleRef = TextStyle(
        fontSize = 28.sp,
        lineHeight = 32.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = letterSpacing
    )
}

@Immutable
internal data object HeaderLarge : NYTextStyle {
    override val styleRef = TextStyle(
        fontSize = 20.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = letterSpacing
    )
}

@Immutable
internal data object HeaderSmall : NYTextStyle {
    override val styleRef = TextStyle(
        fontSize = 18.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = letterSpacing
    )
}

@Immutable
internal data object BodyLarge : NYTextStyle {
    override val styleRef = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = letterSpacing
    )
}

@Immutable
internal data object BodySmall : NYTextStyle {
    override val styleRef = TextStyle(
        fontSize = 14.sp,
        lineHeight = 18.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = letterSpacing
    )
}

@Immutable
internal data object LabelLarge : NYTextStyle {
    override val styleRef = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = letterSpacing
    )
}

@Immutable
internal data object LabelMedium : NYTextStyle {
    override val styleRef = TextStyle(
        fontSize = 14.sp,
        lineHeight = 18.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = letterSpacing
    )
}

@Immutable
internal data object LabelSmall : NYTextStyle {
    override val styleRef = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = letterSpacing
    )
}

@Immutable
internal data object Overline : NYTextStyle {
    override val styleRef = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = letterSpacing
    )
}

@Immutable
internal data object Caption : NYTextStyle {
    override val styleRef = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = letterSpacing
    )
}

sealed interface NYTextStyle {
    val styleRef: TextStyle

    companion object {

        @Stable
        val Title: NYTextStyle
            get() = com.gomaa.nytimesarticles.ui.theme.Title
        @Stable
        val HeaderLarge: NYTextStyle
            get() = com.gomaa.nytimesarticles.ui.theme.HeaderLarge
        @Stable
        val HeaderSmall: NYTextStyle
            get() = com.gomaa.nytimesarticles.ui.theme.HeaderSmall
        @Stable
        val BodyLarge: NYTextStyle
            get() = com.gomaa.nytimesarticles.ui.theme.BodyLarge
        @Stable
        val BodySmall: NYTextStyle
            get() = com.gomaa.nytimesarticles.ui.theme.BodySmall
        @Stable
        val LabelLarge: NYTextStyle
            get() = com.gomaa.nytimesarticles.ui.theme.LabelLarge
        @Stable
        val LabelMedium: NYTextStyle
            get() = com.gomaa.nytimesarticles.ui.theme.LabelMedium
        @Stable
        val LabelSmall: NYTextStyle
            get() = com.gomaa.nytimesarticles.ui.theme.LabelSmall
        @Stable
        val Overline: NYTextStyle
            get() = com.gomaa.nytimesarticles.ui.theme.Overline
        @Stable
        val Caption: NYTextStyle
            get() = com.gomaa.nytimesarticles.ui.theme.Caption
    }
}