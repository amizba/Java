/**
 * Clase que representa una zona de una sala de conciertos.
 * Permite controlar el número de entradas disponibles y gestionar su venta.
 * 
 * @author Amparo Izquierdo Bañez
 * @mail amizba@gmail.com
 */
public class Zona {
    
    // Atributo que almacena cuántas entradas quedan por vender en esta zona
    private int entradasPorVender;

    /**
     * Constructor de la clase Zona.
     * Inicializa la cantidad de entradas disponibles.
     * 
     * @param n número de entradas iniciales disponibles
     */
    public Zona(int n){
        entradasPorVender = n;
    }

    /**
     * Método que devuelve cuántas entradas quedan por vender.
     * 
     * @return número de entradas disponibles
     */
    public int getEntradasPorVender() {
        return entradasPorVender;
    }

    /**
     * Método que gestiona la venta de un número de entradas.
     * Comprueba si hay suficientes entradas antes de realizar la venta.
     * 
     * @param n número de entradas a vender
     */
    public void vender(int n) {
        if (this.entradasPorVender == 0) {
            // No quedan entradas
            System.out.println("Lo siento, las entradas para esa zona están agotadas.");
        } else if (this.entradasPorVender < n) {
            // No hay suficientes entradas para cubrir la petición
            System.out.println("Sólo me quedan " + this.entradasPorVender
                + " entradas para esa zona.");
        }

        if (this.entradasPorVender >= n) {
            // Hay suficientes entradas, se realiza la venta
            entradasPorVender -= n;
            System.out.println("Aquí tiene sus " + n + " entradas, gracias.");
        }
    }
}
