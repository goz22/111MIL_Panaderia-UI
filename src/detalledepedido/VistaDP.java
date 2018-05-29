/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detalledepedido;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import pkg111mil_panaderia.ui.ContratoControladorVistas;

/**
 *
 * @author utku30
 */
public class VistaDP implements ContratoVistaDP{
    private ContratoPresentadorDP presentadorDP;
    private ContratoControladorVistas controlador;
    
    private Scene scene;
    private StackPane root;
    private Button mainButton;
    
    public VistaDP(ContratoControladorVistas controlador) {
        this.controlador = controlador;
        this.setupGraphicObjects();
        this.presentadorDP = new PresentadorDP(this);
        this.presentadorDP.iniciar();
    }
    
    private void setupGraphicObjects(){
        this.root = new StackPane();
        this.scene = new Scene(this.root,600, 600);
        this.mainButton = new Button();
        mainButton.setText("SECONDARY BUTTON");
        mainButton.setOnAction((ActionEvent event) -> {
            System.out.println("SECONDDDDDD VIEW!!");
            this.presentadorDP.mainButtonPressed();
        });
        this.root.getChildren().add(this.mainButton);
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
