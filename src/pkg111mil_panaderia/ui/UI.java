/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg111mil_panaderia.ui;

import detalledepedido.VistaDP;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author steve-urbit
 */
public class UI extends Application implements ContratoControladorVistas{
    private Stage mainStage;
    private VistaDP vistaDP = null;
    
    @Override
    public void start(Stage primaryStage) {
        this.mainStage = primaryStage;
        //Lanzar primera vista
        this.lanzarDetallePedido();
        this.mainStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void lanzarDetallePedido() {
        if(this.vistaDP == null){
            this.vistaDP = new VistaDP(this);
        }
        this.mainStage.setScene(this.vistaDP.getScene());
    }
    
}
