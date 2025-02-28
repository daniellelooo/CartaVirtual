package com.example.cartavirtual

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class SedesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sedes)

        // Coordenadas de cada sede
        val coordenadasSedes = arrayOf(
            "4.60971,-74.08175",  // Sede Centro
            "4.71099,-74.07209",  // Sede Norte
            "4.59889,-74.07603"   // Sede Sur
        )

        // Referencias a los CardView
        val cardViewSede1 = findViewById<CardView>(R.id.cardViewSede1)
        val cardViewSede2 = findViewById<CardView>(R.id.cardViewSede2)
        val cardViewSede3 = findViewById<CardView>(R.id.cardViewSede3)

        // Agregar OnClickListener a cada CardView
        cardViewSede1.setOnClickListener { abrirMapa(coordenadasSedes[0]) }
        cardViewSede2.setOnClickListener { abrirMapa(coordenadasSedes[1]) }
        cardViewSede3.setOnClickListener { abrirMapa(coordenadasSedes[2]) }
    }

    private fun abrirMapa(coordenadas: String) {
        val uri = Uri.parse("geo:$coordenadas?q=$coordenadas")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.setPackage("com.google.android.apps.maps") // Abre directamente Google Maps
        startActivity(intent)
    }
}
