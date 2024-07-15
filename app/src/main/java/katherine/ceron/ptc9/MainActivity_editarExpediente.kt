package katherine.ceron.ptc9

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity_editarExpediente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_editar_expediente)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.MainActivity_AgregarExpediente)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtnombreEP = findViewById<EditText>(R.id.txtnombreeditarP)
        val spinner2HabitacionesEdit = findViewById<Spinner>(R.id.spinner2HabitacionesEdit)
        val spinner3CategoriaEdit= findViewById<Spinner>(R.id.spinner3CategoriaEdit)
        val txtdiagnosEP = findViewById<EditText>(R.id.txtdiagnosEdit)
        val txthistorialEP = findViewById<EditText>(R.id.txthistorialedit)
        val btnAgregarExpedit = findViewById<Button>(R.id.btnAgregarExpedit)
        val btnElimirarExitP = findViewById<Button>(R.id.btnElimirarExitP)

        btnAgregarExpedit.setOnClickListener {
            val nombreEP = txtnombreEP.text.toString()
            val habitacionEP = spinner2HabitacionesEdit.toString()
            val CategoriaEP = spinner3CategoriaEdit.toString()
            val diagnosticoEP = txtdiagnosEP.text.toString()
            val historialEP = txthistorialEP.text.toString()
        }

    }
}