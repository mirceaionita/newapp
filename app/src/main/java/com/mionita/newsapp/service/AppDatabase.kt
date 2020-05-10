package com.mionita.newsapp.service

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mionita.newsapp.dao.FavoriteDao
import com.mionita.newsapp.model.Favorite

@Database(entities = [Favorite::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}