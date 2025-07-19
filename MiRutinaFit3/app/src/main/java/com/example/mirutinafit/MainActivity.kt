package com.example.mirutinafit

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import com.example.mirutinafit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase
    private lateinit var adapter: RutinaAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getDB(this)
        adapter = RutinaAdapter()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.btnAgregar.setOnClickListener {
            startActivity(Intent(this, AddRoutineActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            val rutinas = db.rutinaDao().obtenerTodas()
            adapter.actualizar(rutinas)
        }
    }
}
