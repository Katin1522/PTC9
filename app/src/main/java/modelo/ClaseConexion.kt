package modelo

import java.sql.Connection
import java.sql.DriverManager

class ClaseConexion {
    fun cadenaConexion(): Connection?{
        try {
            val url="jdbc:oracle:thin:@192.168.96.123:1521:xe"
            val usuario ="system"
            val contraseña= "itr2020"

            val connection= DriverManager.getConnection(url,usuario,contraseña)
            return connection
        }catch (e:Exception){
            println("error : $e")
            return null
        }
    }

}