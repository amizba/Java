// Autor: Amparo Izquierdo Bañez
// Email: amizba@gmail.com
// Programa: Clase para gestionar la conexión a la base de datos MySQL para la aplicación CRUD.

package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Constantes con los datos de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/crud_db"; // URL de la base de datos (puerto 3306 y base de datos 'crud_db')
    private static final String USER = "root";       // Usuario de la base de datos
    private static final String PASS = "";           // Contraseña del usuario (reemplazar si se usa contraseña)

    // Método estático que devuelve una conexión activa a la base de datos
    public static Connection getConnection() {
        try {
            // Intenta establecer la conexión con los parámetros definidos
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            // Si hay error, lo muestra por consola y devuelve null
            System.out.println("Error en la conexión: " + e.getMessage());
            return null;
        }
    }
}

