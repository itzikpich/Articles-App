package com.itzikpichhadze.zemingoapp.data

import com.itzikpichhadze.zemingoapp.model.ArticleResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

const val BASE_URL = "https://www.globes.co.il/"

interface ApiService {

    @GET("webservice/rss/rssfeeder.asmx/FeederNode")
    suspend fun getCars(
        @Query("iID") id:Int=3220,
    ) : Response<ArticleResponse>

    @GET("webservice/rss/rssfeeder.asmx/FeederNode")
    suspend fun getTourism(
        @Query("iID") id:Int=9010,
    ) : Response<ArticleResponse>

    @GET("webservice/rss/rssfeeder.asmx/FeederNode")
    suspend fun getCareer(
        @Query("iID") id:Int=3266,
    ) : Response<ArticleResponse>

    @GET("webservice/rss/rssfeeder.asmx/FeederNode")
    suspend fun getDataById(
        @Query("iID") id:Int,
    ) : Response<ArticleResponse>

    companion object {
        // init Retrofit base server instance
        val client by lazy { invoke(BASE_URL) }

        operator fun invoke(baseUrl: String): ApiService {
//            val client = OkHttpClient.Builder().apply {
//                addNetworkInterceptor(loggingInterceptor)
//                connectTimeout(10, TimeUnit.MINUTES)
//                readTimeout(10, TimeUnit.MINUTES)
//                writeTimeout(10, TimeUnit.MINUTES)
//            }.build()

            return Retrofit.Builder()
//                .client(client)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }

}