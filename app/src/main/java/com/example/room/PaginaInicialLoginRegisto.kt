package com.example.room

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection


class PaginaInicialLoginRegisto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_inicial_login_registo)



}


    fun abrePaginaLogin(view: View) {
        //remover o toast
        Toast.makeText(applicationContext, "Abre Pagina Login", Toast.LENGTH_SHORT).show()


        //remover isto (so para testes)
        //****************************************************************************//
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        //****************************************************************************//

    }

    fun abrePaginaRegisto(view: View) {
        //remover o toast
        Toast.makeText(applicationContext, "Abre Pagina Registo", Toast.LENGTH_SHORT).show()
    }




}