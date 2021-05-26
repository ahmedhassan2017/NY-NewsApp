package com.example.nytimes.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nytimes.data.ArticlesClient
import com.example.nytimes.pojo.ArticlesModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ArticleViewModel : ViewModel() {
    var listMutableLiveData = MutableLiveData<ArticlesModel?>()
    val articles: Unit
        get()  {
        val observable: @NonNull Observable<ArticlesModel?>? =
            ArticlesClient.iNSTANCE?.articles
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
        val observer: Observer<ArticlesModel?> =
            object : Observer<ArticlesModel?> {
                override fun onSubscribe(d: @NonNull Disposable?) {}
                override fun onNext(articlesModels: @NonNull ArticlesModel?) {
                    listMutableLiveData.setValue(articlesModels)
                }

                override fun onError(e: @NonNull Throwable?) {

                }

                override fun onComplete() {}
            }
        if (observable != null) {
            observable.subscribe(observer)
        }
    }

}
