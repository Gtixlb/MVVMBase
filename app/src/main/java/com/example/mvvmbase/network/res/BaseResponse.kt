package com.example.mvvmbase.network.res

data class BaseResponse<T>(
    val status: String,
    val message: String,
    var data: T? = null
)