package com.lazday.news.source.model

data class NewsModel(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleModel>
)
