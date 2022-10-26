package com.example.myapplication

import java.util.*

class Dice(val slices: Int =6) {


    fun roll(): Int {
        val random = Random()
        val randomNumber = random.nextInt(slices) + 1
        return randomNumber
    }
}