package katherine.ceron.ptc9

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivityAjustesInventario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_ajustes_inventario)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtnombreIN= findViewById<EditText>(R.id.txtnombreIN)
        val txtMarcaIn= findViewById<EditText>(R.id.txtMarcaIN)
        val btnAgregarAin =findViewById<Button>(R.id.btnAgregarAin)
        val btnactualizarAin =findViewById<Button>(R.id.btnactualizarAin)
        val btneliminarAin =findViewById<Button>(R.id.btneliminarAin)

        btnAgregarAin.setOnClickListener(){
            val nombre = txtnombreIN.text.toString()
            val Marca = txtMarcaIn.text.toString()
        }
    }
}