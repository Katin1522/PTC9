package katherine.ceron.ptc9

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import modelo.ClaseConexion
import modelo.DataClassCard

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
        val txtnombreIN = findViewById<EditText>(R.id.txtnombreIN)
        val txtMarcaIn = findViewById<EditText>(R.id.txtMarcaIN)
        val txtCantidadIn = findViewById<EditText>(R.id.txtCantidadIn)
        val btnAgregarAin = findViewById<Button>(R.id.btnAgregarAin)
        val btnactualizarAin = findViewById<Button>(R.id.btnactualizarAin)
        val btneliminarAin = findViewById<Button>(R.id.btneliminarAin)
        val rcvItemsMedicamento = findViewById<RecyclerView>(R.id.rcvItemsMedicamento)

        rcvItemsMedicamento.layoutManager = LinearLayoutManager(this)

        fun obtenerDatos(): List<DataClassCard> {
            val card = mutableListOf<DataClassCard>()
            val objClaseConexion = ClaseConexion().cadenaConexion()

            objClaseConexion?.use { connection ->
                val statement = connection.createStatement()
                val resulSet= statement.executeQuery("SELECT * FROM MEDICAMENTOS")


                resulSet.use { rs ->
                    while (rs.next()){
                        val nombre = rs.getString("NOMBRE")
                        val marca = rs.getString("MARCA")
                        val cantidad = rs.getInt("CANTIDAD")

                        val card = DataClassCard(nombre, marca, cantidad)
                        card.add(card)
                    }
                }
            }
            return card
        }


    }
}