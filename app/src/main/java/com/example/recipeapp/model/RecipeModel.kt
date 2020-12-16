package com.example.recipeapp.model

data class RecipeModel(
    val description: String,
    val id: Int,
    val image: String,
    val ingredients: String,
    val instructions: String,
    val title: String
)