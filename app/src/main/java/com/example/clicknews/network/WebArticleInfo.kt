package com.example.clicknews.network

import com.google.gson.annotations.SerializedName
data class WebArticleInfo(val title : String, @SerializedName("url")val urlToArticle : String, val urlToImage : String, val publishedAt : String)