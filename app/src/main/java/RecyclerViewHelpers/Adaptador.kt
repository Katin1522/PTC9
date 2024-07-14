package RecyclerViewHelpers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import katherine.ceron.ptc9.R
import modelo.Recetas

class Adaptador(var DatosR: List<Recetas>): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_cad,parent,false)
        return ViewHolder(vista)
    }
    fun actualizarLista(nuevaLista: List<class>) {
        DatosR = nuevaLista
        notifyDataSetChanged()
    }

    override fun getItemCount() = DatosR.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = DatosR [position]
        holder.txtNombreCard.text = item.Paciente

    }
}