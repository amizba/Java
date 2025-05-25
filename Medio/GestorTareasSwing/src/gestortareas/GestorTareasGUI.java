/**
 * Autor: Amparo Izquierdo Bañez
 * Programa: Gestor de Tareas
 * Descripción: Esta clase implementa la interfaz gráfica de usuario utilizando Swing.
 * Permite añadir, eliminar y visualizar tareas, que se guardan en un archivo de texto.
 */

package gestortareas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class GestorTareasGUI extends JFrame {

    private DefaultListModel<Tarea> modeloLista; // Modelo para mostrar las tareas en una lista
    private JList<Tarea> listaTareas; // Componente de lista para mostrar tareas
    private JTextField campoTitulo; // Campo de texto para el título de la tarea
    private JTextArea campoDescripcion; // Área de texto para la descripción

    private List<Tarea> tareas; // Lista donde se almacenan las tareas

    // Constructor del GUI
    public GestorTareasGUI() {
        super("Gestor de Tareas"); // Título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al salir
        setSize(500, 400); // Tamaño de la ventana
        setLocationRelativeTo(null); // Centra la ventana en pantalla

        tareas = GestorArchivo.cargarTareas(); // Carga las tareas desde el archivo

        modeloLista = new DefaultListModel<>(); // Modelo para la lista
        listaTareas = new JList<>(modeloLista); // Lista que muestra las tareas
        JScrollPane scrollLista = new JScrollPane(listaTareas); // Scroll para la lista

        campoTitulo = new JTextField(20); // Campo para ingresar el título
        campoDescripcion = new JTextArea(3, 20); // Área para la descripción
        JScrollPane scrollDescripcion = new JScrollPane(campoDescripcion); // Scroll para la descripción

        JButton botonAgregar = new JButton("Agregar Tarea"); // Botón para añadir tareas
        JButton botonEliminar = new JButton("Eliminar Seleccionada"); // Botón para eliminar tareas

        // Panel para entrada de datos
        JPanel panelInput = new JPanel();
        panelInput.setLayout(new BorderLayout());

        JPanel panelCampos = new JPanel(new GridLayout(4, 1)); // Campos en una cuadrícula
        panelCampos.add(new JLabel("Título:"));
        panelCampos.add(campoTitulo);
        panelCampos.add(new JLabel("Descripción:"));
        panelCampos.add(scrollDescripcion);

        panelInput.add(panelCampos, BorderLayout.CENTER);
        panelInput.add(botonAgregar, BorderLayout.SOUTH);

        // Panel para el botón de eliminar
        JPanel panelBotones = new JPanel();
        panelBotones.add(botonEliminar);

        // Agrega los paneles a la ventana
        add(panelInput, BorderLayout.NORTH);
        add(scrollLista, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        cargarTareasEnLista(); // Muestra las tareas existentes

        // Evento: al hacer clic en "Agregar"
        botonAgregar.addActionListener(e -> agregarTarea());

        // Evento: al hacer clic en "Eliminar"
        botonEliminar.addActionListener(e -> eliminarTarea());

        setVisible(true); // Muestra la ventana
    }

    // Método para añadir una nueva tarea
    private void agregarTarea() {
        String titulo = campoTitulo.getText().trim();
        String descripcion = campoDescripcion.getText().trim();

        if (!titulo.isEmpty()) {
            Tarea nueva = new Tarea(titulo, descripcion);
            tareas.add(nueva); // Añade a la lista
            modeloLista.addElement(nueva); // Añade al modelo visual
            GestorArchivo.guardarTareas(tareas); // Guarda en archivo
            campoTitulo.setText("");
            campoDescripcion.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "El título no puede estar vacío."); // Validación
        }
    }

    // Método para eliminar la tarea seleccionada
    private void eliminarTarea() {
        int indice = listaTareas.getSelectedIndex();
        if (indice != -1) {
            tareas.remove(indice); // Elimina de la lista de datos
            modeloLista.remove(indice); // Elimina de la lista visual
            GestorArchivo.guardarTareas(tareas); // Actualiza el archivo
        }
    }

    // Carga todas las tareas en la lista gráfica
    private void cargarTareasEnLista() {
        for (Tarea t : tareas) {
            modeloLista.addElement(t);
        }
    }

    // Método principal que lanza la interfaz
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GestorTareasGUI::new); // Ejecuta el GUI en el hilo de eventos
    }
}
