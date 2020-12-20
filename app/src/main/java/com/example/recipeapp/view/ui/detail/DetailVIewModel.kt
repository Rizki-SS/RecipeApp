package com.example.recipeapp.view.ui.detail

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.recipeapp.api.ApiClient
import com.example.recipeapp.model.RecipeModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailVIewModel(application: Application, id:Int):ViewModel(){

    private val _recipe:MutableLiveData<RecipeModel> = MutableLiveData<RecipeModel>()
    val recipe:LiveData<RecipeModel> get() = _recipe

    init {
        val api = ApiClient().getApiServic();
        api.getRecipeDetail(id.toString()).enqueue(object : Callback<RecipeModel>{
            override fun onFailure(call: Call<RecipeModel>, t: Throwable) {

            }

            override fun onResponse(call: Call<RecipeModel>, response: Response<RecipeModel>) {
                _recipe.value = response.body()
            }

        })
    }

    fun navigateUp(view: View){
        Navigation.findNavController(view).navigateUp()
    }
}