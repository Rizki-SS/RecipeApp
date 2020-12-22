package com.example.recipeapp.view.ui.saved

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.recipeapp.R
import com.example.recipeapp.databinding.FragmentSavedBinding
import com.example.recipeapp.utility.adapter.RecipeAdaptor

class SavedFragment : Fragment() {

    private lateinit var binding:FragmentSavedBinding
    private val vm: SavedViewModel by viewModels {
        SavedViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSavedBinding.inflate(layoutInflater,container,false)
        binding.vm = vm
        vm.recipeList.observe(this, Observer {
            binding.list.adapter = RecipeAdaptor(it, R.id.action_navigation_saved_to_detailFragment)
        })
        return binding.root
    }
}