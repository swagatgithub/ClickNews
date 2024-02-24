package com.example.clicknews.data

import com.example.clicknews.network.NewsApiService
import javax.inject.Inject

class NewsRepository @Inject constructor(val newsApiService: NewsApiService,
                                         val clickNewsDatabase: ClickNewsDatabase)
{
    val generalDao = clickNewsDatabase.generalDao()
}