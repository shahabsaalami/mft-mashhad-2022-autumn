package com.example.myapplication

open class RoundCabin(resident: Int) : Dwelling(resident) {
    override val buildingMaterial: String ="Ney"
    override val capacity: Int = 4
}