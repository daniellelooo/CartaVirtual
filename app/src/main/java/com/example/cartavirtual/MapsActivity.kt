package com.example.cartavirtual

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Obtener la latitud y longitud pasadas desde el Intent
        val lat = intent.getDoubleExtra("LATITUD", 0.0)
        val lng = intent.getDoubleExtra("LONGITUD", 0.0)
        val nombreSede = intent.getStringExtra("NOMBRE_SEDE") ?: "Sede"

        val ubicacion = LatLng(lat, lng)
        mMap.addMarker(MarkerOptions().position(ubicacion).title(nombreSede))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, 15f))
    }
}
