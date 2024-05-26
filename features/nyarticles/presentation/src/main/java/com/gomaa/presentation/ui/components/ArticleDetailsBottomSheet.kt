package com.gomaa.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.gomaa.design_system.NYText
import com.gomaa.design_system.NYTextStyle
import com.gomaa.presentation.R
import com.gomaa.presentation.model.ArticleUiEntity
import com.gomaa.utils.openInBrowser

@Composable
fun ArticleDetailBottomSheet(article: ArticleUiEntity, onCloseClicked: (() -> Unit)) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxHeight()
            .statusBarsPadding(),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.weight(1f))

            Icon(
                painter = painterResource(id = R.drawable.close_circle),
                contentDescription = stringResource(
                    id = R.string.close
                ),
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(bottom = 12.dp)
                    .clickable {
                        onCloseClicked.invoke()
                    }
                    .size(32.dp)
            )
        }
        Image(
            painter = rememberAsyncImagePainter(article.largeThumbnail),
            contentDescription = stringResource(id = R.string.image_content_desc),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.4f)
                .clip(RoundedCornerShape(12.dp))
        )

        NYText(
            text = article.title,
            nyTextStyle = NYTextStyle.Title,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(12.dp),
            color = MaterialTheme.colorScheme.primary
        )
        NYText(
            text = article.byLine,
            nyTextStyle = NYTextStyle.BodySmall,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(12.dp),
            color = MaterialTheme.colorScheme.inverseSurface
        )
        NYText(
            text = stringResource(id = R.string.published, article.publishedAgo),
            nyTextStyle = NYTextStyle.BodySmall,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(12.dp),
            color = MaterialTheme.colorScheme.inverseSurface
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .clickable {
                    openInBrowser(
                        url = article.url, context
                    )
                }, contentAlignment = Alignment.CenterStart

        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.open_in_new),
                    contentDescription = stringResource(
                        id = R.string.open_in_browser
                    ),
                    modifier = Modifier.padding(start = 12.dp, end = 8.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                NYText(
                    text = stringResource(id = R.string.open_in_browser),
                    nyTextStyle = NYTextStyle.LabelSmall,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(12.dp),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}