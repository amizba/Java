// Autor: Amparo Izquierdo Bañez
// Email: amizba@gmail.com
// Agenda de contactos en Java con Swing

package agenda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AgendaContactos extends JFrame {
    private static final long serialVersionUID = 1L;

    // Componentes de la interfaz
    private JTextField campoNombre, campoTelefono, campoEmail;
    private JTextArea areaContactos;
    private ArrayList<Contacto> listaContactos;

    public AgendaContactos() {
        setTitle("Agenda de Contactos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null); // Centrar ventana
        setResizable(false);

        // Inicializamos lista de contactos
        listaContactos = new ArrayList<>();

        // Crear campos de entrada
        campoNombre = new JTextField(20);
        campoTelefono = new JTextField(20);
        campoEmail = new JTextField(20);

        // Crear área de texto donde se muestran los contactos
        areaContactos = new JTextArea();
        areaContactos.setEditable(false);
        areaContactos.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(areaContactos);

        // Crear botones y asignar acciones
        JButton btnAgregar = new JButton("Agregar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnLimpiar = new JButton("Limpiar");

        btnAgregar.addActionListener(e -> agregarContacto());
        btnEliminar.addActionListener(e -> eliminarContacto());
        btnLimpiar.addActionListener(e -> limpiarCampos());

        // Panel de entrada de datos
        JPanel panelEntrada = new JPanel(new GridLayout(4, 2, 10, 10));
        panelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelEntrada.add(new JLabel("Nombre:"));
        panelEntrada.add(campoNombre);
        panelEntrada.add(new JLabel("Teléfono:"));
        panelEntrada.add(campoTelefono);
        panelEntrada.add(new JLabel("Email:"));
        panelEntrada.add(campoEmail);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnLimpiar);

        // Añadir todo al contenedor principal
        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout(10, 10));
        contenedor.add(panelEntrada, BorderLayout.NORTH);
        contenedor.add(scroll, BorderLayout.CENTER);
        contenedor.add(panelBotones, BorderLayout.SOUTH);
    }

    // Clase interna para representar un contacto
    private static class Contacto {
        String nombre, telefono, email;

        public Contacto(String nombre, String telefono, String email) {
            this.nombre = nombre;
            this.telefono = telefono;
            this.email = email;
        }

        @Override
        public String toString() {
            return String.format("Nombre: %s | Tel: %s | Email: %s", nombre, telefono, email);
        }
    }

    // Método para agregar un contacto
    private void agregarContacto() {
        String nombre = campoNombre.getText().trim();
        String telefono = campoTelefono.getText().trim();
        String email = campoEmail.getText().trim();

        if (nombre.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre y teléfono son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Contacto nuevo = new Contacto(nombre, telefono, email);
        listaContactos.add(nuevo);
        actualizarLista();
        limpiarCampos();
    }

    // Método para eliminar un contacto por nombre
    private void eliminarContacto() {
        String nombre = campoNombre.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduce el nombre del contacto a eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean eliminado = listaContactos.removeIf(c -> c.nombre.equalsIgnoreCase(nombre));

        if (eliminado) {
            actualizarLista();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró ningún contacto con ese nombre.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para limpiar los campos de entrada
    private void limpiarCampos() {
        campoNombre.setText("");
        campoTelefono.setText("");
        campoEmail.setText("");
    }

    // Método para mostrar todos los contactos en el área de texto
    private void actualizarLista() {
        areaContactos.setText("");
        for (Contacto c : listaContactos) {
            areaContactos.append(c.toString() + "\n");
        }
    }

    // Método principal
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AgendaContactos().setVisible(true);
        });
    }
}
