package katherine.ceron.ptc9

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.txtHistorialExp)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtCorreoUsuLog = findViewById<EditText>(R.id.txtCorreoUsuLog)
        val txtContrasenaLog = findViewById<EditText>(R.id.txtContrasenaLog)
        val lbOlvidarContra = findViewById<TextView>(R.id.lbOlvidaContra)
        val btnIniciarSecion = findViewById<Button>(R.id.btnIniciarSecion)

        lbOlvidarContra.setOnClickListener{
            val pantallaRegistrate = Intent()
        }

        btnIniciarSecion.setOnClickListener{
            val Correo= txtCorreoUsuLog.text.toString()
            val Contrasena= txtContrasenaLog.text.toString()
        }

    }

}