package com.example.recipeapp.view.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recipeapp.utility.Session
import com.example.recipeapp.view.ui.comment.CommentViewModel

class AuthViewModelFactory(
    private val session:Session
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        AuthViewModel(session) as T
}