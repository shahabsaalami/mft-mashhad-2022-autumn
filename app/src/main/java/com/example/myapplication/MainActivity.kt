package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dice = Dice(6)
        val randomNumber = dice.roll()
        Log.w("MainActivity", "Your ${dice.slices} sided dice rolled  ${randomNumber}!")


    }
}