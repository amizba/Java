// Autor: Amparo Izquierdo Bañez
// Email: amizba@gmail.com
// Programa: Interfaz gráfica principal para el CRUD (Crear, Leer, Actualizar, Eliminar) con Java y MySQL

package crud;

import javax.swing.*;
import java.awt.event.*;

public class Formulario extends JFrame {

    // Campos de texto para capturar los datos del usuario
    JTextField txtNombre = new JTextField();
    JTextField txtEmail = new JTextField();
    JTextField txtID = new JTextField();

    // Tabla para mostrar los registros de la base de datos
    JTable tabla = new JTable();
    JScrollPane scroll = new JScrollPane(tabla); // Scroll para la tabla

    // Constructor del formulario
    public Formulario() {
        setTitle("CRUD Java + MySQL");     // Título de la ventana
        setSize(500, 400);                 // Tamaño de la ventana
        setLayout(null);                   // Disposición absoluta (sin gestor de diseño)

        // Etiquetas descriptivas
        JLabel lblID = new JLabel("ID:");
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblEmail = new JLabel("Email:");

        // Botones para las operaciones CRUD
        JButton btnInsertar = new JButton("Insertar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnCargar = new JButton("Cargar");

        // Posicionamiento de los componentes en el formulario
        lblID.setBounds(20, 20, 100, 25);
        txtID.setBounds(120, 20, 200, 25);
        lblNombre.setBounds(20, 60, 100, 25);
        txtNombre.setBounds(120, 60, 200, 25);
        lblEmail.setBounds(20, 100, 100, 25);
        txtEmail.setBounds(120, 100, 200, 25);

        btnInsertar.setBounds(350, 20, 100, 25);
        btnActualizar.setBounds(350, 60, 100, 25);
        btnEliminar.setBounds(350, 100, 100, 25);
        btnCargar.setBounds(200, 140, 100, 25);

        scroll.setBounds(20, 180, 440, 150); // Área visible de la tabla con scroll

        // Añadir componentes al formulario
        add(lblID); add(txtID);
        add(lblNombre); add(txtNombre);
        add(lblEmail); add(txtEmail);
        add(btnInsertar); add(btnActualizar); add(btnEliminar); add(btnCargar);
        add(scroll);

        // Acción al hacer clic en "Insertar"
        btnInsertar.addActionListener(e -> {
            CRUD.insertar(txtNombre.getText(), txtEmail.getText());
        });

        // Acción al hacer clic en "Actualizar"
        btnActualizar.addActionListener(e -> {
            int id = Integer.parseInt(txtID.getText());
            CRUD.actualizar(id, txtNombre.getText(), txtEmail.getText());
        });

        // Acción al hacer clic en "Eliminar"
        btnEliminar.addActionListener(e -> {
            int id = Integer.parseInt(txtID.getText());
            CRUD.eliminar(id);
        });

        // Acción al hacer clic en "Cargar"
        btnCargar.addActionListener(e -> {
            tabla.setModel(CRUD.listar()); // Llama al método listar y asigna el modelo a la tabla
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        setVisible(true); // Muestra la ventana
    }
}


