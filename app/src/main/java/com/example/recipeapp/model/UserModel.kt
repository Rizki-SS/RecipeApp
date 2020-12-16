package com.example.recipeapp.model

data class UserModel(
    val id: Int,
    val name: String,
    val token: String,
    val username: String
)

class UserRequestModel{
    var username: String? = null
    var password: String? = null
    var name:String? = null
}