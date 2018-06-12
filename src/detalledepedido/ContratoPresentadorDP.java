/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detalledepedido;

import java.util.ArrayList;
import pkg111mil_panaderia.modelo.DetallePedido;

/**
 *
 * @author utku30
 */
public interface ContratoPresentadorDP {
    
    public void iniciar();
    public ArrayList<DetallePedido> getDetallePedido();
    public ArrayList<String> getURLS();
    
}
