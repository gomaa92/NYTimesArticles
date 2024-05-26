package com.gomaa.design_system

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Stable

@Stable
sealed interface Illustrations {
    val res: Int
    companion object {
        val Search: Illustrations
            get() = com.gomaa.design_system.Search

        val Error: Illustrations
            get() = com.gomaa.design_system.Error
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
