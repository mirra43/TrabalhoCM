package com.example.room.adapter

import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.room.InfoSalaEstudo
import com.example.room.ListarSalas
import com.example.room.R
import com.example.room.api.Salas
import com.example.room.api.User

class SalasAdapter(val salas: List<Salas>): RecyclerView.Adapter<SalasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalasViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return SalasViewHolder(view)
    }

    override fun getItemCount(): Int {
        return salas.size
    }

    override fun onBindViewHolder(holder: SalasViewHolder, position: Int) {
        return holder.bind(salas[position])
    }


}
class SalasViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
    private val nome: TextView = itemView.findViewById(R.id.sala)
    private val circle: View = itemView.findViewById(R.id.indicativoCirculo)
    private val rect: View = itemView.findViewById(R.id.indicativoRetangulo)
    private val indtext: TextView = itemView.findViewById(R.id.indicativoTexto)

    fun bind(sala: Salas) {
        nome.text = sala.nome
        if(sala.ocupada == 0){
            val color = ContextCompat.getColor(itemView.context, R.color.vermelho)

            indtext.text = "ocupada"
            indtext.setTextColor(Color.RED)
            nome.setTextColor(Color.RED)

        }
        itemView.setOnClickListener {
            val intent = Intent(itemView.context, InfoSalaEstudo::class.java)
            intent.putExtra("salaId", sala.id)
            itemView.context.startActivity(intent)
        }
    }



}
