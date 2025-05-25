import javax.swing.*;           // Importa las clases necesarias para crear interfaces gráficas y diálogos
import java.awt.event.*;         // Importa las clases para manejo de eventos
import java.util.*;              // Importa utilidades como Date
import javax.swing.Timer;        // Importa la clase Timer para temporizadores

/**
 * Programa que muestra la hora actual por consola cada 5 segundos
 * usando un temporizador (Timer) de Swing.
 * Al pulsar "Aceptar" en el cuadro de diálogo, se detiene el programa.
 * 
 * Autor: Amparo Izquierdo Bañez
 * Email: amizba@gmail.com
 */
public class Temporizador {

    public static void main(String[] args) {
        
        // Creamos un objeto de la clase que responderá al evento del temporizador
        DameLaHora oyente = new DameLaHora();
        
        // Creamos un Timer que se activa cada 5000 ms (5 segundos)
        // y ejecuta el método actionPerformed de "oyente"
        Timer mitemporizador = new Timer(5000, oyente); 
        
        // Iniciamos el temporizador para que empiece a contar
        mitemporizador.start();
        
        // Muestra un cuadro de diálogo que detiene el programa al pulsar "Aceptar"
        JOptionPane.showMessageDialog(null, "Pulsa Aceptar para detener");
        
        // Finaliza la ejecución del programa al cerrar el diálogo
        System.exit(0);
    }
}

// Clase que implementa ActionListener para manejar los eventos del Timer
class DameLaHora implements ActionListener {
    
    // Este método se ejecuta cada vez que el temporizador "dispara" un evento
    public void actionPerformed(ActionEvent e) {
        
        // Obtiene la hora y fecha actual
        Date ahora = new Date();
        
        // Imprime la hora actual en la consola cada 5 segundos
        System.out.println("Te pongo la hora cada 5 sg: " + ahora);
    }
}
