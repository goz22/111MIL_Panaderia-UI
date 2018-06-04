/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detalledepedido;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
    private GridPane grid;
    private BorderPane panel;
    
    public VistaDP(ContratoControladorVistas controlador) {
        this.controlador = controlador;
        this.presentadorDP = new PresentadorDP(this);
        this.iniciarGrafica();
        this.presentadorDP.iniciar();
    }
    
    
    private void iniciarGrafica(){
        /**
         * CREACION DE PANELES
         */
        // Creacion de la grilla (CENTER OF PANEL)
        this.grid = new GridPane();
        this.grid.setHgap(10);
        this.grid.setVgap(10);
        this.grid.setPadding(new Insets(10, 10, 10, 10));
        this.grid.setAlignment(Pos.BASELINE_CENTER);
        
        // Creacion de caja horizontal (BOTTOM OF PANEL)
        HBox caja = new HBox();
        caja.setSpacing(10);
        caja.setStyle("-fx-background-color: #336699;");
        caja.setAlignment(Pos.CENTER);
        
        // Creacion de caja horizontal (TOP OF PANEL)
        HBox caja2 = new HBox();
        caja.setSpacing(10);
        caja.setStyle("-fx-background-color: #336699;");
        caja.setAlignment(Pos.CENTER);
        
        // Creacion del panel Principal
        this.panel = new BorderPane();
        this.panel.setPadding(new Insets(10));
        this.panel.setCenter(grid);
        this.panel.setBottom(caja);
        this.panel.setTop(caja2);
        
        
        /**
         * CREACION DE ELEMENTOS Y AGREGADO A LOS PANELES
         */
        // (CENTER) Creacion de elementos y agregado a la grilla
        Label estadoPedido = new Label("Estado Pedido");
        Label categoria = new Label("Producto");
        Label cantidad = new Label("Cantidad");
        Label precio = new Label("Precio U");
        
        this.grid.add(categoria, 0 ,0);
        this.grid.add(cantidad, 1 ,0);
        this.grid.add(precio, 2 ,0);
        this.grid.add(estadoPedido, 3, 0);
        
        List<Button> botones = new ArrayList();
        List<Label> labelEstado = new ArrayList();
        List<Label> labelPrecio = new ArrayList();
        List<Label> labelCantidad = new ArrayList();
        int i = 1;
        for(DetallePedido detalle : this.presentadorDP.getDetallePedido()) {
            String producto = detalle.getTipoProducto().getNombre();
            String cantidadProd = String.valueOf(detalle.getCantidad());
            String precioProd = String.valueOf(detalle.getTipoProducto().getPrecioUnitario());
            
            Label nombreProducto = new Label(producto);
            Label cantidadProductos = new Label(cantidadProd);
            Label precioProducto = new Label(precioProd);
            Label estadoPed = new Label("Confirmado");
            Button botonCancelar = new Button("Cancelar");
            
            botones.add(botonCancelar);
            labelEstado.add(estadoPed);
            labelPrecio.add(precioProducto);
            labelCantidad.add(cantidadProductos);
            
            this.grid.add(nombreProducto, 0 ,i);
            this.grid.add(cantidadProductos, 1 ,i);
            this.grid.add(precioProducto, 2 ,i);
            this.grid.add(botonCancelar, 3 ,i);
            this.grid.add(estadoPed, 4 ,i);
            
            i++;
        }
        
        // (BOTTOM) Creacion de elementos y agregado a caja horizontal
        Button botonCancelarGral = new Button("Cancelar Pedidos");
        Button botonCobrar = new Button("Cobrar");
        Label total = new Label();
        
        float totalPedidos = 0;
        for(DetallePedido detalle : this.presentadorDP.getDetallePedido()) {
            totalPedidos += detalle.calcularTotalDetalle();
        }
        total.setText(String.valueOf(totalPedidos));
        
        caja.getChildren().add(botonCobrar);
        caja.getChildren().add(total);
        caja.getChildren().add(botonCancelarGral);
        
        // (TOP) Creacion de elementos y agregados a posicion
        Label titulo = new Label("COBRO DE PEDIDOS");
        caja2.getChildren().add(titulo);
       
        
        /**
         * ACCION DE BOTONES 
         */
        botonCancelarGral.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            // LLAMAR A OTRA VISTA DEL CONTROLADOR???
            total.setText("0");
            for(Label label : labelEstado) {
                label.setText("Cancelado");
            }
        }
        });
        
        
        botonCobrar.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            // LLAMAR A OTRA VISTA DEL CONTROLADOR???
            List<Integer> banderas = new ArrayList();
            for(int i = 0; i < labelEstado.size(); i++) {
                Label label = labelEstado.get(i);
                if(label.getText().equals("Cancelado") == true) {
                    banderas.add(0);
                }
                else {
                    banderas.add(1);
                }
            }
           
            int cantPedCanc = 0;
            for(int i = 0; i < banderas.size(); i++) {
                if(banderas.get(i) == 0) {
                    cantPedCanc ++;
                }
            }
            
            if(cantPedCanc < 4){
                imprimirFactura(banderas);
            }
            else {
                System.out.println("Todos los pedidos fueron cancelados!");
            }
        }
        });
        
        
        botones.get(0).setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if(labelEstado.get(0).getText().equals("Cancelado") != true) {
                labelEstado.get(0).setText("Cancelado");
                float precioTotal = Float.parseFloat(total.getText());
                float cantProductosACancelar = Float.parseFloat(labelCantidad.get(0).getText());
                float precioProductoACancelar = Float.parseFloat(labelPrecio.get(0).getText());
                float precioFinal = precioTotal - (cantProductosACancelar * precioProductoACancelar);

                String nuevoPrecio = String.valueOf(precioFinal);
                total.setText(nuevoPrecio);
            }
        }
        });
        
        botones.get(1).setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if(labelEstado.get(1).getText().equals("Cancelado") != true) {
                labelEstado.get(1).setText("Cancelado");
                float precioTotal = Float.parseFloat(total.getText());
                float cantProductosACancelar = Float.parseFloat(labelCantidad.get(1).getText());
                float precioProductoACancelar = Float.parseFloat(labelPrecio.get(1).getText());
                float precioFinal = precioTotal - (cantProductosACancelar * precioProductoACancelar);

                String nuevoPrecio = String.valueOf(precioFinal);
                total.setText(nuevoPrecio);
            }
        }
        });
        
        botones.get(2).setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if(labelEstado.get(2).getText().equals("Cancelado") != true) {
                labelEstado.get(2).setText("Cancelado");
                float precioTotal = Float.parseFloat(total.getText());
                float cantProductosACancelar = Float.parseFloat(labelCantidad.get(2).getText());
                float precioProductoACancelar = Float.parseFloat(labelPrecio.get(2).getText());
                float precioFinal = precioTotal - (cantProductosACancelar * precioProductoACancelar);

                String nuevoPrecio = String.valueOf(precioFinal);
                total.setText(nuevoPrecio);
            }
        }
        });
        
        botones.get(3).setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if(labelEstado.get(3).getText().equals("Cancelado") != true) {
                labelEstado.get(3).setText("Cancelado");
                float precioTotal = Float.parseFloat(total.getText());
                float cantProductosACancelar = Float.parseFloat(labelCantidad.get(3).getText());
                float precioProductoACancelar = Float.parseFloat(labelPrecio.get(3).getText());
                float precioFinal = precioTotal - (cantProductosACancelar * precioProductoACancelar);

                String nuevoPrecio = String.valueOf(precioFinal);
                total.setText(nuevoPrecio);
            }
        }
        });
        
        
        
        
        
        /**
         * Seteo de Escena
         */
        this.scene = new Scene(this.panel, 500, 500);
        
    }
    
    @Override
    public Scene getScene() {
        return this.scene;
    }

    public void imprimirFactura(List<Integer> lista){
        ArrayList<DetallePedido> pedidosNoCancelados = new ArrayList(); 
        for(int i = 0; i < this.presentadorDP.getDetallePedido().size(); i++) {
            if(lista.get(i) == 1) {
                DetallePedido pedido = this.presentadorDP.getDetallePedido().get(i);
                pedidosNoCancelados.add(pedido);
            }
        }
        int total = 0;
        for(DetallePedido detalle : pedidosNoCancelados) {
            total += detalle.calcularTotalDetalle();
        }
        System.out.println("");
        System.out.println("*** FACTURA ***");
        System.out.println("Tipo Producto         Precio U          Cantidad");
        for(DetallePedido detalle : pedidosNoCancelados) {
            System.out.println(detalle.getTipoProducto().getNombre() + "            " + 
                    detalle.getTipoProducto().getPrecioUnitario() + "               " + detalle.getCantidad());
        }
        System.out.println("");
        System.out.println("Total a pagar: " + total);
        System.out.println("*** FIN DE FACTURA ***");
    }
    
}
