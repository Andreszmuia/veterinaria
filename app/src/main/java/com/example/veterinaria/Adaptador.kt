package com.example.veterinaria

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class Adaptador : RecyclerView.Adapter<Adaptador.ViewHolder>() {


    var Listaareplicar:MutableList<CapaDeDatos.Cita> = ArrayList()
    //VARIABLE CONTEXTO QUE GUARDARA EL ACTIVITY QUE ESTA INSTANCIANDO EL ADAPTER
    lateinit var context: Context
    fun Adapter(estudiantes: MutableList<CapaDeDatos.Cita>, context: Context)
    {
        Listaareplicar = estudiantes
        this.context = context

    }

    //REESCRIBIMOS EL RELLENAR EL VIEW HOLDER PARA UTILIZAR LA LISTA DE ESTUDIANTES
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = Listaareplicar.get(position)
        holder.bind(item, context)
    }
    //REESCRIBIMOS EL CREATE DEL VIEW HOLDER PARA INDICARLE EL DISENNO LAYOUT RESPECTIVO CON EL QUE QUEREMOS RELLENAR
    //EL RECYCLER
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        //AQUI SELECCIONAMOS EL NOMBRE DEL LAYOUT CORRESPONDIENTE
        return ViewHolder(layoutInflater.inflate(R.layout.disennoquesereplica, parent, false))
    }
    //PARA SABER CUANTOS ITEMS VA A TENER EL RECYCLER, ES EL MISMO NUMERO DE ESTUDIANTES
    override fun getItemCount(): Int {
        return Listaareplicar.size
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombreMascota = view.findViewById(R.id.tvNombreMascota) as TextView
        val nombreDueno = view.findViewById(R.id.tvNombreDueno) as TextView
        val raza = view.findViewById(R.id.tvRaza) as TextView
        val edad = view.findViewById(R.id.tvEdad) as TextView
        val hora = view.findViewById(R.id.etHora) as EditText
        val descripcion = view.findViewById(R.id.tvDescripcion) as TextView
        val eliminar = view.findViewById(R.id.btnEliminar) as Button
        val fotoMascota = view.findViewById(R.id.ivFotoMascota) as ImageView

        //ESTA FUNCION RELLENA CADA ITEM DEL RECYCLERVIEW CON LA INFORMACION RESPECTIVA DE CADA CLASE ESTUDIANTE
        //QUE ESTA EN LA LISTA
        fun bind(cita: CapaDeDatos.Cita, context: Context){
            nombreMascota
            nombreDueno
            raza
            edad
            hora
            descripcion
            eliminar
            fotoMascota.loadUrl(cita.foto)//UTILIZO LA LIBRERIA PICASSO PARA CARGAR UNA IMAGEN DESDE UNA URL
            //A UN IMAGEVIEW




//PARA CAMBIAR LA NOTA DE UN ESTUDIANTE AL PRESIONAR UNA TECLA EN EL EDITEXT
            txtnota.setText(estudiante.nota.toString())
            txtnota.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {//CORROBORA QUE LA TECLA PRESIOANDA
                    //SEA ENTER
                    estudiante.nota = txtnota.text.toString().toInt()//REESCRIBO EL ATRIBUTO NOTA DE LA CLASE ACTUAL CON LO QUE
                    //ESCRIBIO EL USUARIO EN EL CAMPO
                    Toast.makeText(context,  "Nota del estudiante: " + estudiante.nombre + " ha sido actualizada", Toast.LENGTH_SHORT).show()
//LE MUESTRO UN MSG AL USUAIRO SOBRE LA MODIFICACION
                    return@OnKeyListener true
                }
                false
            })
            //AL PRESIONAR SOBRE EL BOTON ELIMINAR
            botonelimina.setOnClickListener(){
//CREO UN TEXTO DE DIALOGO PARA EL USUARIO, PROGRAMO QUE PASA CUANDO SE PRESIONA POSITICO O NEGATIVO
                var dialogClickListener =
                    DialogInterface.OnClickListener { dialog, which ->
                        when (which) {
                            DialogInterface.BUTTON_POSITIVE -> {
                                //SI SE PRESIONA POSITIVO
                                CapadeDatos.SharedApp.estudiantestodos.remove(estudiante)//ELIMINO DE LA LISTA DE LA CLASE
                                //COMPARTIDA, EL ESTUDIANTE ACTUAL
                                Toast.makeText(context,  estudiante.nombre + " eliminado", Toast.LENGTH_SHORT).show()
                                // LE MUESTRO UN MSG AL USUARIO

                            }
                            DialogInterface.BUTTON_NEGATIVE -> {
//SI PRESIONA NEGATIVO, NO HAGO NADA
                            }
                        }
                    }
//INSTANCIO Y PONGO EL TEXTO DE LA CONSULTA AL USUAIRO, SOBRE SI DESEA ELIMINAR EL ESTUDIANTE
                val builder: AlertDialog.Builder = AlertDialog.Builder(context)
                builder.setMessage("Desea eliminar este estudiante "+ estudiante.nombre +"?").setPositiveButton("Si", dialogClickListener)
                    .setNegativeButton("No", dialogClickListener).show()//LE ASIGNO AL SI Y AL NO, LA VARIABLE CREADA ANTERIORMENTE
            }

        }
        //FUNCION GENERICA PARA CARGAR URL A UN IMAGEVIEW USANDO LA LIBRERIA PICASSO
        fun ImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(this)
        }
    }
}