package com.example.vet_vetericano

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vet_vetericano.databinding.ActivityInicioBienvenidBinding

class Inicio_bienvenid : AppCompatActivity() {

    private lateinit var binding: ActivityInicioBienvenidBinding
    private lateinit var adapter: PeticionesAdapter
    private var listaOriginal = listOf<Peticion>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioBienvenidBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cargarDatosEjemplo()
        setupRecyclerView()
        setupBuscador()
    }

    private fun cargarDatosEjemplo() {
        listaOriginal = listOf(
            Peticion("#INC-2026-000123", "Canino-Animal herido o enfermo", "Barrio el poblado, com. 14", "08:15", "Urgente"),
            Peticion("#INC-2026-000124", "Felino- Herida abierta", "Barrio San Fernando, com. 9", "09:02", "Asignada"),
            Peticion("#INC-2026-000125", "Ave- Ala lesionada", "Barrio las granjas, com. 5", "07:30", "En proceso")
        )
    }

    private fun setupRecyclerView() {
        adapter = PeticionesAdapter(listaOriginal) { peticion ->
            // Navega a la pantalla de detalle que hizo tu compañero
            val intent = Intent(this, Detalle_peticiones::class.java)
            startActivity(intent)
        }
        binding.rvPeticiones.layoutManager = LinearLayoutManager(this)
        binding.rvPeticiones.adapter = adapter
    }

    private fun setupBuscador() {
        binding.etBuscar.addTextChangedListener { texto ->
            val filtro = texto.toString().lowercase()
            val listaFiltrada = listaOriginal.filter {
                it.titulo.lowercase().contains(filtro) || it.codigo.lowercase().contains(filtro)
            }
            adapter.actualizarLista(listaFiltrada)
        }
    }
}