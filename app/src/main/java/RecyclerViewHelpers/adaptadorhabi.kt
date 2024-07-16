package RecyclerViewHelpers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import katherine.ceron.ptc9.R
import modelo.tbHabitaciones

class adaptadorhabi (var datos: List<tbHabitaciones>): RecyclerView.Adapter<viewholderhabi>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholderhabi {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_card,parent,false)
        return viewholderhabi(view)
    }

    override fun getItemCount() = datos.size

    override fun onBindViewHolder(holder: viewholderhabi, position: Int) {

        val item = datos[position]
        holder.txtNombreCard.text = item.nombrePaciente
    }

}


