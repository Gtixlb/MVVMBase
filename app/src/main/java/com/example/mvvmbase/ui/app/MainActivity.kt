package com.example.mvvmbase.ui.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmbase.R
import com.example.mvvmbase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(this.root)
        }
    }
}