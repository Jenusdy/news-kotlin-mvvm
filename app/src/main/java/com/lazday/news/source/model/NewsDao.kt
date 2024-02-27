package com.lazday.news.source.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface NewsDao {
    @Query("SELECT * FROM table_article")
    fun findAll(): LiveData<List<ArticleModel>>

    @Query("SELECT COUNT(*) FROM table_article WHERE publishedAt=:publish")
    suspend fun find(publish: String): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(articleModel: ArticleModel)

    @Delete
    suspend fun remove(articleModel: ArticleModel)

}