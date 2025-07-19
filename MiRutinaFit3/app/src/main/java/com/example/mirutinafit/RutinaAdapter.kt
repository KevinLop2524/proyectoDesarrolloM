package com.example.mirutinafit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mirutinafit.databinding.ItemRutinaBinding
import com.example.mirutinafit.RutinaEntity


class RutinaAdapter : RecyclerView.Adapter<RutinaAdapter.ViewHolder>() {
    private val lista = mutableListOf<RutinaEntity>()

    fun actualizar(nuevaLista: List<RutinaEntity>) {
        lista.clear()
        lista.addAll(nuevaLista)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemRutinaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(r: RutinaEntity) {
            binding.txtDatos.text = "${r.tipo} - ${r.duracion} min - ${r.intensidad} - ${r.fecha}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRutinaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = lista.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position])
    }
}
