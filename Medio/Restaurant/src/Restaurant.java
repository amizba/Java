import java.util.Scanner;

/**
* Programa que simula la gestión de ocupación de mesas en un restaurante.
* Permite asignar grupos de clientes a mesas libres o compartir mesa si hay hueco.
* 
* @author Amparo Izquierdo Bañez
* @mail amizba@gmail.com
*/
public class Restaurant {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Creamos un array para representar 10 mesas con número de ocupantes
		int[] mesa = new int[10]; 

		// Rellenamos las mesas con ocupación aleatoria entre 0 y 6 clientes
		for (int i = 0; i < 10; i++) {
			mesa[i] = (int)(Math.random() * 7);
		}

		int clientes; // número de clientes que llegan al restaurante buscando mesa

		do {
			// Mostrar el estado actual de las mesas: número y ocupación
			System.out.println("\n┌─────────┬────┬────┬────┬────┬────┬────┬────┬────┬────┬────┐");
			System.out.print("│Mesa nº: ");
			for (int i = 1; i < 11; i++) {
				System.out.printf("│ %2d ", i);
			}

			System.out.println("│\n├─────────┼────┼────┼────┼────┼────┼────┼────┼────┼────┼────┤");
			System.out.print("│Ocupación");
			for (int m : mesa) {
				System.out.printf("│ %2d ", m);
			}
			System.out.println("│\n└─────────┴────┴────┴────┴────┴────┴────┴────┴────┴────┴────┘");

			// Preguntamos al usuario cuántos clientes llegan
			System.out.print("¿Cuántos son? (Introduzca -1 para salir del programa): ");
			clientes = sc.nextInt();

			// Validación: no admitimos grupos mayores de 6 personas
			if (clientes > 6) {
				System.out.print("Lo siento, no admitimos grupos de más de 6, haga grupos de");
				System.out.println(" 6 personas como máximo e intente de nuevo.");
			} else {

				// Buscamos una mesa completamente vacía (ocupación 0)
				int iVacia = 0;
				boolean hayMesaVacia = false;
				for (int i = 9; i >= 0; i--) {
					if (mesa[i] == 0) {
						iVacia = i;
						hayMesaVacia = true;
					}
				}

				if (hayMesaVacia) {
					// Asignamos el grupo a la mesa vacía encontrada
					mesa[iVacia] = clientes;
					System.out.println("Por favor, siéntense en la mesa número " + (iVacia + 1) + ".");
				} else {
					// Si no hay mesa vacía, buscamos si hay hueco para compartir mesa (máximo 4 por mesa)
					int iHueco = 0;
					boolean hayHueco = false;
					for (int i = 9; i >= 0; i--) {
						// Comprobamos si caben los clientes en la mesa (máximo 4)
						if (clientes <= (4 - mesa[i])) {
							iHueco = i;
							hayHueco = true;
						}
					}

					if (hayHueco) {
						// Añadimos los clientes a la mesa que tiene hueco
						mesa[iHueco] += clientes;
						System.out.println("Tendrán que compartir mesa. Por favor, siéntense en la mesa número " + (iHueco + 1) + ".");
					} else {
						// Si no hay hueco, informamos que no hay sitio disponible
						System.out.println("Lo siento, en estos momentos no queda sitio.");
					}
				}
			}
		} while (clientes != -1); // El programa termina cuando el usuario introduce -1
	}
}
