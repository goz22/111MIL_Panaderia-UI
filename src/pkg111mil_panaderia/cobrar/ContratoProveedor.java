/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg111mil_panaderia.cobrar;

import java.util.List;
import pkg111mil_panaderia.modelo.Dinero;

/**
 *
 * @author agustin
 */
public interface ContratoProveedor {
    public List<Dinero> getDineroAutorizado();
    public void agregarDineroACaja(List<Dinero> dinero);
}
