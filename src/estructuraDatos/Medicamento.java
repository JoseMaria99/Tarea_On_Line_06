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

    private TipoMedicamento tipoMedicamento;
    private String comoTomar;
    private String efectosAdversos;

    public Medicamento(String codigo, String nombre, String descripcion, double precio,
            int unidades, TipoMedicamento tipoMedicamento, String comoTomar,
            String efectosAdversos) {

        super(codigo, nombre, descripcion, precio, unidades);
        this.tipoMedicamento = tipoMedicamento;
        this.comoTomar = comoTomar;
        this.efectosAdversos = efectosAdversos;

    }

    public Medicamento(Medicamento medicamento) {

        super(medicamento.getCodigo(), medicamento.getNombre(),
                medicamento.getDescripcion(), medicamento.getPrecio(),
                medicamento.getUnidades());
        this.tipoMedicamento = medicamento.tipoMedicamento;
        this.comoTomar = medicamento.comoTomar;
        this.efectosAdversos = medicamento.efectosAdversos;
    }

    public TipoMedicamento getTipoMedicamento() {
        return tipoMedicamento;
    }

    public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
        this.tipoMedicamento = tipoMedicamento;
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
        return (super.toString() + "\n   Tipo de Medicamento: " + tipoMedicamento + "\n   Cómo tomar el medicamento: " + comoTomar + "\n   Los posibles efectos adversos son: : " + efectosAdversos);
    }

}
