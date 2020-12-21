package com.example.recipeapp.view.ui.comment


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipeapp.api.ApiClient
import com.example.recipeapp.model.CommentModel
import com.example.recipeapp.model.RecipeModel
import com.example.recipeapp.utility.Session
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentViewModel(
    private val id:Int,
    private val session: Session
):ViewModel(){
    private val _commentList:MutableLiveData<MutableList<CommentModel>> = MutableLiveData<MutableList<CommentModel>>()
    val commentList: LiveData<MutableList<CommentModel>>
        get() = _commentList

    private val api = ApiClient().getApiServic()


    init {
        api.getRecipeComment(id.toString()).enqueue(object : Callback<List<CommentModel>> {
            override fun onFailure(call: Call<List<CommentModel>>, t: Throwable) {
                Log.d("msg", t.message.toString())
            }

            override fun onResponse(
                call: Call<List<CommentModel>>,
                response: Response<List<CommentModel>>
            ) {
                _commentList.value = response.body() as MutableList<CommentModel>?
            }

        })
    }

    fun addComment(comment:String){
        session.tokenUser?.let {
            api.postComment(comment, id.toString(), it)
                .enqueue(object :Callback<CommentModel>{
                    override fun onFailure(call: Call<CommentModel>, t: Throwable) {
                        Log.d("error", t.message.toString())
                    }

                    override fun onResponse(
                        call: Call<CommentModel>,
                        response: Response<CommentModel>
                    ) {
                        response.body()?.let { _commentList.value?.add(it) }
                    }

                })
        }
    }
}