package com.example.empattesttask.data.di

import dagger.Module

@Module(
    includes = [
        DataProviderModule::class,
        ServiceModule::class,
        RemoteSourceModule::class,
        DbModule::class
    ]
)
class NetworkModule {
}