/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg111mil_panaderia.cobrar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import pkg111mil_panaderia.modelo.Dinero;
import pkg111mil_panaderia.modelo.TipoDinero;

/**
 *
 * @author utku33
 */
public class VistaCobranza implements ContratoVistaCobranza {
     private Scene scene;
   // private GridPane root;
    private BorderPane root;
    private TilePane lienzoEfectivo;
    private ContratoPresentadorCobranza presentador;
    
    public VistaCobranza(){
        this.configurarVentanita();
        this.presentador = new PresentadorCobranza(this);
    }
    
    @Override
    public Scene getScene() {
       return this.scene;
    }
   
  private void configurarVentanita(){
      root = new BorderPane();
      HBox hbox = addHBox();
      VBox vbox = addVBox();
      //Inicia el Lienzo de billetes seleccionados
      //Cada fila mostrara un maximo de 4 billetes.
      this.lienzoEfectivo = new TilePane();
      this.lienzoEfectivo.setHgap(60);
      this.lienzoEfectivo.setPrefColumns(4);
      
      root.setCenter(this.lienzoEfectivo);
      root.setLeft (vbox);
      root.setBottom(hbox);
      this.scene = new Scene(this.root,500, 500);
    }
     @Override
  public HBox addHBox() {
      HBox hbox = new HBox();
      hbox.setPadding (new Insets (15, 12, 15, 12));
      hbox.setSpacing(10);
      hbox.setStyle("-fx-background-color: #999999");
      
     Button botonBien = new Button ("Cobrar");
     botonBien.setPrefSize(100, 50);
     botonBien.setStyle("-fx-background-color: #008000");
     
     
     Button botonCancelar = new Button ("Cancelar");
     botonCancelar.setPrefSize (100, 50);
     botonCancelar.setStyle("-fx-background-color: #FF0000");
      botonCancelar.setOnAction(new EventHandler<ActionEvent>() {

          @Override
          public void handle(ActionEvent event) {
              presentador.botonCancelarCobranza();
          
          }
      });
     hbox.getChildren().addAll(botonBien, botonCancelar);
     return hbox;
    }

     @Override
    public VBox addVBox() {
      VBox vbox = new VBox();
      vbox.setPadding (new Insets (15, 12, 15, 12));
      vbox.setSpacing(10);
      vbox.setStyle(null);
     Button botonVeinticinco = new Button ("$0.25");
     botonVeinticinco.setPrefSize (80, 80);
     botonVeinticinco.setOnAction(new EventHandler<ActionEvent>() {

          @Override
          public void handle(ActionEvent event) {
              presentador.billeteElegido(new Dinero(0.25f, TipoDinero.MONEDA));
          }
      });
     Button botonCincuenta = new Button ("$0.50");
     botonCincuenta.setPrefSize(80, 80);
     botonCincuenta.setOnAction(new EventHandler<ActionEvent>() {

          @Override
          public void handle(ActionEvent event) {
              presentador.billeteElegido(new Dinero(0.50f, TipoDinero.MONEDA));
          }
      });
     Button boton1 = new Button ("$1");
     boton1.setPrefSize(80, 80);
     boton1.setOnAction(new EventHandler<ActionEvent>() {

          @Override
          public void handle(ActionEvent event) {
              presentador.billeteElegido(new Dinero(1.0f, TipoDinero.MONEDA));
          }
      });
     Button boton2 = new Button ("$2");
     boton2.setPrefSize (80, 80);
     boton2.setOnAction(new EventHandler<ActionEvent>() {

          @Override
          public void handle(ActionEvent event) {
              presentador.billeteElegido(new Dinero(2.0f, TipoDinero.MONEDA));
          }
      });
     Button boton5 = new Button ("$5");
     boton5.setPrefSize(80, 80);
     boton5.setOnAction(new EventHandler<ActionEvent>() {

          @Override
          public void handle(ActionEvent event) {
              presentador.billeteElegido(new Dinero(5.0f, TipoDinero.BILLETE));
          }
      });
     Button boton10 = new Button ("$10");
     boton10.setPrefSize(80, 80);
     boton10.setOnAction(new EventHandler<ActionEvent>() {

          @Override
          public void handle(ActionEvent event) {
              presentador.billeteElegido(new Dinero(10.0f, TipoDinero.BILLETE));
          }
      });
     Button boton20 = new Button ("$20");
     boton20.setPrefSize(80, 80);
     boton20.setOnAction(new EventHandler<ActionEvent>() {

          @Override
          public void handle(ActionEvent event) {
              presentador.billeteElegido(new Dinero(20.0f, TipoDinero.BILLETE));
          }
      });
     Button boton50 = new Button ("$50");
     boton50.setPrefSize(80, 80);
       boton50.setOnAction(new EventHandler<ActionEvent>() {

          @Override
          public void handle(ActionEvent event) {
              presentador.billeteElegido(new Dinero(50.0f, TipoDinero.BILLETE));
          }
      });
     Button boton100 = new Button ("$100");
     boton100.setPrefSize(80, 80);
       boton100.setOnAction(new EventHandler<ActionEvent>() {

          @Override
          public void handle(ActionEvent event) {
              presentador.billeteElegido(new Dinero(100.0f, TipoDinero.BILLETE));
          }
      });
     Button boton200 = new Button ("$200");
     boton200.setPrefSize(80, 80);
     boton200.setOnAction(new EventHandler<ActionEvent>() {

          @Override
          public void handle(ActionEvent event) {
              presentador.billeteElegido(new Dinero(200.0f, TipoDinero.BILLETE));
          }
      });
     Button boton500 = new Button ("$500");
     boton500.setPrefSize(80, 80);
     boton500.setOnAction(new EventHandler<ActionEvent>() {

          @Override
          public void handle(ActionEvent event) {
              presentador.billeteElegido(new Dinero(500.0f, TipoDinero.BILLETE));
          }
      });
    vbox.getChildren().addAll(botonVeinticinco, botonCincuenta, boton1, boton2, boton5, boton10, boton20, boton50, boton100, boton200, boton500);
    
     return vbox;
    }
    
    @Override 
    public void agregarBillete (Dinero billete) {
        Text textoBillete = new Text("$ " + billete.getDenominacion());
        this.lienzoEfectivo.getChildren().add(textoBillete);
       
    }
    
    @Override  
    public void aceptarCobranza (){
        //Falta que termine de definirse la funcionalidad Vuelto.
    }
    
    @Override
    public void cancelarCobranza(){
        this.lienzoEfectivo.getChildren().clear();
       
        
    }
             
   
    }
