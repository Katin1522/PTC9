package RecyclerViewHelpers

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import katherine.ceron.ptc9.R


class ViewHolder2(view: View): RecyclerView.ViewHolder(view) {

    val NombreP = view.findViewById<TextView>(R.id.txtNombreH)
    val Habitacion = view.findViewById<TextView>(R.id.txtnumeroHabi)
}