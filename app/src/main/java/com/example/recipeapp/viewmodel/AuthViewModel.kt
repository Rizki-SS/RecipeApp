package com.example.recipeapp.viewmodel

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.recipeapp.api.ApiClient
import com.example.recipeapp.model.UserLoginModel
import com.example.recipeapp.model.UserModel
import com.example.recipeapp.session.Session
import com.example.recipeapp.view.fargment.LoginFragmentDirections
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AuthViewModel:ViewModel(){
    private val _isLogin = MutableLiveData<Boolean>()
    val isLogin: LiveData<Boolean> get() = _isLogin

    private val _username = MutableLiveData<String>()
    private val _name = MutableLiveData<String>()
    private val _password = MutableLiveData<String>()
    private val _error = MutableLiveData<String>()

//    var session = Session(Application())

    fun login(view:View){
        val api = ApiClient().getApiServic();
        api.login(UserLoginModel(username.value.toString(),password.value.toString()))
            .enqueue(object :Callback<UserModel>{
                override fun onFailure(call: Call<UserModel>, t: Throwable) {
                    Log.d("Failed", t.message.toString())
                }

                override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
//                    response.body()?.let { session.setUser(it) }
                    if (response.body()!=null){
                        _isLogin.value = true
                    }else{
                        Log.d("failed", response.errorBody().toString())
                    }
                }

            })
    }

    fun register(view:View){
        val api = ApiClient().getApiServic();
        api.register(name.value.toString(),password.value.toString(),username.value.toString())
            .enqueue(object :Callback<UserModel>{
                override fun onFailure(call: Call<UserModel>, t: Throwable) {
                    Log.d("Failed", t.message.toString())
                }

                override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
//                    response.body()?.let { session.setUser(it) }
//                    if (!response.body()?.token.isNullOrBlank()){
//                        _isLogin.value = true
//                    }
                }

            })
    }

    fun clickRegister(view:View){
        view.findNavController().navigate(
            LoginFragmentDirections.actionLoginFragment3ToRegisterFragment3()
        )
    }


    var username: MutableLiveData<String>
        get() = _username
        set(value) {
            _username.value = value.toString()
        }

    var name: MutableLiveData<String>
        get() = _name
        set(value) {
            _name.value = value.toString()
        }

    var password: MutableLiveData<String>
        get() = _password
        set(value) {
            _password.value = value.toString()
        }

    var error: MutableLiveData<String>
        get() = _error
        set(value) {
            _error.value = value.toString()
        }

}