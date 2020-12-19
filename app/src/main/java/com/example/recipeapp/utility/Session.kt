package com.example.recipeapp.utility

import android.content.Context
import android.content.SharedPreferences
import com.example.recipeapp.model.UserModel


class Session(context: Context){
    private val USERNAME_KEY = "key_username"
    private val NAME_KEY = "key_name"
    private val TOKEN_KEY = "key_token"
    private val ID = "key_id"
    private val PREFS_NAME = "mas_koki"
    val preferences: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    val isLogin:Boolean
        get() {
            return !tokenUser.isNullOrEmpty()
        }

    val idUser:Int
        get() {
            return preferences.getInt(ID, 0)
        }

    val name: String?
        get() {
            return preferences.getString(NAME_KEY,"")
        }

    val tokenUser: String?
        get() {
            return preferences.getString(TOKEN_KEY,"")
        }

    val userName: String?
        get() {
            return preferences.getString(USERNAME_KEY,"")
        }

    fun setUser(userModel:UserModel){
        with(preferences.edit()){
            putInt(ID, userModel.id)
            putString(NAME_KEY,userModel.name)
            putString(USERNAME_KEY, userModel.name)
            putString(TOKEN_KEY, userModel.token)
            apply()
        }
    }
}