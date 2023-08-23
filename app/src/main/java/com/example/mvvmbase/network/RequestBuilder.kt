package com.example.mvvmbase.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RequestBuilder {

    private lateinit var retrofitBuilder: Retrofit

    init {
        OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .build().apply {
                retrofitBuilder = Retrofit.Builder()
                    .baseUrl(REQUEST_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(this)
                    .build()
            }
    }

    fun <T> getAPI(apiType: Class<T>): T = retrofitBuilder.create(apiType)

    companion object {
        const val REQUEST_URL = "http://10.55.0.136:8555/rest/park/"
    }


}