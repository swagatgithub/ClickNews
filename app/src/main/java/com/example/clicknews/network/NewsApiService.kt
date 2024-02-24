package com.example.clicknews.network

import com.example.clicknews.BuildConfig
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApiService {

    companion object {
        const val BASE_URL = " https://newsapi.org/v2/"
    }

    //provides live top and breaking headlines for a country
    @Headers("X-Api-Key:${BuildConfig.newsApiKey}")
    @GET("top-headlines")
    suspend fun getTopHeadlines(@Query("country") countryName : String) : NewsDataFromWeb

    //endpoint suits article discovery and analysis
    @Headers("X-Api-Key:${BuildConfig.newsApiKey}")
    @GET("everything")
    suspend fun getEverything(@Query("q") keywordToSearch : String) : NewsDataFromWeb

}