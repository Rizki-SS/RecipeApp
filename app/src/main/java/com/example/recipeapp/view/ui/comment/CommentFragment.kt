package com.example.recipeapp.view.ui.comment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.viewModels
import com.example.recipeapp.databinding.FragmentCommentBinding
import com.example.recipeapp.utility.Session
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class CommentFragment(
    private val id_recipe:Int
) : BottomSheetDialogFragment() {

    private lateinit var binding:FragmentCommentBinding
    val vm:CommentViewModel by viewModels{
        CommentViewModelFactory(Session(this.requireContext()), id_recipe)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommentBinding.inflate(layoutInflater, container,false)
        binding.vm = vm
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sendEditText.setOnEditorActionListener { v, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    vm.addComment(binding.sendEditText.text.toString())
                    binding.sendEditText.text = null
                    val imm: InputMethodManager = v.context
                        .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(v.windowToken, 0)
                    true
                }
                else -> false
            }
        }
    }
}