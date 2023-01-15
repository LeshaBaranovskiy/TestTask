package com.example.empattesttask.domain.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.empattesttask.domain.viewmodel.ShowForecastViewModel
import com.example.empattesttask.domain.viewmodel.base.ViewModelFactory
import com.example.empattesttask.domain.viewmodel.base.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap as IntoMap1

@Module
interface ViewModelModule {
    @Binds
    fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap1
    @ViewModelKey(ShowForecastViewModel::class)
    fun bindShowForecastViewModel(viewModel: ShowForecastViewModel): ViewModel
}