package com.example.mvvmbase.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmbase.network.APIResponse
import com.example.mvvmbase.network.RequestBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class PublicViewModel: ViewModel() {

    val testValue by lazy{
        MutableLiveData("")
    }

    // 独立对象，避免变量污染
    private val requestBuilder = RequestBuilder()

    fun <T> getAPI(apiType: Class<T>): T = requestBuilder.getAPI(apiType)

    // 挂起函数
    fun <T> Call<T>.getResponse(process: suspend (flow: Flow<APIResponse<T>>) -> Unit){
        // 协成处理
        viewModelScope.launch(Dispatchers.IO){
            process(requestBuilder.getResponseFlow {
                this@getResponse.execute()
            })
        }

    }


}