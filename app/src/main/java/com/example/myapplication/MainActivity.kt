package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //How to use Kotlin data types, operators, and variables
        val name: String = "Khayyam"
        val birthdayInYear: Int = 1350
        var currentYear = 1401

        val age = currentYear - birthdayInYear

        println("$name has $age years old")

        //How to work with booleans and conditions
        var deathDate: Int = 1380
        // var isCorrect : Boolean = false
        // == , < , > , <= , >= , !=
        // *  / - +
        if (deathDate == 0) {
            println("$name currently is alive")
        } else {
            age = deathDate - birthdayInYear
            println("$name died in $deathDate, and have $age yeas old")
        }
        //The difference between nullable and non-nullable variables
        //Step 1: Learn about nullability
        //Step 2: Learn about the ? and ?: operators

        var family: String? = null
        println("$name $family.")


    }
}