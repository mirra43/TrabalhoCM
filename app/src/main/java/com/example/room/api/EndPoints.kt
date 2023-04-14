package com.example.room.api

import retrofit2.Call
import retrofit2.http.*

interface EndPoints {

    @GET("/users")
    fun getUsers(): Call<List<User>>


    @GET("/getSalas.php")
    fun getSalas(): Call<List<Salas>>

}