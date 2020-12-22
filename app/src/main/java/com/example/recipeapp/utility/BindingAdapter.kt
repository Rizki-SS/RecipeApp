package com.example.recipeapp.utility

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.model.CommentModel
import com.example.recipeapp.model.RecipeModel
import com.example.recipeapp.utility.adapter.CommentAdapter
import com.example.recipeapp.utility.adapter.RecipeAdaptor
import com.squareup.picasso.Picasso

@BindingAdapter("android:imgUrl")
fun loadImage(view: ImageView, url:String? ) {
    Picasso.get().load(url).into(view)
}

//@BindingAdapter("android:setRecipeAdapter")
//fun setAdapterRecipe(view: RecyclerView, list: List<RecipeModel>? ) {
//    view.adapter = list?.let {
//        RecipeAdaptor(
//            it
//        )
//    }
//}
//
//
@BindingAdapter("android:setCommentAdapter")
fun updateAdapter(view:RecyclerView, list: List<CommentModel>?){
    view.adapter = list?.let {
        CommentAdapter(
            it
        )
    }
}