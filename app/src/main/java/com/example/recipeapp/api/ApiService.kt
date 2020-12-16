package com.example.recipeapp.api

import com.example.recipeapp.model.*
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("/api/comments/{id}")
    fun getCommentDetail(
        @Path("id") id:String
    ): Call <CommentModel>

    @DELETE("/api/comments/{id}")
    fun deleteCommentDetail(
        @Path("id")id:String,
        @Header("Authorization") key:String
    ):Call <CommentModel>

    @GET("/api/recipes")
    fun getRecipe():Call <List<RecipeModel>>

    @GET("/api/recipes/{id}")
    fun getRecipeDetail(
        @Path("id")id:String
    ):Call <RecipeModel>

    @GET("/api/recipes/{recipeId}/comments")
    fun getRecipeComment(
        @Path("recipeId") recipeId:String
    ):Call <CommentModel>

    @POST("/api/recipes/{recipeId}/comments")
    fun postComment(
        @Body comment:String,
        @Path("recipeId") recipeId:String,
        @Header("Authorization") key:String
    ):Call <List<CommentModel>>

    @PUT("/api/recipes/{recipeId}/comments/{id}")
    fun updateComment(
        @Body comment:String,
        @Path("recipeId") recipeId:String,
        @Path("id") id:String,
        @Header("Authorization") key:String
    ):Call <CommentModel>

    @POST("/api/users/register")
    fun register(
        @Body user:UserRequestModel
    ):Call <UserModel>

    @POST("/api/users/token")
    fun login(
        @Body user:UserRequestModel
    ):Call <UserModel>
}