package com.gomaa.nytimesarticles.features.populararticles.presentation.ui.designsystem

import androidx.compose.material3.Icon as MaterialIcon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics

/**
 * Illustrations are used in our empty states, errors, and celebrations to add delight and clarity.
 * They usually do not include any people but occasionally include some atmospheric background elements,
 * depending on the design.
 *
 * They are meant to be used on light backgrounds and do not change colors between light and dark mode;
 * if placed on a dark background, ensure ample contrast by positioning the illustration on a light
 * circle to maintain visibility.
 *
 * @param illustration Required. An [Illustrations] object to be displayed
 * @param contentDescription Required. A nullable [String] to be used as the content description
 * @param modifier Optional. A [Modifier] to affect the Illustration
 * */
@Composable
fun Illustration(
    illustration: Illustrations,
    contentDescription: String?,
    modifier: Modifier = Modifier,
) {
    MaterialIcon(
        painter = painterResource(id = illustration.res),
        contentDescription = contentDescription,
        modifier = modifier.semantics { drawableId = illustration.res },
        tint = Color.Unspecified
    )
}
