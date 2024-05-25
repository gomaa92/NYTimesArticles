package com.gomaa.nytimesarticles.features.populararticles.presentation.ui.designsystem

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Stable
import com.gomaa.nytimesarticles.R

@Stable
sealed interface Illustrations {
    val res: Int
    companion object {
        val Search: Illustrations
            get() = com.gomaa.nytimesarticles.features.populararticles.presentation.ui.designsystem.Search

        val Error: Illustrations
            get() = com.gomaa.nytimesarticles.features.populararticles.presentation.ui.designsystem.Error
    }
}


private data object Search : Illustrations {
    @DrawableRes
    override val res = R.drawable.illustration_empty
}

private data object Error : Illustrations {
    @DrawableRes
    override val res = R.drawable.error
}
