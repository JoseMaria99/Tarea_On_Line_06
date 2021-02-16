/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraDatos;

/**
 * Clase para crear dos enumerados, Categoría y TipoMedicamento. ambos serán
 * variables de ParaFarmacia y Medicamentos respectivamente. Y se pedirán en los
 * constructores respectivos
 *
 * @author José María Pérez
 * @version 1.0
 */
public class Enumerados {

    public enum Categoria {

        DENTAL, FACIAL, GELES, CORPORAL, CABELLO, ANTIMOSQUITOS, INTIMA, NASAL, OCULAR, BOTIQUIN, OIDOS, TOALLITAS, LIMPIEZA, HOGAR, MASCARILLAS
    }

    public enum TipoMedicamento {

        ANALGESICOS, LAXANTES, ANTIINFECCIOSOS, ANTIDEPRESIVOS, ANTITUSIVOS, MUCOLITICOS, ANTIACIDOS, ANTIULCEROSOS, ANTIALERGICOS, ANTIDIARREICOS
    }
}
