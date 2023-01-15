package com.example.empattesttask.data.local.dao

import androidx.room.*
import com.example.empattesttask.data.local.dbentity.DBWeatherEntity
import retrofit2.http.DELETE

@Dao
interface WeatherDao {
    @Query("SELECT * FROM city_weather")
    suspend fun getAllCities(): List<DBWeatherEntity>

    @Query("SELECT * FROM city_weather WHERE city = :city")
    suspend fun getCityByName(city: String): List<DBWeatherEntity>

    @Query("DELETE FROM city_weather WHERE city = :city")
    suspend fun deleteByCityName(city: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(dbWeatherEntity: DBWeatherEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(dbWeatherEntity: List<DBWeatherEntity>)
}