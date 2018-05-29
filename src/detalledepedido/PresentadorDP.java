/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detalledepedido;

/**
 *
 * @author utku30
 */
public class PresentadorDP implements ContratoPresentadorDP {
     private ContratoVistaDP vista;
    
    public PresentadorDP(ContratoVistaDP vista) {
        this.vista = vista;
    }

    @Override
    public void iniciar() {
        this.vista.changeButtonToBlue();
    }

    @Override
    public void mainButtonPressed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
