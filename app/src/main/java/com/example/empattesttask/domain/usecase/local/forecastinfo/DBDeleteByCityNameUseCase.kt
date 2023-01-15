package com.example.empattesttask.domain.usecase.local.forecastinfo

import com.example.empattesttask.domain.repository.LocalDbWeatherRepositoryImpl
import com.example.empattesttask.domain.usecase.base.BaseUseCaseDb

class DBDeleteByCityNameUseCase(
    private val localDbWeatherRepositoryImpl: LocalDbWeatherRepositoryImpl
): BaseUseCaseDb<Unit, String>() {
    override suspend fun getSuspend(params: String?) =
        localDbWeatherRepositoryImpl.deleteByCityName(params.toString())
}