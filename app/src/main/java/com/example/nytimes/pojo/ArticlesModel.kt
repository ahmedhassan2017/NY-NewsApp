package com.example.nytimes.pojo

import com.google.gson.annotations.SerializedName


class ArticlesModel {

    lateinit var results: List<Results>

    fun getDetails(): List<Results?>? {
        return results
    }

    class Results {
        var published_date: String? = null
        var byline: String? = null
        var title: String? = null

        @SerializedName("abstract")
        val newsabstract: String? = null
        val media: List<Medium>? = null

    }

    class Medium {
        val caption: String? = null

        @SerializedName("media-metadata")
        val mediaMetadata: List<MediaMetadatum>? = null
    }

    class MediaMetadatum {
        val url: String? = null
    }
}
