package com.example.room

//import android.content.Intent
//import android.os.AsyncTask
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.room.adapter.SalasAdapter
import com.example.room.api.EndPoints
import com.example.room.api.Salas
import com.example.room.api.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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

        val request = ServiceBuilder.buildService(EndPoints::class.java)
        val call = request.getSalas()
        call.enqueue(object : Callback<List<Salas>> {
            override fun onResponse(call: Call<List<Salas>>, response: Response<List<Salas>>) {
                Log.d("ListarSalas", "onResponse: called")
                if (response.isSuccessful){
                    Log.d("ListarSalas", "Response successful")
                    val salas: List<Salas>? = response.body()
                    for (sala in salas!!) {
                        Log.d("SALA", sala.toString())
                    }

                    (findViewById<RecyclerView>(R.id.recyclersalas)).apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@ListarSalas)
                        adapter = SalasAdapter(response.body()!!)
                    }
                } else {
                    Log.d("ListarSalas", "Response unsuccessful: ${response.code()}")
                }
            }
            override fun onFailure(call: Call<List<Salas>>, t: Throwable) {
                Log.d("ListarSalas", "onFailure: ${t.message}")
                Toast.makeText(this@ListarSalas, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
/*
        val url = "https://trabalhocmdux2223.000webhostapp.com/Api/getSalas.php"
        val task = MyTask(this)
        task.execute(url)*/
    }


    /*
    fun onTaskCompleted(salas: List<Sala>) {
        val salaRecyclerView = findViewById<RecyclerView>(R.id.recyclersalas)
        salaRecyclerView.layoutManager = LinearLayoutManager(this@ListarSalas)

        salaRecyclerView.adapter = SalasAdapter(salas)


    }
    class MyTask(private val callback: ListarSalas) : AsyncTask<String, Void, List<Sala>>() {

        override fun doInBackground(vararg urls: String): List<Sala> {
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
                val usersJson = stringBuilder.toString()
                return gson.fromJson(usersJson, Array<Sala>::class.java).toList()
            }
            throw IOException("HTTP error code: $responseCode")
        }

        override fun onPostExecute(result: List<Sala>) {
            callback.onTaskCompleted(result)
        }


    }

        interface MyTaskCallback {
            fun onTaskCompleted(users: List<Sala>)
        }


    data class Sala(val id: Int, val nome: String,val ocupada: Int)
*/


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
        val intent = Intent(this, MapaEscola::class.java)
        startActivity(intent)
    }
    fun abreLogout(view: View) {
        //remover o toast
        val sharedPref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.remove("username")
        editor.apply()

        val intent = Intent(this, Login::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
    fun abreLocalizacao(view: View) {

        val intent = Intent(this, LocalizaUser::class.java)
        startActivity(intent)
    }
}