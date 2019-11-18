/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazGrafica;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author matia
 */
public class ItemCarritoController implements Initializable {

    @FXML
    private Label nombreArticulo;
    @FXML
    private ImageView imagenArticulo;
    @FXML
    private Label cantidadYPrecioArticulo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void cargarNombreArticulo(String nombre){
        nombreArticulo.setText(nombre);
    }
    
    public void cargarImagenArticulo(String url){
        Image imagenACargar = new Image(url);
        imagenArticulo.setImage(imagenACargar);
    }
    
    public void cargarCantidadYPrecio(double cantidad, double precio){
        String strAMostrar = cantidad + " kg - $" + precio;
        
        cantidadYPrecioArticulo.setText(strAMostrar);
    }
    
    @FXML
    private void sacarArticuloDelCarrito(ActionEvent event) {
    }
    
}
