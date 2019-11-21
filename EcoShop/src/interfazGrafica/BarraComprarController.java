/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazGrafica;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import interfazDominio.IDireccion;
import interfazDominio.IPuntoDeVenta;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author matia
 */
public class BarraComprarController implements Initializable {

    @FXML
    private JFXButton favoritoArticuloBtn;
    @FXML
    private JFXButton btnComprar;
    @FXML
    private ChoiceBox<String> choiceBoxPuntoDeVenta;
    @FXML
    private JFXDatePicker calendario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void cargarPuntosDeVenta(ArrayList<IPuntoDeVenta> listaPuntosDeVenta){
        for (int i = 0; i < listaPuntosDeVenta.size(); i++) {
            IPuntoDeVenta puntoDeVentaTmp = listaPuntosDeVenta.get(i);
            int numeroDeLocal = puntoDeVentaTmp.obtenerNumeroDeLocal();
            IDireccion direccionDelLocal = puntoDeVentaTmp.obtenerDireccionDelLocal();
            String strParaAgregarAChoiceBox = numeroDeLocal + " - " + 
                    direccionDelLocal.obtenerCalle();
            
            choiceBoxPuntoDeVenta.getItems().add(strParaAgregarAChoiceBox);
        }
    }
    
    @FXML
    private void clickBtnFavoritoArticulo(MouseEvent event) {
    }

    @FXML
    private void clickComprar(MouseEvent event) {
    }

    @FXML
    private void clickBtnAgregarAlCarrito(ActionEvent event) {
    }
    
}
