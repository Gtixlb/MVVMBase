package com.example.mvvmbase.network.res

data class UserLoginRes(
    var userId: Int,
    var account: String,
    var password: String,
    var nickname: String,
)
