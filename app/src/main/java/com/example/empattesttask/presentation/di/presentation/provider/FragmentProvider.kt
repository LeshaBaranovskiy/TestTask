package com.example.empattesttask.presentation.di.presentation.provider

import com.example.empattesttask.presentation.fragment.BaseFragment
import com.example.empattesttask.presentation.fragment.SelectCityFragment
import com.example.empattesttask.presentation.fragment.ShowForecastFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentProvider {
    @ContributesAndroidInjector
    abstract fun provideBaseFragment(): BaseFragment

    @ContributesAndroidInjector
    abstract fun provideSelectCityFragment(): SelectCityFragment

    @ContributesAndroidInjector
    abstract fun provideShowForecastFragment(): ShowForecastFragment
}