package com.hmn.simplemovieslist.repo

import androidx.lifecycle.MutableLiveData
import com.hmn.simplemovieslist.network.model.LatestVideo
import com.hmn.simplemovieslist.network.model.PopularVideo
import com.hmn.simplemovieslist.network.model.TopVideo

interface Repository {

    fun getLatestMovies():MutableLiveData<List<LatestVideo>>

    fun getTopMoview():MutableLiveData<List<TopVideo>>

    fun getPopulerMovies():MutableLiveData<List<PopularVideo>>
}