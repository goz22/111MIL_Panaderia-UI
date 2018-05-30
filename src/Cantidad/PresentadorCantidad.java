package Cantidad;

import pkg111mil_panaderia.modelo.TipoProducto;

public class PresentadorCantidad implements ContratoPresentadorCantidad{
    
    private ContratoVistaCantidad vista;
    private TipoProducto producto;
    
    public PresentadorCantidad(ContratoVistaCantidad vista, TipoProducto producto){
        this.vista = vista;
        this.producto = producto;
    }
    @Override
    public float calcularTotal(float cantidad){
        return this.producto.getPrecioUnitario()* cantidad;
    }
    @Override
    public void iniciar(){
        
    }
}
