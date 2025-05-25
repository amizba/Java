
/**
 * Programa de gestión de entradas para una sala de conciertos.
 * Permite mostrar entradas disponibles y vender entradas por zona.
 * 
 * @author Amparo Izquierdo Bañez
 * @mail amizba@gmail.com
 */
import java.util.Scanner; // Importamos la clase Scanner para leer datos del usuario

public class SalaConciertos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // Creamos el objeto Scanner para entrada de datos por consola

		// Creamos tres zonas con diferentes cantidades de entradas disponibles
		Zona Primera = new Zona(500);   // Zona principal
		Zona Segunda = new Zona(150);   // Zona de compra-venta
		Zona Tercera = new Zona(50);    // Zona VIP

		int opcion = 0;   // Opción del menú principal
		int opcion2 = 0;  // Opción del submenú para elegir zona
		int n = 0;        // Número de entradas a vender

		// Bucle principal del programa (menú)
		do {
			System.out.println("\n\nSALA CONCIERTOS");
			System.out.println("1. Mostrar número de entradas libres");
			System.out.println("2. Vender entradas");
			System.out.println("3. Salir");
			System.out.println("Elige una opción: ");
			opcion = sc.nextInt(); // Leemos la opción del usuario

			if (opcion == 1) {
				// Mostrar entradas disponibles en cada zona
				System.out.println("\n\nEn la zona principal hay " + Primera.getEntradasPorVender());
				System.out.println("En la zona de compra venta hay " + Segunda.getEntradasPorVender());
				System.out.println("En la zona vip hay " + Tercera.getEntradasPorVender());
			}

			if (opcion == 2) {
				// Menú para vender entradas
				System.out.println("\n\n1. Primera");
				System.out.println("2. Segunda");
				System.out.println("3. Tercera");
				System.out.print("Elige la zona para la que quieres comprar las entradas: ");
				opcion2 = sc.nextInt(); // Leemos la zona elegida
				System.out.print("¿Cuántas entradas quieres? ");
				n = sc.nextInt(); // Leemos cuántas entradas desea

				// Ejecutamos la venta según la zona elegida
				switch (opcion2) {
					case 1:
						Primera.vender(n);
						break;
					case 2:
						Segunda.vender(n);
						break;
					case 3:
						Tercera.vender(n);
						break;
					default:
						// No se hace nada si la opción no es válida
				}
			}
		} while (opcion < 3); // Repetimos el menú hasta que el usuario elija salir
	}
}
