package com.example.cartavirtual
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cartavirtual.PlatoDetalleActivity
import com.example.cartavirtual.R

class MenuActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var menuAdapter: MenuAdapter

    private val platos = listOf(
        Plato("Bife de Chorizo", "Delicioso corte de carne a la parrilla.", "$25.00", R.drawable.bifedechorizo),
        Plato("Entraña", "Jugosa entraña a la parrilla con chimichurri.", "$22.00", R.drawable.entrana),
        Plato("Picaña", "Sabrosa picaña a la parrilla con sal gruesa.", "$28.00", R.drawable.picana),
        Plato("Asado de Tira", "Clásico asado de tira cocido lentamente.", "$20.00", R.drawable.asadodetira),
        Plato("Costillas de Cerdo", "Tiernas costillas de cerdo a la barbacoa.", "$23.00", R.drawable.costillasdecerdo)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu) // ✅ Corrección

        recyclerView = findViewById(R.id.menuRecyclerView) // ✅ Corrección
        recyclerView.layoutManager = LinearLayoutManager(this)

        menuAdapter = MenuAdapter(platos)
        recyclerView.adapter = menuAdapter
    }

    data class Plato(val nombre: String, val descripcion: String, val precio: String, val imagenResId: Int)

    private inner class MenuAdapter(private val platos: List<Plato>) :
        RecyclerView.Adapter<MenuAdapter.PlatoViewHolder>() {

        inner class PlatoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val cardView: CardView = itemView.findViewById(R.id.platoCardView) // ✅ Corrección
            val nombreTextView: TextView = itemView.findViewById(R.id.nombrePlatoTextView) // ✅ Corrección
            val precioTextView: TextView = itemView.findViewById(R.id.precioPlatoTextView) // ✅ Corrección
            val platoImageView: ImageView = itemView.findViewById(R.id.platoImageView) // ✅ Corrección
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlatoViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.plato_item, parent, false) // ✅ Corrección
            return PlatoViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: PlatoViewHolder, position: Int) {
            val plato = platos[position]
            holder.nombreTextView.text = plato.nombre
            holder.precioTextView.text = plato.precio
            holder.platoImageView.setImageResource(plato.imagenResId) // ✅ Corrección

            holder.cardView.setOnClickListener {
                val intent = Intent(holder.itemView.context, PlatoDetalleActivity::class.java)
                intent.putExtra("nombre", plato.nombre)
                intent.putExtra("descripcion", plato.descripcion)
                intent.putExtra("precio", plato.precio)
                intent.putExtra("imagen", plato.imagenResId) // ✅ Corrección
                holder.itemView.context.startActivity(intent)
            }
        }

        override fun getItemCount() = platos.size
    }
}
