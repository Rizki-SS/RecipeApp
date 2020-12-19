package com.example.recipeapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipeapp.api.ApiClient
import com.example.recipeapp.model.RecipeModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val _recipeList = MutableLiveData<List<RecipeModel>>()
    val recipeList: LiveData<List<RecipeModel>> get() = _recipeList

    private val _username = MutableLiveData<String>()
    val username: LiveData<String> get() = _username

    init {
        val api = ApiClient().getApiServic();
        api.getRecipe().enqueue(object : Callback<List<RecipeModel>> {
            override fun onFailure(call: Call<List<RecipeModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<List<RecipeModel>>,
                response: Response<List<RecipeModel>>
            ) {
                _recipeList.value = response.body()
                _username.value = "Wooiiiii"
//                Log.d("test", recipeList.value.toString())
            }
        })
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}