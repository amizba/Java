/**
* Cálculo de una ecuación de primer grado del tipo ax + b = 0
*
* @author Amparo Izquierdo
* @mail amizba@gmail.com
* @url https://empezandojava.blogspot.com/
*
*/
import java.util.Scanner;

public class Ecuacion1Grado {

    public static void main(String[] args) {
        
        // Mensaje inicial explicando qué hace el programa
        System.out.println("Este programa resuelve ecuaciones de primer grado del tipo ax + b = 0");
        
        // Creamos un objeto Scanner para leer datos desde teclado
        Scanner sc = new Scanner(System.in);

        // Pedimos al usuario que introduzca el valor de 'a'
        System.out.print("Por favor, introduzca el valor de a: ");
        Double a = sc.nextDouble();

        // Pedimos al usuario que introduzca el valor de 'b'
        System.out.print("Por favor, introduzca el valor de b: ");
        Double b = sc.nextDouble();

        // Comprobamos si 'a' es cero (no sería una ecuación de primer grado)
        if (a == 0) {
            // Si a = 0, la ecuación no tiene solución real (o no es válida)
            System.out.println("Esa ecuación no tiene solución real.");
        } else {
            // Si a no es cero, calculamos la solución de la ecuación: x = -b / a
            System.out.println("x = " + (-b / a));
        }
    }
}
