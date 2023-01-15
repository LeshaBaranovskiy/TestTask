package com.example.empattesttask.data.local

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.empattesttask.BuildConfig.PREVIUOS_VERSION_DB
import com.example.empattesttask.BuildConfig.VERSION_DB
import com.example.empattesttask.data.local.dao.FavouriteCitiesDao
import com.example.empattesttask.data.local.dao.WeatherDao
import com.example.empattesttask.data.local.dbentity.DBFavouriteCitiesEntity
import com.example.empattesttask.data.local.dbentity.DBWeatherEntity

@Database(
    entities = [
        DBWeatherEntity::class,
        DBFavouriteCitiesEntity::class
    ],
    version = VERSION_DB,
    autoMigrations = [AutoMigration(from = PREVIUOS_VERSION_DB, to = VERSION_DB)],
    exportSchema = true
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getWeatherDao() : WeatherDao

    abstract fun getFavouriteCitiesDao(): FavouriteCitiesDao

    companion object {
        private var db_instance: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase {
            if (db_instance != null) return db_instance!!

            synchronized(this) {
                db_instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "main_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                return db_instance!!
            }
        }
    }
}