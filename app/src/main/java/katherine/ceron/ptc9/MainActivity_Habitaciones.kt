package katherine.ceron.ptc9

import RecyclerViewHelpers.adaptadorhabi
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import modelo.ClaseConexion
import modelo.tbHabitaciones

class MainActivity_Habitaciones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_habitaciones)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.MainActivity_Habitaciones)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtConfirmarContra = findViewById<EditText>(R.id.txtConfirmarContra)
        val txtnumeroHabi = findViewById<EditText>(R.id.txtnumeroHabi)
        val btnAgregarHabi = findViewById<Button>(R.id.btnAgregarHabi)
        val rcvHabitaciones = findViewById<RecyclerView>(R.id.rcvHabitaciones)

        rcvHabitaciones.layoutManager = LinearLayoutManager(this)

        /////// TODO

      fun obtenerDatos(): List<tbHabitaciones>{

            val objConexion = ClaseConexion().cadenaConexion()
          //CREATE STAMENT
            val statement = objConexion?.createStatement()
          val resultSet = statement?.executeQuery("SELECT * FROM tbHabitaciones")

          val listaHabitaciones = mutableListOf<tbHabitaciones>()

          while (resultSet!!.next()){
              val ID_HABITACION = resultSet!!.getInt("ID_HABITACION")
              val ID_PACIENTE = resultSet!!.getInt("ID_PACIENTE")
              val nombrePaciente = resultSet!!.getString("nombrePaciente")

              val habitacion = tbHabitaciones(ID_HABITACION,ID_PACIENTE,nombrePaciente)

              listaHabitaciones.add(habitacion)

          }
          return listaHabitaciones
      }

        CoroutineScope(Dispatchers.IO).launch {
            val Habitaciones = obtenerDatos()
            withContext(Dispatchers.Main){
                val adapter = adaptadorhabi(Habitaciones)
                rcvHabitaciones.adapter = adapter
            }
        }

        btnAgregarHabi.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                val objConexionh = ClaseConexion().cadenaConexion()

                val addHabi = objConexionh?.prepareStatement("INSERT INTO tbhabitacione (NUMERO, NOMBRE) VALUES (?,?)")
               addHabi?.setInt(1,txtnumeroHabi.text.toString().toInt())
                addHabi?.setString(2,txtConfirmarContra.text.toString())
                addHabi?.executeUpdate()

            }
        }


    }
}