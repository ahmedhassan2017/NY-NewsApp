package com.example.nytimes.data

import com.example.nytimes.pojo.ArticlesModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ArticlesClient {
    private val articlesInterface: ArticlesInterface
    val articles: Observable<ArticlesModel?>? get() = articlesInterface.getArticles()

    companion object {
        private const val BASE_URL = "https://api.nytimes.com/svc/mostpopular/v2/"
        var iNSTANCE: ArticlesClient? = null
            get() {
                if (null == field)
                    field = ArticlesClient()
                return field
            }
            private set
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        articlesInterface = retrofit.create(ArticlesInterface::class.java)
    }
}