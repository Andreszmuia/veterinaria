package com.example.veterinaria

import android.app.Application
import java.sql.Time

class CapaDeDatos {

    data class Cita(
        var nombreMascota:String,
        var nombreDueno:String,
        var raza:String,
        var edad:Number,
        var hora:String,
        var descripcion:String,
        var fotoMascota:String
    )

    class SharedApp : Application() {
        companion object {
            lateinit var citasTodos: MutableList<Cita>
        }

        override fun onCreate() {
            super.onCreate()
            citasTodos = ArrayList()
        }


    }

}