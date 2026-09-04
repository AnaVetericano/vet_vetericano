package com.example.vet_vetericano

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.vet_vetericano.databinding.ItemEstadoBinding

class AdaptadorEstado(
    private val estados: List<Estado>,
    private val alSeleccionar: (Estado) -> Unit
) : RecyclerView.Adapter<AdaptadorEstado.VistaEstado>() {

    private var posicionSeleccionada = 1

    inner class VistaEstado(
        val binding: ItemEstadoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {

            binding.root.setOnClickListener {

                val posicion = bindingAdapterPosition

                if (posicion == RecyclerView.NO_POSITION) {
                    return@setOnClickListener
                }

                val posicionAnterior = posicionSeleccionada

                posicionSeleccionada = posicion

                if (posicionAnterior != -1) {
                    notifyItemChanged(posicionAnterior)
                }

                notifyItemChanged(posicionSeleccionada)

                alSeleccionar(estados[posicion])
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VistaEstado {

        val binding = ItemEstadoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return VistaEstado(binding)
    }

    override fun onBindViewHolder(
        holder: VistaEstado,
        position: Int
    ) {

        val estado = estados[position]
        val binding = holder.binding
        val contexto = holder.itemView.context

        // Nombre
        binding.txtNombreEstado.text = estado.nombre

        // Color del círculo
        binding.vistaColor.backgroundTintList =
            ContextCompat.getColorStateList(
                contexto,
                estado.color
            )

        // Radio seleccionado
        val seleccionado = position == posicionSeleccionada

        binding.radioEstado.isChecked = seleccionado

        if (seleccionado) {

            binding.tarjetaEstado.setCardBackgroundColor(
                ContextCompat.getColor(
                    contexto,
                    R.color.estado_seleccionado
                )
            )

            binding.tarjetaEstado.strokeColor =
                ContextCompat.getColor(
                    contexto,
                    R.color.morado_principal
                )

            binding.txtNombreEstado.setTextColor(
                ContextCompat.getColor(
                    contexto,
                    R.color.morado_principal
                )
            )

        } else {

            binding.tarjetaEstado.setCardBackgroundColor(
                ContextCompat.getColor(
                    contexto,
                    R.color.blanco
                )
            )

            binding.tarjetaEstado.strokeColor =
                ContextCompat.getColor(
                    contexto,
                    R.color.borde_tarjeta
                )

            binding.txtNombreEstado.setTextColor(
                ContextCompat.getColor(
                    contexto,
                    R.color.negro
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return estados.size
    }
}
