package com.example.recipeapp.view.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.recipeapp.databinding.FragmentHomeBinding
import com.example.recipeapp.utility.Session

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        homeViewModel.session = Session(this.requireContext())
        binding.vm = homeViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}