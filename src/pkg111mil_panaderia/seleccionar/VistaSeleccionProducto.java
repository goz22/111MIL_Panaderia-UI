
package pkg111mil_panaderia.seleccionar;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Application; 
import javafx.collections.ObservableList; 
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.geometry.Orientation; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane; 
import javafx.stage.Stage;

import pkg111mil_panaderia.modelo.TipoProducto;
import pkg111mil_panaderia.ui.ContratoControladorVistas;

public class VistaSeleccionProducto implements ContratoVistaSeleccionProducto{
    private PresentadorSeleccionProducto presentador;
    private ContratoControladorVistas controlador;
    
    private Scene escena;
    private StackPane lienzo;

    public VistaSeleccionProducto(ContratoControladorVistas controlador) {
        this.controlador = controlador;
        this.presentador = new PresentadorSeleccionProducto(this);
        this.crearYInicializarObjetosVisuales();
       // this.presentador.iniciar();
    }
    
  
    
   private void crearYInicializarObjetosVisuales() {
      List<TipoProducto> productos = this.presentador.dameLosProductos();
      //Creating an array of Buttons 
       List<Button> botonesProductos = new ArrayList<>();
       for(TipoProducto prod : productos){
           Button boton = new Button(prod.getNombre());
           boton.setOnAction(new EventHandler<ActionEvent>() {

               @Override
               public void handle(ActionEvent event) {
                   controlador.lanzarVistaCantidad(prod);
               }
           });
           botonesProductos.add(boton);
        }
       
       for (int i=0;i<botonesProductos.size();i++){
           System.out.println(getClass().getResource("criollitos.jpg"));
        Image imagen = new Image( getClass().getResource("criollitos.jpg").toExternalForm());
        BackgroundImage backgroundImage = new BackgroundImage( imagen , 
                BackgroundRepeat.NO_REPEAT, 
                BackgroundRepeat.NO_REPEAT, 
                BackgroundPosition.DEFAULT, 
                BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        
       
        //botonesProductos.get(0).setBackground(background);
        botonesProductos.get(i).setStyle("-fx-background-image: url('criollitos.jpg')");
        botonesProductos.get(i).setPrefSize(200,200);
       }
       //Creating a Tile Pane 
           Stage stage=new Stage();

      TilePane tilePane = new TilePane(30.0,30.0);   
      tilePane.setPadding(new Insets(25, 25, 25, 25));
      
      //Setting the orientation for the Tile Pane 
      tilePane.setOrientation(Orientation.HORIZONTAL); 
       
      //Setting the alignment for the Tile Pane 
      tilePane.setTileAlignment(Pos.CENTER_LEFT); 
       
      //Setting the preferred columns for the Tile Pane 
      tilePane.setPrefRows(4);  
      
      //Retrieving the observable list of the Tile Pane 
      ObservableList list = tilePane.getChildren(); 
       
      //Adding the array of buttons to the pane 
      list.addAll(botonesProductos);
	  
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
