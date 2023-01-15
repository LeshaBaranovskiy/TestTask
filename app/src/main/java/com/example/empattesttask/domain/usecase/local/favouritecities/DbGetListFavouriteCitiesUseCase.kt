package com.example.empattesttask.domain.usecase.local.favouritecities

import com.example.empattesttask.data.local.dbentity.DBFavouriteCitiesEntity
import com.example.empattesttask.domain.repository.FavouriteCitiesRepositoryImpl
import com.example.empattesttask.domain.usecase.base.BaseUseCaseDb

class DbGetListFavouriteCitiesUseCase(
    private val favouriteCitiesRepositoryImpl: FavouriteCitiesRepositoryImpl
): BaseUseCaseDb<List<DBFavouriteCitiesEntity>, Unit>() {
    override suspend fun getSuspend(params: Unit?): List<DBFavouriteCitiesEntity> {
        return favouriteCitiesRepositoryImpl.getAllCities()
    }
}