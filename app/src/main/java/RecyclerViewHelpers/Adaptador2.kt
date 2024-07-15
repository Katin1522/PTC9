package RecyclerViewHelpers

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import katherine.ceron.ptc9.R
import modelo.Habitaciones

class Adaptador2(var DatosH: List<Habitaciones>): RecyclerView.Adapter<ViewHolder2>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder2 {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.activity_main_habitaciones,parent,false)
        return ViewHolder2(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder2, position: Int) {
        val item = DatosH[position]
        holder.NombreP.text = item.Nombre
        holder.Habitacion.text = item.Habitacion.toString()

        holder.itemView.setOnClickListener{
            val context = holder.itemView.context
            val pantalla = Intent(context,Habitaciones::class.java)
            pantalla.putExtra(
                "Nombre",
                item.Nombre
            )
            pantalla.putExtra(
                "Habitacion",
                item.Habitacion
            )
            context.startActivity(pantalla)
        }
    }

    override fun getItemCount() = DatosH.size
    }



