package com.hmn.simplemovieslist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hmn.simplemovieslist.network.model.LatestVideo
import com.hmn.simplemovieslist.network.model.PopularVideo
import com.hmn.simplemovieslist.network.model.TopVideo
import com.hmn.simplemovieslist.repo.RepositoryImplement
import com.hmn.simplemovieslist.room.entity.LatestEntity
import com.hmn.simplemovieslist.room.entity.PopulerEntity
import com.hmn.simplemovieslist.room.entity.TopEntity

class FViewModelImplement(application: Application) : AndroidViewModel(application), FViewModel {

    private val repository = RepositoryImplement(application)
    private lateinit var latestVideoList: MutableLiveData<List<LatestVideo>>
    private lateinit var topVideoList: MutableLiveData<List<TopVideo>>
    private lateinit var populerList:MutableLiveData<List<PopularVideo>>



    override fun getFromModel(): LiveData<List<LatestVideo>> {
        latestVideoList = repository.getLatestMovies()
        return latestVideoList
    }


    override fun getAllLatest(): LiveData<List<LatestEntity>> {
        return repository.getAllLatest()
    }

    override fun insertLatest(latestEntity: LatestEntity) {
        repository.insertLatest(latestEntity)
    }

    override fun updateLatest(latestEntity: LatestEntity) {
        repository.updateLatest(latestEntity)
    }

    override fun deleteLatest(latestEntity: LatestEntity) {
        repository.deleteLatest(latestEntity)
    }

    override fun deleteAllLatest() {
        repository.deleteAllLatest()
    }

    override fun insertTop(topEntity: TopEntity) {
        repository.insertTop(topEntity)
    }

    override fun getAllTop(): LiveData<List<TopEntity>> {
        return  repository.getAllTop()

    }

    override fun getFromTopModel(): LiveData<List<TopVideo>> {
       topVideoList = repository.getTopMoview()
        return topVideoList
    }

    override fun deleteAllTop() {
        repository.deleteAllTop()
    }

    override fun insertPopulerToEntity(populerEntity: PopulerEntity) {
       repository.insertPopulerToRoom(populerEntity)
    }

    override fun getAllPopulerFromEntity(): LiveData<List<PopulerEntity>> {
        return repository.getAllPopuler()
    }

    override fun getPopulerFromRetrofit(): LiveData<List<PopularVideo>> {
       populerList = repository.getPopulerMovies()
        return populerList
    }

    override fun deleteAllPopuler() {
        repository.deleteAllPopulerFromRoom()
    }
}