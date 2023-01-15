package com.example.empattesttask.common.utils.time

import java.text.SimpleDateFormat
import java.util.*

class TimeUtil {
    companion object {
        fun millToDate(millis: Long): String {
            val formatter = SimpleDateFormat("EEE, MMM d", Locale.getDefault())
            return formatter.format(Date(millis*1000))
        }
    }
}