package katherine.ceron.ptc9

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import modelo.ClaseConexion
import java.util.UUID

class Registrate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registrate)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Registrarte)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtNombreRe = findViewById<EditText>(R.id.txtNombreRe)
        val txtUsuarioRe= findViewById<EditText>(R.id.txtUsuarioRe)
        val txtContraRe = findViewById<EditText>(R.id.txtContraRe)
        val btnRegistrarse = findViewById<Button>(R.id.btnRegistrarse)


        btnRegistrarse.setOnClickListener {
            val objConexion = ClaseConexion().cadenaConexion()

            val crearUsuario = objConexion?.prepareStatement("INSERT INTO  (UUID,NombreR,UsuarioR,ContrasenaR) VALUES ()")!!
            crearUsuario.setString(1,UUID.randomUUID().toString())
            crearUsuario.setString(2,txtNombreRe.text.toString())
            crearUsuario.setString(3,txtUsuarioRe.text.toString())
            crearUsuario.setString(4,txtContraRe.text.toString())
            withContext(Dispatchers.Main){
                Toast.makeText(this@Registrate, "Usuario creado exitosamewnte",Toast.LENGTH_SHORT).show()
                txtNombreRe.setText("")
                txtUsuarioRe.setText("")
                txtContraRe.setText("")
            }


        }

    }
    }



























































































































































