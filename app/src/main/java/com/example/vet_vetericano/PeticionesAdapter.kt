package com.example.vet_vetericano

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vet_vetericano.databinding.ItemPeticionBinding

// Modelo simple de datos
data class Peticion(
    val codigo: String,
    val titulo: String,
    val ubicacion: String,
    val hora: String,
    val estado: String
)

class PeticionesAdapter(
    private var lista: List<Peticion>,
    private val onDetalleClick: (Peticion) -> Unit
) : RecyclerView.Adapter<PeticionesAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemPeticionBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPeticionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = lista[position]
        with(holder.binding) {
            tvCodigo.text = item.codigo
            tvTitulo.text = item.titulo
            tvUbicacion.text = item.ubicacion
            tvHora.text = "Asignada: ${item.hora}"
            tvEstado.text = item.estado

            // Click en "Ver detalle"
            tvVerDetalle.setOnClickListener { onDetalleClick(item) }
        }
    }

    override fun getItemCount(): Int = lista.size

    // Actualiza la lista en pantalla
    fun actualizarLista(nuevaLista: List<Peticion>) {
        lista = nuevaLista
        notifyDataSetChanged()
    }
}
