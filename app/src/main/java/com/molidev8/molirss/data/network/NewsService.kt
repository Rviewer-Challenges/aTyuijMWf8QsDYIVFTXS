package com.molidev8.molirss.data.network

import com.molidev8.molirss.BuildConfig
import com.molidev8.molirss.domain.Everything
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://newsapi.org/v2/"

private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
    this.level = HttpLoggingInterceptor.Level.HEADERS
}

val client: OkHttpClient = OkHttpClient.Builder().apply {
    this.addInterceptor(interceptor)
}.build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .client(client)
    .build()

interface NewsServiceApi {

    private val apiKey get() = BuildConfig.NEWS_API_KEY

    // API sorts by newest articles by default
    @GET("everything")
    fun getEverything(
        @Query("apiKey") apiKey: String = this.apiKey,
        @Query("pageSize") pageSize: Int = 10,
        @Query("q") topic: String
    ): Call<Everything>
}

object NewsApi {
    val retrofitService: NewsServiceApi by lazy {
        retrofit.create(NewsServiceApi::class.java)
    }
}