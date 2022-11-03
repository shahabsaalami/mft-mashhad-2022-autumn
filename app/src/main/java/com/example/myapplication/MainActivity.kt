package com.example.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.LetterAdapter

class MainActivity : AppCompatActivity() {

    private var isLinearLayoutManager = true
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        // Generates a [CharRange] from 'A' to 'Z' and converts it to a list
        val listOfChars = ('A').rangeTo('Z')

        recyclerView.layoutManager = GridLayoutManager(this, 4)
        recyclerView.adapter = LetterAdapter(listOfChars.toList())


    }

    fun chooseLayout() {
        if (isLinearLayoutManager) {
            recyclerView.layoutManager = LinearLayoutManager(this)
        } else {
            recyclerView.layoutManager = GridLayoutManager(this, 4)
        }
        val listOfChars = ('A').rangeTo('Z')
        recyclerView.adapter = LetterAdapter(listOfChars.toList())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)
        val layoutButton = menu?.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)

        // Calls code to set the icon based on the LinearLayoutManager of the RecyclerView
        return true
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this, R.drawable.ic_baseline_grid_view)
            else ContextCompat.getDrawable(this, R.drawable.ic_baseline_view_stream_24)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                // Sets isLinearLayoutManager (a Boolean) to the opposite value
                isLinearLayoutManager = !isLinearLayoutManager
                // Sets layout and icon
                chooseLayout()
                setIcon(item)

                return true
            }
            //  Otherwise, do nothing and use the core event handling

            // when clauses require that all possible paths be accounted for explicitly,
            //  for instance both the true and false cases if the value is a Boolean,
            //  or an else to catch all unhandled cases.
            else -> super.onOptionsItemSelected(item)
        }
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