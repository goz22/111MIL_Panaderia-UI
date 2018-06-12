/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg111mil_panaderia.ui;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import pkg111mil_panaderia.modelo.TipoProducto;
import pkg111mil_panaderia.seleccionar.VistaSeleccionProducto;
import pkg111mil_panaderia.cantidad.VistaCantidad;
import pkg111mil_panaderia.cobrar.VistaCobranza;

/**
 *
 * @author steve-urbit
 */
public class UI extends Application implements ContratoControladorVistas{
    private Stage mainStage;
    private VistaCobranza vistaConbranza = new VistaCobranza();
    private VistaCantidad vista = null;
    
    @Override
    public void start(Stage primaryStage) {
       VistaSeleccionProducto vista1 = new VistaSeleccionProducto(this);
        this.mainStage = primaryStage;
        this.launchVistaCobranza();
        //vista = new VistaCantidad(this);
       //Stage cantidadStage = new Stage();
        primaryStage.setScene(vista.getScene());
       // primaryStage.show();
        this.mainStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
        
    }
    
    @Override
    public void launchVistaCobranza() {
        if(this.vistaConbranza == null){
            this.vistaConbranza = new VistaCobranza();
        }
        this.mainStage.setScene(this.vistaConbranza.getScene());
    }

    @Override
    public void lanzarVistaCantidad(TipoProducto productoSeleccionado) {
        
    }
    
}
