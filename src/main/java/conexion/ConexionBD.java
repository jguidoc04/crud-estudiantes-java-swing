/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

/**
 *
 * @author USER
 */
public class ConexionBD {
            
    private static final Dotenv dotenv = Dotenv.load();
    private static final String URL = dotenv.get("DB_URL");
    private static final String USUARIO = dotenv.get("DB_USER");
    private static final String CLAVE = dotenv.get("DB_PASSWORD");
    
   
 
    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}