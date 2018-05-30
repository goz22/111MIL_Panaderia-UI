/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg111mil_panaderia.cobrar;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

/**
 *
 * @author utku33
 */
public class VistaCobranza implements ContratoVistaCobranza {
     private Scene scene;
   // private GridPane root;
    private Button mainButton;
    private BorderPane root;
    
    
    private contratoPresentadorCobranza;
    
    @Override
    public Scene getScene() {
       return this.scene;
    }
   
  private void configurarVentanita(){
      root = new BorderPane();
      HBox hbox = addHBox();
      VBox vbox = new VBox();
      root.setCenter(new TilePane());
      root.setLeft (vbox);
      root.setBottom(hbox);
    }
  public HBox addHBox() {
      HBox hbox = new HBox();
      hbox.setPadding (new Insets (15, 12, 15, 12));
      hbox.setSpacing(10);
      hbox.setStyle(null);
      
     Button botonBien = new Button ("Bien");
     botonBien.setPrefSize(10, 20);
     
     
     Button botonCancelar = new Button ("Cancelar");
     botonCancelar.setPrefSize (10, 20);
     hbox.getChildren().addAll(botonBien, botonCancelar);
     return hbox;
    }

    public VBox addVBox() {
      VBox vbox = new VBox();
      vbox.setPadding (new Insets (15, 12, 15, 12));
      vbox.setSpacing(10);
      vbox.setStyle(null);
      
     Button boton5 = new Button ("5");
     boton5.setPrefSize(10, 20);
     Button boton10 = new Button ("10");
     boton10.setPrefSize(10, 20);
     Button boton20 = new Button ("20");
     boton20.setPrefSize(10, 20);
     Button boton50 = new Button ("50");
     boton50.setPrefSize(10, 20);
     Button boton100 = new Button ("100");
     boton100.setPrefSize(10, 20);
     Button boton200 = new Button ("200");
     boton200.setPrefSize(10, 20);
     Button boton500 = new Button ("500");
     boton500.setPrefSize(10, 20);
    vbox.getChildren().addAll(boton5, boton10, boton20, boton50, boton100, boton200, boton500);
    
     return vbox;
    }
 
   
    }
