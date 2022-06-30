package com.molidev8.molirss.data

import com.molidev8.molirss.data.database.NewsDatabase
import com.molidev8.molirss.data.network.NewsService

class NewsRepository(
    val newsService: NewsService,
    newsDatabase: NewsDatabase,
    val preferences: Preferences
) {
    private val dao = newsDatabase.dao()
}