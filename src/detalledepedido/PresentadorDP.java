/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detalledepedido;

import detalledepedido.Proveedor.ContratoFalsoProveedor;
import detalledepedido.Proveedor.FalsoProveedor;
import java.util.ArrayList;
import pkg111mil_panaderia.modelo.DetallePedido;

/**
 *
 * @author utku30
 */
public class PresentadorDP implements ContratoPresentadorDP {
     private ContratoVistaDP vista;
     private ContratoFalsoProveedor falsoProveedor;
    
    public PresentadorDP(ContratoVistaDP vista) {
        this.vista = vista;
        this.falsoProveedor = new FalsoProveedor();
    }

    @Override
    public void iniciar() {
        
    }

    @Override
    public void mainButtonPressed() {
        
    }

    @Override
    public ArrayList<DetallePedido> getDetallePedido() {
        return (this.falsoProveedor.getDetallesPedido());
    }
    
}
