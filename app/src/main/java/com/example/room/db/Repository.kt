package com.example.room.db

import com.example.room.dao.CityDao
import com.example.room.entities.City
import kotlinx.coroutines.flow.Flow

class Repository(private val cityDao: CityDao) {
    fun getAllCities(): Flow<List<City>> {
        return cityDao.getAllCities()
    }

    fun insert(city: City) {
        cityDao.insert(city)
    }
}