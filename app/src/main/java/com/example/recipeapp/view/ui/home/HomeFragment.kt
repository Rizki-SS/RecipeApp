package com.example.recipeapp.view.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.recipeapp.R
import com.example.recipeapp.databinding.FragmentHomeBinding
import com.example.recipeapp.utility.Session
import com.example.recipeapp.utility.adapter.RecipeAdaptor

class HomeFragment : Fragment() {

    private lateinit var vm: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        vm = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        vm.session = Session(this.requireContext())
        binding.vm = vm
        vm.recipeList.observe(this, Observer {
            binding.list.adapter = RecipeAdaptor(it, R.id.action_navigation_home_to_detailFragment)
            binding.loading.visibility = View.GONE
        })
        return binding.root
    }
}