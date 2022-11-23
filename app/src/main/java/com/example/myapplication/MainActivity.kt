package com.example.myapplication

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            AppDatabase.getDatabase(applicationContext).californiaParkDao().getAll()
        }
    }
}