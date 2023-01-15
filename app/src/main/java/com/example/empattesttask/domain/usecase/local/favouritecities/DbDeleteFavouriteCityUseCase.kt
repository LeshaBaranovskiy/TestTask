package com.example.empattesttask.domain.usecase.local.favouritecities

import com.example.empattesttask.domain.repository.FavouriteCitiesRepositoryImpl
import com.example.empattesttask.domain.usecase.base.BaseUseCaseDb

class DbDeleteFavouriteCityUseCase(
    private val favouriteCitiesRepositoryImpl: FavouriteCitiesRepositoryImpl
): BaseUseCaseDb<Unit, String>() {
    override suspend fun getSuspend(params: String?) {
        return favouriteCitiesRepositoryImpl.deleteByCityName(params.toString())
    }
}