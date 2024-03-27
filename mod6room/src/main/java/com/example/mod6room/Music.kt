package com.example.mod6room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Music(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L,
    val title: String,
    val author: String,
    val lengthInSeconds : Int
)
