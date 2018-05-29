
package pkg111mil_panaderia.seleccionar;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application; 
import javafx.collections.ObservableList; 
import javafx.geometry.Orientation; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane; 
import javafx.stage.Stage;
import pkg111mil_panaderia.modelo.TipoProducto;

public class VistaSeleccionProducto implements ContratoVistaSeleccionProducto{
    private ContratoPresentadorSeleccionProducto presentador;
    private ContratoControladorVistas controlador;
    
    private Scene escena;
    private StackPane lienzo;

    public VistaSeleccionProducto(ContratoControladorVistas controlador) {
        this.controlador = controlador;
        this.presentador = new PresentadorSeleccionProducto(this);
        this.crearYInicializarObjetosVisuales();
        this.presentador.iniciar();
    }
    
    
    
   private void crearYInicializarObjetosVisuales() {
       List<TipoProducto> productos = this.presentador.dameLosProductos();
      //Creating an array of Buttons 
       List<Button> botonesProductos = new ArrayList<>();
       for(TipoProducto prod : productos){
           Button boton = new Button(prod.getNombre());
           boton.
           botonesProductos.add(boton);
       }
      
      //Creating a Tile Pane 
      TilePane tilePane = new TilePane();   
       
      //Setting the orientation for the Tile Pane 
      tilePane.setOrientation(Orientation.HORIZONTAL); 
       
      //Setting the alignment for the Tile Pane 
      tilePane.setTileAlignment(Pos.CENTER_LEFT); 
       
      //Setting the preferred columns for the Tile Pane 
      tilePane.setPrefRows(4);  
      
      //Retrieving the observable list of the Tile Pane 
      ObservableList list = tilePane.getChildren(); 
       
      //Adding the array of buttons to the pane 
      list.addAll(buttons);
	  
      //Creating a scene object 
      Scene scene = new Scene(tilePane);  
      
      //Setting title to the Stage 
      stage.setTitle("Tile Pane Example"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show(); 
   } 
}
