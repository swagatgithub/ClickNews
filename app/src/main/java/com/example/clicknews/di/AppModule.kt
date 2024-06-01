package com.example.clicknews.di

import android.app.Application
import androidx.room.Room
import com.example.clicknews.data.ClickNewsDatabase
import com.example.clicknews.network.NewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit
    {
        val logging = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.HEADERS
          redactHeader("X-Api-Key")
        }
        val okHttpClient = OkHttpClient.Builder().addInterceptor(logging).build()
        return Retrofit.Builder().client(okHttpClient)
            .baseUrl(NewsApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideNewsApi(retrofit: Retrofit):NewsApiService
    {
        return retrofit.create(NewsApiService::class.java)
    }

    @Singleton
    @Provides
    fun getClickNewsDB(application : Application) : ClickNewsDatabase
    {
        return Room.databaseBuilder(application , ClickNewsDatabase::class.java ,"ClickNewsDatabase")
            .fallbackToDestructiveMigration()
            .build()
    }

}