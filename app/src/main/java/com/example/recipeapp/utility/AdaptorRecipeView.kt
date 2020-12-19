package com.example.recipeapp.utility

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.R
import com.example.recipeapp.databinding.ItemRecipesLayoutBinding
import com.example.recipeapp.model.RecipeModel

class AdaptorRecipeView(
    private var data: List<RecipeModel>
) : RecyclerView.Adapter<AdaptorRecipeView.ItemViewHolder>() {

    class ItemViewHolder(
        val listItemBinding: ItemRecipesLayoutBinding
    ) : RecyclerView.ViewHolder(listItemBinding.root)

    override fun getItemCount() = data.size

    fun updateData(data:List<RecipeModel>){
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_recipes_layout, parent, false)
    )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//        Log.d("String",data.get(position).toString())
        holder.listItemBinding.model = data.get(position)
        holder.itemView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                val activity = v!!.context as AppCompatActivity
            }
        })
    }
}