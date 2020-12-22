package com.example.recipeapp.view.ui.saved

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SavedViewModelFactory(
    private val context: Context
) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>):
            T = SavedViewModel(context) as T
}