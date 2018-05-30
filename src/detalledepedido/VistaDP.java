/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detalledepedido;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
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
    private BorderPane lienzo;
    private Button eliminarPedido;
    private Button cobrar;
    private Label total;
    private ScrollPane scroll;
    private ListView<DetallePedido> lista;
    private ArrayList<DetallePedido> detalles;
    
    
    public VistaDP(ContratoControladorVistas controlador) {
        this.controlador = controlador;
        this.iniciarGrafica();
        this.presentadorDP = new PresentadorDP(this);
        this.presentadorDP.iniciar();
    }
    
    
    private void iniciarGrafica(){
        this.lienzo = new BorderPane();
        this.scene = new Scene(this.lienzo, 800, 800);
        
        this.lista = new ListView();
        /*
        for(DetallePedido detalle: this.presentadorDP.getDetallePedido()) {
            this.lista.getItems().add(detalle);
        }
        */
        this.detalles = this.presentadorDP.getDetallePedido();
        System.out.println(detalles.size());
        
        // 
        this.lista.setCellFactory(new Callback<ListView<DetallePedido>, ListCell<DetallePedido>>() {

              @Override
              public ListCell<DetallePedido> call(ListView<DetallePedido> param) {
                final Label nombreProducto = new Label();
                final Label cantidadProductos = new Label();
                final Label precioProducto = new Label();
                final Button botonCancelar = new Button();
                
                final ListCell<DetallePedido> cell = new ListCell<DetallePedido>() {
                  @Override
                  public void updateItem(DetallePedido item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null) {
                      nombreProducto.setText(item.getTipoProducto().getNombre());
                      cantidadProductos.setText(String.valueOf(item.getCantidad()));
                      precioProducto.setText(String.valueOf(item.getTipoProducto().getPrecioUnitario()));
                      botonCancelar.setText("Cancelar");
                    }
                  }
                };
                return cell;
              }
            });

    }
    
    @Override
    public Scene getScene() {
        return this.scene;
    }

}
