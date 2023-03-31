package com.example.room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

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