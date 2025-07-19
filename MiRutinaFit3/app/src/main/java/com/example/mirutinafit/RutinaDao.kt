package com.example.mirutinafit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RutinaDao {
    @Insert
    suspend fun insertar(rutina: RutinaEntity)

    @Query("SELECT * FROM rutinas ORDER BY id DESC")
    suspend fun obtenerTodas(): List<RutinaEntity>
}
