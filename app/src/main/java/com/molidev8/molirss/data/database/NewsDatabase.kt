package com.molidev8.molirss.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DATABASE_NAME = "news_db"

@Database(
    entities = [NewsSource::class, Bookmark::class],
    version = 1,
    exportSchema = false
)

abstract class NewsDatabase : RoomDatabase() {

    abstract fun dao(): NewsDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: NewsDatabase? = null

        fun getInstance(context: Context): NewsDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NewsDatabase::class.java,
                        DATABASE_NAME
                    ).setJournalMode(JournalMode.TRUNCATE).build()
                }
                return instance
            }
        }
    }

}