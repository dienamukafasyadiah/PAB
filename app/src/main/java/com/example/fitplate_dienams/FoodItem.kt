package com.example.fitplate_dienams

data class FoodItem(
    val id: Int,
    val name: String,
    val mealTime: String,
    val calories: Int,
    val carbs: Int,
    val protein: Int,
    val fat: Int
)