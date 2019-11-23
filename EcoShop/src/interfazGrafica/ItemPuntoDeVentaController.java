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
public class ItemPuntoDeVentaController implements Initializable {

    @FXML
    private Label labelCalle;
    @FXML
    private Label labelCodigoPostal;
    @FXML
    private Label labelNumeroDeLocal;
    @FXML
    private Label labelBarrio;
    @FXML
    private Label labelDepartamento;
    @FXML
    private ImageView imagenLocal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void cargarCalle(String calle){
        labelCalle.setText(calle);
    }
    
    public void cargarCodigoPostal(int codigoPostal){
        labelCodigoPostal.setText(codigoPostal + "");
    }
    
    public void cargarNumeroDeLocal(int numero){
        String strAMostrar = "Local n° " + numero;
        
        labelNumeroDeLocal.setText(strAMostrar);
    }
    
    public void cargarBarrio(String barrio){
        labelBarrio.setText(barrio);
    }
    
    public void cargarDepartamento(String departamento){
        labelDepartamento.setText(departamento);
    }
    
    public void cargarImagenLocal(String rutaDeImagen){
        Image imagenAColocar = new Image(rutaDeImagen);
        
        imagenLocal.setImage(imagenAColocar);
    }
}
