package com.example.recipeapp.utility.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.R
import com.example.recipeapp.databinding.ItemCommentLayoutBinding
import com.example.recipeapp.model.CommentModel

class CommentAdapter(
    private var data: List<CommentModel>
) : RecyclerView.Adapter<CommentAdapter.ItemViewHolder>() {

    class ItemViewHolder(
        val listItemBinding: ItemCommentLayoutBinding
    ) : RecyclerView.ViewHolder(listItemBinding.root)

    override fun getItemCount() = data.size

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int) =
        ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_comment_layout, parent, false
            )
        )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.listItemBinding.model = data.get(position)
    }
}