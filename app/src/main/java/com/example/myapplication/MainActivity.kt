package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.data.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView :TextView = findViewById(R.id.textView)

        val dataSource =DataSource()
        val listOfData = dataSource.loadAffirmations()

       textView .text =  listOfData.size.toString()
    }

}