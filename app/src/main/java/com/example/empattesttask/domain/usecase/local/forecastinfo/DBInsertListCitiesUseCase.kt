package com.example.empattesttask.domain.usecase.local.forecastinfo

import com.example.empattesttask.data.local.dbentity.DBWeatherEntity
import com.example.empattesttask.domain.repository.LocalDbWeatherRepositoryImpl
import com.example.empattesttask.domain.usecase.base.BaseUseCaseDb

class DBInsertListCitiesUseCase(
    private val localDbWeatherRepositoryImpl: LocalDbWeatherRepositoryImpl
): BaseUseCaseDb<Unit, List<DBWeatherEntity>>() {
    override suspend fun getSuspend(params: List<DBWeatherEntity>?) =
        localDbWeatherRepositoryImpl.insertCity(params!!)
}