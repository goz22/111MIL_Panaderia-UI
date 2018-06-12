/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg111mil_panaderia.ui;

import Cantidad.VistaCantidad;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import Cantidad.PresentadorCantidad;

/**
 *
 * @author steve-urbit
 */
public class UI extends Application implements ContratoControladorVistas{
    private Stage mainStage;
    private VistaCantidad vista = null;
    
    @Override
    public void start(Stage primaryStage) {
        this.mainStage = primaryStage;
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
    
}
