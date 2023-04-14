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

        val myTask = MyTask()
        myTask.execute("https://trabalhocmdux2223.000webhostapp.com/Api/getSalas.php")
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
    class MyTask : AsyncTask<String, Void,List<Sala>>() {
        override fun doInBackground(vararg urls: String): List<Sala> {
            val url = URL(urls[0])
            val connection = url.openConnection() as HttpsURLConnection
            connection.requestMethod = "GET"
            connection.connect()

            val responseCode = connection.responseCode
            if (responseCode == HttpsURLConnection.HTTP_OK) {
                val inputStream = connection.inputStream
                val bufferedReader = BufferedReader(InputStreamReader(inputStream))
                val stringBuilder = StringBuilder()
                var line: String?
                while (bufferedReader.readLine().also { line = it } != null) {
                    stringBuilder.append(line)
                }
                bufferedReader.close()
                inputStream.close()
                connection.disconnect()
                val gson = Gson()
                val salasJson = stringBuilder.toString()
                return gson.fromJson(salasJson, Array<Sala>::class.java).toList()
                //return stringBuilder.toString()
            }
            throw IOException("HTTP error code: $responseCode")
        }

        override fun onPostExecute(salas: List<Sala>) {
            for (sala in salas) {
                Log.d("MyTask", "User from API: id=${sala.id}, name=${sala.nome}")
            }

        }
    }

    data class Sala(val id: Int, val nome: String)
}