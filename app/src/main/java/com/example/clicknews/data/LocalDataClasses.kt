package com.example.clicknews.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_articles")
data class LocalArticleInfo(
    @ColumnInfo(name = "news_headline") val newsHeadline : String ,
    @ColumnInfo(name = "news_url") @PrimaryKey val urlToNews : String ,
    @ColumnInfo(name = "news_thumbnail_url") val newsThumbnailUrl : String?,
    @ColumnInfo(name = "is_bookmarked") val isBookMarked : Boolean ,
    @ColumnInfo(name = "last_update_time") val updatedAt : Long = System.currentTimeMillis() )

@Entity(tableName = "breaking_news")
data class BreakingNews(
    @PrimaryKey(autoGenerate = true ) val id : Int ,
    @ColumnInfo(name = "breaking_news_url")val breakingNewsUrl : String
)
