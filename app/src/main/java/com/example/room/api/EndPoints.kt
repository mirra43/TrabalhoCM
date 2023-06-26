package com.example.room.api

import retrofit2.Call
import retrofit2.http.*

interface EndPoints {

    @GET("/users")
    fun getUsers(): Call<List<User>>


    @GET("salas")
    fun getSalas(): Call<List<Salas>>


    @GET("salas/{id}")
    fun getSalaById(@Path("id") id: Int): Call<Salas>

    @GET("biblioteca")
    fun getBiblioteca() : Call<List<LugaresBiblioteca>>

}