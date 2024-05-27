package com.gomaa.presentation.mapper

import com.gomaa.data.model.Article
import com.gomaa.presentation.model.ArticleUiEntity
import org.jetbrains.annotations.VisibleForTesting
import java.time.Clock
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

object ArticlesUIMapper {
    private fun mapDataArticleToUiArticle(article: Article): ArticleUiEntity {
        return ArticleUiEntity(
            title = article.title.orEmpty(),
            publishedDate = article.publishedDate.orEmpty(),
            byLine = article.byline.orEmpty(),
            url = article.url.orEmpty(),
            smallThumbnail = article.media?.firstOrNull()?.mediaMetadata?.get(0)?.url.orEmpty(),
            mediumThumbnail = article.media?.firstOrNull()?.mediaMetadata?.get(1)?.url.orEmpty(),
            largeThumbnail = article.media?.firstOrNull()?.mediaMetadata?.get(2)?.url.orEmpty(),
            publishedAgo = calculateDaysBetween(article.publishedDate.orEmpty())
        )
    }

    fun mapDataArticlesToUiArticles(articles: List<Article>): List<ArticleUiEntity> {
        return articles.map { article ->
            mapDataArticleToUiArticle(article)
        }
    }

    @VisibleForTesting
    fun calculateDaysBetween(publishedDate: String, clock: Clock = Clock.systemDefaultZone()): String {
        val formatter = DateTimeFormatter.ISO_LOCAL_DATE

        val givenDate = LocalDate.parse(publishedDate, formatter)
        val currentDate = LocalDate.now(clock)

        val daysDifference = ChronoUnit.DAYS.between(givenDate, currentDate)

        return when {
            daysDifference > 0 -> "$daysDifference day(s) ago"
            daysDifference < 0 -> "${-daysDifference} day(s) from now" // This case shouldn't be called ever
            else -> "Today"
        }
    }
}