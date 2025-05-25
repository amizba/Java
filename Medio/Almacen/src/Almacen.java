import java.util.Scanner; // Importa la clase Scanner para leer datos por teclado

/**
 * @author Amparo Izquierdo Bañez
 * @mail amizba@gmail.com
 */
public class Almacen {
    // Constante que define el tamaño máximo del almacén
    static int N = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner para la entrada de datos
        int opcion; // Almacena la opción del menú elegida
        int primeraLibre; // Guarda la posición libre en el array
        int i; // Variable de control para bucles
        int stockIntroducido;
        double precioDeCompraIntroducido;
        double precioDeVentaIntroducido;
        String codigo;
        String codigoIntroducido = "";
        String descripcionIntroducida;
        String precioDeCompraIntroducidoString;
        String precioDeVentaIntroducidoString;
        String stockIntroducidoString;
        boolean existeCodigo;

        // Crea un array de objetos Articulos
        Articulos[] articulo = new Articulos[N];

        // Inicializa cada posición del array con un nuevo objeto Articulos
        for(i = 0; i < N; i++) {
            articulo[i] = new Articulos();
        }

        // Bucle principal del menú
        do {
            // Muestra el menú principal
            System.out.println("\n\nG E S T I S I M A L");
            System.out.println("===================");
            System.out.println("1. Listado");
            System.out.println("2. Alta");
            System.out.println("3. Baja");
            System.out.println("4. Modificación");
            System.out.println("5. Entrada de mercancía");
            System.out.println("6. Salida de mercancía");
            System.out.println("7. Salir");
            System.out.print("Introduzca una opción: ");
            opcion = sc.nextInt(); // Lee la opción elegida por el usuario

            switch (opcion) {
                /////////////////////////////////////////////////////////////////////////////
                // LISTADO: muestra los artículos que no están marcados como "LIBRE"
                case 1:
                    System.out.println("\nLISTADO");
                    System.out.println("=======");
                    for(i = 0; i < N; i++) {
                        if (!articulo[i].getCodigo().equals("LIBRE")) {
                            System.out.println(articulo[i]);
                        }
                    }
                    break;

                /////////////////////////////////////////////////////////////////////////////
                // ALTA: inserta un nuevo artículo
                case 2:
                    System.out.println("\nNUEVO ARTÍCULO");
                    System.out.println("==============");

                    // Busca la primera posición libre en el array
                    primeraLibre = 0;
                    codigo = articulo[primeraLibre].getCodigo();
                    while ((primeraLibre < N) && (!codigo.equals("LIBRE"))) {
                        primeraLibre++;
                        if (primeraLibre < N) {
                            codigo = articulo[primeraLibre].getCodigo();
                        }
                    }

                    // Si no hay sitio, se avisa
                    if (primeraLibre == N) {
                        System.out.println("Lo siento, la base de datos está llena.");
                    } else {
                        // Introduce los datos del nuevo artículo
                        System.out.println("Por favor, introduzca los datos del artículo.");
                        System.out.print("Código: ");

                        // Verifica que el código no exista ya
                        existeCodigo = true;
                        while (existeCodigo) {
                            existeCodigo = false;
                            codigoIntroducido = sc.next();
                            for (i = 0; i < N; i++) {
                                if (codigoIntroducido.equals(articulo[i].getCodigo())) {
                                    existeCodigo = true;
                                }
                            }

                            if (existeCodigo) {
                                System.out.println("Ese código ya existe en la base de datos.");
                                System.out.print("Introduzca otro código: ");
                            }
                        }

                        // Guarda los datos introducidos
                        articulo[primeraLibre].setCodigo(codigoIntroducido);
                        System.out.print("Descripcion: ");
                        descripcionIntroducida = sc.next();
                        articulo[primeraLibre].setDescripcion(descripcionIntroducida);
                        System.out.print("Precio de compra: ");
                        precioDeCompraIntroducido = sc.nextDouble();
                        articulo[primeraLibre].setPrecioDeCompra(precioDeCompraIntroducido);
                        System.out.print("Precio de venta: ");
                        precioDeVentaIntroducido = sc.nextDouble();
                        articulo[primeraLibre].setPrecioDeVenta(precioDeVentaIntroducido);
                        System.out.print("Stock: ");
                        stockIntroducido = sc.nextInt();
                        articulo[primeraLibre].setStock(stockIntroducido);
                    }
                    break;

                /////////////////////////////////////////////////////////////////////////////
                // BAJA: elimina un artículo (lo marca como "LIBRE")
                case 3:
                    System.out.println("\nBAJA");
                    System.out.println("====");
                    System.out.print("Por favor, introduzca el código del artículo que desea dar de baja: ");
                    codigoIntroducido = sc.next();
                    i = -1;
                    codigo = "";
                    do {
                        i++;
                        if (i < N) {
                            codigo = articulo[i].getCodigo();
                        }
                    } while (!codigo.equals(codigoIntroducido) && (i < N));

                    if (i == N) {
                        System.out.println("Lo siento, el código introducido no existe.");
                    } else {
                        articulo[i].setCodigo("LIBRE"); // Marca como libre
                        System.out.println("Artículo borrado.");
                    }
                    break;

                /////////////////////////////////////////////////////////////////////////////
                // MODIFICACIÓN: cambia los datos de un artículo
                case 4:
                    System.out.println("\nMODIFICACIÓN");
                    System.out.println("============");
                    System.out.print("Por favor, introduzca el código del artículo cuyos datos desea cambiar: ");
                    codigoIntroducido = sc.next();
                    i = -1;
                    do {
                        i++;
                    } while (!articulo[i].getCodigo().equals(codigoIntroducido));

                    // Permite modificar cada dato individualmente
                    System.out.println("Introduzca los nuevos datos del artículo o INTRO para dejarlos igual.");
                    System.out.println("Código: " + articulo[i].getCodigo());
                    System.out.print("Nuevo código: ");
                    codigoIntroducido = sc.next();
                    if (!codigoIntroducido.equals("")) {
                        articulo[i].setCodigo(codigoIntroducido);
                    }

                    System.out.println("Descripción: " + articulo[i].getDescripcion());
                    System.out.print("Nueva descripción: ");
                    descripcionIntroducida = sc.next();
                    if (!descripcionIntroducida.equals("")) {
                        articulo[i].setDescripcion(descripcionIntroducida);
                    }

                    System.out.println("Precio de compra: " + articulo[i].getPrecioDeCompra());
                    System.out.print("Nuevo precio de compra: ");
                    precioDeCompraIntroducidoString = sc.next();
                    if (!precioDeCompraIntroducidoString.equals("")) {
                        articulo[i].setPrecioDeCompra(Double.parseDouble(precioDeCompraIntroducidoString));
                    }

                    System.out.println("Precio de venta: " + articulo[i].getPrecioDeVenta());
                    System.out.print("Nuevo precio de venta: ");
                    precioDeVentaIntroducidoString = sc.next();
                    if (!precioDeVentaIntroducidoString.equals("")) {
                        articulo[i].setPrecioDeVenta(Double.parseDouble(precioDeVentaIntroducidoString));
                    }

                    System.out.println("Stock: " + articulo[i].getStock());
                    System.out.print("Nuevo stock: ");
                    stockIntroducidoString = sc.next();
                    if (!stockIntroducidoString.equals("")) {
                        articulo[i].setStock(Integer.parseInt(stockIntroducidoString));
                    }
                    break;

                /////////////////////////////////////////////////////////////////////////////
                // ENTRADA DE MERCANCÍA: añade unidades al stock
                case 5:
                    System.out.println("\nENTRADA DE MERCANCÍA");
                    System.out.println("====================");
                    System.out.print("Por favor, introduzca el código del artículo: ");
                    codigoIntroducido = sc.next();
                    i = -1;
                    codigo = "";
                    do {
                        i++;
                        if (i < N) {
                            codigo = articulo[i].getCodigo();
                        }
                    } while (!codigo.equals(codigoIntroducido) && (i < N));

                    if (i == N) {
                        System.out.println("Lo siento, el código introducido no existe.");
                    } else {
                        System.out.println("Entrada de mercancía del siguiente artículo: ");
                        System.out.println(articulo[i]);
                        System.out.print("Introduzca el número de unidades que entran al almacén: ");
                        stockIntroducidoString = sc.next();
                        articulo[i].setStock(Integer.parseInt(stockIntroducidoString) + articulo[i].getStock());
                        System.out.println("La mercancía ha entrado en el almacén.");
                    }
                    break;

                /////////////////////////////////////////////////////////////////////////////
                // SALIDA DE MERCANCÍA: resta unidades del stock
                case 6:
                    System.out.println("\nSALIDA DE MERCANCÍA");
                    System.out.println("===================");
                    System.out.print("Por favor, introduzca el código del artículo: ");
                    codigoIntroducido = sc.next();
                    i = -1;
                    codigo = "";
                    do {
                        i++;
                        if (i < N) {
                            codigo = articulo[i].getCodigo();
                        }
                    } while (!codigo.equals(codigoIntroducido) && (i < N));

                    if (i == N) {
                        System.out.println("Lo siento, el código introducido no existe.");
                    } else {
                        System.out.println("Salida de mercancía del siguiente artículo: ");
                        System.out.println(articulo[i]);
                        System.out.print("Introduzca el número de unidades que desea sacar del almacén: ");
                        stockIntroducido = sc.nextInt();

                        if (articulo[i].getStock() - stockIntroducido > 0) {
                            articulo[i].setStock(articulo[i].getStock() - stockIntroducido);
                            System.out.println("La mercancía ha salido del almacén.");
                        } else {
                            System.out.println("Lo siento, no se pueden sacar tantas unidades.");
                        }
                    }
                    break;
            } // Fin del switch
        } while (opcion != 7); // Fin del menú
    } // Fin del main
} // Fin de la clase
