/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraDatos;

import estructuraDatos.Enumerados.Categoria;

/**
 *
 * @author José María Pérez
 */
public class ParaFarmacia extends Producto {

    private Categoria categoria;
    private int dosisUnidades;
    private float descuento;

    public ParaFarmacia(String codigo, String nombre, String descripcion, double precio, int unidades, Categoria categoria, int dosisUnidades, float descuento) {

        super(codigo, nombre, descripcion, precio, unidades);
        this.categoria = categoria;
        this.dosisUnidades = dosisUnidades;
        this.descuento = descuento;

    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getDosisUnidades() {
        return dosisUnidades;
    }

    public void setDosisUnidades(int dosisUnidades) {
        this.dosisUnidades = dosisUnidades;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return (super.toString() + "\n   Categoría de Parafarmacia: " + categoria + "\n   Número de dosis por envase: " + dosisUnidades + "\n  El descuento que tiene es de un: " + descuento);
    }

}
