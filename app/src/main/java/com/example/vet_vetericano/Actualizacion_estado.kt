package com.example.vet_vetericano

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vet_vetericano.databinding.ActivityActualizacionEstadoBinding

class Actualizacion_estado : AppCompatActivity() {

    private lateinit var binding: ActivityActualizacionEstadoBinding

    private var selectedStatusId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityActualizacionEstadoBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupRecyclerView()

        // Botón actualizar estado
        binding.btnActualizarEstado.setOnClickListener {

            val observation =
                binding.edtObservacion.text.toString().trim()

            if (selectedStatusId != null) {

                Toast.makeText(
                    this,
                    "Estado actualizado: $selectedStatusId\nObs: $observation",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                Toast.makeText(
                    this,
                    "Por favor, selecciona un nuevo estado",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // Botón regresar
        binding.btnRegresar.setOnClickListener {
            finish()
        }
    }

    private fun setupRecyclerView() {

        val statuses = listOf(

            Estado(
                1,
                "En evaluación",
                R.color.status_azul
            ),

            Estado(
                2,
                "En tratamiento",
                R.color.status_amarillo
            ),

            Estado(
                3,
                "En observación",
                R.color.status_azul_claro
            ),

            Estado(
                4,
                "Alta médica",
                R.color.status_verde
            ),

            Estado(
                5,
                "Fallecido",
                R.color.status_rojo
            ),

            Estado(
                6,
                "Transferido a otro centro",
                R.color.status_gris
            )
        )

        val adapter = AdaptadorEstado(statuses) { selectedItem ->

            selectedStatusId = selectedItem.id

        }

        binding.recyclerEstados.layoutManager =
            LinearLayoutManager(this)

        binding.recyclerEstados.adapter = adapter
        Toast.makeText(
            this,
            "Estados: ${statuses.size}",
            Toast.LENGTH_LONG
        ).show()

    }
}