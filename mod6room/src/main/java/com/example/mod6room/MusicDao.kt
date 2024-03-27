package com.example.mod6room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MusicDao {
    @Insert
    fun insert(music: Music)
    @Query("SELECT * FROM Music")
    fun getAllMusic() : Flow<List<Music>>
    @Delete
    fun deleteMusic(music: Music)
}