package com.example.room

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
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
        val url = "https://trabalhocmdux2223.000webhostapp.com/Api/getSalaById.php?id=$salaId"
        val task = GetSalaByIdTask(this)
        task.execute(url)
    }

    fun onGetSalaByIdCompleted(sala: Sala) {
        // Use the sala object as needed...
        Log.d("Sala ID", sala.id.toString())
        Log.d("Sala Nome", sala.nome)
        val nome: TextView = findViewById(R.id.sala)
        val circle: View = findViewById(R.id.indicativoCirculo)
        val rect: View = findViewById(R.id.indicativoRetangulo)
        val indtext: TextView = findViewById(R.id.indicativoTexto)
        val mesa: View = findViewById(R.id.mesa)
        val lugar1:View = findViewById(R.id.lugar1)
        val lugar2:View = findViewById(R.id.lugar2)
        val lugar3: View = findViewById(R.id.lugar3)
        val lugar4:View = findViewById(R.id.lugar4)
        nome.text = sala.nome
        if(sala.ocupada == 0){
            val color = ContextCompat.getColor(this, R.color.vermelho)
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
    class GetSalaByIdTask(private val callback: InfoSalaEstudo) : AsyncTask<String, Void, Sala>() {

        override fun doInBackground(vararg urls: String): Sala {
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
                val salaJson = stringBuilder.toString()
                return gson.fromJson(salaJson, Sala::class.java)
            }
            throw IOException("HTTP error code: $responseCode")
        }

        override fun onPostExecute(result: Sala) {
            callback.onGetSalaByIdCompleted(result)
        }
    }

    interface GetSalaByIdCallback {
        fun onGetSalaByIdCompleted(sala: Sala)
    }

    data class Sala(val id: Int, val nome: String, val ocupada: Int)
}