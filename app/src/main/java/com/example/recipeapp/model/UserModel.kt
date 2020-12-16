package com.example.recipeapp.model

data class UserModel(
    val id: Int,
    val name: String,
    val token: String,
    val username: String
)

data class UserLoginModel(
    val username: String,
    val password: String
)

data class UserRegisterModel(
    val username: String,
    val password: String,
    val name:String
)