package com.lazday.news.source.model

data class ArticleModel(
    val source: SourceModel?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?
)


