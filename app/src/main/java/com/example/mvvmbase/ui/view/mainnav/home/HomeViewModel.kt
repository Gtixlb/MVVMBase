package com.example.mvvmbase.ui.view.mainnav.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel:ViewModel() {
    val testValue by lazy{
        MutableLiveData("")
    }

}