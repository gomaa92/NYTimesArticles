package com.gomaa.nytimesarticles.features.populararticles.presentation.mapper

import com.gomaa.nytimesarticles.features.populararticles.data.model.Article
import com.gomaa.nytimesarticles.features.populararticles.presentation.model.ArticleUiEntity
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

object ArticlesDomainMapper {
    private fun mapDataArticleToUiArticle(article: Article): ArticleUiEntity {
        return ArticleUiEntity(
            title = article.title.orEmpty(),
            publishedDate = article.publishedDate.orEmpty(),
            byLine = article.byline.orEmpty(),
            url = article.url.orEmpty(),
            smallThumbnail = article.media?.firstOrNull()?.mediaMetadata?.get(0)?.url ?: "",
            mediumThumbnail = article.media?.firstOrNull()?.mediaMetadata?.get(1)?.url ?: "",
            largeThumbnail = article.media?.firstOrNull()?.mediaMetadata?.get(2)?.url ?: "",
            publishedAgo = calculateDaysBetween(article.publishedDate.orEmpty())
        )
    }

    fun mapDataArticlesToUiArticles(articles: List<Article>): List<ArticleUiEntity> {
        return articles.map { article ->
            mapDataArticleToUiArticle(article)
        }
    }

    private fun calculateDaysBetween(publishedDate: String): String {
        val formatter = DateTimeFormatter.ISO_LOCAL_DATE

        // Parse the given date
        val givenDate = LocalDate.parse(publishedDate, formatter)

        // Get the current date
        val currentDate = LocalDate.now()

        // Calculate the difference in days
        val daysDifference = ChronoUnit.DAYS.between(givenDate, currentDate)

        // Create a human-readable result
        return when {
            daysDifference > 0 -> "$daysDifference day(s) ago"
            daysDifference < 0 -> "${-daysDifference} day(s) from now"
            else -> "Today"
        }
    }
}