package com.example.room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.drawerlayout.widget.DrawerLayout
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navDrawer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        navDrawer = findViewById(R.id.nav_drawer)

        val openMenuButton: ImageButton = findViewById(R.id.button_open_menu)
        openMenuButton.setOnClickListener {
            drawerLayout.openDrawer(navDrawer)
        }




    }


    fun abrePaginaInicial(view: View) {
        //remover o toast
        Toast.makeText(applicationContext, "Abre Página Inicial", Toast.LENGTH_SHORT).show()
    }

    fun abreBiblioteca(view: View) {
        //remover o toast
        Toast.makeText(applicationContext, "Abre Biblioteca", Toast.LENGTH_SHORT).show()
    }

    fun abreSalaEstudo(view: View) {
        //remover o toast
        Toast.makeText(applicationContext, "Abre Salas de Estudo", Toast.LENGTH_SHORT).show()

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


