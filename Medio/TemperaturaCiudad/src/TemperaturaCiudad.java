/**
 * Programa que simula la previsión del tiempo según la estación del año seleccionada.
 * Genera temperaturas mínimas y máximas aleatorias y determina si el cielo estará soleado o nublado.
 * 
 * @author Amparo Izquierdo Bañez
 * @mail amizba@gmail.com
 */
import java.util.Scanner;

public class TemperaturaCiudad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Mostrar menú para seleccionar estación del año
        System.out.println("1. Primavera");
        System.out.println("2. Verano");
        System.out.println("3. Otoño");
        System.out.println("4. Invierno");
        System.out.print("Seleccione la estación del año (1-4): ");

        // Leer opción seleccionada por el usuario
        int estacion = sc.nextInt();

        // Variables para almacenar temperaturas y estado del cielo
        int temperaturaMinima = 0;
        int temperaturaMaxima = 0;
        String cielo = "";

        // Según la estación, se generan temperaturas y probabilidad de cielo soleado/nublado
        switch(estacion) {
            case 1: // Primavera
                // Temperaturas entre 15 y 30 grados (16 posibles valores empezando en 15)
                temperaturaMinima = (int)(Math.random() * 16 + 15);
                temperaturaMaxima = (int)(Math.random() * 16 + 15);
                // 60% de probabilidad de estar soleado
                cielo = Math.random() <= 0.6 ? "Soleado" : "Nublado";
                break;
            case 2: // Verano
                // Temperaturas entre 25 y 45 grados
                temperaturaMinima = (int)(Math.random() * 21 + 25);
                temperaturaMaxima = (int)(Math.random() * 21 + 25);
                // 80% de probabilidad de estar soleado
                cielo = Math.random() <= 0.8 ? "Soleado" : "Nublado";
                break;
            case 3: // Otoño
                // Temperaturas entre 20 y 30 grados
                temperaturaMinima = (int)(Math.random() * 11 + 20);
                temperaturaMaxima = (int)(Math.random() * 11 + 20);
                // 40% de probabilidad de estar soleado
                cielo = Math.random() <= 0.4 ? "Soleado" : "Nublado";
                break;
            case 4: // Invierno
                // Temperaturas entre 0 y 25 grados
                temperaturaMinima = (int)(Math.random() * 26);
                temperaturaMaxima = (int)(Math.random() * 26);
                // 20% de probabilidad de estar soleado
                cielo = Math.random() <= 0.2 ? "Soleado" : "Nublado";
                break;
            default:
                // En caso de opción inválida, se muestra mensaje de error
                System.out.println("La estación seleccionada no es correcta.");
        }

        // Si la temperatura mínima es mayor que la máxima, se intercambian para corregir
        if (temperaturaMinima > temperaturaMaxima) {
            int aux = temperaturaMinima;
            temperaturaMinima = temperaturaMaxima;
            temperaturaMaxima = aux;
        }

        // Mostrar la previsión del tiempo generada
        System.out.println("Previsión del tiempo para mañana");
        System.out.println("--------------------------------");
        System.out.println("Temperatura mínima: " + temperaturaMinima);
        System.out.println("Temperatura máxima: " + temperaturaMaxima);
        System.out.println(cielo);
    }
}
