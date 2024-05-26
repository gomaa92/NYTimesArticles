package com.gomaa.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.gomaa.design_system.NYText
import com.gomaa.design_system.NYTextStyle
import com.gomaa.presentation.R
import com.gomaa.presentation.model.ArticleUiEntity
import com.gomaa.presentation.ui.components.ArticlesListConstants.ARTICLES_LIST_TEST_TAG

@Composable
fun ArticlesList(
    articles: List<ArticleUiEntity>,
    modifier: Modifier = Modifier,
    onItemClick: (ArticleUiEntity) -> Unit,
) {
    LazyColumn(
        state = rememberLazyListState(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.testTag(ARTICLES_LIST_TEST_TAG)
    ) {
        items(articles) {
            ArticleItem(it, onItemClick)
        }
    }
}

@Composable
fun ArticleItem(
    item: ArticleUiEntity, onItemClick: (ArticleUiEntity) -> Unit, modifier: Modifier = Modifier
) {
    Card(shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onItemClick(item) }) {
        Column {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = rememberAsyncImagePainter(item.largeThumbnail),
                    contentDescription = stringResource(id = R.string.image_content_desc),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.4f)
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .aspectRatio(1.4f)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black.copy(alpha = 0.1f),
                                    Color.Black.copy(alpha = 0.35f),
                                ), startY = 0f, endY = 100f
                            )
                        )
                        .align(Alignment.BottomStart)
                ) {
                    NYText(
                        text = item.title,
                        nyTextStyle = NYTextStyle.BodySmall,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }
            NYText(
                text = item.byLine,
                nyTextStyle = NYTextStyle.LabelLarge,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

object ArticlesListConstants {
    const val ARTICLES_LIST_TEST_TAG = "ARTICLES_LIST_TEST_TAG"
}

