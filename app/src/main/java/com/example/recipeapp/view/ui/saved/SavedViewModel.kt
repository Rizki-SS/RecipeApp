package com.example.recipeapp.view.ui.saved

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipeapp.model.RecipeModel
import com.example.recipeapp.utility.db.BookMarkDBHandle

class SavedViewModel(
    private val context:Context
) : ViewModel() {

    private val _recipeList = MutableLiveData<List<RecipeModel>>()
    val recipeList: LiveData<List<RecipeModel>> get() = _recipeList

    private val bookMarkDB = BookMarkDBHandle(context)

    init {
        _recipeList.value = bookMarkDB.gelAll()
    }
}