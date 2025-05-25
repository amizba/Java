/**
* Conversor de euros a pesetas.
*
* @author Amparo Izquierdo
* @url    https://empezandojava.blogspot.com/
*
*/

import java.util.Scanner;

public class Eur_Pts {

	public static void main(String[] args) {
		
		// Crear un objeto Scanner para leer datos desde teclado
		Scanner sc = new Scanner(System.in);
		
		// Pedir al usuario que introduzca la cantidad de euros a convertir
		System.out.print("Por favor, introduce la cantidad de euros que quieres convertir: ");
		
		// Leer la cantidad de euros introducida por el usuario (tipo double)
		double euros = sc.nextDouble();
		
		// Convertir euros a pesetas multiplicando por 166.386
		// El resultado se convierte a int porque las pesetas son enteros
		int pesetas = (int) (euros * 166.386);
		
		// Mostrar el resultado de la conversión por pantalla
		System.out.print(euros + " euros son " + pesetas + " pesetas.");
	}

}
