/**
 * Autor: Amparo Izquierdo Bañez
 * Programa: Gestor de Tareas
 * Descripción: Esta clase gestiona el almacenamiento de las tareas en un archivo de texto.
 * Permite guardar una lista de tareas y recuperarlas al iniciar el programa.
 */

package gestortareas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivo {

    private static final String ARCHIVO = "tareas.txt"; // Nombre del archivo donde se guardarán las tareas

    // Método para guardar la lista de tareas en el archivo
    public static void guardarTareas(List<Tarea> tareas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO))) {
            // Recorre la lista de tareas y guarda cada una en una línea del archivo
            for (Tarea tarea : tareas) {
                writer.write(tarea.getTitulo() + ";" + tarea.getDescripcion()); // Separa los campos con ;
                writer.newLine(); // Salto de línea entre tareas
            }
        } catch (IOException e) {
            e.printStackTrace(); // Muestra el error si ocurre al escribir
        }
    }

    // Método para leer y cargar las tareas desde el archivo
    public static List<Tarea> cargarTareas() {
        List<Tarea> tareas = new ArrayList<>(); // Lista donde se almacenarán las tareas recuperadas
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            // Lee línea por línea el archivo
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";", 2); // Separa título y descripción
                if (partes.length == 2) {
                    tareas.add(new Tarea(partes[0], partes[1])); // Crea una tarea con los datos leídos
                }
            }
        } catch (IOException e) {
            // Si el archivo no existe, se devuelve una lista vacía sin mostrar error
        }
        return tareas; // Devuelve la lista de tareas cargadas
    }
}
