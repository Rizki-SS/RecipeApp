package com.example.recipeapp.session

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.recipeapp.model.UserModel


class Session(context: Context){
    private val USERNAME_KEY = "key_username"
    private val NAME_KEY = "key_name"
    private val TOKEN_KEY = "key_token"
    private val ID = "key_id"
    private val preferences = context.getSharedPreferences("session", Context.MODE_PRIVATE);

    val isLogin:Boolean
        get() {
            return preferences.getBoolean(TOKEN_KEY,true)
        }

    val idUser:Int
        get() {
            return preferences.getInt(ID, 0)
        }

    val nameUser: String?
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