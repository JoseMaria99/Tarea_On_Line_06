/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author José María Pérez
 */
public class ValidarDatos {

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

        if (mat.find()) {

            if (nif.charAt(0) == 'X' || nif.charAt(0) == 'Y' || nif.charAt(0) == 'Z' || nif.charAt(0) == 'x' || nif.charAt(0) == 'y' || nif.charAt(0) == 'z') {

                digitosNie = (int) Integer.parseInt(nif.substring(1, 8));
                //System.out.println(digitosNie); para mi control
                letraNie = nif.charAt(8);
                //System.out.println(letraNie); para mi control

                if (nif.charAt(0) == 'Y' || nif.charAt(0) == 'y') {

                    digitosNie = digitosNie + 10000000;

                } else if (nif.charAt(0) == 'Z' || nif.charAt(0) == 'z') {

                    digitosNie = digitosNie + 20000000;

                }

            } else {

                digitosNif = (int) Integer.parseInt(nif.substring(0, 8));
                //System.out.println(digitosNif);
                letraNif = nif.charAt(8);
                //System.out.println(letraNif);
            }

            if (letraNif == tablaLetras.charAt(digitosNif % 23) || letraNie == tablaLetras.charAt(digitosNie % 23)) {

                nifValido = true;

            } else {

                nifValido = false;

            }

        }
        return nifValido;

    }

}
