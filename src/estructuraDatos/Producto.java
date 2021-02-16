/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraDatos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author José María Pérez
 */
public abstract class Producto {

    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int unidades;

    public Producto(String codigo, String nombre, String descripcion, double precio, int unidades) {

        if (comprobarCodigo(codigo)) {

            this.codigo = codigo;

        } else {

            this.codigo = "X";
        }

        this.descripcion = descripcion;
        this.nombre = nombre;

        if (precio >= 0) {

            this.precio = precio;

        } else {
            this.precio = 0;
        }

        if (unidades >= 0) {

            this.unidades = unidades;

        } else {

            this.unidades = 0;
        }

    }

    public Producto(Producto producto) {

        producto.getCodigo();
        producto.getNombre();
        producto.getDescripcion();
        producto.getPrecio();
        producto.getUnidades();

    }

    public void setCodigo(String codigo) {

        if (comprobarCodigo(codigo)) {

            this.codigo = codigo;
        } else {
            this.codigo = "X";
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {

        if (precio >= 0) {

            this.precio = precio;
        } else {
            this.precio = 0;
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getUnidades() {
        return unidades;
    }

    /**
     * Mñetodo que verifica qu el código introducido es un nñumero de 13
     * caracteres
     *
     * @param codigo String
     * @return codigoCorrecto un boolean
     */
    public static boolean comprobarCodigo(String codigo) {

        boolean codigoCorrecto = false;

        Pattern patron = Pattern.compile("^[0-9]{13}$");
        Matcher mat = patron.matcher(codigo);

        if (mat.find()) {

            codigoCorrecto = true;
        }

        return codigoCorrecto;
    }

    /**
     * Método para añadir unidades de un producto.Si es negativo devolverá
     * false.
     *
     * @param nuevasUnidades int son las nuevas unidades a añadir
     * @return saldrá false si hemos introducido un número negativo
     */
    public boolean aniadirUnidades(int nuevasUnidades) {

        boolean aniadeUnidades = false;

        if (nuevasUnidades > 0) {

            unidades = unidades + nuevasUnidades;
            aniadeUnidades = true;

        }
        return aniadeUnidades;
    }

    /**
     * Método para quitar unidades de un producto.Si es negativo devolverá
     * false.
     *
     * @param menosUnidades int
     * @return quitarUnidades saldrá false si hemos introducido un número
     * negativo
     */
    public boolean quitarUnidades(int menosUnidades) {

        boolean quitarUnidades = false;

        if (menosUnidades > 0) {

            if (unidades < menosUnidades) {

                quitarUnidades = false;

            } else {
                unidades = unidades - menosUnidades;
                quitarUnidades = true;
            }

        }
        return quitarUnidades;
    }

    @Override
    public String toString() {
        return "Producto: " + "\n   Código: " + codigo + "\n   Nombre: " + nombre + "\n   Descripción: " + descripcion + "\n   Precio: " + precio + "\n   Unidades: " + unidades;
    }

}
