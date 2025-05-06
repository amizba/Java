// Autor: Amparo Izquierdo Bañez
// Email: amizba@gmail.com
// Programa: Calculadora gráfica básica en Java con operaciones aritméticas y soporte para paréntesis

package calculadora;

import javax.swing.*;     // Importa librerías para componentes gráficos (Swing)
import java.awt.*;        // Importa clases para gestión de diseño gráfico
import java.awt.event.*;  // Importa eventos para manejar interacciones del usuario

// Clase principal que extiende JFrame para crear una ventana
public class Calculadora extends JFrame {
    private static final long serialVersionUID = 1L; // Identificador de versión para la clase serializable
    private JTextField display; // Campo de texto para mostrar la operación y el resultado

    // Constructor de la calculadora
    public Calculadora() {
        setTitle("Calculadora"); // Título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        setResizable(false); // No permite redimensionar la ventana

        // Configura el campo de texto
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 30)); // Fuente grande
        display.setEditable(false); // El usuario no puede escribir directamente
        display.setHorizontalAlignment(SwingConstants.RIGHT); // Alineado a la derecha

        // Panel principal con borde y espaciado
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(display, BorderLayout.NORTH); // Añade el campo de texto en la parte superior

        // Panel para los botones en una cuadrícula 5x4
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10)); // 5 filas, 4 columnas, con espacios

        // Array con los nombres de los botones
        String[] buttons = {
            "C", "⌫", "(", ")",   // Fila 1: Borrar, borrar último, paréntesis
            "7", "8", "9", "/",   // Fila 2: Números y división
            "4", "5", "6", "*",   // Fila 3: Números y multiplicación
            "1", "2", "3", "-",   // Fila 4: Números y resta
            "0", ".", "=", "+"    // Fila 5: Cero, punto decimal, igual y suma
        };

        // Crea los botones y les asigna acción
        for (String button : buttons) {
            JButton btn = new JButton(button);
            btn.setFont(new Font("Arial", Font.BOLD, 24)); // Fuente grande para visibilidad
            btn.addActionListener(new ButtonClickListener()); // Añade el listener
            buttonPanel.add(btn); // Añade el botón al panel
        }

        panel.add(buttonPanel, BorderLayout.CENTER); // Añade el panel de botones al centro
        add(panel); // Añade el panel completo al JFrame
        setSize(400, 500); // Tamaño fijo de la ventana
        setLocationRelativeTo(null); // Centra la ventana en pantalla
    }

    // Clase interna que maneja los eventos de los botones
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand(); // Obtiene el texto del botón pulsado

            switch (command) {
                case "=":
                    // Evalúa la expresión matemática y muestra el resultado
                    String expression = display.getText();
                    try {
                        double result = eval(expression); // Llama al evaluador
                        display.setText(Double.toString(result)); // Muestra resultado
                    } catch (Exception ex) {
                        display.setText("Error"); // Muestra error si hay excepción
                    }
                    break;
                case "C":
                    display.setText(""); // Limpia el campo de texto
                    break;
                case "⌫":
                    // Borra el último carácter del texto
                    String currentText = display.getText();
                    if (!currentText.isEmpty()) {
                        display.setText(currentText.substring(0, currentText.length() - 1));
                    }
                    break;
                default:
                    // Añade el texto del botón pulsado al campo de texto
                    display.setText(display.getText() + command);
                    break;
            }
        }

        // Método para evaluar una expresión matemática en forma de cadena
        private double eval(final String str) {
            return new Object() {
                int pos = -1, ch;

                void nextChar() {
                    ch = (++pos < str.length()) ? str.charAt(pos) : -1;
                }

                boolean eat(int charToEat) {
                    while (ch == ' ') nextChar(); // Ignora espacios
                    if (ch == charToEat) {
                        nextChar();
                        return true;
                    }
                    return false;
                }

                // Comienza a parsear la expresión
                double parse() {
                    nextChar();
                    double x = parseExpression(); // Empieza por una expresión
                    if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                    return x;
                }

                // Evaluación de expresiones con + y -
                double parseExpression() {
                    double x = parseTerm();
                    for (;;) {
                        if (eat('+')) x += parseTerm(); // Suma
                        else if (eat('-')) x -= parseTerm(); // Resta
                        else return x;
                    }
                }

                // Evaluación de términos con * y /
                double parseTerm() {
                    double x = parseFactor();
                    for (;;) {
                        if (eat('*')) x *= parseFactor(); // Multiplicación
                        else if (eat('/')) x /= parseFactor(); // División
                        else return x;
                    }
                }

                // Evaluación de factores (números, paréntesis y signos)
                double parseFactor() {
                    if (eat('+')) return parseFactor(); // + unario
                    if (eat('-')) return -parseFactor(); // - unario

                    double x;
                    int startPos = this.pos;
                    if (eat('(')) {
                        x = parseExpression(); // Expresión entre paréntesis
                        if (!eat(')')) throw new RuntimeException("Missing ')'");
                    } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                        // Lee número
                        while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                        x = Double.parseDouble(str.substring(startPos, this.pos));
                    } else {
                        throw new RuntimeException("Unexpected: " + (char) ch); // Caracter no esperado
                    }

                    return x;
                }
            }.parse(); // Llama al método parse
        }
    }

    // Método principal: lanza la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculadora calc = new Calculadora(); // Crea instancia de la calculadora
            calc.setVisible(true); // Muestra la ventana
        });
    }
}

