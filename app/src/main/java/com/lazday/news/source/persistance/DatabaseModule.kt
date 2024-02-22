package com.lazday.news.source.persistance

import android.app.Application
import androidx.room.Room
import com.lazday.news.source.model.NewsDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val databaseModule = module {
    single { provideDatabase(androidApplication()) }
    single { provideNews(get()) }

}

fun provideDatabase(application: Application): DatabaseClient {
    return Room.databaseBuilder(
        application,
        DatabaseClient::class.java,
        "news-database.db"
    ).fallbackToDestructiveMigration()
        .build()
}

fun provideNews(databaseClient: DatabaseClient): NewsDao {
    return databaseClient.newsDao
}