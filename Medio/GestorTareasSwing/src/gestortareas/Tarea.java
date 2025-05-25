/**
 * Autor: Amparo Izquierdo Bañez
 * Programa: Gestor de Tareas
 * Descripción: Esta clase representa una tarea con un título y una descripción.
 * Se utiliza como parte del sistema para crear, mostrar y almacenar tareas en un gestor con interfaz gráfica.
 */

package gestortareas;

import java.io.Serializable; // Permite que los objetos de esta clase se puedan guardar en archivos

public class Tarea implements Serializable { // Implementa Serializable para permitir la escritura/lectura del objeto en archivos

    // Atributos que definen una tarea: título y descripción
    private String titulo;
    private String descripcion;

    // Constructor que inicializa los atributos de la tarea
    public Tarea(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    // Método para obtener el título de la tarea
    public String getTitulo() {
        return titulo;
    }

    // Método para obtener la descripción de la tarea
    public String getDescripcion() {
        return descripcion;
    }

    // Método sobrescrito que define cómo se mostrará la tarea al convertirla en texto (por ejemplo, en una lista)
    @Override
    public String toString() {
        return titulo + ": " + descripcion; // Muestra el título seguido de la descripción
    }
}
