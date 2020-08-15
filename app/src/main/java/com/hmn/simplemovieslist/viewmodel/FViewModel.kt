package com.hmn.simplemovieslist.viewmodel

import androidx.lifecycle.LiveData
import com.hmn.simplemovieslist.network.model.LatestVideo
import com.hmn.simplemovieslist.network.model.PopularVideo
import com.hmn.simplemovieslist.network.model.TopVideo
import com.hmn.simplemovieslist.room.entity.LatestEntity
import com.hmn.simplemovieslist.room.entity.PopulerEntity
import com.hmn.simplemovieslist.room.entity.TopEntity

interface FViewModel {

    fun getAllLatest(): LiveData<List<LatestEntity>>
    fun getFromModel(): LiveData<List<LatestVideo>>
    fun insertLatest(latestEntity: LatestEntity)
    fun updateLatest(latestEntity: LatestEntity)
    fun deleteLatest(latestEntity: LatestEntity)
    fun deleteAllLatest()

    fun insertTop(topEntity: TopEntity)
    fun getAllTop(): LiveData<List<TopEntity>>
    fun getFromTopModel(): LiveData<List<TopVideo>>
    fun deleteAllTop()

    fun insertPopulerToEntity(populerEntity: PopulerEntity)
    fun getAllPopulerFromEntity(): LiveData<List<PopulerEntity>>
    fun getPopulerFromRetrofit(): LiveData<List<PopularVideo>>
    fun deleteAllPopuler()
}