package com.example.myapplication

class RoundTower(residents: Int, val floors: Int) : RoundCabin(residents) {
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors
}
