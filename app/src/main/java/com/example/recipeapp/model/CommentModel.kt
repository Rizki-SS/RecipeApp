package com.example.recipeapp.model

data class CommentModel(
    val comment: String,
    val id: Int,
    val recipe_id: Int,
    val user: User,
    val user_id: Int
)

data class User(
    val id: Int,
    val name: String,
    val password: String,
    val username: String
)