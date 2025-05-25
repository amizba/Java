import java.util.Scanner;

/**
 * Programa para registrar y mostrar la temperatura media mensual de un año.
 * El usuario introduce la temperatura media de cada mes y el programa muestra
 * un gráfico de barras en consola representando dichas temperaturas con colores.
 * 
 * @author Amparo Izquierdo Bañez
 * @mail amizba@gmail.com
 */
public class Temperatura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Array con los nombres de los 12 meses
        String[] mes = {
            "enero", "febrero", "marzo", "abril", "mayo", "junio",
            "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"
        };
        
        // Array para guardar la temperatura media de cada mes
        int[] temperatura = new int[12];
        
        // Variables auxiliares para los bucles
        int i, j;
        
        // Códigos de color ANSI para dar color a la salida en consola
        String verde = "\033[32m";
        String naranja = "\033[33m";
        String azul = "\033[34m";
        String morado = "\033[35m";
        String blanco = "\033[37m";
        
        // Bucle para pedir al usuario que introduzca la temperatura media de cada mes
        for (i = 0; i < 12; i++) {
            System.out.print("Introduzca la temperatura media de " + mes[i] + ": ");
            temperatura[i] = sc.nextInt();
        }
        
        // Bucle para mostrar un gráfico de barras con las temperaturas
        for (i = 0; i < 12; i++) {
            // Imprime el nombre del mes en azul y una barra vertical verde
            System.out.printf(azul + "%12s " + verde + "│", mes[i]);
            
            // Imprime un número de espacios morados igual a la temperatura
            for (j = 0; j < temperatura[i]; j++) {
                System.out.print(morado + " ");
            }
            
            // Imprime la temperatura con grados en naranja y resetea color a blanco
            System.out.println(naranja + " " + temperatura[i] + "ºC" + blanco);
        }
    }
}
