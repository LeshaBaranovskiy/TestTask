package com.example.empattesttask.data.local.dbentity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "city_weather"
)
data class DBWeatherEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,
    @ColumnInfo(name = "city")
    val city: String,
    @ColumnInfo(name = "date")
    val date: Long,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "temperature")
    val temperature: Int,
    @ColumnInfo(name = "wind_speed")
    val windSpeed: Float,
    @ColumnInfo(name = "humidity")
    val humidity: Int,
    @ColumnInfo(name = "icon_name")
    val iconName: String
)