package com.example.veterinaria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class EditarCita : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_cita)
    }
    fun leer_el_nuevo_estudiante(view: View)
    {
//AL PRESIONAR SOBRE EL BOTON DE AGREGAR ESTUDIANTE
        var textodelnombre = findViewById<EditText>(R.id.edt_nombre)
        var textodelcarnet = findViewById<EditText>(R.id.edt_carnet)
        var textodelaedad = findViewById<EditText>(R.id.edt_edad)
        actualizaestudiantes(CapaDeDatos.Estudiante(textodelnombre.text.toString(), textodelcarnet.text.toString(),textodelaedad.text.toString(),"https://cdn.pixabay.com/photo/2016/04/15/18/05/computer-1331579_1280.png",0))
//SE LLAMA A LA FUNCION DE ACTUALIZAR ESTUDIANTE Y SE LE PASAN LOS CAMPOS RESPECTIVOS DEL NUEVO ESTUDIANTE
        //QUE EL USUAIRO RELLENO EN EL ALYOUT
        textodelnombre.setText("")
        textodelcarnet.setText("")
        textodelaedad.setText("")

    }
    //ESTA FUNCION RECIBE UN ESTUDIANTE Y LO GUARDA EN LA LISTA DE LA CLASE SHAREDAPP QUE YA VIMOS ES COMPARTIDA PARA TODA LA
    //APLICACION
    fun actualizaestudiantes(nuevoestudiante: CapadeDatos.Estudiante): MutableList<CapadeDatos.Estudiante>{

        CapadeDatos.SharedApp.estudiantestodos.add(nuevoestudiante)
        setUpRecyclerView()//RELLENAMOS NUEVAMENTE EL RECYCLER VIEW
        Toast.makeText(this, "Nuevo estudiante agregado", Toast.LENGTH_SHORT).show()//LE MOSTRAMOS UN MSG AL USUARIO
        return CapadeDatos.SharedApp.estudiantestodos//DEVOLVEMOS LA LISTA DE ESTUDIANTE GLOBAL
    }
}