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
        binding.btnUpdateStatus.setOnClickListener {

            val observation =
                binding.etObservation.text.toString().trim()

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
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun setupRecyclerView() {

        val statuses = listOf(

            StatusItem(
                1,
                "En evaluación",
                R.color.status_blue
            ),

            StatusItem(
                2,
                "En tratamiento",
                R.color.status_yellow
            ),

            StatusItem(
                3,
                "En observación",
                R.color.status_light_blue
            ),

            StatusItem(
                4,
                "Alta médica",
                R.color.status_green
            ),

            StatusItem(
                5,
                "Fallecido",
                R.color.status_red
            ),

            StatusItem(
                6,
                "Transferido a otro centro",
                R.color.status_grey
            )
        )

        val adapter = StatusAdapter(statuses) { selectedItem ->

            selectedStatusId = selectedItem.id

        }

        binding.rvStatuses.layoutManager =
            LinearLayoutManager(this)

        binding.rvStatuses.adapter = adapter
    }
}