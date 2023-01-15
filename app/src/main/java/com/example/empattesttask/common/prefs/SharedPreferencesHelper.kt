package com.example.empattesttask.common.prefs

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity

class SharedPreferencesHelper {
    companion object {
        private var sharedPref: SharedPreferences? = null
        const val TAG_LAST_CITY = "TAG_LAST_CITY"

        fun setLastCity(activity: Activity, city: String) {
            sharedPref = activity.getPreferences(Context.MODE_PRIVATE) ?: return
            with(sharedPref?.edit()) {
                this?.putString(TAG_LAST_CITY, city)
                this?.apply()
            }
        }

        fun getLastCity(activity: Activity): String {
            sharedPref = activity.getPreferences(Context.MODE_PRIVATE)
            return sharedPref?.getString(TAG_LAST_CITY, "").toString()
        }
    }
}