package com.example.recipeapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.recipeapp.R
import com.example.recipeapp.session.Session

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var session = Session(this)
        Log.d("token",session.tokenUser!!)
    }
}