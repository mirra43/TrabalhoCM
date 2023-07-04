package com.example.room.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi

object ServiceBuilder {
    private val client = OkHttpClient.Builder().build()
    private val moshi: Moshi = Moshi.Builder().build()
    private val gson = GsonBuilder().setLenient().create() // Configuração para aceitar JSON inválido
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://trabalhocmdux2223.000webhostapp.com/Api/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}
