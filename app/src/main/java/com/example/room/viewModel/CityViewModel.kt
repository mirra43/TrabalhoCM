package com.example.room.viewModel

import androidx.lifecycle.*
import com.example.room.db.Repository
import com.example.room.entities.City
import kotlinx.coroutines.launch

class CityViewModel(private val repository: Repository) : ViewModel() {

    fun allCities() : LiveData<List<City>> = repository.getAllCities().asLiveData()

    fun insert(city: City) = viewModelScope.launch {
        repository.insert(city)
    }

}

class CityViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CityViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CityViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}