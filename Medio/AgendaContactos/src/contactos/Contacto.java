// Autor: Amparo Izquierdo Bañez
// Email: amizba@gmail.com
// Programa: Clase Contacto para representar personas en una agenda con nombre, teléfono y correo

package contactos; // Paquete donde se agrupa la clase

// Clase que representa un contacto con nombre, teléfono y correo electrónico
public class Contacto {
    // Atributos privados del contacto
    private String nombre;   // Nombre del contacto
    private String telefono; // Teléfono del contacto
    private String email;    // Correo electrónico del contacto

    // Constructor que inicializa un nuevo contacto con los datos proporcionados
    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    // Métodos getters para acceder a los datos del contacto

    public String getNombre() {
        return nombre; // Devuelve el nombre
    }

    public String getTelefono() {
        return telefono; // Devuelve el teléfono
    }

    public String getEmail() {
        return email; // Devuelve el email
    }

    // Método que devuelve los datos del contacto como una única cadena separada por punto y coma
    @Override
    public String toString() {
        return nombre + ";" + telefono + ";" + email;
    }

    // Método estático que crea un objeto Contacto a partir de una línea de texto con formato "nombre;telefono;email"
    public static Contacto fromString(String linea) {
        String[] partes = linea.split(";"); // Separa la línea en partes usando punto y coma como delimitador
        return new Contacto(partes[0], partes[1], partes[2]); // Crea y devuelve un nuevo contacto con esos datos
    }
}
