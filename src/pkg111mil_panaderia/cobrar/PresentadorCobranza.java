/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg111mil_panaderia.cobrar;

import java.util.ArrayList;
import java.util.List;
import pkg111mil_panaderia.modelo.Dinero;

/**
 *
 * @author BusquetsLA
 */
public class PresentadorCobranza implements ContratoPresentadorCobranza{
    
    private final ContratoVistaCobranza vista;
    private float total;
    private float totalPedido;
    private List<Dinero> dineroIngresado = new ArrayList<>();
    private ContratoProveedor proveedor;
    
    
    public PresentadorCobranza(ContratoVistaCobranza vista) {
        this.vista = vista;
        proveedor = new ProveedorCobranza();
        //totalPedido= this.vista.pedido.calcularTotalPedido();
    }   
    
    @Override
    public void billeteElegido(Dinero bill){
        this.total = this.total + bill.getDenominacion();
        dineroIngresado.add(bill);
        this.vista.agregarBillete(bill);
    }
    
    @Override
    public void botonCancelarCobranza(){
        this.vista.cancelarCobranza();
        this.total = 0;
    }
    
    @Override
    public void botonAceptarCobranza(){
        this.vista.aceptarCobranza();
    }
    @Override
    public float mostrarTotalPedido(){
        return totalPedido;
    }
    
    @Override
    public float mostrarTotal(){
        return total;
    }
    
    public void agregarDineroACaja(){
        proveedor.agregarDineroACaja(dineroIngresado);
    }
}
