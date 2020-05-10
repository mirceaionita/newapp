package com.mionita.newsapp.model

import java.util.*

object NewsContent {

    val ITEMS: MutableList<NewsItem> = ArrayList()

    fun createNewsList(news: News) {
        val iterator = news.results.iterator()
        for ((index, value) in iterator.withIndex()) {
            ITEMS.add(
                createNewsItem(
                    index,
                    value
                )
            )
        }
    }

    private fun createNewsItem(position: Int, article: Articles): NewsItem {
        return NewsItem(
            position.toString(),
            article.title,
            article.description,
            article.getUrlToImage(),
            article.url,
            article.publishedAt
        )
    }

    data class NewsItem(val id: String, val title: String, val details: String, val image: String, val url: String, val publishedAt: Date) {
        override fun toString(): String = title
    }
}
