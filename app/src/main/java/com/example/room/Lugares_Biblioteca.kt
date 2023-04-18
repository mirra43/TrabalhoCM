package com.example.room

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.content.Intent
import android.widget.*
import androidx.drawerlayout.widget.DrawerLayout
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.room.api.EndPoints
import com.example.room.api.LugaresBiblioteca
import com.example.room.api.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Lugares_Biblioteca : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navDrawer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lugares_biblioteca)

        drawerLayout = findViewById(R.id.drawer_layout)
        navDrawer = findViewById(R.id.nav_drawer)

        val openMenuButton: ImageButton = findViewById(R.id.button_open_menu)
        openMenuButton.setOnClickListener {
            drawerLayout.openDrawer(navDrawer)
        }
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
        val request = ServiceBuilder.buildService(EndPoints::class.java)
        val call = request.getBiblioteca()
        call.enqueue(object : Callback<List<LugaresBiblioteca>> {
            override fun onResponse(call: Call<List<LugaresBiblioteca>>, response: Response<List<LugaresBiblioteca>>) {
                Log.d("ListarLugares", "onResponse: called")
                if (response.isSuccessful){
                    val lugares: List<LugaresBiblioteca>? = response.body() // get the data from the API
                    for (lugar in lugares!!) { // loop over the items in the list
                        val viewId = "l${lugar.id}" // get the ID of the corresponding view
                        val view = findViewById<View>(resources.getIdentifier(viewId, "id", packageName)) // get a reference to the view
                        val drawable = view.background as GradientDrawable // get a reference to the drawable object
                        if (lugar.ocupada == 1) { // check if the "ocupada" field is 1
                            val verdeColor = ContextCompat.getColor(this@Lugares_Biblioteca, R.color.verde) // get the color from colors.xml
                            drawable.setColorFilter(verdeColor, PorterDuff.Mode.SRC_ATOP) // set the color filter to the "verde" color
                        } else {
                            val vermelhoColor = ContextCompat.getColor(this@Lugares_Biblioteca, R.color.vermelho) // get the color from colors.xml
                            drawable.setColorFilter(vermelhoColor, PorterDuff.Mode.SRC_ATOP) // set the color filter to the "vermelho" color
                        }
                    }


                } else {
                    Log.d("Listar Lugares", "Response unsuccessful: ${response.code()}")
                }
            }
            override fun onFailure(call: Call<List<LugaresBiblioteca>>, t: Throwable) {
                Log.d("Listar Lugares", "onFailure: ${t.message}")
                Toast.makeText(this@Lugares_Biblioteca, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
}
