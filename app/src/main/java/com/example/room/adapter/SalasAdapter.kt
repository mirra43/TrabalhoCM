package com.example.room.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.room.ListarSalas
import com.example.room.R
import com.example.room.api.User

class SalasAdapter(val salas: List<ListarSalas.Sala>): RecyclerView.Adapter<SalasViewHolder>() {
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



    fun bind(sala: ListarSalas.Sala) {
        nome.text = sala.nome


    }

}