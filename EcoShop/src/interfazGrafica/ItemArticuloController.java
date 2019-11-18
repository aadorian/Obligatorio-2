/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazGrafica;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Alert;
import interfazDominio.IEcoShop;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author matia
 */
public class ItemArticuloController implements Initializable {
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
    @FXML
    private TextField textFieldPeso;

    
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

    @FXML
    private void clickBtnAgregarAlCarrito(ActionEvent event) {
        IEcoShop sistemaEcoShop = VentanaFXML.obtenerSistema();
        String pesoIngresado = textFieldPeso.getText();
        String digitos = "[0-9]+";
        
        if(pesoIngresado.trim().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR, "No ingreso la cantidad a llevar");
            alert.showAndWait();
        }
        else if(!pesoIngresado.matches(digitos)){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Peso inválido (solo números)");
            alert.showAndWait();
        }
        else{
            double pesoSeleccionado = Double.parseDouble(pesoIngresado);
            sistemaEcoShop.agregarAlCarrito(sistemaEcoShop.
                    obtenerArticuloPorNombre(nombreArticulo.getText()), pesoSeleccionado);
            textFieldPeso.setText("");
        }
    }
    
}
