package com.example.empattesttask.presentation.navigation

import androidx.fragment.app.FragmentManager
import com.example.empattesttask.domain.viewmodel.ShowForecastViewModel
import com.example.empattesttask.presentation.fragment.SelectCityFragment
import com.example.empattesttask.presentation.fragment.ShowForecastFragment

object FragmentNavigation: Navigation() {
    const val TAG_SELECT_CITY_FRAGMENT = "TAG_SELECT_CITY_FRAGMENT"

    fun navigateToSelectCity(
        fragmentManager: FragmentManager
    ) {
        navigateTo(
            fragmentManager,
            SelectCityFragment.newInstance(),
            TAG_SELECT_CITY_FRAGMENT
        )
    }

    fun navigateToShowForecast(
        fragmentManager: FragmentManager,
        city: String,
        isFavourite: Boolean = false
    ) {
        navigateTo(
            fragmentManager,
            ShowForecastFragment.newInstance(city, isFavourite),
            TAG_SELECT_CITY_FRAGMENT
        )
    }
}