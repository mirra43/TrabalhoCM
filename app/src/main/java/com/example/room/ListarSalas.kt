package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.drawerlayout.widget.DrawerLayout

class ListarSalas : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navDrawer: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_salas)

        drawerLayout = findViewById(R.id.drawer_layout)
        navDrawer = findViewById(R.id.nav_drawer)

        val openMenuButton: ImageButton = findViewById(R.id.button_open_menu)
        openMenuButton.setOnClickListener {
            drawerLayout.openDrawer(navDrawer)
        }
    }
}