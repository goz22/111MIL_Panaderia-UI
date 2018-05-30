package Cantidad;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import pkg111mil_panaderia.ui.ContratoControladorVistas;
import pkg111mil_panaderia.modelo.TipoProducto;

public class VistaCantidad implements ContratoVistaCantidad{
    
    private ContratoPresentadorCantidad presentador;
    private ContratoControladorVistas controlador;
    
    private Scene scene;
    private GridPane lienzo;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;
    private Button coma;
    private Button ok;
    private Button cancelar;
    private Label textoCantidad;
    private Label textoMonto;
    private float total;
    
    public VistaCantidad(ContratoControladorVistas controlador, TipoProducto producto){
        this.controlador = controlador;
        this.iniciarInterfazGrafica();
        this.presentador = new PresentadorCantidad(this, producto);
        this.presentador.iniciar();
    }
    
    public void iniciarInterfazGrafica(){
        this.lienzo = new GridPane();
        this.lienzo.setAlignment(Pos.CENTER);
        this.lienzo.setHgap(10);
        this.lienzo.setVgap(10);
        this.lienzo.setPadding(new Insets(25, 25, 25, 25));
        
        this.scene = new Scene(this.lienzo, 500, 500);
        btn1 = new Button();
        btn2 = new Button();
        btn3 = new Button();
        btn4 = new Button();
        btn5 = new Button();
        btn6 = new Button();
        btn7 = new Button();
        btn8 = new Button();
        btn9 = new Button();
        btn0 = new Button();
        coma = new Button();
        ok = new Button();
        cancelar = new Button();
        
        btn1.setText("1");
        btn2.setText("2");
        btn3.setText("3");
        btn4.setText("4");
        btn5.setText("5");
        btn6.setText("6");
        btn7.setText("7");
        btn8.setText("8");
        btn9.setText("9");
        btn0.setText("0");
        coma.setText(",");
        ok.setText("ok");
        cancelar.setText("X");
        
        
      /*  lienzo.getChildren().add(btn1);
        lienzo.getChildren().add(btn2);
        lienzo.getChildren().add(btn3);
        lienzo.getChildren().add(btn4);
        lienzo.getChildren().add(btn5);
        lienzo.getChildren().add(btn6);
        lienzo.getChildren().add(btn7);
        lienzo.getChildren().add(btn8);
        lienzo.getChildren().add(btn9);
        lienzo.getChildren().add(btn0);
        lienzo.getChildren().add(ok);
        lienzo.getChildren().add(coma);
        lienzo.getChildren().add(cancelar);
      */  
        textoCantidad = new Label("");
        textoMonto = new Label("0");
        /*
        lienzo.getChildren().add(textoCantidad);
        lienzo.getChildren().add(textoMonto);
       */
       this.lienzo.add(this.textoCantidad, 0, 0, 3, 1);
       this.lienzo.add(this.textoMonto, 2, 1, 3, 2);
       this.lienzo.add(btn1, 0, 3);
       this.lienzo.add(btn2, 1, 3);
       this.lienzo.add(btn3, 2, 3);
       this.lienzo.add(btn4, 0, 4);
       this.lienzo.add(btn5, 1, 4);
       this.lienzo.add(btn6, 2, 4);
       this.lienzo.add(btn7, 0, 5);
       this.lienzo.add(btn8, 1, 5);
       this.lienzo.add(btn9, 2, 5);
       this.lienzo.add(coma, 0, 6);
       this.lienzo.add(btn0, 1, 6);
       this.lienzo.add(ok, 0, 7);
       this.lienzo.add(cancelar, 2, 7);
       
       total = 0;
       
       btn1.setOnAction((ActionEvent event) -> {
           textoCantidad.setText(textoCantidad.getText() + "1");
           total = Integer.parseInt(textoCantidad.getText());
           textoMonto.setText("" + total);
        });
       
       btn2.setOnAction((ActionEvent event) -> {
           textoCantidad.setText(textoCantidad.getText() + "2");
           total = Integer.parseInt(textoCantidad.getText());
           textoMonto.setText("" + total);
        });
       
       btn3.setOnAction((ActionEvent event) -> {
           textoCantidad.setText(textoCantidad.getText() + "3");
           total = Integer.parseInt(textoCantidad.getText());
           textoMonto.setText("" + total);
        });
       
       btn4.setOnAction((ActionEvent event) -> {
           textoCantidad.setText(textoCantidad.getText() + "4");
           total = Integer.parseInt(textoCantidad.getText());
           textoMonto.setText("" + total);
        });
       
       btn5.setOnAction((ActionEvent event) -> {
           textoCantidad.setText(textoCantidad.getText() + "5");
           total = Float.parseFloat(textoCantidad.getText());
           textoMonto.setText("" + total);
        });
       
       btn6.setOnAction((ActionEvent event) -> {
           textoCantidad.setText(textoCantidad.getText() + "6");
           total = Integer.parseInt(textoCantidad.getText());
           textoMonto.setText("" + total);
        });
       
       btn7.setOnAction((ActionEvent event) -> {
           textoCantidad.setText(textoCantidad.getText() + "7");
           total = Integer.parseInt(textoCantidad.getText());
           textoMonto.setText("" + total);
        });
       
       btn8.setOnAction((ActionEvent event) -> {
           textoCantidad.setText(textoCantidad.getText() + "8");
           total = Integer.parseInt(textoCantidad.getText());
           textoMonto.setText("" + total);
        });
       
       btn9.setOnAction((ActionEvent event) -> {
           textoCantidad.setText(textoCantidad.getText() + "9");
           total = Integer.parseInt(textoCantidad.getText());
           textoMonto.setText("" + total);
        });
       
       btn0.setOnAction((ActionEvent event) -> {
           textoCantidad.setText(textoCantidad.getText() + "0");
           total = Integer.parseInt(textoCantidad.getText());
           textoMonto.setText("" + total);
        });
       
       coma.setOnAction((ActionEvent event) -> {
           textoCantidad.setText(textoCantidad.getText() + ".");
        }); 
       
       cancelar.setOnAction((ActionEvent event) -> {
           String textoActual = textoCantidad.getText();
           String nuevoTexto = textoActual.substring(0, textoActual.length() - 1);
           this.textoCantidad.setText(nuevoTexto);
        }); 
    }
    
    private void accionBoton(int numero){
        textoCantidad.setText(textoCantidad.getText() + numero);
        total = Float.parseFloat(textoCantidad.getText());
        textoMonto.setText("" + total);
    }
    
    @Override
    public Scene getScene() {
        return this.scene;
    }
}