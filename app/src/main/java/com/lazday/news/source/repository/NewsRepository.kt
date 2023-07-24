package com.lazday.news.source.repository

import com.lazday.news.BuildConfig
import com.lazday.news.source.model.NewsModel
import com.lazday.news.source.network.ApiClient
import org.koin.dsl.module

val repositoryModule = module {
        factory { NewsRepository(get()) }
}

class NewsRepository (
        private val api: ApiClient
) {

        suspend fun fetch(
                category: String,
                query: String,
                page: Int
        ): NewsModel {
                return api.fetchNews(
                        BuildConfig.API_KEY,
                        "id",
                        category,
                        query,
                        page
                )
        }

}