package com.example.room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Registo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registo)
    }

    fun iniciar(view: View){
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }

    fun paginaInicial(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}