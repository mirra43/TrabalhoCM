package com.example.room.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface EndPoints {

    @GET("/users")
    fun getUsers(): Call<List<User>>

    @FormUrlEncoded
    @POST("createUser.php")
    fun postUser(
        @Field("nome") nome: String?,
        @Field("username") username: String?,
        @Field("email") email: String?,
        @Field("password") password: String?
    ): Call<ResponseBody>

    @FormUrlEncoded
    @POST("loginUser.php")
    fun loginUser(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<ResponseBody>


    @GET("salas")
    fun getSalas(): Call<List<Salas>>


    @GET("salas/{id}")
    fun getSalaById(@Path("id") id: Int): Call<Salas>

    @GET("biblioteca")
    fun getBiblioteca() : Call<List<LugaresBiblioteca>>

}