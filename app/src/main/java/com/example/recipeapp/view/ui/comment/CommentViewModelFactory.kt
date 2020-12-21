package com.example.recipeapp.view.ui.comment

import android.app.Application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recipeapp.utility.Session

class CommentViewModelFactory(
    private val session: Session,
    private val id: Int
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(DetailVIewModel: Class<T>): T =
        CommentViewModel(id, session) as T
}