package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val slices = 6
        val random = Random()
        val randomNumber = random.nextInt(slices) + 1
        Log.w("MainActivity", " Random Number = ${randomNumber}")


    }
}