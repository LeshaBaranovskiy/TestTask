package com.example.empattesttask.presentation.di

import com.example.empattesttask.data.di.NetworkModule
import com.example.empattesttask.presentation.di.presentation.PresentationModule
import dagger.Module

@Module(
    includes = [
        PresentationModule::class,
        NetworkModule::class
    ]
)
class ApplicationModule {
}