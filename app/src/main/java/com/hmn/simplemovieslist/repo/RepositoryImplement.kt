package com.hmn.simplemovieslist.repo

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.hmn.simplemovieslist.network.model.*
import com.hmn.simplemovieslist.network.retrofit.Api
import com.hmn.simplemovieslist.network.retrofit.RetrofitHelper
import com.hmn.simplemovieslist.room.*
import com.hmn.simplemovieslist.room.dao.Dao
import com.hmn.simplemovieslist.room.dao.PopulerDao
import com.hmn.simplemovieslist.room.dao.TopDao
import com.hmn.simplemovieslist.room.entity.LatestEntity
import com.hmn.simplemovieslist.room.entity.PopulerEntity
import com.hmn.simplemovieslist.room.entity.TopEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryImplement(application: Application) : Repository {

    private val latestDb = DatabaseL.getDatabase(application)

    private val latestDao = latestDb.latestDao()
    private val topDao = latestDb.topDao()
    private val populerDao = latestDb.populerDao()

    private val allTop = topDao.getAllTop()
    private val allLatest = latestDao.getAllLatest()
    private val allPopuler = populerDao.getAllRoomPopulerMovies()

    private val mApi: Api = RetrofitHelper.getRetrofit()

    override fun getLatestMovies(): MutableLiveData<List<LatestVideo>> {
        val latestVideos = MutableLiveData<List<LatestVideo>>()
        mApi.movies().enqueue(object : Callback<MoviesL> {
            override fun onFailure(call: Call<MoviesL>, t: Throwable) {
               // latestVideos.value = null
            }

            override fun onResponse(call: Call<MoviesL>, response: Response<MoviesL>) {
                if (response.isSuccessful) {
                    latestVideos.value = response.body()!!.latest_video

                }
            }

        })
        return latestVideos


    }

    override fun getTopMoview(): MutableLiveData<List<TopVideo>> {
        val topVideo = MutableLiveData<List<TopVideo>>()
        mApi.getTop().enqueue(object : Callback<TopMovies> {
            override fun onFailure(call: Call<TopMovies>, t: Throwable) {
               // topVideo.value = null
            }

            override fun onResponse(call: Call<TopMovies>, response: Response<TopMovies>) {
                if (response.isSuccessful) {
                    topVideo.value = response.body()!!.top_video
                }
            }

        })
        return topVideo
    }

    override fun getPopulerMovies(): MutableLiveData<List<PopularVideo>> {
        val populerVideo = MutableLiveData<List<PopularVideo>>()
        mApi.getPopulerMovies().enqueue(object : Callback<PopulerMovies> {
            override fun onFailure(call: Call<PopulerMovies>, t: Throwable) {
              //  populerVideo.value = null
            }

            override fun onResponse(call: Call<PopulerMovies>, response: Response<PopulerMovies>) {
                if (response.isSuccessful) {
                    populerVideo.value = response.body()!!.popular_video
                }
            }

        })
        return populerVideo
    }


    fun getAllLatest(): LiveData<List<LatestEntity>> = allLatest

    fun getAllTop(): LiveData<List<TopEntity>> = allTop
    fun getAllPopuler(): LiveData<List<PopulerEntity>> = allPopuler

    fun insertPopulerToRoom(populerEntity: PopulerEntity) {
        InsertPopuler(populerDao).execute(populerEntity)
    }

    fun deleteAllPopulerFromRoom() {
        DeleteAllPopuler(populerDao).execute()
    }

    fun insertTop(topEntity: TopEntity) {
        InsertTop(topDao).execute(topEntity)
    }

    fun deleteAllTop() {
        DeleteAllTop(topDao).execute()
    }

    fun insertLatest(latestEntity: LatestEntity) {
        InsertLatest(latestDao).execute(latestEntity)
    }

    fun updateLatest(latestEntity: LatestEntity) {
        UpdateLatest(latestDao).execute(latestEntity)

    }

    fun deleteLatest(latestEntity: LatestEntity) {
        DeleteLatest(latestDao).execute(latestEntity)
    }

    fun deleteAllLatest() {
        DeleteAllLatest(latestDao).execute()
    }


    class InsertLatest(dao: Dao) : AsyncTask<LatestEntity, Void, Void>() {
        private val latestDao: Dao = dao
        override fun doInBackground(vararg p0: LatestEntity?): Void? {
            latestDao.insertLatest(p0[0]!!)
            return null
        }
    }

    class UpdateLatest(dao: Dao) : AsyncTask<LatestEntity, Void, Void>() {
        private val latestDao: Dao = dao
        override fun doInBackground(vararg p0: LatestEntity?): Void? {
            latestDao.insertLatest(p0[0]!!)
            return null
        }

    }


    class DeleteLatest(dao: Dao) : AsyncTask<LatestEntity, Void, Void>() {
        private val latestDao: Dao = dao
        override fun doInBackground(vararg p0: LatestEntity?): Void? {
            latestDao.insertLatest(p0[0]!!)
            return null
        }

    }

    private class DeleteAllLatest(dao: Dao) : AsyncTask<Void, Void, Void>() {
        private val latestDao: Dao = dao
        override fun doInBackground(vararg params: Void?): Void? {
            latestDao.deleteALlLatest()
            return null
        }
    }

    class InsertTop(dao: TopDao) : AsyncTask<TopEntity, Void, Void>() {
        private val toptDao: TopDao = dao
        override fun doInBackground(vararg p0: TopEntity?): Void? {
            toptDao.insertTop(p0[0]!!)
            return null
        }
    }

    private class DeleteAllTop(dao: TopDao) : AsyncTask<Void, Void, Void>() {
        private val topDao: TopDao = dao
        override fun doInBackground(vararg params: Void?): Void? {
            topDao.deleteALlTop()
            return null
        }
    }

    private class InsertPopuler(dao: PopulerDao) : AsyncTask<PopulerEntity, Void, Void>() {
        private val populerDao: PopulerDao = dao
        override fun doInBackground(vararg p0: PopulerEntity?): Void? {
            populerDao.insertRoomPopuler(p0[0]!!)
            return null
        }
    }

    private class DeleteAllPopuler(dao: PopulerDao) : AsyncTask<Void, Void, Void>() {
        private val populerDao: PopulerDao = dao
        override fun doInBackground(vararg p0: Void?): Void? {
            populerDao.deleteRoomPopuler()
            return null
        }

    }

}