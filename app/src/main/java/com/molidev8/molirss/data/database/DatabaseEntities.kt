package com.molidev8.molirss.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NewsSource(
    @PrimaryKey val id: String,
    val name: String,
    val isEnabled: Boolean
)

@Entity
data class Bookmark(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val sourceId: String,
    val title: String,
    val url: String,
    val urlToImage: String
)