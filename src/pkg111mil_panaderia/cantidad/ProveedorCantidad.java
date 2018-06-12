package pkg111mil_panaderia.cantidad;

import java.util.Arrays;
import java.util.List;
import pkg111mil_panaderia.modelo.TipoProducto;
import pkg111mil_panaderia.modelo.UnidadMedida;

public class ProveedorCantidad implements ContratoProveedorCantidad{
    
    private List<TipoProducto> productos = Arrays.asList(
        new TipoProducto("Criollo Normal", 80, UnidadMedida.PESO, 15),
        new TipoProducto("Criollo de Ojaldre", 100, UnidadMedida.PESO, 15),
        new TipoProducto("Pan Francés", 85, UnidadMedida.PESO, 10));
    
    @Override
    public TipoProducto obtenerProducto(List<TipoProducto> productos, int ind){
        for(int i = 0; i<productos.size(); i++){
            if(productos.get(i) == productos.get(ind)){
                return productos.get(ind);
            }
        }
        return null;
    }
}
