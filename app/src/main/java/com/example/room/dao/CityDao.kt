package com.example.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.room.entities.City
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao {
    @Query("SELECT * from city_table ORDER BY city ASC")
    fun getAllCities(): Flow<List<City>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(city: City)
}
