package com.example.empattesttask.domain.repository

import com.example.empattesttask.data.local.dbentity.DBFavouriteCitiesEntity
import com.example.empattesttask.data.local.localdataprovider.LocalFavouriteCitiesDataProvider
import javax.inject.Inject

class FavouriteCitiesRepositoryImpl @Inject constructor(
    private val favouriteCitiesDataProvider: LocalFavouriteCitiesDataProvider
): FavouriteCitiesRepository {
    override suspend fun getAllCities(): List<DBFavouriteCitiesEntity> =
        favouriteCitiesDataProvider.getAllCities()

    override suspend fun deleteByCityName(city: String) =
        favouriteCitiesDataProvider.deleteByCityName(city)

    override suspend fun insertCity(dbWeatherEntity: DBFavouriteCitiesEntity) =
        favouriteCitiesDataProvider.insertCity(dbWeatherEntity)
}