package com.example.empattesttask.domain.usecase

import com.example.empattesttask.common.utils.result.Result
import com.example.empattesttask.domain.model.entity.WeatherEntity
import com.example.empattesttask.domain.params.WeatherParams
import com.example.empattesttask.domain.repository.WeatherRepository
import com.example.empattesttask.domain.usecase.base.BaseUseCase

class GetForecastUseCase(
    private val repository: WeatherRepository
): BaseUseCase<WeatherEntity, WeatherParams>() {

    override suspend fun getSuspend(params: WeatherParams): Result<WeatherEntity> {
        return repository.getForecast(params.city, params.countOfDays, params.key)
    }
}