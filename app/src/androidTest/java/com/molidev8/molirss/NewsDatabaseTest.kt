package com.molidev8.molirss

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.filters.SmallTest
import com.molidev8.molirss.data.database.NewsDatabase
import com.molidev8.molirss.data.database.NewsSource
import org.junit.After
import org.junit.Test

@SmallTest
class NewsDatabaseTest {

    private val db: NewsDatabase = Room.inMemoryDatabaseBuilder(
        getApplicationContext(),
        NewsDatabase::class.java
    ).allowMainThreadQueries().build()

    private val newsSource = NewsSource("1", "Test", false)

    @After
    fun close() {
        db.close()
    }

    @Test
    fun insertNewsSourceAndGet() = with(db.dao()) {
        insertNewsSource(newsSource)
        val obtainedNewsSources = getNewsSources()
        assert(obtainedNewsSources.first() == newsSource)
    }


    @Test
    fun updateNewsSource() = with(db.dao()) {
        insertNewsSource(newsSource)
        val updatedNewsSource = newsSource.copy(name = "TestCopy")
        updateNewsSource(updatedNewsSource)
        val obtainedNewsSources = getNewsSources()
        assert(obtainedNewsSources.first() == updatedNewsSource)
    }


    @Test
    fun insertNewsSourceAndRemove() = with(db.dao()) {
        insertNewsSource(newsSource)
        deleteNewsSource(newsSource)
        val obtainedNewsSources = getNewsSources()
        assert(obtainedNewsSources.isEmpty())
    }

}