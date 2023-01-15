package com.example.empattesttask.domain.usecase.local.forecastinfo

import com.example.empattesttask.data.local.dbentity.DBWeatherEntity
import com.example.empattesttask.domain.repository.LocalDbWeatherRepositoryImpl
import com.example.empattesttask.domain.usecase.base.BaseUseCaseDb

class DBGetAllCitiesUseCase(
    private val localDbWeatherRepositoryImpl: LocalDbWeatherRepositoryImpl
): BaseUseCaseDb<List<DBWeatherEntity>, Unit>() {

    override suspend fun getSuspend(params: Unit?): List<DBWeatherEntity> =
        localDbWeatherRepositoryImpl.getAllCities()

}