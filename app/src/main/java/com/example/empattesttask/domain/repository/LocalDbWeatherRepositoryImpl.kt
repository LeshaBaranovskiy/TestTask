package com.example.empattesttask.domain.repository

import com.example.empattesttask.data.local.dbentity.DBWeatherEntity
import com.example.empattesttask.data.local.localdataprovider.LocalWeatherDataProvider
import javax.inject.Inject

class LocalDbWeatherRepositoryImpl @Inject constructor(
    private val localWeatherDataProvider: LocalWeatherDataProvider
): LocalDbWeatherRepository {
    override suspend fun getAllCities(): List<DBWeatherEntity> =
        localWeatherDataProvider.getAllCities()

    override suspend fun getCityByName(city: String): List<DBWeatherEntity> =
        localWeatherDataProvider.getCityByName(city)

    override suspend fun deleteByCityName(city: String) =
        localWeatherDataProvider.deleteByCityName(city)

    override suspend fun insertCity(dbWeatherEntity: DBWeatherEntity) =
        localWeatherDataProvider.insertCity(dbWeatherEntity)

    override suspend fun insertCity(dbWeatherEntity: List<DBWeatherEntity>) =
        localWeatherDataProvider.insertCity(dbWeatherEntity)
}