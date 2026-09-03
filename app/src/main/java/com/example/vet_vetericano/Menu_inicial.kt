package com.example.vet_vetericano

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.vet_vetericano.databinding.ActivityMainBinding
import com.example.vet_vetericano.databinding.ActivityMenuInicialBinding
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class Menu_inicial : AppCompatActivity() {
private lateinit var binding: ActivityMenuInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityMenuInicialBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.pet.setOnClickListener {
            val intent= Intent(this, Detalle_peticiones::class.java)
            startActivity(intent)

        }
        // Creamos los 3 pedazos del pastel
        val pedazos = ArrayList<PieEntry>()
        pedazos.add(PieEntry(45f, "Atendidas"))
        pedazos.add(PieEntry(35f, "Asignadas"))
        pedazos.add(PieEntry(20f, "Reasignadas"))

        // Los metemos en un paquete de datos
        val datosDelPastel = PieDataSet(pedazos, "")

        // Le ponemos los colores amarillo azul rojo
        val colores = ArrayList<Int>()
        colores.add(Color.parseColor("#F4D03F")) // Amarillo
        colores.add(Color.parseColor("#3457D5")) // Azul
        colores.add(Color.parseColor("#D9534F")) // Rojo
        datosDelPastel.colors = colores

        // Estilo del texto dentro del pastel
        datosDelPastel.valueTextColor = Color.WHITE
        datosDelPastel.valueTextSize = 14f

        // 3. USAMOS EL BINDING PARA PASARLE LOS DATOS AL GRÁFICO
        binding.miGrafico.data = PieData(datosDelPastel)

        // 4. USAMOS EL BINDING PARA CONFIGURARLO
        binding.miGrafico.description.isEnabled = false // Quita textos por defecto
        binding.miGrafico.legend.isEnabled = false      // Quita la leyenda de abajo
        binding.miGrafico.isDrawHoleEnabled = false     // Para que sea pastel completo y no dona

        // 5. Refrescamos el gráfico
        binding.miGrafico.invalidate()
    }
}


