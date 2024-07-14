package RecyclerViewHelpers

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import katherine.ceron.ptc9.R

class ViewHolder(view:View): RecyclerView.ViewHolder(view) {

    val txtNombreCard = view.findViewById<TextView>(R.id.txtNombreCard)
    val txtDescripcionCard = view.findViewById<TextView>(R.id.txtDescripcionCard)

}