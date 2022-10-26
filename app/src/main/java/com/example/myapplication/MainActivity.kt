package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dice = Dice(6)
        val luckyNumber = 6


        val diceRollButton: Button = findViewById(R.id.buttonDice)
        diceRollButton.setOnClickListener {
            val rollResult = dice.roll()

            Log.w("MainActivity", "Your ${dice.slices} sided dice rolled  ${rollResult}!")

            when(rollResult){
                6->Toast.makeText(this, "برنده شدی", Toast.LENGTH_LONG).show()
                5->Toast.makeText(this, "نزدیک بود ولی برنده نشدی!", Toast.LENGTH_SHORT).show()
                4->Toast.makeText(this, "تو می‌تونی موفق بشی، دوباره تلاش کن", Toast.LENGTH_SHORT).show()
                3->Toast.makeText(this, "تلاش بیشتر شانس بیشتر!", Toast.LENGTH_SHORT).show()
                2->Toast.makeText(this, "نشد که بشه! دوباره امتحان کن", Toast.LENGTH_SHORT).show()
                1->Toast.makeText(this, "خیلی بد شانسی می‌خوای دوباره شانستو امحتحان کنی؟", Toast.LENGTH_SHORT).show()
            }
        }


    }
}