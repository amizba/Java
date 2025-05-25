/**
 *
 *
 * @author Amparo Izquierdo Bañez
 * @mail amizba@gmail.com
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TresEnRaya extends JFrame {

    // Variable para controlar el turno del jugador: false = jugador 1 (X), true = jugador 2 (O)
    private boolean player = false;
    // Array de botones que representa el tablero 3x3
    JButton[] buttons = new JButton[9];			
	
    // Constructor: crea la ventana y los componentes gráficos
    public TresEnRaya() {
        super("Tres en Raya"); // Título de la ventana
        getContentPane().setLayout(new BorderLayout()); // Usa BorderLayout para organizar componentes
		
        // Etiqueta que muestra de quién es el turno
        JLabel display = new JLabel("Jugador1 - X");
		
        // Panel con layout de cuadrícula 3x3 para colocar los botones
        JPanel buttonsPanel = new JPanel(new GridLayout(3, 3));
		
        // Crear e insertar los 9 botones del tablero
        for (int i = 0; i < 9; i++){
            buttons[i] = new JButton();           // Crear botón vacío
            buttonsPanel.add(buttons[i]);         // Añadir botón al panel
            // Añadir ActionListener para gestionar clicks, pasando referencia a esta ventana y la etiqueta de turno
            buttons[i].addActionListener(new TresEnRayaOy(this, display));
        }
		
        // Añadir la etiqueta con el turno en la parte superior de la ventana
        getContentPane().add(display, BorderLayout.NORTH);
        // Añadir el panel con los botones al centro de la ventana
        getContentPane().add(buttonsPanel, BorderLayout.CENTER);
		
        // Configurar que al cerrar la ventana, la aplicación termine
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Tamaño de la ventana
        setSize(320,240);
        // Mostrar la ventana
        setVisible(true);
    }
		
    // Getter para saber de quién es el turno actual
    public boolean getPlayer(){
        return player;
    }
	
    // Setter para cambiar el turno al siguiente jugador
    public void setPlayer(boolean player){
        this.player = player;
    }	

    // Método que comprueba si un jugador ha ganado el juego
    // Recibe el símbolo del jugador (por ejemplo "X" o "O")
    public boolean isWinner(String value){
        // Comprobar filas
        if (buttons[0].getText().equals(value) && buttons[1].getText().equals(value)
            && buttons[2].getText().equals(value)){
            return true;
        } 
        else if (buttons[3].getText().equals(value) && buttons[4].getText().equals(value)
            && buttons[5].getText().equals(value)){
           return true;
        } 
        else if (buttons[6].getText().equals(value) && buttons[7].getText().equals(value)
            && buttons[8].getText().equals(value)){
           return true;
        } 
        // Comprobar columnas
        else if (buttons[0].getText().equals(value) && buttons[3].getText().equals(value)
            && buttons[6].getText().equals(value)){
           return true;
        } 
        else if (buttons[1].getText().equals(value) && buttons[4].getText().equals(value)
            && buttons[7].getText().equals(value)){
           return true;
        } 
        else if (buttons[2].getText().equals(value) && buttons[5].getText().equals(value)
            && buttons[8].getText().equals(value)){
           return true;
        } 
        // Comprobar diagonales
        else if (buttons[0].getText().equals(value) && buttons[4].getText().equals(value)
            && buttons[8].getText().equals(value)){
           return true;
        } 
        else if (buttons[2].getText().equals(value) && buttons[4].getText().equals(value)
            && buttons[6].getText().equals(value)){
           return true;
        } 
        // Si ninguna línea tiene 3 iguales, no hay ganador aún
        else {
           return false;
        }	
    }
	
    // Método main para iniciar la aplicación
    public static void main(String[] args) {
        // Ejecutar la creación de la interfaz gráfica en el hilo de eventos de Swing
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Crear y mostrar la ventana del juego
                TresEnRaya gui = new TresEnRaya();
            }
        });
    }
}
