package com.molidev8.molirss.di

import android.app.Application
import com.molidev8.molirss.data.NewsRepository
import com.molidev8.molirss.data.Preferences
import com.molidev8.molirss.data.database.NewsDatabase
import com.molidev8.molirss.data.network.NewsApi
import com.molidev8.molirss.data.network.NewsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun databaseProvider(context: Application): NewsDatabase = NewsDatabase.getInstance(context)

    @Provides
    @Singleton
    fun newsServiceProvider(): NewsService = NewsApi.retrofitService

    @Provides
    @Singleton
    fun preferencesProvider(context: Application): Preferences = Preferences(context)

    @Provides
    @Singleton
    fun newsRepositoryProvider(
        newsService: NewsService,
        newsDatabase: NewsDatabase,
        preferences: Preferences
    ): NewsRepository = NewsRepository(newsService, newsDatabase, preferences)
}