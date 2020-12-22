package com.example.recipeapp.view.ui.account

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.recipeapp.databinding.FragmentAccountBinding
import com.example.recipeapp.utility.Session
import com.example.recipeapp.view.activity.AuthActivity


class AccountFragment : Fragment() {

    private lateinit var binding:FragmentAccountBinding
    lateinit var session:Session

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountBinding.inflate(layoutInflater, container, false)
        binding.vm = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        session = Session(requireContext())
    }

    fun logout(v: View){
        val alert: AlertDialog.Builder = AlertDialog.Builder(context)
        alert.setTitle("Logout")
        alert.setMessage("Do you realy to sing Out?")
        alert.setPositiveButton("Ok",
            DialogInterface.OnClickListener { dialog, whichButton ->
                session?.clear()
                startActivity(Intent(activity, AuthActivity::class.java))
                activity?.finish();
            })
        alert.setNegativeButton("Cancel",
            DialogInterface.OnClickListener { dialog, whichButton -> })
        alert.show()
    }
}