package com.example.recipeapp.view.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.recipeapp.R
import com.example.recipeapp.databinding.FragmentDetailBinding
import com.example.recipeapp.view.ui.comment.CommentFragment
import kotlinx.android.synthetic.main.fragment_detail.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    val vm: DetailVIewModel by viewModels {
        DetailViewModelFactory(requireContext(), requireArguments().getInt("id"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)
        binding.vm = vm
        binding.fragment = this
        vm.isSaved.observe(this, Observer {
            if (vm.isSaved.value!!){
                binding.saveBtn.setImageResource(R.drawable.ic_baseline_favorite_24)
            }else{
                binding.saveBtn.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            }
        })
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.actionBar?.hide();
    }


    fun openComment(view: View){
        getFragmentManager()?.let { vm.recipe.value?.id?.let { it1 -> CommentFragment(it1).show(it.beginTransaction(),"modal") } }
    }
}