package com.example.cartavirtual

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class PlatoDetalleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plato_detalle) // Usamos R.layout

        // Obtenemos los datos del intent
        val nombre = intent.getStringExtra("nombre")
        val descripcion = intent.getStringExtra("descripcion")
        val precio = intent.getStringExtra("precio")
        val imagen = intent.getIntExtra("imagen", 0)

        // Asignamos los datos a los elementos de la UI
        findViewById<TextView>(R.id.nombreDetalleTextView).text = nombre
        findViewById<TextView>(R.id.descripcionDetalleTextView).text = descripcion
        findViewById<TextView>(R.id.precioDetalleTextView).text = precio
        findViewById<ImageView>(R.id.imagenDetalleImageView).setImageResource(imagen)
    }
}
