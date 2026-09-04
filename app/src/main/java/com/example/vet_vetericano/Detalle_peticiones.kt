package com.example.vet_vetericano

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.vet_vetericano.databinding.ActivityDetallePeticionesBinding

class Detalle_peticiones : AppCompatActivity() {

    private lateinit var binding: ActivityDetallePeticionesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetallePeticionesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.




    }
}