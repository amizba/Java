import java.util.Scanner;

/**
 *
 * Programa que resuelve una ecuación de segundo grado
 * (del tipo ax^2 + bx + c = 0).
 * Solicita al usuario los coeficientes a, b y c, y calcula
 * las soluciones reales o indica si no existen o son infinitas.
 * 
 * @author Amparo Izquierdo Bañez
 * @mail amizba@gmail.com
 */
public class Ecuacion2Grado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1, x2;  // Variables para almacenar las soluciones

        // Mensajes informativos para el usuario
        System.out.println("Este programa resuelve ecuaciones de segundo grado.");
        System.out.println("ax^2 + bx + c = 0");
        System.out.println("Por favor, introduzca los valores.");

        // Lectura de los coeficientes a, b y c
        System.out.print("a = ");
        double a = sc.nextDouble();
        System.out.print("b = ");
        double b = sc.nextDouble();
        System.out.print("c = ");
        double c = sc.nextDouble();

        // Caso 1: a=0, b=0, c=0 → infinitas soluciones
        if ((a == 0) && (b == 0) && (c == 0)) {
            System.out.println("La ecuación tiene infinitas soluciones.");
        }

        // Caso 2: a=0, b=0, c distinto de 0 → no tiene solución
        if ((a == 0) && (b == 0) && (c != 0)) {
            System.out.println("La ecuación no tiene solución.");
        }

        // Caso 3: c=0, a y b distintos de 0 → una raíz es 0, la otra -b/a
        if ((a != 0) && (b != 0) && (c == 0)) {
            System.out.println("x1 = 0");
            System.out.println("x2 = " + (-b / a));
        }

        // Caso 4: a=0, b y c distintos de 0 → ecuación lineal bx + c = 0
        if ((a == 0) && (b != 0) && (c != 0)) {
            System.out.println("x1 = x2 = " + (-c / b));
        }

        // Caso 5: a, b y c distintos de 0 → ecuación cuadrática estándar
        if ((a != 0) && (b != 0) && (c != 0)) {
            // Calculamos el discriminante para determinar la naturaleza de las raíces
            double discriminante = b * b - (4 * a * c);

            if (discriminante < 0) {
                // Discriminante negativo → no hay soluciones reales
                System.out.println("La ecuación no tiene soluciones reales");
            } else {
                // Discriminante >= 0 → calculamos y mostramos las dos soluciones reales
                System.out.println("x1 = " + (-b + Math.sqrt(discriminante)) / (2 * a));
                System.out.println("x2 = " + (-b - Math.sqrt(discriminante)) / (2 * a));
            }
        }
    }
}
