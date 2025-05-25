// Autor: Amparo Izquierdo Bañez
// Email: amizba@gmail.com
// Programa: Clase CRUD en Java para gestionar registros en una base de datos MySQL con interfaz Swing.

package crud;

import java.sql.*;                           // Para trabajar con bases de datos
import javax.swing.*;                        // Para mostrar mensajes en cuadros de diálogo
import javax.swing.table.DefaultTableModel;  // Para construir el modelo de datos de la tabla

public class CRUD {

    // Inserta un nuevo registro en la tabla "persona"
    public static void insertar(String nombre, String email) {
        String sql = "INSERT INTO persona (nombre, email) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, email);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro insertado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar: " + e.getMessage());
        }
    }

    // Actualiza un registro existente en la tabla "persona" según su ID
    public static void actualizar(int id, String nombre, String email) {
        String sql = "UPDATE persona SET nombre = ?, email = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, email);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro actualizado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage());
        }
    }

    // Elimina un registro de la tabla "persona" según su ID
    public static void eliminar(int id) {
        String sql = "DELETE FROM persona WHERE id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro eliminado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e.getMessage());
        }
    }

    // Recupera todos los registros de la tabla "persona" y los devuelve en un modelo de tabla
    public static DefaultTableModel listar() {
        String[] columnas = {"ID", "Nombre", "Email"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);

        String sql = "SELECT * FROM persona";
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Object[] fila = {rs.getInt("id"), rs.getString("nombre"), rs.getString("email")};
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar: " + e.getMessage());
        }

        return modelo;
    }
}

