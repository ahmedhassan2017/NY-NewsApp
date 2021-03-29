package com.example.nytimes.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimes.R
import com.example.nytimes.pojo.ArticlesModel
import com.example.nytimes.pojo.ArticlesModel.Results
import com.example.nytimes.ui.main.ArticleAdapter.PostViewHolder
import com.squareup.picasso.Picasso
import java.util.*

class ArticleAdapter(private val onItemListener: OnItemListener) :
    RecyclerView.Adapter<PostViewHolder>() {
    var ArticleModelArrayList: List<ArticlesModel.Results> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false),
            onItemListener
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        if (ArticleModelArrayList[position].media!!.size == 0) {
            holder.imageView.setImageResource(R.drawable.ic_launcher_background)
        } else {
            Picasso.get()
                .load(ArticleModelArrayList[position].media!![0].mediaMetadata!![1].url)
                .into(holder.imageView)
        }
        holder.byLine.text = ArticleModelArrayList[position].byline
        holder.date.text = ArticleModelArrayList[position].published_date
        holder.titleTV.text = ArticleModelArrayList[position].title
    }

    override fun getItemCount(): Int {
        return ArticleModelArrayList.size
    }

    fun setList(articlesList: List<ArticlesModel.Results>) {
        ArticleModelArrayList = articlesList
        if (articlesList.size > 0) notifyDataSetChanged()
    }

    inner class PostViewHolder(
        itemView: View,
        onItemListener: OnItemListener
    ) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val titleTV: TextView
        val byLine: TextView
        val date: TextView
        val imageView: ImageView
        var onItemListener: OnItemListener
        override fun onClick(v: View) {
            onItemListener.onItemClicked(adapterPosition)
        }

        init {
            titleTV = itemView.findViewById(R.id.news_title)
            byLine = itemView.findViewById(R.id.byline)
            date = itemView.findViewById(R.id.date)
            imageView = itemView.findViewById(R.id.news_image)
            this.onItemListener = onItemListener
            itemView.setOnClickListener(this)
        }
    }

}

interface OnItemListener {
    fun onItemClicked(position: Int)
}