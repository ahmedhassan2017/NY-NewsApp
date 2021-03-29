package com.example.nytimes.ui.main

import android.os.Bundle
import android.os.TokenWatcher
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.nytimes.R
import com.squareup.picasso.Picasso

class DetailedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)
        var title: TextView = findViewById(R.id.title_detailes)
        var publishDate: TextView = findViewById(R.id.date_detailes)
        var byline: TextView = findViewById(R.id.byline_detailes)
        var desc:TextView= findViewById(R.id.description_details)
        var mAbstract:TextView = findViewById(R.id.abstract_details)
        var imageView:ImageView = findViewById(R.id.image_detailes)

        val intent = intent

        title.text = intent.getStringExtra("title")
        publishDate.text=intent.getStringExtra("date")
        byline.text=intent.getStringExtra("byline")
        mAbstract.text= intent.getStringExtra("abstract")
        desc.text=intent.getStringExtra("desc")
        if (intent.getStringExtra("image") == "no image")
            imageView.setImageResource(R.drawable.ic_launcher_background) else Picasso.get()
            .load(intent.getStringExtra("image")).into(imageView)
    }
}