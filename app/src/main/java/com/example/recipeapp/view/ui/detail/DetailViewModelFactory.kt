package com.example.recipeapp.view.ui.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DetailViewModelFactory(
    private val application: Application,
    private val id: Int
):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(DetailVIewModel: Class<T>): T =
        DetailVIewModel(application, id) as T
}