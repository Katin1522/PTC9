package RecyclerViewHelpers

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import katherine.ceron.ptc9.R

class viewholderhabi (view: View): RecyclerView.ViewHolder(view){
 val txtNombreCard = view.findViewById<TextView>(R.id.txtNombreCard)
 val img_lapiz = view.findViewById<ImageView>(R.id.img_lapiz)

}