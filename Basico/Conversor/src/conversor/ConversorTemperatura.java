// Autor: Amparo Izquierdo Bañez
// Email: amizba@gmail.com
// Conversor de Temperaturas en Java con Swing

package conversor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConversorTemperatura extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField campoEntrada;
    private JComboBox<String> comboOrigen;
    private JComboBox<String> comboDestino;
    private JLabel resultado;

    public ConversorTemperatura() {
        setTitle("Conversor de Temperaturas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 300);
        setLocationRelativeTo(null); // Centrar la ventana

        // Campo donde se introduce el valor a convertir
        campoEntrada = new JTextField();
        campoEntrada.setFont(new Font("Arial", Font.BOLD, 24));
        campoEntrada.setHorizontalAlignment(SwingConstants.RIGHT);

        // Menús desplegables para seleccionar unidades de temperatura
        String[] unidades = {"Celsius", "Fahrenheit", "Kelvin"};
        comboOrigen = new JComboBox<>(unidades);
        comboDestino = new JComboBox<>(unidades);

        // Botón para convertir
        JButton btnConvertir = new JButton("Convertir");
        btnConvertir.setFont(new Font("Arial", Font.BOLD, 20));
        btnConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertirTemperatura();
            }
        });

        // Etiqueta donde se muestra el resultado
        resultado = new JLabel("Resultado: ");
        resultado.setFont(new Font("Arial", Font.BOLD, 20));
        resultado.setHorizontalAlignment(SwingConstants.CENTER);

        // Crear panel principal con BorderLayout
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(campoEntrada, BorderLayout.NORTH);

        // Panel para combos y botón
        JPanel panelCentro = new JPanel(new GridLayout(2, 2, 10, 10));
        panelCentro.add(new JLabel("De:"));
        panelCentro.add(comboOrigen);
        panelCentro.add(new JLabel("A:"));
        panelCentro.add(comboDestino);

        panel.add(panelCentro, BorderLayout.CENTER);
        panel.add(btnConvertir, BorderLayout.SOUTH);
        panel.add(resultado, BorderLayout.SOUTH);

        // Usamos BoxLayout para organizar todo en vertical
        JPanel contenedor = new JPanel();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
        contenedor.add(campoEntrada);
        contenedor.add(panelCentro);
        contenedor.add(btnConvertir);
        contenedor.add(resultado);

        add(contenedor);
    }

    // Método que realiza la conversión
    private void convertirTemperatura() {
        try {
            double valor = Double.parseDouble(campoEntrada.getText());
            String origen = (String) comboOrigen.getSelectedItem();
            String destino = (String) comboDestino.getSelectedItem();

            double valorConvertido = convertir(valor, origen, destino);
            resultado.setText(String.format("Resultado: %.2f %s", valorConvertido, destino));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Introduce un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Lógica de conversión entre Celsius, Fahrenheit y Kelvin
    private double convertir(double valor, String origen, String destino) {
        if (origen.equals(destino)) return valor;

        // Convertir a Celsius primero
        double tempCelsius = switch (origen) {
            case "Fahrenheit" -> (valor - 32) * 5 / 9;
            case "Kelvin" -> valor - 273.15;
            default -> valor; // Celsius
        };

        // Convertir de Celsius a destino
        return switch (destino) {
            case "Fahrenheit" -> (tempCelsius * 9 / 5) + 32;
            case "Kelvin" -> tempCelsius + 273.15;
            default -> tempCelsius; // Celsius
        };
    }

    // Método principal
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConversorTemperatura app = new ConversorTemperatura();
            app.setVisible(true);
        });
    }
}

