package com.example.recipeapp.utility

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.model.RecipeModel
import com.squareup.picasso.Picasso

@BindingAdapter("android:imgUrl")
fun loadImage(view: ImageView, url:String? ) {
    Picasso.get().load(url).into(view)
}

@BindingAdapter("android:setRecipeAdapter")
fun setAdapterRecipe(view: RecyclerView, list: List<RecipeModel>? ) {
    Log.d("list", list.toString())
    view.adapter = list?.let { AdaptorRecipeView(it) }
}