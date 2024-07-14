package katherine.ceron.ptc9

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity_ConfiguracionSistema : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_configuracion_sistema)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.txtHistorialExp)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtnombreNuevo = findViewById<EditText>(R.id.txtnombreNuevo)
        val txtusuarioNuevo = findViewById<EditText>(R.id.txtusuarioNuevo)
        val txtcontrasenaNueva = findViewById<EditText>(R.id.txtcontrasenaNueva)
        val btnAgregarUser =findViewById<Button>(R.id.btnAgregarUser)
        val spinner1 = findViewById<Spinner>(R.id.spinner1)

        btnAgregarUser.setOnClickListener {
            val nombre = txtnombreNuevo.text.toString()
            val usuario = txtusuarioNuevo.text.toString()
            val contrasena = txtcontrasenaNueva.text.toString()
            val rol = spinner1.selectedItem.toString()
        }
    }
}
