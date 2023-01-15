package com.example.empattesttask.presentation.navigation

import android.content.Context
import android.content.Intent
import com.example.empattesttask.presentation.activity.InitialActivity

object ActivityNavigation {
    fun navigateToInitialActivity(context: Context) {
        val intent = Intent(context, InitialActivity::class.java)
        context.startActivity(intent)
    }
}