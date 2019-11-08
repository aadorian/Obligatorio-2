/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazGrafica;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import dominio.*;
/**
 * FXML Controller class
 *
 * @author Marcos Novelli - Matias Salles
 */
public class VentanaMenúPrincipalController implements Initializable {
    private EcoShop ejemplo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ejemplo = new EcoShop();
    }    
    
}
