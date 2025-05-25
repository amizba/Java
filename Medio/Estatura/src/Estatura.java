/**
 * Programa que simula la recopilación de estaturas de 10 personas
 * para 4 países diferentes (España, Portugal, Francia, Italia).
 * 
 * El programa genera aleatoriamente las estaturas entre 140 y 210 cm,
 * calcula la media, el valor mínimo y máximo de estaturas para cada país,
 * y muestra toda la información por pantalla.
 *
 * @author Amparo Izquierdo Bañez
 * @mail amizba@gmail.com
 */
public class Estatura {
	public static void main(String[] args) {
		// Array con los nombres de los países que serán las filas de la matriz
		String[] pais = {"España", "Portugal", "Francia", "Italia"};
		
		// Matriz para almacenar 10 estaturas por cada país (4 filas x 10 columnas)
		int[][] estaturas = new int[4][10];
		
		// Generación aleatoria de las estaturas para cada país
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				// Cada estatura será un número entero entre 140 y 210 cm
				estaturas[i][j] = (int) (Math.random() * (210 - 140 + 1)) + 140;
			}
		}
		
		// Encabezado de la tabla con las columnas: Media, Mínimo y Máximo
		System.out.printf("%64s\n", "MED MIN MAX");
		
		// Procesa cada país para calcular y mostrar las estadísticas
		for (int i = 0; i < 4; i++) {
			// Variables para almacenar el máximo, mínimo y suma de estaturas
			int maximo = 140;  // inicializado al valor mínimo posible
			int minimo = 210;  // inicializado al valor máximo posible
			int suma = 0;      // acumulador para calcular la media
			
			// Imprime el nombre del país con formato alineado
			System.out.printf("%9s:", pais[i]);
			
			// Recorre las estaturas del país actual
			for (int estatura : estaturas[i]) {
				// Imprime cada estatura con formato para alineación
				System.out.printf("%4d", estatura);
				
				// Actualiza el valor máximo si la estatura actual es mayor
				maximo = estatura > maximo ? estatura : maximo;
				
				// Actualiza el valor mínimo si la estatura actual es menor
				minimo = estatura < minimo ? estatura : minimo;
				
				// Suma las estaturas para calcular la media posteriormente
				suma += estatura;
			}
			
			// Imprime la media, el mínimo y el máximo de estaturas para el país
			System.out.printf(" |%4d%4d%4d\n", suma / 10, minimo, maximo);
		}
	}
}
