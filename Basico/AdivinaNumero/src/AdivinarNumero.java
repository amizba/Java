/**
* Juego para adivinar un número entre 0 y 100.
* El jugador tiene cinco oportunidades para acertar.
*
* @author Amparo Izquierdo
* @mail amizba@gmail.com
* @url https://empezandojava.blogspot.com/
*
*/
import java.util.Scanner;

public class AdivinarNumero {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int oportunidades = 5;  // Número de intentos disponibles
        int numeroIntroducido;  // Número que introduce el usuario
        boolean acertado = false;  // Indicador si el número fue acertado
        int numeroMisterioso = (int)(Math.random() * 101);  // Número aleatorio entre 0 y 100
        
        System.out.println("Estoy pensando un número del 0 al 100, intenta adivinarlo. Tienes 5 oportunidades.");
        
        do {
            System.out.print("Introduce un número: ");
            numeroIntroducido = sc.nextInt();
            oportunidades--;  // Disminuye las oportunidades después de cada intento
            
            // Si el número introducido es mayor que el número misterioso
            if ( (numeroIntroducido > numeroMisterioso) && (oportunidades > 0) ){
                System.out.println("El número que estoy pensando es menor que " + numeroIntroducido);
                System.out.println("Te quedan " + oportunidades + " oportunidades.");
            }
            
            // Si el número introducido es menor que el número misterioso
            if ( (numeroIntroducido < numeroMisterioso) && (oportunidades > 0) ){
                System.out.println("El número que estoy pensando es mayor que " + numeroIntroducido);
                System.out.println("Te quedan " + oportunidades + " oportunidades.");
            }
            
            // Si el número introducido es igual al número misterioso
            if (numeroIntroducido == numeroMisterioso) {
                acertado = true;
                System.out.println("¡Enhorabuena! ¡has acertado!");
            }
            
        } while (!acertado && (oportunidades > 0));  // Repite mientras no se acierte y queden oportunidades
        
        // Si no acertó después de agotar las oportunidades
        if (!acertado) {
            System.out.println("Lo siento, no has acertado, el número que estaba pensando era el " + numeroMisterioso);
        }
    }
}
