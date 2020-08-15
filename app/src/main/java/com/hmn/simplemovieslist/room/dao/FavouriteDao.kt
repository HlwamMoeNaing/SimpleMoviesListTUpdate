package com.hmn.simplemovieslist.room.dao

import androidx.room.*
import androidx.room.Dao
import com.hmn.simplemovieslist.room.entity.FavouriteEntity
import com.hmn.simplemovieslist.room.entity.PopularFavouriteEntity
import com.hmn.simplemovieslist.room.entity.TopFavouriteEntity


@Dao
interface FavouriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavourite(favouriteEntity: FavouriteEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularFavourite(popularFavouriteEntity: PopularFavouriteEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopFavourite(topFavouriteEntity: TopFavouriteEntity)


    @Delete
    fun deleteFavourite(favouriteEntity: FavouriteEntity)
    @Delete
    fun deletePopularFav(popularFavouriteEntity: PopularFavouriteEntity)
    @Delete
    fun deleteTopFavourite(topFavouriteEntity: TopFavouriteEntity)


    @Query("SELECT * From favourite_table")
    fun getAllFavourite(): List<FavouriteEntity>

    @Query("SELECT * From popular_favourite_table")
    fun getAllPopularFav(): List<PopularFavouriteEntity>

    @Query("SELECT * FROM top_favourite_table")
    fun getAllTopFav(): List<TopFavouriteEntity>


    @Query("SELECT EXISTS (SELECT 1 FROM favourite_table WHERE id=:id)")
    fun isFavorite(id: Int): Int

    @Query("SELECT EXISTS (SELECT 1 FROM popular_favourite_table WHERE id=:id)")
    fun isPopularFav(id: Int): Int

    @Query("SELECT EXISTS (SELECT 1 FROM top_favourite_table WHERE id=:id)")
    fun isTopFavorite(id: Int): Int


}