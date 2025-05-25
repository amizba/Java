// Autor: Amparo Izquierdo Bañez
// Email: amizba@gmail.com
// Programa: Aplicación gráfica Swing para gestionar una agenda de contactos con almacenamiento en archivo de texto.

package contactos;

import javax.swing.*;                         // Componentes gráficos
import javax.swing.table.DefaultTableModel;   // Modelo de tabla para JTable
import java.awt.*;                            // Layouts y componentes visuales
import java.awt.event.*;                      // Eventos de interfaz
import java.io.*;                             // Lectura y escritura de archivos
import java.util.ArrayList;

public class AgendaApp extends JFrame {
    private DefaultTableModel model;   // Modelo de la tabla que contiene los contactos
    private JTable table;              // Tabla para mostrar los contactos
    private JTextField nombreField, telefonoField, emailField; // Campos de entrada
    private final String archivo = "contactos.txt"; // Archivo donde se guardan los datos

    // Constructor: Configura la ventana y carga los contactos desde el archivo
    public AgendaApp() {
        setTitle("Agenda de Contactos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana

        initComponents(); // Inicializa los componentes gráficos
        cargarContactos(); // Carga los contactos del archivo
    }

    // Inicializa los paneles, campos, botones y tabla
    private void initComponents() {
        // Panel con formulario para añadir contactos
        JPanel panel = new JPanel(new GridLayout(4, 2)); // 4 filas, 2 columnas
        panel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        panel.add(nombreField);

        panel.add(new JLabel("Teléfono:"));
        telefonoField = new JTextField();
        panel.add(telefonoField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        // Botón Agregar
        JButton addButton = new JButton("Agregar");
        addButton.addActionListener(e -> agregarContacto());
        panel.add(addButton);

        // Botón Eliminar
        JButton deleteButton = new JButton("Eliminar");
        deleteButton.addActionListener(e -> eliminarContacto());
        panel.add(deleteButton);

        // Tabla de contactos
        model = new DefaultTableModel(new String[]{"Nombre", "Teléfono", "Email"}, 0);
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table); // Scroll para la tabla

        // Añade los paneles al layout principal
        add(panel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    // Agrega un nuevo contacto a la tabla y lo guarda en el archivo
    private void agregarContacto() {
        String nombre = nombreField.getText();
        String telefono = telefonoField.getText();
        String email = emailField.getText();

        if (nombre.isEmpty() || telefono.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
            return;
        }

        Contacto c = new Contacto(nombre, telefono, email);
        model.addRow(new String[]{c.getNombre(), c.getTelefono(), c.getEmail()});
        guardarContacto(c);
        limpiarCampos();
    }

    // Elimina el contacto seleccionado de la tabla y actualiza el archivo
    private void eliminarContacto() {
        int fila = table.getSelectedRow();
        if (fila != -1) {
            model.removeRow(fila);
            guardarTodosDesdeTabla(); // Reescribe el archivo completo
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un contacto para eliminar.");
        }
    }

    // Limpia los campos de texto del formulario
    private void limpiarCampos() {
        nombreField.setText("");
        telefonoField.setText("");
        emailField.setText("");
    }

    // Guarda un contacto en el archivo, añadiéndolo al final
    private void guardarContacto(Contacto c) {
        try (FileWriter fw = new FileWriter(archivo, true)) {
            fw.write(c.toString() + "\n"); // Usa el método toString del objeto Contacto
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Guarda todos los contactos desde la tabla en el archivo (sobrescribe todo)
    private void guardarTodosDesdeTabla() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (int i = 0; i < model.getRowCount(); i++) {
                String nombre = (String) model.getValueAt(i, 0);
                String telefono = (String) model.getValueAt(i, 1);
                String email = (String) model.getValueAt(i, 2);
                pw.println(nombre + ";" + telefono + ";" + email); // Formato separado por punto y coma
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Carga los contactos desde el archivo y los muestra en la tabla
    private void cargarContactos() {
        File f = new File(archivo);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Contacto c = Contacto.fromString(linea); // Convierte la línea en un objeto Contacto
                model.addRow(new String[]{c.getNombre(), c.getTelefono(), c.getEmail()});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método principal que lanza la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AgendaApp().setVisible(true));
    }
}
