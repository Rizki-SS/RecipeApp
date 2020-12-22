package com.example.recipeapp.utility.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.R
import com.example.recipeapp.databinding.ItemRecipesLayoutBinding
import com.example.recipeapp.model.RecipeModel


class RecipeAdaptor(
    private var data: List<RecipeModel>,
    private val id_destination: Int
) : RecyclerView.Adapter<RecipeAdaptor.ItemViewHolder>() {

    class ItemViewHolder(
        val listItemBinding: ItemRecipesLayoutBinding
    ) : RecyclerView.ViewHolder(listItemBinding.root)

    override fun getItemCount() = data.size

    fun updateData(data:Any ?){
        this.data = data as List<RecipeModel>
        notifyDataSetChanged();
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_recipes_layout, parent, false
            )
        )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//        Log.d("String",data.get(position).toString())
        holder.listItemBinding.model = data.get(position)
        holder.itemView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                val activity = v!!.context as AppCompatActivity
                val bundle = bundleOf("id" to data.get(position).id)
                Navigation.findNavController(v).navigate(id_destination, bundle)
            }
        })
    }
}