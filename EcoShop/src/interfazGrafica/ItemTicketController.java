/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazGrafica;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author matia
 */
public class ItemTicketController implements Initializable {

    @FXML
    private Label compraEnLocal;
    @FXML
    private Label montoDeCompra;
    @FXML
    private Label fechaDeCompra;
    @FXML
    private Label fechaDeRetiro;
    @FXML
    private JFXButton btnDescargarTicket;
    @FXML
    private Label lugarDeRetiro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickBtnDescargarTicket(MouseEvent event) {
    }
    
    public void cargarCompraEnLocal(int numeroDeLocal){
        String strAMostrar = "Compra en local n°" + numeroDeLocal;
        
        compraEnLocal.setText(strAMostrar);
    }
    
    public void cargarMontoDeCompra(double monto){
        String strAMostrar = "$" + monto;
        
        montoDeCompra.setText(strAMostrar);
    }
    
    public void cargarFechaDeCompra(LocalDateTime fecha){
        String strAMostrar = fecha.format(DateTimeFormatter.ISO_DATE);
        
        fechaDeCompra.setText(strAMostrar);
    }
    
    public void cargarFechaDeRetiro(LocalDate fecha){
        String strAMostrar = fecha.format(DateTimeFormatter.ISO_DATE);
        
        fechaDeRetiro.setText(strAMostrar);
    }
    
    public void cargarLugarDeRetiro(String calle){
        lugarDeRetiro.setText(calle);
    }
}
