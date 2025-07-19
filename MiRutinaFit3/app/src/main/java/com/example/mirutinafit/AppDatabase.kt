package com.example.mirutinafit

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RutinaEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun rutinaDao(): RutinaDao

    companion object {
        fun getDB(context: Context) = Room.databaseBuilder(
            context, AppDatabase::class.java, "rutinas_db"
        ).build()
    }
}
