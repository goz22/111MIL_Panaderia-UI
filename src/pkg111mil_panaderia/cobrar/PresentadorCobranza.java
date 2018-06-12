/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg111mil_panaderia.cobrar;

import java.util.ArrayList;
import java.util.List;
import pkg111mil_panaderia.modelo.Dinero;
import pkg111mil_panaderia.modelo.Pedido;

/**
 *
 * @author BusquetsLA
 */
public class PresentadorCobranza implements ContratoPresentadorCobranza{
    
    private final ContratoVistaCobranza vista;
    private float totalIngresado = 0;
    private List<Dinero> dineroIngresado = new ArrayList<>();
    private ContratoProveedor proveedor;
    private Pedido pedido;
    
    
    public PresentadorCobranza(ContratoVistaCobranza vista) {
        this.vista = vista;
        proveedor = new ProveedorCobranza();
        //totalPedido= this.vista.pedido.calcularTotalPedido();
    }   
    
    @Override
    public void billeteElegido(Dinero bill){
        if(totalIngresado <= pedido.calcularTotalPedido()){
            this.totalIngresado = this.totalIngresado + bill.getDenominacion();
            dineroIngresado.add(bill);
            this.vista.agregarBillete(bill);
        }           
    }
    
    @Override
    public void botonCancelarCobranza(){
        this.vista.cancelarCobranza();
        this.totalIngresado = 0;
    }
    
    @Override
    public void botonAceptarCobranza(){
        this.vista.aceptarCobranza();
    }
    
    @Override
    public float mostrarTotalPedido(){
        return pedido.calcularTotalPedido();
    }
    
    @Override
    public float mostrarTotalIngresado(){
        return totalIngresado;
    }
    
    public void agregarDineroACaja(){
        proveedor.agregarDineroACaja(dineroIngresado);
    }
}
