package com.example.room

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.room.api.EndPoints
import com.example.room.api.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import okhttp3.ResponseBody



class Registo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registo)



    }

    fun irparaLogin(view: View) {
        val intent = Intent(this@Registo, Login::class.java)
        startActivity(intent)

    }


    fun registarUser(view: View) {
        val nomeEditText = findViewById<EditText>(R.id.nomeEditText)
        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)

        val nome = nomeEditText.text.toString().trim()
        val username = usernameEditText.text.toString().trim()
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        val request = ServiceBuilder.buildService(EndPoints::class.java)
        val call = request.postUser(nome, username, email, password)

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()?.string()
                    if (responseBody != null) {
                        // Faça algo com a resposta JSON recebida
                        Log.d("Response", responseBody)

                        // Redirecionar para a página de login
                        val intent = Intent(this@Registo, Login::class.java)
                        startActivity(intent)

                    }
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@Registo, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }












}