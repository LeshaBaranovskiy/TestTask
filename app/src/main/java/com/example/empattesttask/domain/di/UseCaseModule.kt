package com.example.empattesttask.domain.di

import com.example.empattesttask.domain.repository.FavouriteCitiesRepositoryImpl
import com.example.empattesttask.domain.repository.LocalDbWeatherRepositoryImpl
import com.example.empattesttask.domain.repository.WeatherRepository
import com.example.empattesttask.domain.usecase.GetForecastUseCase
import com.example.empattesttask.domain.usecase.local.favouritecities.DbGetListFavouriteCitiesUseCase
import com.example.empattesttask.domain.usecase.local.favouritecities.DbDeleteFavouriteCityUseCase
import com.example.empattesttask.domain.usecase.local.favouritecities.DbInsertFavouriteCityUseCase
import com.example.empattesttask.domain.usecase.local.forecastinfo.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Provides
    @Singleton
    fun provideGetForecastUseCase(
        weatherRepository: WeatherRepository
    ): GetForecastUseCase =
        GetForecastUseCase(weatherRepository)

    @Provides
    @Singleton
    fun provideDBDeleteByCityNameUseCase(
        localDbWeatherRepositoryImpl: LocalDbWeatherRepositoryImpl
    ): DBDeleteByCityNameUseCase =
        DBDeleteByCityNameUseCase(localDbWeatherRepositoryImpl)

    @Provides
    @Singleton
    fun provideDBGetCityByNameUseCase(
        localDbWeatherRepositoryImpl: LocalDbWeatherRepositoryImpl
    ): DBGetCityByNameUseCase =
        DBGetCityByNameUseCase(localDbWeatherRepositoryImpl)

    @Provides
    @Singleton
    fun provideDBGetAllCitiesUseCase(
        localDbWeatherRepositoryImpl: LocalDbWeatherRepositoryImpl
    ): DBGetAllCitiesUseCase =
        DBGetAllCitiesUseCase(localDbWeatherRepositoryImpl)

    @Provides
    @Singleton
    fun provideDBInsertCityUseCase(
        localDbWeatherRepositoryImpl: LocalDbWeatherRepositoryImpl
    ): DBInsertCityUseCase =
        DBInsertCityUseCase(localDbWeatherRepositoryImpl)

    @Provides
    @Singleton
    fun provideDBInsertListCitiesUseCase(
        localDbWeatherRepositoryImpl: LocalDbWeatherRepositoryImpl
    ): DBInsertListCitiesUseCase =
        DBInsertListCitiesUseCase(localDbWeatherRepositoryImpl)

    @Provides
    @Singleton
    fun provideDbGetListFavouriteCitiesUseCase(
        favouriteCitiesRepositoryImpl: FavouriteCitiesRepositoryImpl
    ): DbGetListFavouriteCitiesUseCase =
        DbGetListFavouriteCitiesUseCase(favouriteCitiesRepositoryImpl)

    @Provides
    @Singleton
    fun provideInsertFavouriteCityUseCase(
        favouriteCitiesRepositoryImpl: FavouriteCitiesRepositoryImpl
    ): DbInsertFavouriteCityUseCase =
        DbInsertFavouriteCityUseCase(favouriteCitiesRepositoryImpl)

    @Provides
    @Singleton
    fun provideDeleteFavouriteCityUseCase(
        favouriteCitiesRepositoryImpl: FavouriteCitiesRepositoryImpl
    ): DbDeleteFavouriteCityUseCase =
        DbDeleteFavouriteCityUseCase(favouriteCitiesRepositoryImpl)
}