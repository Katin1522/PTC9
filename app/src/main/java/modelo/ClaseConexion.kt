package modelo

import java.sql.Connection
import java.sql.DriverManager

class ClaseConexion {
    fun cadenaConexion(): Connection?{
        try {
            val url="jdbc:oracle:thin:@ 192.168.0.108:1521:xe"
            val usuario ="dlph"
            val contraseña= "dlphsuerte"

            val connection= DriverManager.getConnection(url,usuario,contraseña)
            return connection
        }catch (e:Exception){
            println("error : $e")
            return null
        }
    }

}