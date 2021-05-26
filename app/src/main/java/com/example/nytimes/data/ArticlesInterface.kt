package com.example.nytimes.data

import com.example.nytimes.BuildConfig
import com.example.nytimes.pojo.ArticlesModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticlesInterface {
    //  http://api.nytimes.com/svc/mostpopular/v2/viewed/7.json?api-key=ej5krEyKcu1O4BUg7bBavRwgbGm7ZDMh


    @GET("viewed/7.json")
    fun getArticles(@Query("api-key") api_key: String = BuildConfig.API_KEY): Observable<ArticlesModel?>?


}