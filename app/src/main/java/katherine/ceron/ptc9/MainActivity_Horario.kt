package katherine.ceron.ptc9

import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity_Horario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_horario)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.txtHistorialExp)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnAgregarTurno = findViewById<Button>(R.id.btnAgregarTurno)
        val calendarView = findViewById<CalendarView>(R.id.calendarView)

    }
}