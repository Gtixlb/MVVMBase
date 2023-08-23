package com.example.mvvmbase.network.api

import com.example.mvvmbase.model.LoginInfo
import com.example.mvvmbase.network.res.BaseResponse
import com.example.mvvmbase.network.res.UserLoginRes
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface User {
    @POST("user/login")
    fun login(@Body loginInfo: LoginInfo): Call<BaseResponse<UserLoginRes>>
}