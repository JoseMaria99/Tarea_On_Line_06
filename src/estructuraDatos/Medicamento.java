/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraDatos;

import estructuraDatos.Enumerados.TipoMedicamento;

/**
 *
 * @author José María Pérez
 */
final public class Medicamento extends Producto {

    private TipoMedicamento medicamento;
    private String comoTomar;
    private String efectosAdversos;

    public Medicamento(String codigo, String nombre, String descripcion, double precio, int unidades, TipoMedicamento medicamento, String comoTomar, String efectosAdversos) {

        super(codigo, nombre, descripcion, precio, unidades);
        this.medicamento = medicamento;
        this.comoTomar = comoTomar;
        this.efectosAdversos = efectosAdversos;

    }

    public Medicamento(TipoMedicamento medicamento) {

        this.medicamento = medicamento;
    }

    public TipoMedicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(TipoMedicamento medicamento) {
        this.medicamento = medicamento;
    }

    public String getComoTomar() {
        return comoTomar;
    }

    public void setComoTomar(String comoTomar) {
        this.comoTomar = comoTomar;
    }

    public String getEfectosAdversos() {
        return efectosAdversos;
    }

    public void setEfectosAdversos(String efectosAdversos) {
        this.efectosAdversos = efectosAdversos;
    }

    @Override
    public String toString() {
        return (super.toString() + "\n   Tipo de Medicamento: " + medicamento + "\n   Cómo tomar el medicamento: " + comoTomar + "\n   Los posibles efectos adversos son: : " + efectosAdversos);
    }

}
