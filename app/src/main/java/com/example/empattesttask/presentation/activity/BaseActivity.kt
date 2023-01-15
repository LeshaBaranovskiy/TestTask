package com.example.empattesttask.presentation.activity

import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResourcesId())
    }

    abstract fun getLayoutResourcesId(): Int
}