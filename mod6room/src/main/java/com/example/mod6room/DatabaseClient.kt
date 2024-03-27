package com.example.mod6room

import android.content.Context
import androidx.room.Room

class DatabaseClient(context : Context) {
    val appDatabase : AppDatabase = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java, "appDatabase.db"
    ).build()
}