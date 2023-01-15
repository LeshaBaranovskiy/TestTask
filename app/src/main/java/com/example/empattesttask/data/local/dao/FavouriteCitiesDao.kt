package com.example.empattesttask.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.empattesttask.data.local.dbentity.DBFavouriteCitiesEntity

@Dao
interface FavouriteCitiesDao {
    @Query("SELECT * FROM favourite_cities")
    suspend fun getAllCities(): List<DBFavouriteCitiesEntity>

    @Query("DELETE FROM favourite_cities WHERE city = :city")
    suspend fun deleteByCityName(city: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(dbWeatherEntity: DBFavouriteCitiesEntity)
}