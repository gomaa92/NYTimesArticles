package com.gomaa.nytimesarticles.features.populararticles.presentation.ui.designsystem

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * Full page empty state with an illustration, header, description, and CTA button.
 * Empty states in app design serve as placeholders or screens that appear when
 * there’s no data or content to display. They’re crucial because they provide
 * guidance, context, and sometimes encouragement to users.
 *
 * @param headerText The header text to display.
 * @param descriptionText The description text to display.
 * @param modifier The modifier to be applied to the layout.
 * @param illustration The illustration to display.
 * @param contentDescription The content description for the illustration.
 */
@Composable
fun EmptyStateFullPage(
    headerText: String?,
    descriptionText: String?,
    modifier: Modifier = Modifier,
    illustration: Illustrations? = null,
    contentDescription: String? = null,
    ctaButtonText: String? = null,
    ctaButtonOnClick: (() -> Unit)? = null
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.CenterVertically)
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .semantics(mergeDescendants = true) {},
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            illustration?.let {
                Illustration(
                    illustration = it,
                    contentDescription = contentDescription,
                    modifier = Modifier
                        .size(96.dp)
                        .padding(bottom = 24.dp)
                )
            }
            headerText?.let {
                NYText(
                    text = headerText,
                    nyTextStyle = NYTextStyle.HeaderSmall,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    maxLines = 2,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
            descriptionText?.let {
                NYText(
                    text = descriptionText,
                    nyTextStyle = NYTextStyle.BodyLarge,
                    textAlign = TextAlign.Center,
                    maxLines = 3,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            ctaButtonText?.let {
                if (descriptionText != null) {
                    Spacer(modifier = Modifier.height(8.dp))
                }
                NYText(
                    text = ctaButtonText,
                    nyTextStyle = NYTextStyle.BodyLarge,
                    textAlign = TextAlign.Center,
                    maxLines = 3,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .clickable {
                            ctaButtonOnClick?.invoke()
                        }
                )
            }
        }
    }
}
