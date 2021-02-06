/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraDatos;

/**
 *
 * @author José María Pérez
 */
public class Cliente {

    private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    private boolean baja;

    public Cliente(String id, String nombre, String direccion, String telefono, boolean baja) {

        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.baja = baja;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Cliente: " + "\n   id: " + id + "\n   Nombre: " + nombre + "\n   Direccion:" + direccion + "\n   Telefono: " + telefono + "\n   Baja : " + baja;
    }

}
