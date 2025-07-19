package com.example.mirutinafit

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rutinas")
data class RutinaEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val tipo: String,
    val duracion: Int,
    val intensidad: String,
    val fecha: String
)
