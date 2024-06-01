package com.example.clicknews.data

import com.example.clicknews.network.NewsApiService
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsApiService: NewsApiService,
                                         clickNewsDatabase: ClickNewsDatabase)
{

    val generalDao = clickNewsDatabase.generalDao()

    suspend fun getBreakingNews() : List<LocalArticleInfo>
    {
        val newsDataFromWeb = newsApiService.getTopHeadlines("us")
        val webArticleInfoList = newsDataFromWeb.articles
        return webArticleInfoList.map {
            LocalArticleInfo(it.title ,
                it.urlToArticle,
                it.urlToImage,
                false)
        }
    }

}