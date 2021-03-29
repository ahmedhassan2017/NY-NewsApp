package com.example.nytimes.ui.main

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimes.R
import com.example.nytimes.pojo.ArticlesModel
import com.google.android.material.snackbar.Snackbar
import java.util.*


class MainActivity : AppCompatActivity(), OnItemListener {
    var articleViewModel: ArticleViewModel? = null
    var articlesModelArrayList: ArrayList<ArticlesModel.Results> =
        ArrayList<ArticlesModel.Results>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var progressBar: ProgressBar = findViewById(R.id.progressBar_cyclic)
        var checkConnection: LinearLayout = findViewById(R.id.linear1)
        if (!InternetConnected()) {
            checkConnection.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
        } else {
            checkConnection.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
        }
        checkConnection.setOnClickListener(View.OnClickListener {
            finish()
            overridePendingTransition(0, 0)
            startActivity(intent)
            overridePendingTransition(0, 0)
        })
        articleViewModel = ViewModelProvider(this)[ArticleViewModel::class.java]
        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        var adapter = ArticleAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        articleViewModel!!.articles
        articleViewModel!!.listMutableLiveData.observe(
            this,
            Observer<ArticlesModel?> { articlesModels ->
                articlesModelArrayList.addAll(articlesModels?.results!!)
                adapter!!.setList(articlesModelArrayList)
                progressBar.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
            })
    }

    override fun onItemClicked(position: Int) {
        val intent = Intent(this@MainActivity, DetailedActivity::class.java)
        intent.putExtra("title", articlesModelArrayList[position].title)
        // sometimes media array = null
        if (articlesModelArrayList[position].media!!.size === 0) {
            intent.putExtra("image", "no image")
            intent.putExtra("desc", "No caption")
        } else {
            intent.putExtra(
                "image",
                articlesModelArrayList[position].media!!.get(0).mediaMetadata!!.get(2)
                    .url
            )
            intent.putExtra("desc", articlesModelArrayList[position].media!!.get(0).caption)
        }
        intent.putExtra("abstract", articlesModelArrayList[position].newsabstract)
        intent.putExtra("date", articlesModelArrayList[position].published_date)
        intent.putExtra("byline", articlesModelArrayList[position].byline)
        startActivity(intent)
    }

    fun InternetConnected(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)!!.state == NetworkInfo.State.CONNECTED ||
            connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)!!.state == NetworkInfo.State.CONNECTED
        ) {
            //we are connected to a network
            true
        } else {
            false
        }
    }

}


