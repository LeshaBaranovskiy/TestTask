package com.example.empattesttask.data.local.localdataprovider

import com.example.empattesttask.data.local.dao.FavouriteCitiesDao
import com.example.empattesttask.data.local.dbentity.DBFavouriteCitiesEntity

class LocalFavouriteCitiesDataProvider(
    private val favouriteCitiesDao: FavouriteCitiesDao
) {
    suspend fun getAllCities(): List<DBFavouriteCitiesEntity> = favouriteCitiesDao.getAllCities()

    suspend fun deleteByCityName(city: String) = favouriteCitiesDao.deleteByCityName(city)

    suspend fun insertCity(dbWeatherEntity: DBFavouriteCitiesEntity) = favouriteCitiesDao.insertCity(dbWeatherEntity)
}