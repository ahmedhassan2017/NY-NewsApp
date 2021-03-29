package com.example.nytimes.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nytimes.data.ArticlesClient
import com.example.nytimes.pojo.ArticlesModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleViewModel : ViewModel() {
    var listMutableLiveData = MutableLiveData<ArticlesModel?>()
    val articles: Unit
        get() {
            ArticlesClient.iNSTANCE!!.articles!!.enqueue(object : Callback<ArticlesModel?> {
                override fun onResponse(
                    call: Call<ArticlesModel?>,
                    response: Response<ArticlesModel?>
                ) {
                    listMutableLiveData.value = response.body()
                }

                override fun onFailure(call: Call<ArticlesModel?>, t: Throwable) {
                    Log.i("ahmed", "onFailure: ")
                }
            })
        }
}