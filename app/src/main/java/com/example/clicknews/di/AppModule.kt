package com.example.clicknews.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.clicknews.data.ClickNewsDatabase
import com.example.clicknews.network.NewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit
    {
        return Retrofit.Builder()
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