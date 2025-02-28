package com.example.cartavirtual

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var sedesButton: Button
    private lateinit var menuButton: Button
    private lateinit var reservasButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Make sure this XML exists

        sedesButton = findViewById(R.id.sedes)
        menuButton = findViewById(R.id.menu)
        reservasButton = findViewById(R.id.reservas)

        sedesButton.setOnClickListener {
            startActivity(Intent(this, SedesActivity::class.java))
        }

        menuButton.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }

        reservasButton.setOnClickListener {
            startActivity(Intent(this, ReservasActivity::class.java))
        }
    }
}
