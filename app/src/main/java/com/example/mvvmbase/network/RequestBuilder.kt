package com.example.mvvmbase.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.OkHttpClient
import retrofit2.Response
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

    // 网络请求条件判断
    fun <T> getResponseFlow(requestFun: () -> Response<T>): Flow<APIResponse<T>> =
        flow {
            emit(APIResponse.Loading)
            try {
                with(requestFun()) {
                    if (isSuccessful) {
                        if (body() == null) {
                            emit(APIResponse.Error("body为null"))
                        } else {
                            emit(APIResponse.Success(body()))
                        }
                    } else {
                        emit(APIResponse.Error("网络请求失败"))
                    }
                }
            } catch (e: Exception) {
                emit(APIResponse.Error("${e.message}"))
            }
        }

    fun <T> getAPI(apiType: Class<T>): T = retrofitBuilder.create(apiType)

    companion object {
        const val REQUEST_URL = "http://10.55.0.136:8555/rest/park/"
    }


}

sealed class APIResponse<out T> {
    data class Success<out T>(val response: T) : APIResponse<T>()

    data class Error(val errMsg: String) : APIResponse<Nothing>()

    // 只需要状态，不需要返回类型
    object Loading : APIResponse<Nothing>()
}





