package com.example.room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
    fun registo(view: View){
        val intent = Intent(this, Registo::class.java)
        startActivity(intent)
    }

    fun paginaInicial(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}