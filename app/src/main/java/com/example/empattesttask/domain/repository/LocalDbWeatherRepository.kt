package com.example.empattesttask.domain.repository

import com.example.empattesttask.data.local.dbentity.DBWeatherEntity

interface LocalDbWeatherRepository {
    suspend fun getAllCities(): List<DBWeatherEntity>

    suspend fun getCityByName(city: String): List<DBWeatherEntity>

    suspend fun deleteByCityName(city: String)

    suspend fun insertCity(dbWeatherEntity: DBWeatherEntity)

    suspend fun insertCity(dbWeatherEntity: List<DBWeatherEntity>)
}