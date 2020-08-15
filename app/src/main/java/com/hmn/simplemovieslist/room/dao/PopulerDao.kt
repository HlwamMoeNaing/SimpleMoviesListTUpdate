package com.hmn.simplemovieslist.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.hmn.simplemovieslist.room.entity.PopulerEntity

@Dao
interface PopulerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRoomPopuler(populerEntity: PopulerEntity)


    @Query("Delete From populer_table")
    fun deleteRoomPopuler()

    @Query("SELECT * From populer_table")
    fun getAllRoomPopulerMovies(): LiveData<List<PopulerEntity>>
}