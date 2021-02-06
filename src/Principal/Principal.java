/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import estructuraDatos.Cliente;
import estructuraDatos.Producto;
import utilidades.IO_ES;
import utilidades.ValidarDatos;

/**
 * Clase donde creamos dos arrays, uno para clientes y otro para productos, de
 * manera que siempre sea el mismo para toda la clase. Así cuando modifiquemos
 * productos y cleintes siempre será en el mismo array. Por eso son static y
 * están declarados antes del main, en la propia clase.
 *
 * @author semipresencial 1º
 */
public class Principal {

    static final int MAXIMOCLIENTES = 50;
    static final int MAXIMOPRODUCTOS = 40;
    static Cliente arrayClientes[] = new Cliente[MAXIMOCLIENTES];
    static Producto arrayProductos[] = new Producto[MAXIMOPRODUCTOS];
    static int contadorClientes = 0;
    static int contadorProductos = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /* esto es para mis pruebas
        arrayClientes[0] = new Cliente("28923637X", "Pepe", "Calle alameda", "676079584", false);
        System.out.println(arrayClientes[0].toString());

        arrayProductos[0] = new Producto("1234567890123", "crema", "para los pies", 4.65, 5);
        System.out.println(arrayProductos[0]);
         */
        boolean bandera = false;
        int opcion;

        System.out.println("<--- ** Bienvenido a la Rebotica de Velázquez ** ---->");
        do {

            System.out.println("-----------------------------------------------------");
            System.out.println("<------- LA BOTICA ------->");
            System.out.println("1. Añadir cliente.");
            System.out.println("2. Dar de baja a un cliente.");
            System.out.println("3. Modificar cliente.");
            System.out.println("4. Listar clientes.");
            System.out.println(" ");
            System.out.println("5. Añadir producto.");
            System.out.println("6. Eliminar producto.");
            System.out.println("7. Modificar producto.");
            System.out.println("8. Añadir unidades.");
            System.out.println("9. Quitar unidades.");
            System.out.println("10. Listar productos.");
            System.out.println("0. Salir del programa.");
            System.out.println(" ");
            opcion = IO_ES.leerInteger("Escoge una opción", 0, 10);

            switch (opcion) {

                case 1:

                    aniadirCliente();

                    break;

                case 2:

                    darBajaCliente();
                    break;

                case 3:

                    menuModificarCliente();

                    break;

                case 4:

                    visualizarClientes();

                    break;

                case 5:

                    aniadirProducto();

                    break;

                case 6:

                    eliminarProducto();

                    break;

                case 7:

                    menuModificarProducto();

                    break;

                case 8:

                    ponerUnidades();

                    break;

                case 9:

                    restarUnidades();

                    break;

                case 10:

                    visualizarProductos();

                    break;

                case 0:

                    bandera = true;

                    break;

            }

        } while (!bandera);

    }

    //****************** Opción 1 Método aniadirCliente **************
    /**
     * Método para añadir clientes al arrayClientes. Si encuentra uns posición
     * vacía en el arrayClientes colocará ahí al nuevo objeto cliente y saldrá
     * del bucle. Preguntará cada parámetro del contructror Clientes
     *
     */
    public static void aniadirCliente() {

        boolean huecoLleno = false;
        boolean bandera = false;
        String id;
        String nombre;
        String direccion;
        String telefono;
        boolean baja = false;

        id = rellenarNif(); //Comprobamos que el NIF es válido

        if (!id.equalsIgnoreCase("Documento no válido")) {

            if (comprobarClienteExiste(id) == true) {  //Comprobamos si el cliente existe ya

                IO_ES.escribirLN("Cliente ya existente");

            } else {

                int contador = 0;

                for (int i = 0; i < MAXIMOCLIENTES && (huecoLleno == false); i++) {

                    if (arrayClientes[i] == null) { //Si comprobamos todo lo anterior, ahora buscamos el primer hueco en el array y ahí metemos al cliente

                        nombre = (IO_ES.leerCadena("Introduzca el nombre: "));
                        direccion = (IO_ES.leerCadena("Introduzca la dirección: "));
                        telefono = (IO_ES.leerCadena("Introduzca el teléfono: "));

                        arrayClientes[contadorClientes] = new Cliente(id, nombre, direccion, telefono, baja);

                        contadorClientes++; //Cada vez que creemos un cliente aumentamos el contador

                        huecoLleno = true; //con esto evitamos seguir el bucle que busca el hueco

                    } else {

                        huecoLleno = false;
                        contador++;
                    }

                }

                if (contador == MAXIMOCLIENTES) {
                    IO_ES.escribirLN("Base de datos llena, no caben más clientes");
                }

            }

        } else {

            IO_ES.escribirLN("Documento no váilido, vuelva a empezar");
        }

    }

    //********** Opción 2. Método darBajaCliente ************
    /**
     * Método para dar de baja a un cliente, pero no eliminarlo del array
     */
    public static void darBajaCliente() {

        String id;
        Cliente clienteAmodificar;
        IO_ES.escribirLN("Vamos a buscar por id al cliente a modificar: ");
        id = rellenarNif(); //Comprobamos que el NIF es válido
        clienteAmodificar = buscarClientes(id);
        IO_ES.escribirLN("El cliente a modificar es: \n" + clienteAmodificar);
        clienteAmodificar.setBaja(IO_ES.leerBooleano("¿Quieres dar de baja a este cliente? s / n"));
        IO_ES.escribirLN("Los datos nuevos del cliente son: \n" + clienteAmodificar);

    }

    //*********************************************************************************************************
    // Bloque del menú modificar clientes
    //***********************************************************************************************************
    //*************** Opción 3. Método menuModificarCliente ***********
    /**
     * Menú a mostrar cuando queramos modificar los parámetros de un cliente
     *
     */
    public static void menuModificarCliente() {

        int opcion;
        boolean bandera = false;

        do {
            System.out.println(" ");
            System.out.println("< --- *** Menú Modificar Cliente: *** --->");
            System.out.println("1. Modificar id del cliente.");
            System.out.println("2. Modificar nombre del cliente.");
            System.out.println("3. Modificar dirección del cliente.");
            System.out.println("4. Modificar teléfono del cliente.");
            System.out.println("0. Volver al menú principal");
            System.out.println(" ");
            opcion = IO_ES.leerInteger("Escoge una opción entre 0 y 4: ", 0, 4);

            switch (opcion) {

                case 1: {
                    modificarId();
                    break;
                }
                case 2: {
                    modificarNombre();
                    break;
                }
                case 3: {
                    modificarDireccion();
                    break;
                }
                case 4: {
                    modificarTelefono();
                    break;
                }

                case 0: {
                    bandera = true;
                    break;
                }
                default: {
                    System.out.println("No es una opción válida");
                    break;
                }
            }
        } while (!bandera);

    }

    //********** Método modificarId ************
    /**
     * Método para modificar el id de un cliente
     */
    public static void modificarId() {

        String id;
        Cliente clienteAmodificar;
        IO_ES.escribirLN("Vamos a buscar por id al cliente a modificar: ");
        id = rellenarNif(); //Comprobamos que el NIF es válido
        clienteAmodificar = buscarClientes(id);
        IO_ES.escribirLN("El cliente a modificar es: \n" + clienteAmodificar);
        IO_ES.escribirLN("Introduce el nuevo valor de id: ");
        clienteAmodificar.setId(rellenarNif());
        IO_ES.escribirLN("Los datos nuevos del cliente son: \n" + clienteAmodificar);

    }

    //********** Método modificarNombre ************
    /**
     * Método para modificar el nombre de un cliente
     */
    public static void modificarNombre() {

        String id;
        Cliente clienteAmodificar;
        IO_ES.escribirLN("Vamos a buscar por id al cliente a modificar: ");
        id = rellenarNif(); //Comprobamos que el NIF es válido
        clienteAmodificar = buscarClientes(id);
        IO_ES.escribirLN("El cliente a modificar es: \n" + clienteAmodificar);
        IO_ES.escribirLN("Introduce el nuevo valor de nombre: ");
        clienteAmodificar.setNombre(IO_ES.leerCadena("Introduce el nuevo nombre del cliente: "));
        IO_ES.escribirLN("Los datos nuevos del cliente son: \n" + clienteAmodificar);

    }

    //********** Método modificarDireccion ************
    /**
     * Método para modificar la direccion de un cliente
     */
    public static void modificarDireccion() {

        String id;
        Cliente clienteAmodificar;
        IO_ES.escribirLN("Vamos a buscar por id al cliente a modificar: ");
        id = rellenarNif(); //Comprobamos que el NIF es válido
        clienteAmodificar = buscarClientes(id);
        IO_ES.escribirLN("El cliente a modificar es: \n" + clienteAmodificar);
        IO_ES.escribirLN("Introduce el nuevo valor de dirección: ");
        clienteAmodificar.setDireccion(IO_ES.leerCadena("Introduce la nueva del cliente: "));
        IO_ES.escribirLN("Los datos nuevos del cliente son: \n" + clienteAmodificar);

    }

    //********** Método modificarTelefono ************
    /**
     * Método para modificar el nombre de un cliente
     */
    public static void modificarTelefono() {

        String id;
        Cliente clienteAmodificar;
        IO_ES.escribirLN("Vamos a buscar por id al cliente a modificar: ");
        id = rellenarNif(); //Comprobamos que el NIF es válido
        clienteAmodificar = buscarClientes(id);
        IO_ES.escribirLN("El cliente a modificar es: \n" + clienteAmodificar);
        IO_ES.escribirLN("Introduce el nuevo valor de teléfono: ");
        clienteAmodificar.setNombre(IO_ES.leerCadena("Introduce el nuevo teléfono del cliente: "));
        IO_ES.escribirLN("Los datos nuevos del cliente son: \n" + clienteAmodificar);

    }

    //******************************************************************************************************
    // Fin bloque Modificar Clientes
    //***********************************************************************************************************
    //******************* Opción 4. visualizarClientes ******
    /**
     * Método para poder ver los clientes totales que tenemos El resultado será
     * el array clientes con sus objetos. Si está vacío el hueco del aray no lo
     * imprimirá
     *
     *
     */
    public static void visualizarClientes() {

        for (int i = 0; i < MAXIMOCLIENTES; i++) {

            if (arrayClientes[i] != null) {

                System.out.println(arrayClientes[i]);
            }
        }
    }

//****************** opción 5. Método aniadirProducto **************
    /**
     * Método para añadir clientes al arrayProducto. Si encuentra uns posición
     * vacía en el arrayProductos colocará ahí al nuevo objeto cliente y saldrá
     * del bucle. Preguntará cada parámetro del contructror Producto
     *
     *
     */
    public static void aniadirProducto() {

        boolean huecoLleno = false;
        boolean bandera = false;
        String codigo;
        String nombre;
        String descripcion = " ";
        Double precio = 0.0;
        int unidades = 0;

        codigo = rellenarCodigo();

        if (comprobarProductoExiste(codigo) == true) {  //Comprobamos si el producto ya existe

            IO_ES.escribirLN("Producto ya existente");

        } else {

            int contador = 0;

            for (int i = 0; i < MAXIMOPRODUCTOS && !huecoLleno; i++) {

                if (arrayProductos[i] == null) { //Si comprobamos todo lo anterior, ahora buscamos el primer hueco en el array y ahí metemos al producto

                    nombre = (IO_ES.leerCadena("Introduzca el nombre: "));
                    descripcion = (IO_ES.leerCadena("Introduzca la descripción: "));
                    precio = (IO_ES.leerRealLargo("Introduzca el precio: "));
                    unidades = (IO_ES.leerInteger("Introduzca las unidades del producto: "));

                    arrayProductos[contadorProductos] = new Producto(codigo, nombre, descripcion, precio, unidades);

                    contadorProductos++; //Cada vez que creemos un producto aumentamos el contador

                    huecoLleno = true; //con esto evitamos seguir el bucle que busca el hueco

                } else {

                    huecoLleno = false;
                    contador++;
                }

            }
            if (contador == MAXIMOPRODUCTOS) {

                IO_ES.escribirLN("Base de datos llena, ya no caben más productos");
            }

        }

    }

    //********** Opción 6. Método eliminarProducto ************
    /**
     * Método para eliminar un producto, ponemos el valor del objeto a null
     */
    public static void eliminarProducto() {

        String codigo;
        Producto productoAmodificar;
        IO_ES.escribirLN("Vamos a buscar por su código al producto a modificar: ");
        codigo = rellenarCodigo(); //Comprobamos que el código es válido
        productoAmodificar = buscarProductos(codigo);
        IO_ES.escribirLN("El producto a eliminar es: \n" + productoAmodificar);

        if (IO_ES.leerBooleano("¿Está seguro que quiere eliminar el producto? s / n ")) {

            productoAmodificar = null;
        }

        IO_ES.escribirLN("Los datos nuevos del producto son: \n" + productoAmodificar);

    }

    //*********************************************************************************************************************
    // Inicio bloque menú modificar clientes
    //*********************************************************************************************************************
    //*************** Opción 7.  Método menuModificarProducto *********************************************
    /**
     * Menú a mostrar cuando queramos modificar los parámetros de un cliente
     *
     */
    public static void menuModificarProducto() {

        int opcion;
        boolean bandera = false;

        do {
            System.out.println(" ");
            System.out.println("< --- *** Menú Modificar Producto: *** --- >");
            System.out.println("1. Modificar el código de un producto.");
            System.out.println("2. Modificar nombre de un producto.");
            System.out.println("3. Modificar la descripción del producto.");
            System.out.println("4. Modificar el precio del producto.");
            System.out.println("0. Volver al menú principal");
            System.out.println(" ");
            opcion = IO_ES.leerInteger("Escoge una opción entre 0 y 4: ", 0, 4);

            switch (opcion) {

                case 1: {
                    modificarCodigo();
                    break;
                }
                case 2: {
                    modificarNombreProducto();
                    break;
                }
                case 3: {
                    modificarDescripcion();
                    break;
                }
                case 4: {
                    modificarPrecio();
                    break;
                }

                case 0: {
                    bandera = true;
                    break;
                }
                default: {
                    System.out.println("No es una opción válida");
                    break;
                }
            }
        } while (!bandera);

    }

    //********** Método modificarCodigo ************
    /**
     * Método para modificar el código de un producto
     */
    public static void modificarCodigo() {

        String codigo;
        Producto productoAmodificar;
        IO_ES.escribirLN("Vamos a buscar por su código al producto a modificar: ");
        codigo = rellenarCodigo(); //Comprobamos que el código es válido
        productoAmodificar = buscarProductos(codigo);
        IO_ES.escribirLN("El producto a modificar es: \n" + productoAmodificar);
        IO_ES.escribirLN("Introduce el nuevo valor de código: ");
        productoAmodificar.setCodigo(rellenarCodigo());
        IO_ES.escribirLN("Los datos nuevos del producto son: \n" + productoAmodificar);

    }

    //********** Método modificarNombreProducto ************
    /**
     * Método para modificar el nombre de un producto
     */
    public static void modificarNombreProducto() {

        String codigo;
        Producto productoAmodificar;
        IO_ES.escribirLN("Vamos a buscar por su código al producto a modificar: ");
        codigo = rellenarCodigo(); //Comprobamos que el código es válido
        productoAmodificar = buscarProductos(codigo);
        IO_ES.escribirLN("El producto a modificar es: \n" + productoAmodificar);
        IO_ES.escribirLN("Introduce el nuevo nombre de producto: ");
        productoAmodificar.setNombre(IO_ES.leerCadena());
        IO_ES.escribirLN("Los datos nuevos del producto son: \n" + productoAmodificar);

    }

    //********** Método modificarDescripcion ************
    /**
     * Método para modificar la descripción de un producto
     */
    public static void modificarDescripcion() {

        String codigo;
        Producto productoAmodificar;
        IO_ES.escribirLN("Vamos a buscar por su código al producto a modificar: ");
        codigo = rellenarCodigo(); //Comprobamos que el código es válido
        productoAmodificar = buscarProductos(codigo);
        IO_ES.escribirLN("El producto a modificar es: \n" + productoAmodificar);
        IO_ES.escribirLN("Introduce la nueva descripción del producto: ");
        productoAmodificar.setDescripcion(IO_ES.leerCadena());
        IO_ES.escribirLN("Los datos nuevos del producto son: \n" + productoAmodificar);

    }

    //********** Método modificarPrecio ************
    /**
     * Método para modificar el precio del producto
     */
    public static void modificarPrecio() {

        String codigo;
        double precio;
        Producto productoAmodificar;
        IO_ES.escribirLN("Vamos a buscar por su código al producto a modificar: ");
        codigo = rellenarCodigo(); //Comprobamos que el código es válido
        productoAmodificar = buscarProductos(codigo);
        IO_ES.escribirLN("El producto a modificar es: \n" + productoAmodificar);
        IO_ES.escribirLN("Introduce el nuevo precio del producto: ");
        productoAmodificar.setPrecio(IO_ES.leerRealLargo());
        IO_ES.escribirLN("Los datos nuevos del producto son: \n" + productoAmodificar);

    }

    //*********************************************************************************************************************
    // Fin bloque menú modificar clientes
    //*********************************************************************************************************************
    //****************** Opción 8  Método ponerUnidades **********
    /**
     * Método que buscará un producto y le añadirá unidades Mostrará un mensaje
     * de "operación realizada" para tranquilidad del usuario.
     *
     */
    public static void ponerUnidades() {

        String codigo;

        codigo = IO_ES.leerCadena("Introduzca el código del producto al que quiere añadir unidades: ", 13);

        if (buscarProductos(codigo) != null) {

            buscarProductos(codigo).aniadirUnidades(IO_ES.leerInteger("Introduzca las unidades a añadir: "));
            IO_ES.escribirLN("Operación realizada");

        }

    }

    //****************** Opción 9  Método restarUnidades **********
    /**
     * Método que buscará un producto y le restará unidades Mostrará un mensaje
     * de "operación realizada" para tranquilidad del usuario.
     *
     */
    public static void restarUnidades() {

        String codigo;

        codigo = IO_ES.leerCadena("Introduzca el código del producto al que quiere restar unidades: ", 13);

        if (buscarProductos(codigo) != null) {

            buscarProductos(codigo).quitarUnidades(IO_ES.leerInteger("Introduzca las unidades a restar: "));
            IO_ES.escribirLN("Operación realizada");

        }
    }

    //******************* Opción 10. visualizarProductos ******
    /**
     * Método para poder ver los productos totales que tenemos El resultado será
     * el array productos con sus objetos. Si está vacío el hueco del aray no lo
     * imprimirá
     *
     *
     */
    public static void visualizarProductos() {

        for (int i = 0; i < MAXIMOPRODUCTOS; i++) {

            if (arrayProductos[i] != null) {

                System.out.println(arrayProductos[i]);
            }
        }
    }

    //************ Método buscarClientes ************
    /**
     * Método para buscar un cliente, para ello usamos el NIF del cliente. Le
     * introducimoms por parámetro el NIF, y nos devolverá al objeto cliente
     * para luego poder hacer lo que necesitemos con él
     *
     * @param id nif o nie que validaremos con el método verificarNIF
     * @return un objeto de la clase cliente
     */
    public static Cliente buscarClientes(String id) {

        Cliente clienteEncontrado = null;
        boolean bandera = false;

        for (int i = 0; i < MAXIMOCLIENTES && !bandera; i++) {

            if (arrayClientes[i] != null) {

                if (id.equalsIgnoreCase(arrayClientes[i].getId())) {

                    clienteEncontrado = arrayClientes[i];
                    bandera = true;
                }

            } else {

                clienteEncontrado = null;
            }

        }

        return clienteEncontrado;

    }

    //************ Método comprobarClienteExiste ************
    /**
     * Método para comprobar si un cliente ya existe, para ello usamos el NIF
     * del cliente. Le introducimoms por parámetro el NIF, y nos devolverá true
     * si existe y false si no existe para luego poder hacer lo que necesitemos
     * con él
     *
     * @param id nif o nie que validaremos con el método verificarNIF
     * @return clienteYaExiste
     */
    public static boolean comprobarClienteExiste(String id) {

        boolean clienteYaExiste = false;
        boolean bandera = false;

        for (int i = 0; i < MAXIMOCLIENTES && !bandera; i++) {

            if (arrayClientes[i] != null) {

                if (id.equalsIgnoreCase(arrayClientes[i].getId())) {

                    clienteYaExiste = true;
                    bandera = true;
                }

            }

        }

        return clienteYaExiste;

    }

    //************ Método buscarProductos ************
    /**
     * Método para buscar un producto, para ello usamos el código del producto.
     * Le introducimoms por parámetro el codigo, y nos devolverá al objeto
     * producto para luego poder hacer lo que necesitemos con él
     *
     * @param codigo código que validaremos con el método comprobarCodigo
     * @return un objeto de la clase producto o null para indicar que el
     * producto no está
     */
    public static Producto buscarProductos(String codigo) {

        Producto productoEncontrado = null;
        boolean bandera = false;

        for (int i = 0; i < MAXIMOPRODUCTOS && !bandera; i++) {

            if (codigo.equalsIgnoreCase(arrayProductos[i].getCodigo())) {

                productoEncontrado = arrayProductos[i];
                bandera = true;

            }
        }

        return productoEncontrado;

    }

    //************ Método comprobarProductoExiste ************
    /**
     * Método para comprobar si un producto ya existe, para ello usamos el
     * código del producto. Le introducimoms por parámetro el código y nos
     * devolverá true si existe y false si no existe para luego poder hacer lo
     * que necesitemos con él
     *
     * @param codigo que validaremos con el método de Producto.comprobarCodigo
     * @return productoYaExiste
     */
    public static boolean comprobarProductoExiste(String codigo) {

        boolean productoYaExiste = false;
        boolean bandera = false;

        for (int i = 0; i < MAXIMOPRODUCTOS && !bandera; i++) {

            if (arrayProductos[i] != null) {

                if (codigo.equalsIgnoreCase(arrayProductos[i].getCodigo())) {

                    productoYaExiste = true;
                    bandera = true;
                }

            }

        }

        return productoYaExiste;

    }

//*************** Método rellenarNif ********
    /**
     * Método para rellenar el NIF o NIE y obtener ya el DNI de 9 caracteres y
     * validado
     *
     * @return id el NIF o NIE validado
     *
     */
    public static String rellenarNif() {

        String nifNie;
        String id = " ";

        nifNie = IO_ES.leerCadena("Introduzca un DNI o un NIE: ", 9);

        if (ValidarDatos.verificarNIF(nifNie)) {

            id = nifNie;
        } else {

            id = "Documento no válido";
        }
        return id;
    }

    //*************** Método rellenarCodigo *********************************
    /**
     * Método para rellenar el código y obtener ya el código de 13 caracteres
     *
     * @return codigo validado
     *
     */
    public static String rellenarCodigo() {

        String codigoIntroducido;
        String codigo = " ";

        codigoIntroducido = IO_ES.leerCadena("Introduzca el código del producto: ");

        if (Producto.comprobarCodigo(codigoIntroducido)) {

            codigo = codigoIntroducido;
        } else {

            IO_ES.escribirLN("Código no válido");

        }
        return codigo;
    }

}
