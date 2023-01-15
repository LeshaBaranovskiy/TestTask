package com.example.empattesttask.domain.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.empattesttask.common.utils.result.Result
import com.example.empattesttask.data.local.dbentity.DBFavouriteCitiesEntity
import com.example.empattesttask.data.local.dbentity.DBWeatherEntity
import com.example.empattesttask.domain.model.entity.WeatherEntity
import com.example.empattesttask.domain.params.WeatherParams
import com.example.empattesttask.domain.usecase.subscriber.UseCaseSubscriberImpl
import com.example.empattesttask.domain.usecase.GetForecastUseCase
import com.example.empattesttask.domain.usecase.local.favouritecities.DbDeleteFavouriteCityUseCase
import com.example.empattesttask.domain.usecase.local.favouritecities.DbGetListFavouriteCitiesUseCase
import com.example.empattesttask.domain.usecase.local.favouritecities.DbInsertFavouriteCityUseCase
import com.example.empattesttask.domain.usecase.local.forecastinfo.*
import javax.inject.Inject

class ShowForecastViewModel @Inject constructor(
    private val getForecastUseCase: GetForecastUseCase,
    private val dbInsertCityUseCase: DBInsertCityUseCase,
    private val dbInsertListCitiesUseCase: DBInsertListCitiesUseCase,
    private val dbGetAllCitiesUseCase: DBGetAllCitiesUseCase,
    private val dbGetCityByNameUseCase: DBGetCityByNameUseCase,
    private val dbDeleteByCityNameUseCase: DBDeleteByCityNameUseCase,
    private val dbGetListFavouriteCitiesUseCase: DbGetListFavouriteCitiesUseCase,
    private val dbInsertFavouriteCityUseCase: DbInsertFavouriteCityUseCase,
    private val dbDeleteFavouriteCityUseCase: DbDeleteFavouriteCityUseCase
): ViewModel() {
    fun getForecast(weatherParams: WeatherParams): LiveData<Result<WeatherEntity>> {
        return getForecastUseCase.getExecute(UseCaseSubscriberImpl(
            {
                Log.d("GET_FORECAST", "getForecast $it")
            },
            {
                Log.d("GET_FORECAST", "getForecast: ${it.message}", it as Exception)
            },
            {
                Log.d("GET_FORECAST", "getForecastCanceled")
            }
        ), weatherParams)
    }

    fun insertToDb(dbWeatherEntity: DBWeatherEntity): LiveData<Unit> {
        return dbInsertCityUseCase.getExecute(UseCaseSubscriberImpl(
            {
                Log.d("insertToDb", "insertToDb $it")
            },
            {
                Log.d("insertToDb", "insertToDb: ${it.message}", it as Exception)
            },
            {
                Log.d("insertToDb", "insertToDb Canceled")
            }
        ), dbWeatherEntity)
    }

    fun insertListToDb(dbWeatherEntity: List<DBWeatherEntity>): LiveData<Unit> {
        return dbInsertListCitiesUseCase.getExecute(UseCaseSubscriberImpl(
            {
                Log.d("insertListToDb", "insertListToDb $it")
            },
            {
                Log.d("insertListToDb", "insertListToDb: ${it.message}", it as Exception)
            },
            {
                Log.d("insertListToDb", "insertListToDb Canceled")
            }
        ), dbWeatherEntity)
    }

    fun getAllCitiesFromDB(): LiveData<List<DBWeatherEntity>> {
        return dbGetAllCitiesUseCase.getExecute(UseCaseSubscriberImpl(
            {
                Log.d("getAllCitiesFromDB", "getAllCitiesFromDB $it")
            },
            {
                Log.d("getAllCitiesFromDB", "getAllCitiesFromDB: ${it.message}", it as Exception)
            },
            {
                Log.d("getAllCitiesFromDB", "getAllCitiesFromDB Canceled")
            }
        ))
    }

    fun getCityFromDB(city: String): LiveData<List<DBWeatherEntity>> {
        return dbGetCityByNameUseCase.getExecute(UseCaseSubscriberImpl(
            {
                Log.d("getCityFromDB", "getCityFromDB $it")
            },
            {
                Log.d("getCityFromDB", "getCityFromDB: ${it.message}", it as Exception)
            },
            {
                Log.d("getCityFromDB", "getCityFromDB Canceled")
            }
        ), city)
    }

    fun deleteCitiesFromDb(city: String): LiveData<Unit> {
        return dbDeleteByCityNameUseCase.getExecute(UseCaseSubscriberImpl(
            {
                Log.d("deleteCitiesFromDb", "deleteCitiesFromDb $it")
            },
            {
                Log.d("deleteCitiesFromDb", "deleteCitiesFromDb: ${it.message}", it as Exception)
            },
            {
                Log.d("deleteCitiesFromDb", "deleteCitiesFromDb Canceled")
            }
        ), city)
    }

    fun getFavouriteCitiesFromDB(): LiveData<List<DBFavouriteCitiesEntity>> {
        return dbGetListFavouriteCitiesUseCase.getExecute(UseCaseSubscriberImpl(
            {
                Log.d("getFavouriteCitiesFrom", "getFavouriteCitiesFromDB $it")
            },
            {
                Log.d("getFavouriteCitiesFrom", "getFavouriteCitiesFromDB: ${it.message}", it as Exception)
            },
            {
                Log.d("getFavouriteCitiesFrom", "getFavouriteCitiesFromDB Canceled")
            }
        ))
    }

    fun deleteFavouriteCitiesFromDb(city: String): LiveData<Unit> {
        return dbDeleteFavouriteCityUseCase.getExecute(UseCaseSubscriberImpl(
            {
                Log.d("deleteFavouriteCities", "deleteFavouriteCities $it")
            },
            {
                Log.d("deleteFavouriteCities", "deleteFavouriteCities: ${it.message}", it as Exception)
            },
            {
                Log.d("deleteFavouriteCities", "deleteFavouriteCities Canceled")
            }
        ), city)
    }

    fun insertFavouriteCityToDb(city: DBFavouriteCitiesEntity): LiveData<Unit> {
        return dbInsertFavouriteCityUseCase.getExecute(UseCaseSubscriberImpl(
            {
                Log.d("insertFavouriteCityToDb", "insertFavouriteCityToDb $it")
            },
            {
                Log.d("insertFavouriteCityToDb", "insertFavouriteCityToDb: ${it.message}", it as Exception)
            },
            {
                Log.d("insertFavouriteCityToDb", "insertFavouriteCityToDb Canceled")
            }
        ), city)
    }
}