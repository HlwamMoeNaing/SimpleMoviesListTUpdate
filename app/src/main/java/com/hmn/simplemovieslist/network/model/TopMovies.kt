package com.hmn.simplemovieslist.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TopMovies(
    val top_video: List<TopVideo>
)

data class TopVideo(
    val desc: String,
    val id: String,
    val thumbnail: TopThumbnail,
    val title: String
)

data class TopThumbnail(
    @SerializedName("@url")
    @Expose
    val url: String,

    @SerializedName("@heigh")
    @Expose
    val height: String,

    @SerializedName("@width")
    @Expose
    val width: String
)