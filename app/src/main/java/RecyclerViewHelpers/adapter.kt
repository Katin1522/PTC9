package RecyclerViewHelpers

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import modelo.DataClassCard

class adapter(var Datos: List<DataClassCard>) : RecyclerView.Adapter<RecyclerViewHelpers.ViewHolder>() {
    fun actualizarLista(nuevaLista: List<DataClassCard>) {
        Datos = nuevaLista
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}