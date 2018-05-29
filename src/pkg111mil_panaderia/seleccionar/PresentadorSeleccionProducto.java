
package pkg111mil_panaderia.seleccionar;

import java.util.List;
import pkg111mil_panaderia.modelo.TipoProducto;
import proveedores.FalsoProveedorProductos;
import proveedores.ProveedorProductos;

public class PresentadorSeleccionProducto implements ContratoPresentadorSeleccionProducto{
    private ContratoVistaSeleccionProducto vista;
    private ProveedorProductos proveedor;

    public PresentadorSeleccionProducto(ContratoVistaSeleccionProducto vista) {
        this.vista = vista;
        this.proveedor = new FalsoProveedorProductos();
    }
    
    
    

    @Override
    public void iniciar() {
        
    }

    @Override
    public List<TipoProducto> dameLosProductos() {
        return this.proveedor.obtenerProductos();
    }
    
}
