/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detalledepedido;

import javafx.geometry.Insets;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import pkg111mil_panaderia.modelo.DetallePedido;
import pkg111mil_panaderia.ui.ContratoControladorVistas;

/**
 *
 * @author utku30
 */
public class VistaDP implements ContratoVistaDP {
    private ContratoPresentadorDP presentadorDP;
    private ContratoControladorVistas controlador;
    
    private Scene scene;
    private GridPane root;
    private Button eliminarPedido;
    private Button cobrar;
    private Label total;
    private ScrollPane scroll;
    
    
    public VistaDP(ContratoControladorVistas controlador) {
        this.controlador = controlador;
        this.presentadorDP = new PresentadorDP(this);
        this.iniciarGrafica();
        this.presentadorDP.iniciar();
    }
    
    
    private void iniciarGrafica(){
        HBox caja = new HBox();
        this.root = new GridPane();
        
        this.root.setVgap(10);
        this.root.setHgap(10);
        
        final Label categoria = new Label();
        final Label cantidad = new Label();
        final Label precio = new Label();
        
        categoria.setText("Producto");
        cantidad.setText("Cantidad");
        precio.setText("Precio");
        
        this.root.add(categoria, 0 ,0);
        this.root.add(cantidad, 1 ,0);
        this.root.add(precio, 2 ,0);
            
        
        int i = 1;
        for(DetallePedido detalle : this.presentadorDP.getDetallePedido()) {
            final Label nombreProducto = new Label();
            final Label cantidadProductos = new Label();
            final Label precioProducto = new Label();
            final Button botonCancelar = new Button();
            
            nombreProducto.setText(detalle.getTipoProducto().getNombre());
            cantidadProductos.setText(String.valueOf(detalle.getCantidad()));
            precioProducto.setText(String.valueOf(detalle.getTipoProducto().getPrecioUnitario()));
            botonCancelar.setText("Cancelar");
            
            this.root.add(nombreProducto, 0 ,i);
            this.root.add(cantidadProductos, 1 ,i);
            this.root.add(precioProducto, 2 ,i);
            this.root.add(botonCancelar, 3 ,i);
            
            i++;
        }
        
        final Button botonCancelarGral = new Button();
        final Button botonCobrar = new Button();
        final Label total = new Label();
        
        botonCancelarGral.setText("Cancelar Pedidos");
        botonCobrar.setText("Cobrar");
        float totalPedidos = 0;
        for(DetallePedido detalle : this.presentadorDP.getDetallePedido()) {
            totalPedidos += detalle.calcularTotalDetalle();
        }
        total.setText(String.valueOf(totalPedidos));
        
        this.root.add(botonCancelarGral, 3 ,20);
        this.root.add(botonCobrar, 1 ,20);
        this.root.add(total, 2, 20);
        this.scene = new Scene(this.root, 500, 500);
        
    }
    
    @Override
    public Scene getScene() {
        return this.scene;
    }

}
