package com.example.room


import android.content.Context
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



class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    fun irpararegisto(view: View){
        val intent = Intent(this@Login, Registo::class.java)
        startActivity(intent)
    }

    fun iniciarSessao(view: View) {

        val usernameEditText = findViewById<EditText>(R.id.usernameLogin)
        val passwordEditText = findViewById<EditText>(R.id.passwordLogin)

        val username = usernameEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        val request = ServiceBuilder.buildService(EndPoints::class.java)
        val call = request.loginUser(username, password)

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()?.string()
                    if (responseBody != null) {
                        // Faça algo com a resposta JSON recebida
                        Log.d("Response", responseBody)

                        // Armazenar o nome de usuário em SharedPreferences
                        val sharedPref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
                        val editor = sharedPref.edit()
                        editor.putString("username", username)
                        editor.apply()

                        // Redirecionar para a página de login
                        val intent = Intent(this@Login, MainActivity::class.java)
                        startActivity(intent)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@Login, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }




}