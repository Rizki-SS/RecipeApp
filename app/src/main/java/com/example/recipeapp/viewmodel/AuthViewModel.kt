package com.example.recipeapp.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.recipeapp.api.ApiClient
import com.example.recipeapp.model.UserModel
import com.example.recipeapp.model.UserRequestModel
import com.example.recipeapp.view.fargment.LoginFragmentDirections
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AuthViewModel:ViewModel(){
    //live data login status
    private val _isLogin = MutableLiveData<Boolean>()
    val isLogin: LiveData<Boolean> get() = _isLogin

    private val _userRequestModel = MutableLiveData<UserRequestModel>()
    val userRequestModel: LiveData<UserRequestModel> get() = _userRequestModel

    private val _error = MutableLiveData<String>()
    val error:LiveData<String> get() = _error

    init {
        _userRequestModel.value = UserRequestModel()
    }

    //login function
    fun login(view:View){
        val api = ApiClient().getApiServic();
        api.login(_userRequestModel.value!!)
            .enqueue(object :Callback<UserModel>{
                override fun onFailure(call: Call<UserModel>, t: Throwable) {
                    Log.d("Failed", t.message.toString())
                    _error.value = t.message.toString()
                }

                override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
//                    response.body()?.let { session.setUser(it) }
                    if (response.body()!=null){
                        _isLogin.value = true
                    }else{
                        _error.value = "Username atau password salah"
                        Log.d("failed", response.errorBody().toString())
                    }
                }

            })
    }

    //register function
    fun register(view:View){
        val api = ApiClient().getApiServic();
        api.register(_userRequestModel.value!!)
            .enqueue(object :Callback<UserModel>{
                override fun onFailure(call: Call<UserModel>, t: Throwable) {
                    Log.d("Failed", t.message.toString())
                    _error.value = t.message.toString()
                }

                override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                    if (response.body()!=null){
                        _isLogin.value = true
                    }else{
                        Log.d("failed", response.errorBody().toString())
                        _error.value = "Username atau password salah"

                    }
                }

            })
    }

    fun clickRegister(view:View){
        view.findNavController().navigate(
            LoginFragmentDirections.actionLoginFragment3ToRegisterFragment3()
        )
    }
}