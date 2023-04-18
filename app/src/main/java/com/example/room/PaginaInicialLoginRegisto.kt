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

    fun abrePaginaInicial(view: View) {
        //remover o toast
        //Toast.makeText(applicationContext, "Abre Página Inicial", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun abreBiblioteca(view: View) {
        //remover o toast
        //Toast.makeText(applicationContext, "Abre Biblioteca", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, Lugares_Biblioteca::class.java)
        startActivity(intent)
    }

    fun abreSalaEstudo(view: View) {
        //remover o toast
        //Toast.makeText(applicationContext, "Abre Salas de Estudo", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, ListarSalas::class.java)
        startActivity(intent)
        //criar  SalasEstudo para isto funcionar
        /*val intent = Intent(this, SalasEstudo::class.java)
        startActivity(intent)*/
    }
    fun abreMapa(view: View) {
        //remover o toast
        Toast.makeText(applicationContext, "Abre Mapa ESTG", Toast.LENGTH_SHORT).show()
    }
    fun abreLogout(view: View) {
        //remover o toast
        Toast.makeText(applicationContext, "Dá Logout e Abre Página Login", Toast.LENGTH_SHORT).show()
    }



}