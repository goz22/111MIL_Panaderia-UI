package pkg111mil_panaderia.cantidad;

import pkg111mil_panaderia.modelo.DetallePedido;

public interface ContratoPresentadorCantidad {
    public void iniciar();
    public float calcularTotal(float cantidad);

    public float calcularMontoTotal(float cantidadIngresada);

    public DetallePedido crearDetalle(float cantidadIngresada);
}
