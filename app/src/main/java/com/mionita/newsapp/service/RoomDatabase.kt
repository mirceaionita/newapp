package com.mionita.newsapp.service

import android.content.Context
import androidx.room.Room

object RoomDatabase : SingletonHolder<AppDatabase, Context>({
    Room.databaseBuilder(it.applicationContext, AppDatabase::class.java, "newsapp-database").build()
})