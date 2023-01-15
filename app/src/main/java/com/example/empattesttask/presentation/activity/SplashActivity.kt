package com.example.empattesttask.presentation.activity

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.empattesttask.databinding.ActivityMainBinding
import com.example.empattesttask.presentation.navigation.ActivityNavigation
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.coroutines.launch

class SplashActivity : DaggerAppCompatActivity() {

    private val binding by viewBinding<ActivityMainBinding>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        lifecycleScope.launch {
            ActivityNavigation.navigateToInitialActivity(this@SplashActivity)
        }
    }
}