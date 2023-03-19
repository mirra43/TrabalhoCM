package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.room.adapter.CityAdapter
import com.example.room.viewModel.CityViewModel
import com.example.room.viewModel.CityViewModelFactory

class MainActivity : AppCompatActivity() {

    private val cityViewModel: CityViewModel by viewModels {
        CityViewModelFactory((application as CitiesApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // recycler view
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = CityAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // view model
        //cityViewModel.allCities().observe(this, Observer { cities ->
        ////Update the cached copy of the words in the adapter.
        //    cities?.let { adapter.setCities(it) }
        //})

        cityViewModel.allCities().observe(this, Observer{
            cities -> cities?.let { adapter.setCities(it) }
        })

    }
}