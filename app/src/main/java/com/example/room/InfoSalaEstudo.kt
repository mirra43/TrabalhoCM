package com.example.room

import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.room.api.EndPoints
import com.example.room.api.Salas
import com.example.room.api.ServiceBuilder
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection


class InfoSalaEstudo : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navDrawer: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_sala_estudo)

        drawerLayout = findViewById(R.id.drawer_layout)
        navDrawer = findViewById(R.id.nav_drawer)

        val openMenuButton: ImageButton = findViewById(R.id.button_open_menu)
        openMenuButton.setOnClickListener {
            drawerLayout.openDrawer(navDrawer)
        }




        val salaId = intent.getIntExtra("salaId", -1)
        val request = ServiceBuilder.buildService(EndPoints::class.java)
        val call = request.getSalaById(salaId) // replace 123 with the ID of the sala you want to fetch
        call.enqueue(object : Callback<Salas> {
            override fun onResponse(call: Call<Salas>, response: Response<Salas>) {
                if (response.isSuccessful){
                    val sala: Salas? = response.body()
                    val nome: TextView = findViewById(R.id.sala)
                    val circle: View = findViewById(R.id.indicativoCirculo)
                    val rect: View = findViewById(R.id.indicativoRetangulo)
                    val indtext: TextView = findViewById(R.id.indicativoTexto)
                    val mesa: View = findViewById(R.id.mesa)
                    val lugar1:View = findViewById(R.id.lugar1)
                    val lugar2:View = findViewById(R.id.lugar2)
                    val lugar3: View = findViewById(R.id.lugar3)
                    val lugar4:View = findViewById(R.id.lugar4)
                    if (sala != null) {
                        nome.text = sala.nome
                    }
                    if (sala != null) {
                        if(sala.ocupada == 0){
                            val color = ContextCompat.getColor(applicationContext, R.color.vermelho)
                            circle.background.setColorFilter(color, PorterDuff.Mode.SRC_IN)
                            rect.background.setColorFilter(color, PorterDuff.Mode.SRC_IN)
                            mesa.background.setColorFilter(color, PorterDuff.Mode.SRC_IN)
                            lugar1.background.setColorFilter(color, PorterDuff.Mode.SRC_IN)
                            lugar2.background.setColorFilter(color, PorterDuff.Mode.SRC_IN)
                            lugar3.background.setColorFilter(color, PorterDuff.Mode.SRC_IN)
                            lugar4.background.setColorFilter(color, PorterDuff.Mode.SRC_IN)
                            indtext.text = "ocupada"
                            indtext.setTextColor(Color.RED)
                            nome.setTextColor(Color.RED)
                        }
                    }
                    Log.d("SALA", sala.toString())
                }
            }

            override fun onFailure(call: Call<Salas>, t: Throwable) {
                Log.d("ErrorCabelo", t.message.toString())
                Toast.makeText(this@InfoSalaEstudo, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

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