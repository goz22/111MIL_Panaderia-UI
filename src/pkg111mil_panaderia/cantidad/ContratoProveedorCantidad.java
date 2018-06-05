package pkg111mil_panaderia.cantidad;

import java.util.List;
import pkg111mil_panaderia.modelo.TipoProducto;

public interface ContratoProveedorCantidad {
    public TipoProducto obtenerProducto(List<TipoProducto> productos, int ind);
}
