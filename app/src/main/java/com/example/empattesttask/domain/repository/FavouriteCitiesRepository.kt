package com.example.empattesttask.domain.repository

import com.example.empattesttask.data.local.dbentity.DBFavouriteCitiesEntity

interface FavouriteCitiesRepository {
    suspend fun getAllCities(): List<DBFavouriteCitiesEntity>

    suspend fun deleteByCityName(city: String)

    suspend fun insertCity(dbWeatherEntity: DBFavouriteCitiesEntity)
}