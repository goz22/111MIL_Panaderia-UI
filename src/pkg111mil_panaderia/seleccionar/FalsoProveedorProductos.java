
package pkg111mil_panaderia.seleccionar;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pkg111mil_panaderia.modelo.TipoProducto;
import pkg111mil_panaderia.modelo.UnidadMedida;

public class FalsoProveedorProductos implements ContratoProveedorProductos{
    
    private ArrayList<TipoProducto> producto = new ArrayList<>();
    
    
    @Override
    public List<TipoProducto> obtenerProductos(){ 
        
    List<TipoProducto>productos=Arrays.asList(
            new TipoProducto("criollo", 12.5f, UnidadMedida.PESO, 20.0f),
            new TipoProducto("Pasta Frola", 25.0f, UnidadMedida.UNIDAD, 100.0f),
            new TipoProducto("Pan Frances", 15.0f, UnidadMedida.UNIDAD, 200.0f),
            new TipoProducto("Facturas", 7.0f, UnidadMedida.UNIDAD, 100.0f)
            );
    
    return productos;
    }
    
    
}
