package com.example.empattesttask.domain.usecase.local.forecastinfo

import com.example.empattesttask.data.local.dbentity.DBWeatherEntity
import com.example.empattesttask.domain.repository.LocalDbWeatherRepositoryImpl
import com.example.empattesttask.domain.usecase.base.BaseUseCaseDb

class DBGetCityByNameUseCase(
    private val localDbWeatherRepositoryImpl: LocalDbWeatherRepositoryImpl
): BaseUseCaseDb<List<DBWeatherEntity>, String>() {
    override suspend fun getSuspend(params: String?): List<DBWeatherEntity> =
        localDbWeatherRepositoryImpl.getCityByName(params.toString())
}