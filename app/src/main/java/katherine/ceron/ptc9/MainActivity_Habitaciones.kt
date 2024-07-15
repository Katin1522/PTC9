package katherine.ceron.ptc9

import RecyclerViewHelpers.Adaptador2
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity_Habitaciones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_habitaciones)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val btnAgregarHabi = findViewById<Button>(R.id.btnAgregarHabi)
        val txtNombre = findViewById<TextView>(R.id.txtNombreH)
        val txtHabitacion = findViewById<TextView>(R.id.txtnumeroHabi)


        btnAgregarHabi.setOnClickListener {
            val nombre = txtNombre.text.toString()
            val habitacion = txtHabitacion.text.toString().toIntOrNull()

            if (nombre.isNullOrEmpty()) {
                txtNombre.error = "Ingrese un nombre válido"
                return@setOnClickListener
            }

            if (habitacion == null || habitacion <= 0) {
                txtHabitacion.error = "Ingrese un número de habitación válido"
                return@setOnClickListener
            }

            txtNombre.text = nombre
            txtHabitacion.text = habitacion.toString()
        }

    }
    }