/**
 *
 *
 * @author Amparo Izquierdo Bañez
 * @mail amizba@gmail.com
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TresEnRayaOy implements ActionListener {

    // Referencia a la ventana principal del juego
    private TresEnRaya t;
    // Referencia a la etiqueta que muestra de quién es el turno
    private JLabel display;
	
    // Constructor que recibe la ventana principal y la etiqueta para actualizar el estado del juego
    public TresEnRayaOy(TresEnRaya t, JLabel display){
        this.t = t;
        this.display = display;	
    }
	
    // Método que se ejecuta cada vez que se hace click en un botón del tablero
    public void actionPerformed(ActionEvent e){
        // Obtener el botón que fue clicado
        JButton clickedButton = (JButton) e.getSource(); 
        // Desactivar el botón para que no pueda volver a pulsarse
        clickedButton.setEnabled(false);
        clickedButton.getParent();  // No se usa aquí, podría eliminarse

        // Comprobar de quién es el turno actual
        if (t.getPlayer() == false){
            // Turno del jugador 1: poner "X" en el botón pulsado
            clickedButton.setText("X");
            // Cambiar turno a jugador 2
            t.setPlayer(true);
            // Actualizar texto de la etiqueta para mostrar el siguiente jugador
            display.setText("Jugador2 - O");
            // Comprobar si jugador 1 ha ganado tras esta jugada
            if (t.isWinner("X")){
                // Mostrar mensaje de victoria
                JOptionPane.showMessageDialog(t, "Gana partida Jugador1. ¡Felicidades!");
            }
        } else {
            // Turno del jugador 2: poner "O" en el botón pulsado
            clickedButton.setText("O");
            // Cambiar turno a jugador 1
            t.setPlayer(false);
            // Actualizar texto de la etiqueta para mostrar el siguiente jugador
            display.setText("Jugador1 - X");			
            // Comprobar si jugador 2 ha ganado tras esta jugada
            if (t.isWinner("O")){
                // Mostrar mensaje de victoria
                JOptionPane.showMessageDialog(t, "Gana partida Jugador2. ¡Felicidades!");
            }			
        }
    }
}
