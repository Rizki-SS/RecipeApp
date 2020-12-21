package com.example.recipeapp.utility

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.R
import com.example.recipeapp.databinding.ItemCommentLayoutBinding
import com.example.recipeapp.databinding.ItemRecipesLayoutBinding
import com.example.recipeapp.model.CommentModel
import com.example.recipeapp.model.RecipeModel

class CommentAdapter(
    private var data: List<CommentModel>
) : RecyclerView.Adapter<CommentAdapter.ItemViewHolder>() {

    class ItemViewHolder(
        val listItemBinding: ItemCommentLayoutBinding
    ) : RecyclerView.ViewHolder(listItemBinding.root)

    override fun getItemCount() = data.size

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int) = ItemViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_comment_layout, parent, false)
    )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.listItemBinding.model = data.get(position)
    }
}