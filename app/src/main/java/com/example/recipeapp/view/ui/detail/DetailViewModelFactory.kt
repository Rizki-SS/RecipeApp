package com.example.recipeapp.view.ui.detail

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DetailViewModelFactory(
    private val context: Context,
    private val id: Int
):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(DetailVIewModel: Class<T>): T =
        DetailVIewModel(context, id) as T
}