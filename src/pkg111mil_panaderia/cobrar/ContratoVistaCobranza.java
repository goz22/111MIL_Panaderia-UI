/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg111mil_panaderia.cobrar;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pkg111mil_panaderia.modelo.Dinero;

/**
 *
 * @author utku33
 */
public interface ContratoVistaCobranza {
    public Scene getScene();
    public HBox addHBox();
    public VBox addVBox();
    public void agregarBillete (Dinero billete);
    public void aceptarCobranza ();
    public void cancelarCobranza();
    
}
