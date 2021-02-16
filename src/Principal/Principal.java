/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import estructuraDatos.Cliente;
import estructuraDatos.Enumerados;
import estructuraDatos.Enumerados.Categoria;
import estructuraDatos.Enumerados.TipoMedicamento;
import estructuraDatos.Medicamento;
import estructuraDatos.ParaFarmacia;
import estructuraDatos.Producto;
import utilidades.IO_ES;
import utilidades.ValidarDatos;

/**
 * Clase donde creamos dos arrays, uno para clientes y otro para productos, de
 * manera que siempre sea el mismo para toda la clase. Así cuando modifiquemos
 * productos y cleintes siempre será en el mismo array. Por eso son static y
 * están declarados antes del main, en la propia clase.
 *
 * @version 1.0
 * @author José María Pérez Sarabia
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

        IO_ES.escribirLnCyan("<--- ** Bienvenido a la Rebotica de Velázquez ** ---->");

        do {

            IO_ES.escribirLnPurple("-----------------------------------------------------");
            IO_ES.escribirLnPurple("<------- LA BOTICA DE VELÁZQUEZ ------->");
            IO_ES.escribirLN(" ");

            IO_ES.escribirLN("1. Menú clientes.");
            IO_ES.escribirLN("2. Menú medicamentos.");
            IO_ES.escribirLN("3. Menú parafarmacia.");
            IO_ES.escribirLN("4. Ver un solo cliente.");
            IO_ES.escribirLN("5. Ver un solo producto.");
            IO_ES.escribirLN("6. Listar todos los clientes.");
            IO_ES.escribirLN("7. Listar todos los productos.");
            IO_ES.escribirLN("0. Salir del programa.");
            IO_ES.escribirLN(" ");
            opcion = IO_ES.leerInteger("Escoge una opción: ", 0, 7);

            switch (opcion) {

                case 1:

                    menuCliente();

                    break;

                case 2:

                    menuMedicamento();

                    break;

                case 3:

                    menuParafarmacia();

                    break;

                case 4:

                    visualizarUnCliente();

                    break;

                case 5:

                    visualizarUnProducto();

                    break;

                case 6:

                    visualizarClientes();

                    break;

                case 7:

                    visualizarProductos();

                    break;

                case 0:

                    bandera = true;

                    break;

                default: {
                    System.out.println("No es una opción válida");
                    break;
                }

            }

        } while (!bandera);

    }

    //*********************************************************************************************************
    // Bloque del menú clientes
    //***********************************************************************************************************
    //*************** Opción 1. Método menuCliente ***********
    /**
     * Menú a mostrar cuando queramos trabajar con clientes Será la opción 1,
     * cada apartado será la opción 1.N.
     */
    public static void menuCliente() {

        int opcion;
        boolean bandera = false;

        do {
            IO_ES.escribirLN(" ");
            IO_ES.escribirLnAzul("< --- *** Menú Cliente: *** --->");
            IO_ES.escribirLN(" ");
            IO_ES.escribirLnAzul("1. Añadir cliente.");
            IO_ES.escribirLnAzul("2. Dar de baja a un cliente.");
            IO_ES.escribirLnAzul("3. Modificar id del cliente.");
            IO_ES.escribirLnAzul("4. Modificar nombre del cliente.");
            IO_ES.escribirLnAzul("5. Modificar dirección del cliente.");
            IO_ES.escribirLnAzul("6. Modificar teléfono del cliente.");
            IO_ES.escribirLnAzul("0. Volver al menú principal");
            System.out.println(" ");
            opcion = IO_ES.leerInteger("Escoge una opción entre 0 y 6: ", 0, 6);

            switch (opcion) {

                case 1: {
                    aniadirCliente();
                    break;
                }
                case 2: {
                    darBajaCliente();
                    break;
                }
                case 3: {
                    modificarId();
                    break;
                }
                case 4: {
                    modificarNombre();
                    break;
                }

                case 5: {
                    modificarDireccion();
                    break;
                }

                case 6: {
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

    //****************** Opción 1.1. Método aniadirCliente **************
    /**
     * Método para añadir clientes al arrayClientes. Si encuentra uns posición
     * vacía en el arrayClientes colocará ahí al nuevo objeto cliente y saldrá
     * del bucle. Preguntará cada parámetro del contructror Clientes
     *
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
                        telefono = IO_ES.leerCadena("Introduce el nuevo teléfono del cliente: ");

                        if (!ValidarDatos.validarTelefono(telefono)) {

                            IO_ES.escribirLnRojo("Teléfono no válido.");
                            IO_ES.escribirLnAmarillo("Para no empezar de nuevo, introducir nuevo teléfono mediante la opción de menú modificar teléfono");
                        }

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

    //********** Opción 1.2. Método darBajaCliente ************
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

    //********** 1.3. Método modificarId ************
    /**
     * Método para modificar el id de un cliente
     */
    public static void modificarId() {

        String id;
        Cliente clienteAmodificar;
        IO_ES.escribirLN("Vamos a buscar por id al cliente a modificar: ");
        id = rellenarNif(); //Comprobamos que el NIF es válido
        clienteAmodificar = buscarClientes(id);

        if (clienteAmodificar != null) {

            IO_ES.escribirLN("El cliente a modificar es: \n" + clienteAmodificar);
            IO_ES.escribirLN("Introduce el nuevo valor de id: ");
            clienteAmodificar.setId(rellenarNif());
            IO_ES.escribirLN("Los datos nuevos del cliente son: \n" + clienteAmodificar);

        } else {

            IO_ES.escribirLnRojo("No hay clientes creados.");
        }

    }

    //********** 1.4. Método modificarNombre ************
    /**
     * Método para modificar el nombre de un cliente
     */
    public static void modificarNombre() {

        String id;
        Cliente clienteAmodificar;
        IO_ES.escribirLN("Vamos a buscar por id al cliente a modificar: ");
        id = rellenarNif(); //Comprobamos que el NIF es válido
        clienteAmodificar = buscarClientes(id);

        if (clienteAmodificar != null) {

            IO_ES.escribirLN("El cliente a modificar es: \n" + clienteAmodificar);
            clienteAmodificar.setNombre(IO_ES.leerCadena("Introduce el nuevo nombre del cliente: "));
            IO_ES.escribirLN("Los datos nuevos del cliente son: \n" + clienteAmodificar);

        } else {

            IO_ES.escribirLnRojo("No hay clientes creados.");
        }
    }

    //********** 1.5. Método modificarDireccion ************
    /**
     * Método para modificar la direccion de un cliente
     */
    public static void modificarDireccion() {

        String id;
        Cliente clienteAmodificar;
        IO_ES.escribirLN("Vamos a buscar por id al cliente a modificar: ");
        id = rellenarNif(); //Comprobamos que el NIF es válido
        clienteAmodificar = buscarClientes(id);

        if (clienteAmodificar != null) {

            IO_ES.escribirLN("El cliente a modificar es: \n" + clienteAmodificar);
            clienteAmodificar.setDireccion(IO_ES.leerCadena("Introduce la nueva dirección del cliente: "));
            IO_ES.escribirLN("Los datos nuevos del cliente son: \n" + clienteAmodificar);

        } else {

            IO_ES.escribirLnRojo("No hay clientes creados.");
        }

    }
    //**********1.6.  Método modificarTelefono ************

    /**
     * Método para modificar el nombre de un cliente
     */
    public static void modificarTelefono() {

        String id;
        Cliente clienteAmodificar;
        String telefono;
        IO_ES.escribirLN("Vamos a buscar por id al cliente a modificar: ");
        id = rellenarNif(); //Comprobamos que el NIF es válido
        clienteAmodificar = buscarClientes(id);

        if (clienteAmodificar != null) {

            IO_ES.escribirLN("El cliente a modificar es: \n" + clienteAmodificar);
            telefono = IO_ES.leerCadena("Introduce el nuevo teléfono del cliente: ");

            if (ValidarDatos.validarTelefono(telefono)) {

                clienteAmodificar.setTelefono(telefono);
                IO_ES.escribirLN("Los datos nuevos del cliente son: \n" + clienteAmodificar);

            } else {

                IO_ES.escribirLnRojo("Teléfono no válido, cambio no realizado.");

            }
        } else {

            IO_ES.escribirLnRojo("No hay clientes creados.");
        }

    }

    //******************************************************************************************************
    // Fin bloque menu Clientes
    //***********************************************************************************************************
    //***********************************************************************
    //BLOQUE ENUMERADOS MEDICAMENTOS Y PARAFARMACIA
    //*********************************************************************
    //************* método menuEnumTipoMedicamento *******
    //Para dar la opción al usuario de escoger el tipo de medicamento
    public static Enumerados.TipoMedicamento menuEnumTipoMedicamento() {

        /**
         * Método para mostrar el menú con las opciones del enum
         * TipoMedicamentos
         */
        int opcion;
        Enumerados.TipoMedicamento medicamento = null;
        System.out.println(" ");
        System.out.println("<--- ** Opciones de tipo de medicamento disponibles ** ---->");
        System.out.println(" ");
        System.out.println("1. Analgésicos");
        System.out.println("2. Laxantes.");
        System.out.println("3. Antiinfecciosos.");
        System.out.println("4. Antidepresivos.");
        System.out.println("5. Antitusivos.");
        System.out.println("6. Mucolíticos.");
        System.out.println("7. Antiácidos");
        System.out.println("8. Antiulcerosos");
        System.out.println("9. Antialérgicos.");
        System.out.println("10. Antidiárreicos");
        System.out.println("0. Volver al menú Añadir Productos.");
        System.out.println(" ");
        opcion = IO_ES.leerInteger("Escoge una opción", 0, 10);

        switch (opcion) {

            case 1:

                medicamento = Enumerados.TipoMedicamento.ANALGESICOS;

                break;

            case 2:

                medicamento = Enumerados.TipoMedicamento.LAXANTES;
                break;

            case 3:

                medicamento = Enumerados.TipoMedicamento.ANTIINFECCIOSOS;

                break;

            case 4:

                medicamento = Enumerados.TipoMedicamento.ANTIDEPRESIVOS;

                break;

            case 5:

                medicamento = Enumerados.TipoMedicamento.ANTITUSIVOS;

                break;

            case 6:

                medicamento = Enumerados.TipoMedicamento.MUCOLITICOS;

                break;

            case 7:

                medicamento = Enumerados.TipoMedicamento.ANTIACIDOS;

                break;

            case 8:

                medicamento = Enumerados.TipoMedicamento.ANTIULCEROSOS;

                break;

            case 9:

                medicamento = Enumerados.TipoMedicamento.ANTIALERGICOS;

                break;

            case 10:

                medicamento = Enumerados.TipoMedicamento.ANTIDIARREICOS;

                break;

            case 0:

                break;

        }

        return medicamento;

    }

    //************* método menuEnumCategoriaParafarmacia *******
    //Para dar la opción al usuario de escoger el tipo de categoria de parafarmacia
    public static Enumerados.Categoria menuEnumCategoriaParafarmacia() {

        /**
         * Método para mostrar el menú con las opciones del enum Categoria, que
         * da la categoría del producto de parafarmacia
         */
        int opcion;
        Enumerados.Categoria categoria = null;

        System.out.println(" ");
        System.out.println("<--- ** Opciones de categorias de parafarmacia disponibles ** ---->");
        System.out.println(" ");
        System.out.println("1. Dental");
        System.out.println("2. Facial.");
        System.out.println("3. Geles.");
        System.out.println("4. Corporal.");
        System.out.println("5. Cabello.");
        System.out.println("6. Antimosquitos.");
        System.out.println("7. Íntima");
        System.out.println("8. Nasal");
        System.out.println("9. Ocular.");
        System.out.println("10. Botiquín");
        System.out.println("11. Oidos.");
        System.out.println("12. Toallitas");
        System.out.println("13. Limpieza");
        System.out.println("14. Hogar");
        System.out.println("15. Macarillas.");
        System.out.println("0. Volver al menú Añadir Productos.");
        System.out.println(" ");
        opcion = IO_ES.leerInteger("Escoge una opción", 0, 15);

        switch (opcion) {

            case 1:

                categoria = Enumerados.Categoria.DENTAL;

                break;

            case 2:

                categoria = Enumerados.Categoria.FACIAL;

                break;

            case 3:

                categoria = Enumerados.Categoria.GELES;

                break;

            case 4:

                categoria = Enumerados.Categoria.CORPORAL;

                break;

            case 5:

                categoria = Enumerados.Categoria.CABELLO;

                break;

            case 6:

                categoria = Enumerados.Categoria.ANTIMOSQUITOS;

                break;

            case 7:

                categoria = Enumerados.Categoria.INTIMA;

                break;

            case 8:

                categoria = Enumerados.Categoria.NASAL;

                break;

            case 9:

                categoria = Enumerados.Categoria.OCULAR;

                break;

            case 10:

                categoria = Enumerados.Categoria.BOTIQUIN;

                break;

            case 11:

                categoria = Enumerados.Categoria.OIDOS;

                break;

            case 12:

                categoria = Enumerados.Categoria.TOALLITAS;

                break;

            case 13:

                categoria = Enumerados.Categoria.LIMPIEZA;

                break;

            case 14:

                categoria = Enumerados.Categoria.HOGAR;

                break;

            case 15:

                categoria = Enumerados.Categoria.MASCARILLAS;

                break;

            case 0:

                break;

        }

        return categoria;

    }

    //*********************************************************************************************
    //           Bloque Menú Medicamentos
    //***************************************************************************************************
    /**
     * ************* Opción 2. Método menuMedicamento
     * ********************************************* /** Menú a mostrar cuando
     * queramos trabajar con un medicamento
     *
     */
    public static void menuMedicamento() {

        int opcion;
        boolean bandera = false;

        do {
            IO_ES.escribirLnCyan(" ");
            IO_ES.escribirLnCyan("< --- *** Menú Medicamento: *** --- >");
            IO_ES.escribirLnCyan(" ");
            IO_ES.escribirLnCyan("1. Añadir Medicamento.");
            IO_ES.escribirLnCyan("2. Modificar código del medicamento");
            IO_ES.escribirLnCyan("3. Modificar nombre del medicamento.");
            IO_ES.escribirLnCyan("4. Modificar la descripción del medicamento.");
            IO_ES.escribirLnCyan("5. Modificar el precio del medicamento.");
            IO_ES.escribirLnCyan("6. Añadir unidades del medicamento.");
            IO_ES.escribirLnCyan("7. Restar unidades del medicamento.");
            IO_ES.escribirLnCyan("8. Modificar el tipo de medicamento.");
            IO_ES.escribirLnCyan("9. Modificar cómo tomar el medicamento.");
            IO_ES.escribirLnCyan("10. Modificar los efectos adeversos del medicamento.");
            IO_ES.escribirLnCyan("11. Eliminar un producto.");
            IO_ES.escribirLnCyan("0. Volver al menú principal");
            IO_ES.escribirLnCyan(" ");
            opcion = IO_ES.leerInteger("Escoge una opción entre 0 y 11: ", 0, 11);

            switch (opcion) {

                case 1: {
                    aniadirMedicamento();
                    break;
                }

                case 2: {
                    modificarCodigo();
                    break;
                }
                case 3: {
                    modificarNombreProducto();
                    break;
                }
                case 4: {
                    modificarDescripcion();
                    break;
                }
                case 5: {
                    modificarPrecio();
                    break;
                }

                case 6: {
                    ponerUnidades();
                    break;
                }

                case 7: {
                    restarUnidades();
                    break;
                }

                case 8: {

                    modificarTipoMedicamento();

                    break;
                }

                case 9: {

                    modificarComoTomarMediacamento();

                    break;
                }

                case 10: {

                    modificarEfectosAdversos();

                    break;
                }

                case 11: {

                    eliminarProducto();

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

    //****************** opción 2.1. de menuAñadirProducto: Método aniadirMedicamento **************
    /**
     * Método para añadir medicamentos al arrayProducto. Si encuentra uns
     * posición vacía en el arrayProductos colocará ahí al nuevo objeto
     * Medicamento y saldrá del bucle. Preguntará cada parámetro del contructror
     * Medicamento
     *
     *
     */
    public static void aniadirMedicamento() {

        boolean huecoLleno = false;
        boolean bandera = false;
        String codigo;
        String nombre;
        String descripcion = " ";
        Double precio = 0.0;
        int unidades = 0;
        Enumerados.TipoMedicamento medicamento;
        String comoTomar;
        String efectosAdversos;

        codigo = rellenarCodigo();

        if (Producto.comprobarCodigo(codigo) == true) {

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
                        medicamento = menuEnumTipoMedicamento();
                        comoTomar = (IO_ES.leerCadena("Indique cómo tomar el medicamento: "));
                        efectosAdversos = (IO_ES.leerCadena("Introduzca posibles efectos adversos del medicamento: "));

                        arrayProductos[contadorProductos] = new Medicamento(codigo, nombre, descripcion, precio, unidades, medicamento, comoTomar, efectosAdversos);

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

        } else {

            IO_ES.escribirLnRojo("No se puede crear un medicamento sin un código válido. Vuelva a empezar.");
        }

    }

    //********** Opción 2.2. y 3.2  Método modificarCodigo ************
    /**
     * Método para modificar el código de un producto
     */
    public static void modificarCodigo() {

        String codigo;
        Producto productoAmodificar;
        IO_ES.escribirLN("Vamos a buscar por su código al producto a modificar: ");
        codigo = rellenarCodigo(); //Comprobamos que el código es válido
        productoAmodificar = buscarProductos(codigo);

        if (productoAmodificar == null) {

            IO_ES.escribirLnRojo("Producto no existente.");

        } else {

            IO_ES.escribirLN("El producto a modificar es: \n" + productoAmodificar);
            productoAmodificar.setCodigo(rellenarCodigo());
            IO_ES.escribirLN("Los datos nuevos del producto son: \n" + productoAmodificar);

        }

    }

    //********** Opción 2.3.  y 3.3 Método modificarNombreProducto ************
    /**
     * Método para modificar el nombre de un producto
     */
    public static void modificarNombreProducto() {

        String codigo;
        Producto productoAmodificar;
        String nuevoNombre;
        IO_ES.escribirLN("Vamos a buscar por su código al producto a modificar: ");
        codigo = rellenarCodigo(); //Comprobamos que el código es válido
        productoAmodificar = buscarProductos(codigo);

        if (productoAmodificar == null) {

            IO_ES.escribirLnRojo("Producto no existente.");

        } else {

            IO_ES.escribirLN("El producto a modificar es: \n" + productoAmodificar);
            nuevoNombre = IO_ES.leerCadena("Introduzca el nuevo nombre del producto: ");
            productoAmodificar.setNombre(nuevoNombre);
            IO_ES.escribirLN("Los datos nuevos del producto son: \n" + productoAmodificar);

        }

    }

    //**********Opción 2.4.  y 3.4. Método modificarDescripcion ************
    /**
     * Método para modificar la descripción de un producto
     */
    public static void modificarDescripcion() {

        String codigo;
        Producto productoAmodificar;
        String nuevaDescripcion;
        IO_ES.escribirLN("Vamos a buscar por su código al producto a modificar: ");
        codigo = rellenarCodigo(); //Comprobamos que el código es válido
        productoAmodificar = buscarProductos(codigo);

        if (productoAmodificar == null) {

            IO_ES.escribirLnRojo("Producto no existente.");

        } else {

            IO_ES.escribirLN("El producto a modificar es: \n" + productoAmodificar);
            nuevaDescripcion = IO_ES.leerCadena("Introduzca la nueva descripción del producto: ");
            productoAmodificar.setDescripcion(nuevaDescripcion);
            IO_ES.escribirLN("Los datos nuevos del producto son: \n" + productoAmodificar);

        }

    }

    //********** Opción 2.5. y 3.5.  Método modificarPrecio ************
    /**
     * Método para modificar el precio del producto
     */
    public static void modificarPrecio() {

        String codigo;
        double precio;
        Producto productoAmodificar;
        double nuevoPrecio;
        IO_ES.escribirLN("Vamos a buscar por su código al producto a modificar: ");
        codigo = rellenarCodigo(); //Comprobamos que el código es válido
        productoAmodificar = buscarProductos(codigo);

        if (productoAmodificar == null) {

            IO_ES.escribirLnRojo("Producto no existente.");

        } else {

            IO_ES.escribirLN("El producto a modificar es: \n" + productoAmodificar);
            nuevoPrecio = IO_ES.leerReal("Introduce el nuevo precio del medicamento: ");
            productoAmodificar.setPrecio(nuevoPrecio);
            IO_ES.escribirLN("Los datos nuevos del producto son: \n" + productoAmodificar);

        }

    }

//****************** Opción 2.6. y 3.6.  Método ponerUnidades **********
    /**
     * Método que buscará un producto y le añadirá unidades Mostrará un mensaje
     * de "operación realizada" para tranquilidad del usuario.
     *
     */
    public static void ponerUnidades() {

        String codigo;

        codigo = IO_ES.leerCadena("Introduzca el código del producto al que quiere añadir unidades: ");

        Producto productoAmodificar = buscarProductos(codigo);

        if (productoAmodificar != null) {

            int unidadesAsumar = IO_ES.leerInteger("Introduzca las unidades a añadir: ");

            if (productoAmodificar.aniadirUnidades(unidadesAsumar)) {

                IO_ES.escribirLN("Operación realizada");

            } else {

                IO_ES.escribirLnRojo("No se ha podido realizar la operación, a introducido un 0 o un número negativo.");
            }

        } else {

            IO_ES.escribirLnRojo("Producto no existente.");
        }

    }

    //****************** Opción 2.7. y 3.7.  Método restarUnidades **********
    /**
     * Método que buscará un producto y le restará unidades Mostrará un mensaje
     * de "operación realizada" para tranquilidad del usuario.
     *
     */
    public static void restarUnidades() {

        String codigo;

        codigo = IO_ES.leerCadena("Introduzca el código del producto al que quiere restar unidades: ");

        Producto productoAmodificar = buscarProductos(codigo);

        if (productoAmodificar != null) {

            int unidadesArestar = IO_ES.leerInteger("Introduzca las unidades a restar: ");

            if (productoAmodificar.quitarUnidades(unidadesArestar)) {

                IO_ES.escribirLN("Operación realizada");

            } else {

                IO_ES.escribirLnRojo("No se ha podido realizar la operación, ha introducido un 0 o ha puesto a restar más unidades de las que existen en almacén.");

            }

        } else {

            IO_ES.escribirLnRojo("Producto no existente.");
        }
    }

    //****************** Opción 2.8.  Método modificarTipoMediamento **********
    /**
     * Método para modificar el tipo de medicameto
     */
    public static void modificarTipoMedicamento() {

        String codigo;
        TipoMedicamento tipoMeicamento;
        Medicamento productoAmodificar;
        TipoMedicamento nuevoTipoMedicamento;
        IO_ES.escribirLN("Vamos a buscar por su código al medicamento a modificar: ");
        codigo = rellenarCodigo(); //Comprobamos que el código es válido
        productoAmodificar = (Medicamento) buscarProductos(codigo);

        if (productoAmodificar == null) {

            IO_ES.escribirLnRojo("Producto no existente.");

        } else {

            IO_ES.escribirLN("El medicamento a modificar es: \n" + productoAmodificar);
            nuevoTipoMedicamento = menuEnumTipoMedicamento();
            productoAmodificar.setTipoMedicamento(nuevoTipoMedicamento);
            IO_ES.escribirLN("Los datos nuevos del producto son: \n" + productoAmodificar);

        }

    }

    //****************** Opción 2.9.  Método modificarComoTomar ***************
    /**
     * Método para modificar el cómo tomar el medicamento
     */
    public static void modificarComoTomarMediacamento() {

        String codigo;
        TipoMedicamento tipoMeicamento;
        Medicamento productoAmodificar;
        String nuevoComoTomarMedicamento;
        IO_ES.escribirLN("Vamos a buscar por su código al medicamento a modificar: ");
        codigo = rellenarCodigo(); //Comprobamos que el código es válido
        productoAmodificar = (Medicamento) buscarProductos(codigo);

        if (productoAmodificar == null) {

            IO_ES.escribirLnRojo("Producto no existente.");

        } else {

            IO_ES.escribirLN("El medicamento a modificar es: \n" + productoAmodificar);
            nuevoComoTomarMedicamento = IO_ES.leerCadena("Introduzca la nueva forma de tomar el medicamento: ");
            productoAmodificar.setComoTomar(nuevoComoTomarMedicamento);
            IO_ES.escribirLN("Los datos nuevos del producto son: \n" + productoAmodificar);

        }

    }

    //****************** Opción 2.10.  Método modificarEfectosAdversos **********
    /**
     * Método para modificar el cómo tomar el medicamento
     */
    public static void modificarEfectosAdversos() {

        String codigo;
        TipoMedicamento tipoMeicamento;
        Medicamento productoAmodificar;
        String nuevosEfectosAdversos;
        IO_ES.escribirLN("Vamos a buscar por su código al medicamento a modificar: ");
        codigo = rellenarCodigo(); //Comprobamos que el código es válido
        productoAmodificar = (Medicamento) buscarProductos(codigo);

        if (productoAmodificar == null) {

            IO_ES.escribirLnRojo("Producto no existente.");

        } else {

            IO_ES.escribirLN("El medicamento a modificar es: \n" + productoAmodificar);
            nuevosEfectosAdversos = IO_ES.leerCadena("Introduzca los nuevos efectos adversos del medicamento: ");
            productoAmodificar.setEfectosAdversos(nuevosEfectosAdversos);
            IO_ES.escribirLN("Los datos nuevos del producto son: \n" + productoAmodificar);

        }

    }

    //********** Opción 2.11 y 3.11. Método eliminarProducto ************
    /**
     * Método para eliminar un producto, ponemos el valor del objeto a null
     */
    public static void eliminarProducto() {

        String codigo;
        Producto productoAmodificar;
        IO_ES.escribirLN("Vamos a buscar por su código al producto a eliminar: ");
        codigo = rellenarCodigo(); //Comprobamos que el código es válido
        productoAmodificar = buscarProductos(codigo);
        IO_ES.escribirLN("El producto a eliminar es: \n" + productoAmodificar);

        if (IO_ES.leerBooleano("¿Está seguro que quiere eliminar el producto? s / n ")) {

            productoAmodificar = null;

            for (int i = 0; i < (MAXIMOPRODUCTOS - 1); i++) {

                if (arrayProductos[i] == null) {
                    arrayProductos[i] = arrayProductos[i + 1];
                    arrayProductos[i + 1] = null;
                }
            }
        }

        IO_ES.escribirLN("Los datos nuevos del producto son: \n" + productoAmodificar);

    }

    //*********************************************************************************************************************
    // Fin bloque menú Medicamentos
    //*********************************************************************************************************************
    //*********************************************************************************************
    //           Bloque Menú Parafarmacia
    //***************************************************************************************************
    /**
     * ************* Opción 2. Método menuMedicamento
     * ********************************************* /** Menú a mostrar cuando
     * queramos trabajar con un medicamento
     *
     */
    public static void menuParafarmacia() {

        int opcion;
        boolean bandera = false;

        do {
            IO_ES.escribirLnVerde(" ");
            IO_ES.escribirLnVerde("< --- *** Menú Parafarmacia: *** --- >");
            IO_ES.escribirLnVerde(" ");
            IO_ES.escribirLnVerde("1. Añadir producto de Parafarmacia.");
            IO_ES.escribirLnVerde("2. Modificar código del producto de Parafarmacia");
            IO_ES.escribirLnVerde("3. Modificar nombre del producto de Parafarmacia.");
            IO_ES.escribirLnVerde("4. Modificar la descripción del producto de Parafarmacia.");
            IO_ES.escribirLnVerde("5. Modificar el precio del producto de Parafarmacia.");
            IO_ES.escribirLnVerde("6. Añadir unidades del producto de Parafarmacia.");
            IO_ES.escribirLnVerde("7. Restar unidades del producto de Parafarmacia.");
            IO_ES.escribirLnVerde("8. Modificar la categoría del producto Parafarmacia.");
            IO_ES.escribirLnVerde("9. Modificar las dosis de cada unidad del producto de Parafarmacia.");
            IO_ES.escribirLnVerde("10. Modificar el descuento del producto de Parafarmacia.");
            IO_ES.escribirLnVerde("11. Eliminar un producto de Parafarmacia.");
            IO_ES.escribirLnVerde("0. Volver al menú principal");
            IO_ES.escribirLnVerde(" ");
            opcion = IO_ES.leerInteger("Escoge una opción entre 0 y 11: ", 0, 11);

            switch (opcion) {

                case 1: {
                    aniadirParaFarmacia();
                    break;
                }

                case 2: {
                    modificarCodigo();
                    break;
                }
                case 3: {
                    modificarNombreProducto();
                    break;
                }
                case 4: {
                    modificarDescripcion();
                    break;
                }
                case 5: {
                    modificarPrecio();
                    break;
                }

                case 6: {
                    ponerUnidades();
                    break;
                }

                case 7: {
                    restarUnidades();
                    break;
                }

                case 8: {

                    modificarCategoria();

                    break;
                }

                case 9: {

                    modificarDosisUnidades();

                    break;
                }

                case 10: {

                    modificarDescuento();

                    break;
                }

                case 11: {

                    eliminarProducto();

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

    //* **************** opción 3.1. de menuAñadirProducto: Método aniadirParaFarmacia **************
    /**
     *
     *
     * /** Método para añadir nuevo producto de parafarmacia al arrayProducto.
     * Si encuentra uns posición vacía en el arrayProductos colocará ahí al
     * nuevo objeto ParaFarmacia y saldrá del bucle. Preguntará cada parámetro
     * del contructror ParaFarmacia.
     *
     *
     */
    public static void aniadirParaFarmacia() {

        boolean huecoLleno = false;
        boolean bandera = false;
        String codigo;
        String nombre;
        String descripcion = " ";
        Double precio = 0.0;
        int unidades = 0;
        Enumerados.Categoria categoria;
        int dosisUnidades = 0;
        float descuento = 0;

        codigo = rellenarCodigo();

        if (Producto.comprobarCodigo(codigo)) {

            if (comprobarProductoExiste(codigo) == true) {  //Comprobamos si el producto ya existe

                IO_ES.escribirLN("Producto ya existente");

            } else {

                int contador = 0; //Contador para saber si la base datos está llena. Si no se encuentran huecos vacíos, al final ese contador será igual que el número máximo del array

                for (int i = 0; i < MAXIMOPRODUCTOS && !huecoLleno; i++) {

                    if (arrayProductos[i] == null) { //Si comprobamos todo lo anterior, ahora buscamos el primer hueco en el array y ahí metemos al producto

                        nombre = (IO_ES.leerCadena("Introduzca el nombre: "));
                        descripcion = (IO_ES.leerCadena("Introduzca la descripción: "));
                        precio = (IO_ES.leerRealLargo("Introduzca el precio: "));
                        unidades = (IO_ES.leerInteger("Introduzca las unidades del producto: "));
                        categoria = menuEnumCategoriaParafarmacia();
                        dosisUnidades = IO_ES.leerInteger("Introduzca el número de dosis que hay en cada envase: ");
                        descuento = IO_ES.leerReal("Indica que descuento tiene el producto: ");

                        arrayProductos[contadorProductos] = new ParaFarmacia(codigo, nombre, descripcion, precio, unidades, categoria, dosisUnidades, descuento);

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

        } else {

            IO_ES.escribirLnRojo("No se puede crear un medicamento sin un código válido. Vuelva a empezar.");
        }

    }

    //***************************************************************************************************
    // Los métodos para modificar código, modificar descripción, modificar id, modificar nombre producto, modificar precio, poner unidades, restar unidades
    // y eliminar productos, van a ser los mismos para medicamentos y parafarmacia
    //***************************************************************************************************
    //****************** Opción 2.8.  Método modificarTipoMediamento **********
    /**
     * Método para modificar el tipo de medicameto
     */
    public static void modificarCategoria() {

        String codigo;
        Categoria categoria;
        ParaFarmacia productoAmodificar;
        Categoria nuevaCategoria;
        IO_ES.escribirLN("Vamos a buscar por su código al producto de Parafarmacia a modificar: ");
        codigo = rellenarCodigo(); //Comprobamos que el código es válido
        productoAmodificar = (ParaFarmacia) buscarProductos(codigo);

        if (productoAmodificar == null) {

            IO_ES.escribirLnRojo("Producto no existente.");

        } else {

            IO_ES.escribirLN("El producto de Parafarmacia a modificar es: \n" + productoAmodificar);
            nuevaCategoria = menuEnumCategoriaParafarmacia();
            productoAmodificar.setCategoria(nuevaCategoria);
            IO_ES.escribirLN("Los datos nuevos del producto son: \n" + productoAmodificar);

        }

    }

    //****************** Opción 2.9.  Método modificarComoTomar ***************
    /**
     * Método para modificar el cómo tomar el medicamento
     */
    public static void modificarDosisUnidades() {

        String codigo;
        Categoria categoria;
        ParaFarmacia productoAmodificar;
        int nuevaDosisUnidades;
        IO_ES.escribirLN("Vamos a buscar por su código al medicamento a modificar: ");
        codigo = rellenarCodigo(); //Comprobamos que el código es válido
        productoAmodificar = (ParaFarmacia) buscarProductos(codigo);

        if (productoAmodificar == null) {

            IO_ES.escribirLnRojo("Producto no existente.");

        } else {

            IO_ES.escribirLN("El producto de Parafarmacia a modificar es: \n" + productoAmodificar);
            nuevaDosisUnidades = IO_ES.leerInteger("Introduzca las nuevas dosis de cada envase: ");
            productoAmodificar.setDosisUnidades(nuevaDosisUnidades);
            IO_ES.escribirLN("Los datos nuevos del producto son: \n" + productoAmodificar);

        }

    }

    //****************** Opción 2.10.  Método modificarEfectosAdversos **********
    /**
     * Método para modificar el cómo tomar el medicamento
     */
    public static void modificarDescuento() {

        String codigo;
        Categoria categoria;
        ParaFarmacia productoAmodificar;
        float nuevoDescuento;
        IO_ES.escribirLN("Vamos a buscar por su código al medicamento a modificar: ");
        codigo = rellenarCodigo(); //Comprobamos que el código es válido
        productoAmodificar = (ParaFarmacia) buscarProductos(codigo);

        if (productoAmodificar == null) {

            IO_ES.escribirLnRojo("Producto no existente.");

        } else {

            IO_ES.escribirLN("El producto de Parafarmacia a modificar es: \n" + productoAmodificar);
            nuevoDescuento = IO_ES.leerReal("Introduzca el nuevo descuento: ");
            productoAmodificar.setDescuento(nuevoDescuento);
            IO_ES.escribirLN("Los datos nuevos del producto son: \n" + productoAmodificar);

        }

    }

    //*********************************************************************************************************************
    // Fin bloque menú parafarmacia
    //*********************************************************************************************************************
    //******************* Opción 4. visualizarUnCliente ******
    /**
     * Método para poder ver un sólo cliente.
     *
     *
     */
    public static void visualizarUnCliente() {

        String id;
        id = rellenarNif();
        boolean bandera = false;

        if (!id.equalsIgnoreCase("Documento no válido")) {

            for (int i = 0; i < MAXIMOCLIENTES && !bandera; i++) {

                if (id.equalsIgnoreCase(arrayClientes[i].getId())) {

                    arrayClientes[i].toString();

                }

            }
        } else {

            IO_ES.escribirLnAzul("Cliente no existente en nuestra base de datos.");
        }

    }

    //******************* Opción 5. visualizarUnProducto ******
    /**
     * Método para poder ver un solo producto.
     *
     *
     */
    public static void visualizarUnProducto() {

        String codigo;
        boolean bandera = false;
        boolean codigoVerificado = false;
        Producto productoAvisualizar;

        codigo = IO_ES.leerCadena("Introduce el código de un producto: ", 13);

        codigoVerificado = Producto.comprobarCodigo(codigo);

        if (codigoVerificado) {

            productoAvisualizar = buscarProductos(codigo);

            if (productoAvisualizar != null) {
                productoAvisualizar.toString();
            } else {
                IO_ES.escribirLnRojo("Producto no existente.");
            }
        } else {
            IO_ES.escribirLnRojo("Código incorrecto.");
        }

    }

    //******************* Opción 6. visualizarClientes ******
    /**
     * Método para poder ver los clientes totales que tenemos El resultado será
     * el array clientes con sus objetos. Si está vacío el hueco del aray no lo
     * imprimirá
     *
     *
     */
    public static void visualizarClientes() {

        if (contadorClientes != 0) {

            for (int i = 0; i < MAXIMOCLIENTES; i++) {

                if (arrayClientes[i] != null) {

                    System.out.println(arrayClientes[i]);
                }

            }

        } else {
            IO_ES.escribirLnRojo("No hay cleintes creados.");
        }
    }

    //******************* Opción 7. visualizarProductos ******
    /**
     * Método para poder ver los productos totales que tenemos El resultado será
     * el array productos con sus objetos. Si está vacío el hueco del aray no lo
     * imprimirá
     *
     *
     */
    public static void visualizarProductos() {

        if (contadorProductos != 0) {

            for (int i = 0; i < MAXIMOPRODUCTOS; i++) {

                if (arrayProductos[i] != null) {

                    System.out.println(arrayProductos[i]);
                }
            }
        } else {
            IO_ES.escribirLnRojo("No hay productos creados.");
        }

    }

    //**********************************************************************
    //     MÉTODOS COMUNES
    //******************************************************************
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

            if (arrayProductos[i] == null) {

                productoEncontrado = null;

            } else {

                if (codigo.equalsIgnoreCase(arrayProductos[i].getCodigo())) {

                    productoEncontrado = arrayProductos[i];
                    bandera = true;

                }
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

            id = nifNie.toUpperCase();
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

        codigoIntroducido = IO_ES.leerCadena("Introduzca el código del producto, recuerda que son 13 números: ", 13);

        if (Producto.comprobarCodigo(codigoIntroducido)) {

            codigo = codigoIntroducido;
        } else {

            IO_ES.escribirLN("Código no válido");

        }
        return codigo;
    }

}
