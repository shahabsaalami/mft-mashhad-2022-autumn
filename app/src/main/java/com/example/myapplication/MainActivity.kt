package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.math.floor

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val squareCabin = SquareCabin(6)
        with(squareCabin) {
            println("\nSquare Cabin \n =================")
            println("Capacity=${capacity}")
            println("buildingMaterial=${buildingMaterial}")
            println("HasRoom?=${hasRoom()}")
        }
        val roundCabin = RoundCabin(5)
        with(roundCabin) {
            println("\nroundCabin Cabin \n =================")
            println("Capacity=${capacity}")
            println("buildingMaterial=${buildingMaterial}")
            println("HasRoom?=${hasRoom()}")
        }
        val roundTower = RoundTower(4, floors= 2)
        with(roundTower) {
            println("\nRound Tower\n==========")
            println("Material: $buildingMaterial")
            println("floors: $floors")
            println("Capacity: $capacity")
            println("Has room? ${hasRoom()}")
        }


    }
}