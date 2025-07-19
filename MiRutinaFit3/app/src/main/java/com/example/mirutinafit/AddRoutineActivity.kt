package com.example.mirutinafit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import com.example.mirutinafit.databinding.ActivityAddRoutineBinding

class AddRoutineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddRoutineBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddRoutineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getDB(this)

        binding.btnGuardar.setOnClickListener {
            val tipo = binding.editTipo.text.toString()
            val duracion = binding.editDuracion.text.toString().toIntOrNull() ?: 0
            val intensidad = binding.editIntensidad.text.toString()
            val fecha = binding.editFecha.text.toString()

            val nuevaRutina = RutinaEntity(
                tipo = tipo,
                duracion = duracion,
                intensidad = intensidad,
                fecha = fecha
            )

            lifecycleScope.launch {
                db.rutinaDao().insertar(nuevaRutina)
                finish()
            }
        }
    }
}
