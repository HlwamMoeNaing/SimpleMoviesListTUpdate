package com.hmn.simplemovieslist.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PopulerMovies(
    val popular_video: List<PopularVideo>
)

data class PopularVideo(
    val desc: String,
    val id: String,
    val thumbnail: ThumbnailPopuler,
    val title: String
)

data class ThumbnailPopuler(
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