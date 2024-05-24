package com.gomaa.nytimesarticles.features.populararticles.presentation.ui.components

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.gomaa.nytimesarticles.features.populararticles.presentation.model.ArticleUiEntity
import com.gomaa.nytimesarticles.ui.theme.NYTextStyle

@Composable
fun ArticlesList(articles: List<ArticleUiEntity>, onItemClick: (ArticleUiEntity) -> Unit) {
    LazyColumn(state = rememberLazyListState(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
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
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.4f)
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent, Color.Black.copy(alpha = 0.4f)
                                ), startY = 0f, endY = 100f
                            )
                        )
                        .align(Alignment.BottomStart)
                ) {
                    NYText(
                        text = item.title,
                        nyTextStyle = NYTextStyle.BodySmall,
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
