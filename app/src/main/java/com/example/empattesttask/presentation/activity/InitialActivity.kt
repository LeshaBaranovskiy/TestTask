package com.example.empattesttask.presentation.activity

import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import com.example.empattesttask.R
import com.example.empattesttask.databinding.ActivityInitialBinding
import com.example.empattesttask.presentation.navigation.FragmentNavigation

class InitialActivity : BaseActivity() {
    private val binding by viewBinding<ActivityInitialBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initialFlow()
    }

    override fun getLayoutResourcesId(): Int {
        return R.layout.activity_initial
    }

    private fun initialFlow() {
        //TODO if sharedPrefs will not be empty make redirect
        FragmentNavigation.navigateToSelectCity(supportFragmentManager)
    }
}