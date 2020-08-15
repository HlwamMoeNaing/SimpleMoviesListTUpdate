package com.hmn.simplemovieslist.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.hmn.simplemovieslist.room.entity.LatestEntity

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLatest(latestEntity: LatestEntity)

    @Update
    fun update(latestEntity: LatestEntity)

    @Delete
    fun deleteLatest(latestEntity: LatestEntity)

    @Query("Delete From latest_table")
    fun deleteALlLatest()

    @Query("SELECT * From latest_table")
    fun getAllLatest(): LiveData<List<LatestEntity>>









}
