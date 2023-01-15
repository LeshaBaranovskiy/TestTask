package com.example.empattesttask.domain.usecase.local.favouritecities

import com.example.empattesttask.data.local.dbentity.DBFavouriteCitiesEntity
import com.example.empattesttask.domain.repository.FavouriteCitiesRepositoryImpl
import com.example.empattesttask.domain.usecase.base.BaseUseCaseDb

class DbInsertFavouriteCityUseCase(
    private val favouriteCitiesRepositoryImpl: FavouriteCitiesRepositoryImpl
): BaseUseCaseDb<Unit, DBFavouriteCitiesEntity>() {
    override suspend fun getSuspend(params: DBFavouriteCitiesEntity?) {
        return favouriteCitiesRepositoryImpl.insertCity(params!!)
    }
}