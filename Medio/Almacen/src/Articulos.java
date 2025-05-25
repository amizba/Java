/**
 *
 * Clase que representa un artículo en el almacén
 * 
 * @author Amparo Izquierdo Bañez
 * @mail amizba@gmail.com
 */
public class Articulos {

    // Atributos (variables de instancia)

    // Código del artículo. Se inicializa con el valor "LIBRE" para indicar que está disponible
    private String codigo = "LIBRE";

    // Descripción del artículo
    private String descripcion;

    // Precio de compra del artículo
    private double precioDeCompra;

    // Precio de venta del artículo
    private double precioDeVenta;

    // Cantidad en stock del artículo
    private int stock;

    // Métodos getter y setter (accesores y modificadores)

    // Devuelve el código del artículo
    public String getCodigo() {
        return codigo;
    }

    // Establece el código del artículo
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Devuelve la descripción del artículo
    public String getDescripcion() {
        return descripcion;
    }

    // Establece la descripción del artículo
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Devuelve el precio de compra
    public double getPrecioDeCompra() {
        return precioDeCompra;
    }

    // Establece el precio de compra
    public void setPrecioDeCompra(double precioDeCompra) {
        this.precioDeCompra = precioDeCompra;
    }

    // Devuelve el precio de venta
    public double getPrecioDeVenta() {
        return precioDeVenta;
    }

    // Establece el precio de venta
    public void setPrecioDeVenta(double precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }

    // Devuelve el stock actual
    public int getStock() {
        return stock;
    }

    // Establece el stock
    public void setStock(int stock) {
        this.stock = stock;
    }

    // Método toString: devuelve una representación en texto del objeto Articulo
    public String toString() {
        String cadena = "------------------------------------------";
        cadena += "\nCódigo: " + this.codigo;
        cadena += "\nDescripción: " + this.descripcion;
        cadena += "\nPrecio de compra: " + this.precioDeCompra;
        cadena += "\nPrecio de venta: " + this.precioDeVenta;
        cadena += "\nStock: " + this.stock + " unidades";
        cadena += "\n------------------------------------------";
        return cadena;
    }
}
