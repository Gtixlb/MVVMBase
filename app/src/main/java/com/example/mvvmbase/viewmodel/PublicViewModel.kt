package com.example.mvvmbase.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PublicViewModel: ViewModel() {

    val testValue by lazy{
        MutableLiveData("")
    }


}