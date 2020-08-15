package com.hmn.simplemovieslist.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.hmn.simplemovieslist.room.entity.TopEntity

@Dao
interface TopDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTop(topEntity: TopEntity)

    @Update
    fun updateTop(topEntity: TopEntity)
    @Delete
    fun deleteTop(topEntity: TopEntity)


    @Query("Delete From top_table")
    fun deleteALlTop()

    @Query("SELECT * From top_table")
    fun getAllTop(): LiveData<List<TopEntity>>

}