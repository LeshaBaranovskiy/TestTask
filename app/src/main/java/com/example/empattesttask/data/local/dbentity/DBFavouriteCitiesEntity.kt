package com.example.empattesttask.data.local.dbentity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "favourite_cities"
)
data class DBFavouriteCitiesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,
    @ColumnInfo(name = "city")
    val city: String
)