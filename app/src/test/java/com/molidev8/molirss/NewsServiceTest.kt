package com.molidev8.molirss

import androidx.test.filters.SmallTest
import com.molidev8.molirss.data.network.NewsApi
import com.molidev8.molirss.data.network.NewsServiceApi
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Before
import org.junit.Test

@SmallTest
class NewsServiceTest {

    private lateinit var newsService: NewsServiceApi

    @Before
    fun setup() {
        newsService = NewsApi.retrofitService
    }

    @Test
    fun requestAndParseNews() = runBlocking {
        withContext(IO) {
            val response = newsService.getEverything(topic = "food").execute()
            if (response.isSuccessful) {
                assert(response.body()?.articles?.isNotEmpty() == true)
            } else {
                throw NullPointerException("Body is empty")
            }
        }
    }
}