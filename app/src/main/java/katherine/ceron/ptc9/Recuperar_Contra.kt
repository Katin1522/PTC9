package katherine.ceron.ptc9

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Recuperar_Contra : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recuperar_contra)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.txtHistorialExp)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)

        btnEnviar.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                enviarCorreo("dlphcontac@gmail.com","Recuperación de contraseña", "Estimado/a usuario/a, Hemos recibido una solicitud para restablecer la contraseña de su cuenta. Si usted no realizó esta solicitud, por favor ignore este mensaje.Para restablecer su contraseña")
            }
        }
    }
}