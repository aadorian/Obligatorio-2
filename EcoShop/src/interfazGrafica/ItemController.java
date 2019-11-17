/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazGrafica;

import java.net.URL;
import java.util.ResourceBundle;
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
public class ItemController implements Initializable {
    @FXML
    Label nombreArticulo;
    @FXML
    private Label precioArticulo;
    @FXML
    private ImageView imagenArticulo;
    @FXML
    private Label nombreProveedor;
    @FXML
    private Label paisYDepartamentoProveedor;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void cargarImagen(String url){
        Image imagenACargar = new Image(url);
        imagenArticulo.setImage(imagenACargar);
    }
    
    public void cargarNombreArticulo(String nombre){
        nombreArticulo.setText(nombre);
    }
    
    public void cargarPrecioPorKG(double precio){
        String strPrecio = "$ ";
        String precioEnString = String.valueOf(precio);
        String resultante = strPrecio + precioEnString + " x kg";
        
        precioArticulo.setText(resultante);
    }
    
    public void cargarNombreProveedor(String nombre){
        nombreProveedor.setText(nombre);
    }
    
    public void cargarPaisYDepartamentoProveedor(String pais, String departamento){
        paisYDepartamentoProveedor.setText(pais + ", " + departamento);
    }
    
}
