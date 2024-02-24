package com.example.clicknews.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LocalArticleInfo::class , BreakingNews::class] , version = 1  )
abstract class ClickNewsDatabase : RoomDatabase() {
    abstract fun  generalDao() : GeneralDao
}