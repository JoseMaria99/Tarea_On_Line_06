/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarDatos {

    /**
     * Método para validar un NIF ó un NIE
     *
     * @author José María Pérez
     * @param nif recibe un NIF o un NIE, que en principio no se distinguen ya
     * que ambos pueden ser el identificador de un cliente
     * @return nifValido es un booleano, y dará igual que sea NIE o NIF,
     * validamos los dos con el mismo método
     */
    public static boolean verificarNIF(String nif) {

        boolean nifValido = false;

        Scanner teclado = new Scanner(System.in);
        String tablaLetras = "TRWAGMYFPDXBNJZSQVHLCKE";
        char letraNif = ' ';
        int digitosNif = 0;
        int digitosNie = 0;
        char letraNie = ' ';

        nif = nif.toUpperCase();

        Pattern patron = Pattern.compile("^[0-9XYZ]{1}[0-9]{7}[TRWAGMYFPDXBNJZSQVHLCKE]{1}$");
        Matcher mat = patron.matcher(nif);

        if (mat.matches()) {

            if (nif.charAt(0) == 'X' || nif.charAt(0) == 'Y' || nif.charAt(0) == 'Z' || nif.charAt(0) == 'x' || nif.charAt(0) == 'y' || nif.charAt(0) == 'z') {

                digitosNie = (int) Integer.parseInt(nif.substring(1, 8));

                letraNie = nif.charAt(8);

                if (nif.charAt(0) == 'Y' || nif.charAt(0) == 'y') {

                    digitosNie = digitosNie + 10000000;

                } else if (nif.charAt(0) == 'Z' || nif.charAt(0) == 'z') {

                    digitosNie = digitosNie + 20000000;

                }

            } else {

                digitosNif = (int) Integer.parseInt(nif.substring(0, 8));

                letraNif = nif.charAt(8);

            }

            if (letraNif == tablaLetras.charAt(digitosNif % 23) || letraNie == tablaLetras.charAt(digitosNie % 23)) {

                nifValido = true;

            } else {

                nifValido = false;

            }

        }
        return nifValido;

    }

    /**
     * Método para validar un ´número de teléfono, será español, puede llevar el
     * +34 o no, y puede ser fijo ó móvil
     *
     * @param telefono
     * @return telefonoValido
     */
    public static boolean validarTelefono(String telefono) {

        boolean numero = false;
        Pattern pat = Pattern.compile("^(\\+34|0034|34)?[6789]\\d{8}$");
        Matcher mat = pat.matcher(telefono);
        if (mat.matches()) {
            numero = true;
        }
        return numero;
    }

}
