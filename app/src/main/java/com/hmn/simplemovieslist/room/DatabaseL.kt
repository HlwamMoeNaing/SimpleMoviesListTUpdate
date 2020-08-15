package com.hmn.simplemovieslist.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hmn.simplemovieslist.room.dao.FavouriteDao
import com.hmn.simplemovieslist.room.entity.FavouriteEntity
import com.hmn.simplemovieslist.room.entity.PopularFavouriteEntity
import com.hmn.simplemovieslist.room.entity.TopFavouriteEntity
import com.hmn.simplemovieslist.room.dao.Dao
import com.hmn.simplemovieslist.room.dao.PopulerDao
import com.hmn.simplemovieslist.room.dao.TopDao
import com.hmn.simplemovieslist.room.entity.LatestEntity
import com.hmn.simplemovieslist.room.entity.PopulerEntity
import com.hmn.simplemovieslist.room.entity.TopEntity
import com.hmn.simplemovieslist.utils.Util


@Database(
    entities = [LatestEntity::class, TopEntity::class, PopulerEntity::class,
        FavouriteEntity::class, PopularFavouriteEntity::class, TopFavouriteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class DatabaseL : RoomDatabase() {
    abstract fun latestDao(): Dao
    abstract fun topDao(): TopDao
    abstract fun populerDao(): PopulerDao
    abstract fun favouriteDao(): FavouriteDao


    companion object {
        private var INSTANCR: DatabaseL? = null

        fun getDatabase(context: Context): DatabaseL {
            if (INSTANCR == null) {
                INSTANCR = Room.databaseBuilder(context, DatabaseL::class.java, Util.DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCR!!
        }
    }
}