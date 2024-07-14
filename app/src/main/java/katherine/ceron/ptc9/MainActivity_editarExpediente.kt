package katherine.ceron.ptc9

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity_editarExpediente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_editar_expediente)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.txtnombrehabi)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtnombreEP = findViewById<EditText>(R.id.txtnombreAgregarP)
        val txtHabitacionEP = findViewById<EditText>(R.id.txtHabitacionEP)
        val txtCategoriaEP= findViewById<EditText>(R.id.txtCategoriaEP)
        val txtdiagnosEP = findViewById<EditText>(R.id.txtdiagnosEP)
        val txthistorialEP = findViewById<EditText>(R.id.txthistorialEP)
        val btnAgregarEP = findViewById<Button>(R.id.btnAgregarEP)
        val btnEliminarEP = findViewById<Button>(R.id.btnEliminarEP)

        btnAgregarEP.setOnClickListener {
            val nombreEP = txtnombreEP.text.toString()
            val habitacionEP = txtHabitacionEP.text.toString()
            val CategoriaEP = txtCategoriaEP.text.toString()
            val diagnosticoEP = txtdiagnosEP.text.toString()
            val historialEP = txthistorialEP.text.toString()
        }

    }
}