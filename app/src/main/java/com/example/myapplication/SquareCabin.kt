package com.example.myapplication

class SquareCabin(residents: Int) :Dwelling(residents){
    override val buildingMaterial: String = "Wood"
    override val capacity: Int = 6
}