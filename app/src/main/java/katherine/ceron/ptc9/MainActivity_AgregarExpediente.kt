package katherine.ceron.ptc9

import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity_AgregarExpediente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_agregar_expediente)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.MainActivity_AgregarExpediente)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtnombreExp = findViewById<EditText>(R.id.txtnombreAgregarP)
        val spinner2Habitaciones = findViewById<Spinner>(R.id.spinner2Habitaciones)
        val spinner3Categoria = findViewById<Spinner>(R.id.spinner3Categoria)
        val txtdiagExp = findViewById<EditText>(R.id.txtdiagnosEP)
        val txthistorialExp = findViewById<EditText>(R.id.txthistorialEP)
        val btnAgregarExp = findViewById<Button>(R.id.btnAgregarExp)

        val listaHabitaciones = listOf("Habitacion 1", "Habitacion 2", "Habitacion 3")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, listaHabitaciones)
        listaHabitaciones.also { spinner2Habitaciones.adapter = adapter  }
        val listaCategoria = listOf("Categoria 1", "Categoria 2", "Categoria 3")
        val adapter2 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, listaCategoria)
        listaCategoria.also { spinner3Categoria.adapter = adapter2 }

        btnAgregarExp.setOnClickListener {
            val nombre = txtnombreExp.text.toString()
            val habitacion = spinner2Habitaciones.toString()
            val categoria = spinner3Categoria.toString()
            val diagnostico = txtdiagExp.text.toString()
            val historial = txthistorialExp.text.toString()
        }
        }

    private fun requireContext(): Context {
        TODO("Not yet implemented")
    }
}
