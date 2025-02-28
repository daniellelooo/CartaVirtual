package com.example.cartavirtual

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ReservasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        abrirWhatsApp()
        finish() // Cierra esta actividad después de abrir WhatsApp
    }

    private fun abrirWhatsApp() {
        val numero = "573115807057"
        val mensaje = "Hola, quiero hacer una reserva."
        val url = "https://api.whatsapp.com/send?phone=$numero&text=${Uri.encode(mensaje)}"

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "WhatsApp no está instalado", Toast.LENGTH_SHORT).show()
        }
    }
}

