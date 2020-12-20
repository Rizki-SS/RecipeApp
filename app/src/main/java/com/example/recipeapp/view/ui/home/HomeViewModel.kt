package com.example.recipeapp.view.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipeapp.api.ApiClient
import com.example.recipeapp.model.RecipeModel
import com.example.recipeapp.utility.Session
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    lateinit var session:Session

    private val _recipeList = MutableLiveData<List<RecipeModel>>()
    val recipeList: LiveData<List<RecipeModel>> get() = _recipeList

    init {
        val api = ApiClient().getApiServic();
        api.getRecipe().enqueue(object : Callback<List<RecipeModel>> {
            override fun onFailure(call: Call<List<RecipeModel>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<List<RecipeModel>>,
                response: Response<List<RecipeModel>>
            ) {
                _recipeList.value = response.body()
            }
        })
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}