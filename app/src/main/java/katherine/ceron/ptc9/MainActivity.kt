package katherine.ceron.ptc9

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import modelo.ClaseConexion

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.MainActivity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtCorreoUsuLog = findViewById<EditText>(R.id.txtCorreoUsuLog)
        val txtContrasenaLog = findViewById<EditText>(R.id.txtContrasena)
<<<<<<< HEAD
        val lbOlvidarContra = findViewById<TextView>(R.id.olvidarContraseña)
=======
        val lbOlvidarContra = findViewById<TextView>(R.id.lblOlvidarContraseña)
>>>>>>> 5302487ee96ce609f9c35edb4b71a13e03a07641
        val btnIniciarSecion = findViewById<Button>(R.id.btnIniciarSecion)

        lbOlvidarContra.setOnClickListener{
            val pantallaRegistrate = Intent()
        }

        btnIniciarSecion.setOnClickListener{
           val pantallaPrincipal = Intent(this,Bienvenida::class.java)
            GlobalScope.launch (Dispatchers.IO){

                val objConexion = ClaseConexion().cadenaConexion()
                val comprobarUsuario = objConexion?.prepareStatement("SELECT * FROM USUARIO WHERE USUARIO = ? AND CLAVE = ? ")!!
                comprobarUsuario.setString(1,txtCorreoUsuLog.text.toString())
                comprobarUsuario.setString(2,txtContrasenaLog.text.toString())

                val resultado = comprobarUsuario.executeQuery()
                if (resultado.next()){
                    startActivity(pantallaPrincipal)
                } else {
                    println("Sus credenciales estan incorrectas verifique sus credenciales o no ha creado una cuenta")
                }
            }


        }
}
    }

