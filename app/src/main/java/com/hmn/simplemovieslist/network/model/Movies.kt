package com.hmn.simplemovieslist.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class MoviesL(
    @SerializedName("latest_video")
    @Expose
    val latest_video: List<LatestVideo>
)
data class LatestVideo(
    val desc: String,
    val id: String,
    val thumbnail: Thumbnail,
    val title: String
)

data class Thumbnail(
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

