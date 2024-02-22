package com.lazday.news.source.persistance;

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lazday.news.source.model.ArticleModel
import com.lazday.news.source.model.NewsDao
import com.lazday.news.source.util.SourceConverter

@Database(
    entities = [
        ArticleModel::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(SourceConverter::class)
abstract class DatabaseClient: RoomDatabase() {
    abstract val newsDao: NewsDao
}
