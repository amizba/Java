/**
* Pintar una pirámide por pantalla, la altura y el carácter con el que se pinta se pide por teclado
*
* @author Amparo Izquierdo
* @mail   amizba@gmail.com
*
*/
import java.util.Scanner;

public class Piramide {

	public static void main(String[] args) {
		// Crear objeto Scanner para leer datos desde teclado
		Scanner sc = new Scanner(System.in);
		
		// Pedir al usuario la altura de la pirámide
		System.out.print("Por favor, introduzca la altura de la pirámide: ");
		int alturaIntroducida = sc.nextInt();
		
		// Pedir al usuario el carácter con el que se rellenará la pirámide
		System.out.print("Introduzca el carácter de relleno: ");
		String relleno = sc.next();
		
		// Variables para controlar la construcción de la pirámide
		int planta = 1;                // planta actual (línea que se va a pintar)
		int longitudDeLinea = 1;       // número de caracteres que se pintan en la línea
		int espacios = alturaIntroducida - 1; // espacios en blanco antes de empezar a pintar el carácter
		
		// Bucle para pintar cada planta (línea) de la pirámide
		while (planta <= alturaIntroducida) {
			
			// Imprimir los espacios en blanco a la izquierda para centrar la pirámide
			for (int i = 1; i <= espacios; i++) {
				System.out.print(" ");
			}
			
			// Imprimir el carácter de relleno tantas veces como longitudDeLinea
			for (int i = 1; i <= longitudDeLinea; i++) {
				System.out.print(relleno);
			}
			
			// Saltar a la siguiente línea para pintar la siguiente planta
			System.out.println();
			
			// Preparar para la siguiente planta
			planta++;          // incrementamos la planta
			espacios--;        // disminuimos espacios (porque la pirámide crece)
			longitudDeLinea += 2; // aumentamos la longitud de la línea en 2 (forma la pirámide)
		}
	}
}
