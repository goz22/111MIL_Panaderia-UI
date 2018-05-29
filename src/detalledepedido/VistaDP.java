/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detalledepedido;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import pkg111mil_panaderia.modelo.DetallePedido;
import pkg111mil_panaderia.ui.ContratoControladorVistas;

/**
 *
 * @author utku30
 */
public class VistaDP implements ContratoVistaDP{
    private ContratoPresentadorDP presentadorDP;
    private ContratoControladorVistas controlador;
    
    private Scene scene;
    private BorderPane lienzo;
    private Button mainButton;
    private Button eliminarPedido;
    private Button cobrar;
    private Label total;
    private ScrollPane scroll;
    private ListView lista;
    
    public VistaDP(ContratoControladorVistas controlador) {
        this.controlador = controlador;
        this.setupGraphicObjects();
        this.presentadorDP = new PresentadorDP(this);
        this.presentadorDP.iniciar();
    }
    
    private void setupGraphicObjects(){
        this.lienzo = new BorderPane();
        this.scene = new Scene(this.lienzo,800, 800);
        /*
        this.mainButton = new Button();
        mainButton.setText("SECONDARY BUTTON");
        mainButton.setOnAction((ActionEvent event) -> {
            System.out.println("SECONDDDDDD VIEW!!");
            this.presentadorDP.mainButtonPressed();
        });
        this.lienzo.getChildren().add(this.mainButton);
        */
        
        this.lista = new ListView<DetallePedido>();
        lista.setPrefWidth(150);
        lista.setPrefHeight(150);

        // 
        this.lista.setCellFactory(new Callback<ListView<DetallePedido>, ListCell<DetallePedido>>() {

              public ListCell<DetallePedido> call(ListView<DetallePedido> param) {
                final Label leadLbl = new Label();
                final Label leadLb2 = new Label();
                final Label leadLb3 = new Label();
                final Button botonCancelar = new Button();
                
                final ListCell<DetallePedido> cell = new ListCell<DetallePedido>() {
                  @Override
                  public void updateItem(DetallePedido item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null) {
                      leadLbl.setText(item.getTipoProducto().getNombre());
                      leadLb2.setText(String.valueOf(item.getCantidad()));
                      leadLb2.setText(String.valueOf(item.getTipoProducto().getPrecioUnitario()));
                      botonCancelar.setText("Cancelar");
                    }
                  }
                }; // ListCell
                return cell;
              }
            }); // setCellFactory

        //gridpane.add(leaderListView, 0, 1);

        
        
        
        
    }
    
    @Override
    public void changeButtonToBlue(){
         this.mainButton.setStyle("-fx-background-color: #00ff88");
    }
    

    @Override
    public Scene getScene() {
        return this.scene;
    }

}
