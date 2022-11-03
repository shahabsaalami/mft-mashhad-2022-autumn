package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main()

    }

    fun main() {
        val words = listOf(
            "about",
            "acute",
            "awesome",
            "balloon",
            "best",
            "Brief",
            "class",
            "coffee",
            "creative"
        )
        val filteredWords = words.filter { it.startsWith("b", ignoreCase = true) }
            .shuffled()
            .take(1)

        println(filteredWords)

    }

    private fun second() {
        val peopleAges = mutableMapOf<String, Int>(
            "Shahab" to 50,
            "Khayam" to 70,
            "Ferdowsi" to 20
        )


        peopleAges.put("Barbara", 42)
        peopleAges["Joe"] = 51
        peopleAges["Fred"] = 31

        println(peopleAges)
//        peopleAges.forEach { print("key=${it.key} is ${it.value}, ") }
//        println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", ") )

        val filteredNames = peopleAges.filter { it.key.length < 4 }
        println(filteredNames)

    }

    private fun first() {
        val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
        println("list:   ${numbers}")
        println("sort:   ${numbers.sorted()}")
        val setOfNumbers = numbers.sorted().toSet()
        println("setlist:   ${setOfNumbers}")

        //        val mouth: Set<Int> = setOf<Int>(1, 1, 1)
        val set1 = setOf(1, 2, 3)
        val set2 = mutableSetOf(3, 2, 1)

        println("$set1 == $set2: ${set1 == set2}")
        println("contains 7: ${setOfNumbers.contains(7)}")


    }

}