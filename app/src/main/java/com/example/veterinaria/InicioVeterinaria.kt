package com.example.veterinaria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class InicioVeterinaria : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_veterinaria)
        setUpRecyclerView()
    }

    lateinit var mRecyclerView : RecyclerView
    val mAdapter : Adaptador = Adaptador()

    fun setUpRecyclerView(){

        mRecyclerView = findViewById(R.id.rvCitas) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.Adapter(CapaDeDatos.SharedApp.citasTodos, this)
        mRecyclerView.adapter = mAdapter

    }

    fun navegarAtras (view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun navegarNC (view: View) {
        val intent = Intent(this, EditarCita::class.java)
        startActivity(intent)
    }

    fun navegarEC (view: View) {
        val intent = Intent(this, EditarCita::class.java)
    }
}