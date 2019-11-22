/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazGrafica;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import interfazDominio.ICarrito;
import interfazDominio.IDireccion;
import interfazDominio.IEcoShop;
import interfazDominio.IPreVenta;
import dominio.*;
import interfazDominio.IPuntoDeVenta;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author matia
 */
public class BarraComprarController implements Initializable {
    @FXML
    private VBox pnl_scroll;
    @FXML
    private Label cantidadArticulosEnCarrito;
    @FXML
    private JFXButton favoritoArticuloBtn;
    @FXML
    private JFXButton btnComprar;
    @FXML
    private ChoiceBox<String> choiceBoxPuntoDeVenta;
    @FXML
    private JFXDatePicker calendario;
    @FXML
    private Label labelCompraExitosa;
    @FXML
    private Label labelFechaInvalida;
    @FXML
    private Label labelLocalInvalido;
    @FXML
    private Label labelEnvasesInvalidos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ponerTodosLosLabelVacios();
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
        IEcoShop sistemaEcoShop = VentanaFXML.obtenerSistema();
        ICarrito carritoSistema = sistemaEcoShop.obtenerCarrito();
        LocalDate fechaIngresada = calendario.getValue();
        LocalDate diaDeHoy = LocalDate.now();
        
        if(!carritoSistema.todosLosArticulosEnElCarritoTienenEnvaseAsociado()){
            ponerTodosLosLabelVacios();
            labelEnvasesInvalidos.setText("Seleccione un envase para cada artículo");
        }
        else if(fechaIngresada == null){
            ponerTodosLosLabelVacios();
            labelFechaInvalida.setText("Fecha inválida");
        }
        else if(fechaIngresada.isBefore(diaDeHoy)){
            ponerTodosLosLabelVacios();
            labelFechaInvalida.setText("Fecha inválida");
        }
        else if(choiceBoxPuntoDeVenta.getSelectionModel().isEmpty()){
            ponerTodosLosLabelVacios();
            labelLocalInvalido.setText("Seleccione un local");
        }
        else{
            String strLocalElegido;
            String strNumeroDelLocalElegido;
            int numeroLocalElegido;
            IPuntoDeVenta localElegido;
            double precioTotalDeLaCompra;
            LocalDateTime fechaDeCompra;
            IPreVenta nuevaPreVenta;
            
            strLocalElegido = choiceBoxPuntoDeVenta.getValue();
            strNumeroDelLocalElegido = strLocalElegido.split(" - ")[0];
            numeroLocalElegido = Integer.parseInt(strNumeroDelLocalElegido);
            localElegido = sistemaEcoShop.
                    obtenerPuntoDeVentaPorNumeroDeLocal(numeroLocalElegido);
            precioTotalDeLaCompra = carritoSistema.obtenerPrecioTotal();
            fechaDeCompra = LocalDateTime.now();
            
            nuevaPreVenta = new PreVenta(carritoSistema, localElegido, 
                    fechaDeCompra, precioTotalDeLaCompra, fechaIngresada);
            
            sistemaEcoShop.registrarPreVenta(nuevaPreVenta);
            sistemaEcoShop.generarTicket(nuevaPreVenta);
            
            //Label compra exitosa
            ponerTodosLosLabelVacios();
            labelCompraExitosa.setText("La compra se ha realizado exitosamente");
            
            vaciarPanel();
            vaciarLabelCantidadItemsEnCarrito();
        }
        
    }

    @FXML
    private void clickBtnAgregarAlCarrito(ActionEvent event) {
    }
    
    private void ponerTodosLosLabelVacios(){
        labelCompraExitosa.setText("");
        labelFechaInvalida.setText("");
        labelLocalInvalido.setText("");
        labelEnvasesInvalidos.setText("");
    }
    
    private void vaciarLabelCantidadItemsEnCarrito(){
        cantidadArticulosEnCarrito.setText("");
    }
    
    private void vaciarPanel(){
        Node barraComprar = pnl_scroll.getChildren().get(0);
        
        pnl_scroll.getChildren().clear();
        pnl_scroll.getChildren().add(barraComprar);
    }
    
    public void cargarLabelCantidadItemsEnCarrito(Label unLabel){
        this.cantidadArticulosEnCarrito = unLabel;
    }
    
    public void cargarPanel(VBox unPanel){
        this.pnl_scroll = unPanel;
    }
}
