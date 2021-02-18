/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author José María Pérez Sarabia
 * @version 1.0 Métodos para leer diferentes entradas por teclado y capturar sus
 * excepciones
 */
public class IO_ES {

    static String reset = "\u001B[0m";

    //**************** leerInteger sin mensaje**********
    /**
     * Método que pide al usuario que introduzca un número. El número esperado
     * es un número entero.
     *
     * @return int un entero llamado num
     */
    public static int leerInteger() {
        int num = 0;
        boolean numeroValido = false;

        do {

            Scanner sc = new Scanner(System.in);

            String s = sc.nextLine();

            if (s != null) {
                try {
                    num = Integer.valueOf(s);
                    numeroValido = true;
                } catch (NumberFormatException e) {
                    System.out.println("ERROR:  El valor introducido no es válido");
                }
            } else {
                numeroValido = true; // Cancelado
            }
        } while (!numeroValido);

        return num;
    }

    //******************* leerInteger con mensaje ************
    /**
     * Método que pide al usuario que introduzca un número, pero el método pide
     * por parámetro un mensaje. El número esperado es un número entero.
     *
     * @param mensaje -- mensaje que muestra para la petición del dato
     * @return int un número entero que hemos llamado d
     */
    static public int leerInteger(String mensaje) {
        int num = 0;
        boolean numeroValido = false;

        do {

            Scanner sc = new Scanner(System.in);

            System.out.print(mensaje);
            String s = sc.nextLine();

            if (s != null) {
                try {
                    num = Integer.parseInt(s);
                    numeroValido = true;
                } catch (NumberFormatException e) {
                    System.out.println("ERROR:  El valor introducido no es válido");
                }
            } else {
                numeroValido = true; // Cancelado
            }
        } while (!numeroValido);

        return num;
    }

    //******************* leerInteger con mensaje y un mínimo  ************
    /**
     * Método que pide al usuario que introduzca un número, pero el método pide
     * por parámetro un mensaje. El número esperado es un número entero, y mayor
     * que o igual que el pedido
     *
     * @param mensaje -- mensaje que muestra para la petición del dato
     * @param min -- valor mínimo que debe meter el usuario
     * @return int un número entero que hemos llamado
     */
    static public int leerInteger(String mensaje, int min) {
        int num = 0;
        boolean numeroValido = false;
        boolean minValido = false;

        do {

            Scanner sc = new Scanner(System.in);

            System.out.println(mensaje);
            String s = sc.nextLine();

            if (s != null) {
                try {
                    num = Integer.parseInt(s);

                    if (num <= min) {

                        System.out.println("El valor introducido es menor que el mínimo pedido");

                    } else {

                        numeroValido = true;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("ERROR:  El valor introducido no es válido");
                }
            } else {
                numeroValido = true; // Cancelado
            }
        } while (!numeroValido);

        return num;
    }

    //******************* leerInteger con mensaje y un mínimo y un máximo  ************
    /**
     * Método que pide al usuario que introduzca un número, pero el método pide
     * por parámetro un mensaje. El número esperado es un número entero, mayor
     * que min y menor que max
     *
     * @param mensaje String  mensaje que muestra para la petición del dato
     * @param min int  valor mínimo que debe meter el usuario
     * @param max int  valor máximo que debe meter el usuario
     * @return num int un número entero que hemos llamado
     */
    static public int leerInteger(String mensaje, int min, int max) {
        int num = 0;
        boolean numeroValido = false;
        boolean minValido = false;

        do {

            Scanner sc = new Scanner(System.in);

            System.out.print(mensaje);
            String s = sc.nextLine();

            if (s != null) {
                try {
                    num = Integer.parseInt(s);

                    if ((num >= min) && (num <= max)) {

                        numeroValido = true;

                    } else {
                        System.out.println("El valor introducido no está entre " + min + " y " + max + " .");

                    }

                } catch (NumberFormatException e) {
                    System.out.println("ERROR:  El valor introducido no es válido");
                }
            } else {
                numeroValido = true; // Cancelado
            }
        } while (!numeroValido);

        return num;
    }

    //*************** leerReal ********************
    /**
     * Método para leer un número decimal Método static para asegurarnos de que
     * el usuario introduce un número real. Solicito por pantalla un número
     * decimal, mientras no me de un entero, no podrá salir del programa y
     * además mandará un mensaje del sistema de error y una frase para que
     * intruzca de nuevo un entero
     *
     * @return real float número decimal
     */
    public static float leerReal() {

        Scanner teclado = new Scanner(System.in);
        float real = 0;
        boolean flag = false;

        do {
            System.out.println("Introduce un número real: ");
            try {

                real = Float.parseFloat(teclado.nextLine());
                flag = true;

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
                System.out.println("No has introducido un número REAL, vuleve a intentarlo, debe llevar coma(,) y no punto (.)");
                teclado.nextLine();
            }

        } while (flag == false);

        return real;

    }

    //*************** leerReal con mensaje********************
    /**
     * Método para leer un número decimal con un mesaje previo Método static
     * para asegurarnos de que el usuario introduce un número real. Solicito por
     * pantalla un número decimal, mientras no me de un entero, no podrá salir
     * del programa y además mandará un mensaje del sistema de error y una frase
     * para que intruzca de nuevo un entero
     *
     *
     * @return real float número decimal
     * @param mensaje String introducir un mensaje
     */
    public static float leerReal(String mensaje) {

        Scanner teclado = new Scanner(System.in);
        float real = 0;
        boolean flag = false;

        do {
            System.out.println(mensaje);
            try {

                real = Float.parseFloat(teclado.nextLine());
                flag = true;

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());

            }

        } while (flag == false);

        return real;

    }

    //******************* leerReal con mensaje y un mínimo  ************
    /**
     * Método que pide al usuario que introduzca un número real, pero el método
     * pide por parámetro un mensaje. El número esperado es un número real, y
     * mayor que o igual que el pedido
     *
     * @param mensaje String  mensaje que muestra para la petición del dato
     * @param min int  valor mínimo que debe meter el usuario
     * @return num float que hemos llamado num
     */
    static public float leerReal(String mensaje, int min) {
        float num = 0;
        boolean numeroValido = false;
        boolean minValido = false;

        do {

            Scanner sc = new Scanner(System.in);

            System.out.println(mensaje);
            //String s = sc.nextLine();

            try {
                num = Float.parseFloat(sc.nextLine());

                if (num <= min) {

                    System.out.println("El valor introducido es menor que el mínimo pedido");

                } else {

                    numeroValido = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("ERROR:  El valor introducido no es válido");
            }

        } while (!numeroValido);

        return num;
    }

    //************** leerEnteroLargo **************
    /**
     * Método static para asegurarnos de que el usuario introduce un número
     * entero largo. Solicito por pantalla un número entero, mientras no me de
     * un entero, no podrá salir del programa y además mandará un mensaje del
     * sistema de error y una frase para que intruzca de nuevo un entero
     *
     * @return long devuelve un número largo
     */
    public static long leerEnteroLargo() {

        Scanner sc = new Scanner(System.in);
        long enteroLargo = 0;
        boolean flag = false;

        do {

            try {

                enteroLargo = Long.parseLong(sc.nextLine());
                flag = true;

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
                System.out.println("Recuerda que es un número entero largo, sin decimales");
                sc.nextLine();
            }

        } while (flag == false);

        return enteroLargo;

    }

    //************** leerEnteroLargo con mensaje**************
    /**
     * Método static para asegurarnos de que el usuario introduce un número
     * entero largo. Solicito por pantalla un número entero, mientras no me de
     * un entero, no podrá salir del programa y además mandará un mensaje del
     * sistema de error y una frase para que intruzca de nuevo un entero
     *
     * @return long devuelve un número largo
     * @param mensaje String mensaje para introducir para que lo reciba el
     * usuario
     */
    public static long leerEnteroLargo(String mensaje) {

        System.out.println(mensaje);
        Scanner sc = new Scanner(System.in);
        long enteroLargo = 0;
        boolean flag = false;

        do {

            try {

                enteroLargo = Long.parseLong(sc.nextLine());
                flag = true;

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
                System.out.println("Recuerda que es un número entero largo, sin decimales");
                sc.nextLine();
            }

        } while (flag == false);

        return enteroLargo;

    }

    //*******************leerRealLargo double***********
    /**
     * Método para leer un real largo
     *
     * @return double real largo
     */
    /* Método static para asegurarnos de que el usuario introduce un número real.
    Solicito por pantalla un número decimal, mientras no me de un entero, no podrá salir del programa
    y además mandará un mensaje del sistema de error y una frase para que intruzca de nuevo un entero.
    También mandaré un aviso si mete un punto en vez de una coma o una letra
     */
    public static double leerRealLargo() {

        Scanner teclado = new Scanner(System.in);
        double realLargo = 0;
        boolean flag = false;

        do {

            try {

                realLargo = Double.parseDouble(teclado.nextLine());
                flag = true;

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());

            }

        } while (flag == false);

        return realLargo;

    }

    //*******************leerRealLargo double con mensaje***********
    /**
     * Método para leer un real largo y que pida un mensaje previo Método static
     * para asegurarnos de que el usuario introduce un número real. Mandará un
     * mensaje previo Solicito por pantalla un número decimal, mientras no me de
     * un entero, no podrá salir del programa y además mandará un mensaje del
     * sistema de error y una frase para que intruzca de nuevo un entero.
     * También mandaré un aviso si mete un punto en vez de una coma o una letra
     *
     * @return double
     * @param mensaje String mensaje para que lo reciba el usuario
     */
    public static double leerRealLargo(String mensaje) {

        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        double realLargo = 0;
        boolean flag = false;

        do {

            try {

                realLargo = Double.parseDouble(teclado.nextLine());
                flag = true;

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());

            }

        } while (flag == false);

        return realLargo;

    }

    //********** leerCadena *****************************
    /**
     * Método para leer una cadena de caracteres
     *
     * @return String
     *
     *
     */
    public static String leerCadena() {

        String cadena;

        Scanner teclado = new Scanner(System.in);

        cadena = teclado.nextLine();

        return cadena;

    }

    //********** leerCadena con mesnaje para el usuario *****************************
    /**
     * Método para leer una cadena de caracteres, pero que mande un mensaje al
     * usuario
     *
     *
     * @return String
     * @param mensaje String para el usuario
     *
     */
    public static String leerCadena(String mensaje) {

        String cadena;

        System.out.println(mensaje);

        Scanner teclado = new Scanner(System.in);

        cadena = teclado.nextLine();

        return cadena;

    }

    //********** leerCadena con mesnaje para el usuario y con valor fijo de caracteres*****************************
    /**
     * Método para leer una cadena de caracteres, que mande un mensaje al
     * usuario, y que lo que escriba tenga una longitud determinada.
     *
     * @return String
     * @param mensaje para el usuario
     * @param longitud de la cadena
     *
     */
    public static String leerCadena(String mensaje, int longitud) {

        String cadena;
        boolean longitudValida = false;

        Scanner teclado = new Scanner(System.in);

        do {

            System.out.println(mensaje);

            cadena = teclado.nextLine();

            if (cadena.length() == longitud) {

                longitudValida = true;

            } else {

                System.out.println("La longitud del texto no es correcta");
            }

        } while (!longitudValida);

        return cadena;

    }

    //**************** método para escribir pero con mensaje para el usuario**********
    /**
     * Método para decirle algo al usuario y que escriba lo que se requiera,
     * pero sin salto de línea
     *
     * @param mensaje String
     */
    public static void escribir(String mensaje) {

        System.out.print(mensaje);

    }

    //************ Método para escribir con salto de línea****
    /**
     * Método para escribir con salto de línea y mandadno mensaje al usuario
     *
     * @param mensaje String
     */
    public static void escribirLN(String mensaje) {

        System.out.println(mensaje);

    }

    //*************Método para que el texto de salida sea rojo *****************
    /**
     * Método para que el texto que se escriba salga en rojo, con salto de línea
     *
     * @param mensaje texto a imprimir en rojo
     */
    public static void escribirLnRojo(String mensaje) {

        String red = "\033[31m";

        System.out.println(red + mensaje + reset);
    }
    

    //*************Método para que el texto de salida sea verde *****************
    /**
     * Método para que el texto que se escriba salga en verde, con salto de
     * línea
     *
     * @param mensaje mensaje a escribir por el programador para que salga por pantalla en verde
     */
    public static void escribirLnVerde(String mensaje) {

        String green = "\033[32m";

        System.out.println(green + mensaje + reset);

    }

    //*************Método para que el texto de salida sea azul *****************
    /**
     * Método para que el texto que se escriba salga en azul, con salto de línea
     *
     * @param mensaje mensaje a escribir por el programador para que salga por pantalla en azul
     */
    public static void escribirLnAzul(String mensaje) {

        String blue = "\033[34m";

        System.out.println(blue + mensaje + reset);

    }

    //*************Método para que el texto de salida sea morado *****************
    /**
     * Método para que el texto que se escriba salga en morado, con salto de
     * línea
     *
     * @param mensaje mensaje a escribir por el programador para que salga por pantalla en morado
     */
    public static void escribirLnPurple(String mensaje) {

        String purple = "\033[35m";

        System.out.println(purple + mensaje + reset);

    }

    //*************Método para que el texto de salida sea morado *****************
    /**
     * Método para que el texto que se escriba salga en cyan, con salto de línea
     *
     * @param mensaje mensaje a escribir por el programador para que salga por pantalla en cyan
     */
    public static void escribirLnCyan(String mensaje) {

        String cyan = "\033[36m";

        System.out.println(cyan + mensaje + reset);

    }

    //*************Método para que el texto de salida sea amarillo *****************
    /**
     * Método para que el texto que se escriba salga en amarillo, con salto de
     * línea
     *
     * @param mensaje mensaje a escribir por el programador para que salga por pantalla en amarillo
     */
    public static void escribirLnAmarillo(String mensaje) {

        String yellow = "\033[33m";

        System.out.println(yellow + mensaje + reset);

    }

    //*************Método para que el texto de salida sea blanco *****************
    /**
     * Método para que el texto que se escriba salga en blanco, con salto de
     * línea
     *
     * @param mensaje mensaje a escribir por el programador para que salga por pantalla en blanco
     */
    public static void escribirLnBlanco(String mensaje) {

        String white = "\033[37m";;

        System.out.println(white + mensaje + reset);

    }

    //*************Método para que el texto de salida sea negro *****************
    /**
     * Método para que el texto que se escriba salga en negro, con salto de
     * línea
     *
     * @param mensaje mensaje a escribir por el programador para que salga por pantalla en negro
     */
    public static void escribirLnNegro(String mensaje) {

        String black = "\033[30m";

        System.out.println(black + mensaje + reset);

    }

    //**************** Método para leer ficheros**********
    /**
     * Método para leer fichero y convertirlos en un String
     *
     * @param rutaFichero String
     * @return String
     */
    public static String lecturaFicherosTexto(String rutaFichero) {

        String textoVar = null;

        try {

            textoVar = new String(Files.readAllBytes(Paths.get("rutaFichero")));

            //System.out.println(textoVar); // para visualizar el contenido del fichero por pantalla --> para que lo pruebes
        } catch (IOException e) {

            // TODO Auto-generated catch block
            System.out.println("ERROR: " + e.getMessage());

        }

        return textoVar;
    }

    //**** Método para leer un char*********************
    /**
     * Método para leer un char
     *
     * @return char
     */
    public static char leerCaracter() {

        char caracter = 0;
        String cadena;
        boolean caracterValido = false;

        Scanner teclado = new Scanner(System.in);

        do {

            cadena = teclado.nextLine();

            if (cadena.length() != 1 || cadena.length() == 0) {

                System.out.println("Has introducido ninguno o más de un carácter.");
                //teclado.nextLine();

            } else {

                caracter = cadena.charAt(0);
                caracterValido = true;

            }
        } while (!caracterValido);

        return caracter;

    }

    //**** Método para leer un char con mensaje para el usuario*********************
    /**
     * Método para leer un char
     *
     * @param mensaje String sería el mensaje para que el usuario introduzca lo
     * que necesitamos
     * @return char
     */
    public static char leerCaracter(String mensaje) {

        char caracter = 0;
        String cadena;
        boolean caracterValido = false;

        Scanner teclado = new Scanner(System.in);

        do {

            System.out.println(mensaje);

            cadena = teclado.nextLine();

            if (cadena.length() != 1 || cadena.length() == 0) {

                System.out.println("Has introducido ninguno o más de un carácter.");
                //teclado.nextLine();

            } else {

                caracter = cadena.charAt(0);
                caracterValido = true;

            }
        } while (!caracterValido);

        return caracter;

    }

    //**** Método para leer un boolean con mensaje para el usuario*********************
    /**
     * Método para leer un boolean, el usuario escribirá si o no, Si o No, S o
     * n, SI o NO
     *
     * @param mensaje sería el mensaje para que el usuario introduzca lo que
     * necesitamos
     * @return boolean
     */
    public static boolean leerBooleano(String mensaje) {

        String cadena;
        boolean resultado = false;
        boolean bandera = false;

        Scanner teclado = new Scanner(System.in);

        do {

            System.out.println(mensaje);

            cadena = teclado.nextLine();

            if (cadena.matches("^s$|^Si$|^SI$|^S$|^si$|^sI$")) {

                resultado = true;
                bandera = true;
                // System.out.println("Correcto");// Para mi control
                //teclado.nextLine();

            } else {
                if (cadena.matches("^n$|^N$|^No$|^NO$|^no$|^nO$")) {
                    resultado = false;
                    bandera = true;
                    //   System.out.println("Incorrecto"); //para mi control
                } else {
                    System.out.println("No ha introducido un valor correcto");
                }

            }
        } while (!bandera);

        //System.out.println(resultado);//para mi control
        return resultado;

    }

    //**** Método para leer un boolean sin mensaje*********************
    /**
     * Método para leer un boolean, el usuario escribirá si o no, Si o No, S o
     * n, SI o NO
     *
     *
     * @return boolean
     */
    public static boolean leerBooleano() {

        String cadena;
        boolean resultado = false;
        boolean bandera = false;

        Scanner teclado = new Scanner(System.in);

        do {

            cadena = teclado.nextLine();

            if (cadena.matches("s|^Si$|^SI$|S|^si$")) {

                resultado = true;
                bandera = true;
                // System.out.println("Correcto");// Para mi control
                //teclado.nextLine();

            } else {
                if (cadena.matches("n|N|^No$|^NO$|^no$")) {
                    resultado = false;
                    bandera = true;
                    //   System.out.println("Incorrecto"); //para mi control
                } else {
                    System.out.println("No ha introducido un valor correcto");
                }

            }
        } while (!bandera);

        //System.out.println(resultado);//para mi control
        return resultado;

    }
}
