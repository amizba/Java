/**
 *
 * @author amizba@gmail.com
 * Amparo Izquierdo Bañez
 * 
 */

/*
 * Aplicación gráfica de una calculadora que realiza las operaciones básicas:
 * sumar, restar, multiplicar y dividir
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class Calculadora {
    public static void main(String[] args) {
        // Crear ventana principal de la calculadora
        MarcoCalculadora mimarco = new MarcoCalculadora();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);
    }
}

class MarcoCalculadora extends JFrame { // Clase que define el marco (ventana)
    public MarcoCalculadora() { // Constructor del marco
        setTitle("Calculadora sencilla"); // Título de la ventana
        
        // Crear panel con botones y display de la calculadora
        LaminaCalculadora milamina = new LaminaCalculadora();
        add(milamina); // Añadir panel al marco
        
        pack(); // Ajustar tamaño al contenido
        
        // Definir tamaño y posición centrada en la pantalla
        int width = 350;
        int height = 350;
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode().getWidth();
        int screenHeight = gd.getDisplayMode().getHeight();
        setBounds(screenWidth / 2 - width / 2, screenHeight / 2 - height / 2, width, height);
    }
}

class LaminaCalculadora extends JPanel { // Panel que contiene botones y lógica
    private JButton display;  // Botón que actúa como pantalla de la calculadora
    private JPanel panel;     // Panel para los botones numéricos y de operación
    private BigDecimal result; // Resultado acumulado en los cálculos
    private String lastCommand; // Última operación pulsada (+, -, *, /, =)
    private boolean start;    // Indica si se empieza a escribir número nuevo

    public LaminaCalculadora() { // Constructor: crea los componentes
        setLayout(new BorderLayout());
        
        result = BigDecimal.ZERO; // Inicializar resultado a 0
        lastCommand = "=";        // Operación inicial es igual (=)
        start = true;             // Empezamos sin número introducido
        
        // Crear display deshabilitado para mostrar resultado y números
        display = new JButton("0");
        display.setEnabled(false);
        display.setFont(display.getFont().deriveFont(50f)); // Tamaño grande fuente
        add(display, BorderLayout.NORTH); // Colocar display arriba
        
        // Listeners para botones numéricos y botones de operaciones
        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4)); // 4 filas x 4 columnas
        
        // Añadir botones numéricos y de operaciones al panel
        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", command);
        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", command);
        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", command);
        addButton("0", insert);
        addButton(".", insert);
        addButton("=", command);
        addButton("+", command);
        
        add(panel, BorderLayout.CENTER); // Añadir panel con botones al centro
    }
    
    // Método para crear un botón con texto y asignar su listener
    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.setFont(button.getFont().deriveFont(20f));
        button.addActionListener(listener);
        panel.add(button);
    }

    // Listener para botones numéricos y punto decimal
    private class InsertAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();
            if (start) {
                display.setText(""); // Limpiar display al empezar número nuevo
                start = false;
            }
            display.setText(display.getText() + input); // Añadir dígito o punto
        }
    }

    // Listener para botones de operaciones (+, -, *, /, =)
    private class CommandAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            if (start) { // Si empezamos y pulsamos "-"
                if (command.equals("-")) {
                    display.setText(command); // Permitir número negativo
                    start = false;
                } else
                    lastCommand = command; // Cambiar operación sin calcular
            } else {
                calcular(new BigDecimal(display.getText())); // Ejecutar cálculo
                lastCommand = command; // Guardar última operación pulsada
                start = true;          // Empezar nuevo número tras operación
            }
        }
    }

    /*
     * Realiza el cálculo según la última operación y actualiza el display
     */
    public void calcular(BigDecimal x) {
        if (lastCommand.equals("+")) result = result.add(x);
        else if (lastCommand.equals("-")) result = result.subtract(x);
        else if (lastCommand.equals("*")) result = result.multiply(x);
        else if (lastCommand.equals("/")) result = result.divide(x);
        else if (lastCommand.equals("=")) result = x;
        
        if (result.compareTo(BigDecimal.ZERO) == 0) {
            result = BigDecimal.ZERO; // Evitar valores muy pequeños cerca de cero
        }
        
        display.setText(result.toString()); // Mostrar resultado en display
    }
}
