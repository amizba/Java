/**
* Conversor de pesetas a euros.
*
* @author Amparo Izquierdo
* @mail amizba@gmail.com
* @url https://empezandojava.blogspot.com/
*
*/

import java.util.Scanner;

public class Pts_Euro {

    public static void main(String[] args) {
        
        // Crear objeto Scanner para leer datos desde teclado
        Scanner sc = new Scanner(System.in);
        
        // Solicitar al usuario que introduzca la cantidad en pesetas
        System.out.print("Por favor, introduce la cantidad de pesetas que quieres convertir: ");
        
        // Leer la cantidad de pesetas introducida por el usuario
        int pesetas = sc.nextInt();
        
        // Convertir pesetas a euros, dividiendo por 166.386 (tipo de cambio fijo)
        // Se hace cast a double para evitar división entera
        double euros = (double) (pesetas / 166.386);
        
        // Mostrar el resultado de la conversión en pantalla
        System.out.print(pesetas + " pesetas son " + euros + " €.");
    }

}
