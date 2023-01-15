package com.example.empattesttask.data.di

import com.example.empattesttask.common.utils.Constants
import com.example.empattesttask.data.network.api.WeatherService
import com.example.empattesttask.data.network.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ServiceModule {
    @Provides
    @Singleton
    fun provideWeatherService(remoteDataSource: RemoteDataSource): WeatherService =
        remoteDataSource.buildApi(
            WeatherService::class.java,
            Constants.API_SERVICE_URL
        )
}