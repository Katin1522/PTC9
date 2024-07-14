package katherine.ceron.ptc9

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity_AgregarExpediente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_agregar_expediente)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Registrarte)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtnombreExp = findViewById<EditText>(R.id.txtnombreAgregarP)
        val txtHabitacionExp = findViewById<EditText>(R.id.txtHabitacionEP)
        val txtCategoriaExp = findViewById<EditText>(R.id.txtCategoriaEP)
        val txtdiagExp = findViewById<EditText>(R.id.txtdiagnosEP)
        val txthistorialExp = findViewById<EditText>(R.id.txthistorialEP)
        val btnAgregarExp = findViewById<Button>(R.id.btnAgregarExp)

        btnAgregarExp.setOnClickListener {
            val nombre = txtnombreExp.text.toString()
            val habitacion = txtHabitacionExp.text.toString()
            val categoria = txtCategoriaExp.text.toString()
            val diagnostico = txtdiagExp.text.toString()
            val historial = txthistorialExp.text.toString()
        }
        }
    }
