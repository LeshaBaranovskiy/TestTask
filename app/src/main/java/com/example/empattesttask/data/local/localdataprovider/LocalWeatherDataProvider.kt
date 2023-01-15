package com.example.empattesttask.data.local.localdataprovider

import com.example.empattesttask.data.local.dao.WeatherDao
import com.example.empattesttask.data.local.dbentity.DBWeatherEntity

class LocalWeatherDataProvider(
    private val weatherDao: WeatherDao
) {
    suspend fun getAllCities(): List<DBWeatherEntity> = weatherDao.getAllCities()

    suspend fun getCityByName(city: String): List<DBWeatherEntity> = weatherDao.getCityByName(city)

    suspend fun deleteByCityName(city: String) = weatherDao.deleteByCityName(city)

    suspend fun insertCity(dbWeatherEntity: DBWeatherEntity) = weatherDao.insertCity(dbWeatherEntity)

    suspend fun insertCity(dbWeatherEntity: List<DBWeatherEntity>) = weatherDao.insertCity(dbWeatherEntity)
}