package com.hmn.simplemovieslist.network.retrofit



import com.hmn.simplemovieslist.network.model.MoviesL
import com.hmn.simplemovieslist.network.model.PopulerMovies
import com.hmn.simplemovieslist.network.model.TopMovies
import retrofit2.Call
import retrofit2.http.GET


interface Api {
    @GET("latest_video.json")
    fun movies(): Call<MoviesL>

    @GET("top_video.json")
    fun getTop(): Call<TopMovies>

    @GET("popular_video.json")
    fun getPopulerMovies():Call<PopulerMovies>

}