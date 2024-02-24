package com.example.clicknews.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface GeneralDao {


    @Query("SELECT * FROM breaking_news INNER JOIN news_articles ON breaking_news_url = news_url" )
    fun getBreakingNewsArticle() : Flow<List<LocalArticleInfo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsArticle(newsArticles : List<LocalArticleInfo>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIntoBreakingNewsTable(breakingNewsArticles : List<BreakingNews>)

    @Query("DELETE FROM breaking_news")
    suspend fun deleteAllBreakingNews()
}