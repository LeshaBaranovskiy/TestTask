package com.example.empattesttask.presentation.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.empattesttask.R

open class Navigation {
    fun navigateTo(
        fragmentManager: FragmentManager,
        fragment: Fragment,
        tag: String
    ) {
        saveFragmentToBackStack(fragmentManager, fragment, tag, R.id.fragment_container)
    }

    private fun saveFragmentToBackStack(
        fragmentManager: FragmentManager,
        fragment: Fragment,
        tag: String,
        fragmentContainer: Int
    ) {
        fragmentManager
            .beginTransaction()
            .replace(fragmentContainer, fragment, tag)
            .addToBackStack(tag)
            .commit()
    }
}