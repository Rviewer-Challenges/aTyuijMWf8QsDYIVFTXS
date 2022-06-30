package com.molidev8.molirss.data.database

import androidx.room.*

@Dao
interface NewsDatabaseDao {

    @Query("SELECT * FROM NewsSource")
    fun getNewsSources(): List<NewsSource>

    @Query("SELECT * FROM Bookmark")
    fun getBookmarks(): List<Bookmark>

    @Insert
    fun insertNewsSource(newsSource: NewsSource)

    @Insert
    fun insertBookmark(bookmark: Bookmark)

    @Update
    fun updateNewsSource(newsSource: NewsSource)

    @Delete
    fun deleteNewsSource(newsSource: NewsSource)

    @Delete
    fun deleteBookmark(bookmark: Bookmark)
}