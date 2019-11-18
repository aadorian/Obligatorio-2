/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazGrafica;

import com.jfoenix.controls.JFXButton;
import interfazDominio.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

/**
 * FXML Controller class
 *
 * @author novhm
 */
public class VentanaPrincipalController implements Initializable {
    @FXML
    private VBox pnl_scroll;
    @FXML
    private JFXButton btnTodosLosArticulos;
    @FXML
    private JFXButton btnMisCompras;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cargarItemsTodosLosArticulos();
    }

    /**
     * 
     */
    private void cargarItemsTodosLosArticulos() {
        IEcoShop sistemaEcoshop = VentanaFXML.obtenerSistema();
        ArrayList<IArticulo> listaArticulosSistema = sistemaEcoshop.obtenerListaArticulos();
        
        pnl_scroll.getChildren().clear();

        Node[] nodos = new Node[listaArticulosSistema.size()];

        for (int i = 0; i < nodos.length; i++) {
            try {
                IArticulo articuloTmp = listaArticulosSistema.get(i);
                IProveedor proveedorTmp = articuloTmp.obtenerOrigen();
                IDireccion direccionTmp = proveedorTmp.obtenerDireccion();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ItemArticulo.fxml"));
                Parent root = loader.load();
                ItemArticuloController iController = loader.<ItemArticuloController>getController();

                iController.cargarNombreArticulo(articuloTmp.obtenerNombre());
                iController.cargarPrecioPorKG(articuloTmp.obtenerPrecioPorKG());
                iController.cargarImagen(articuloTmp.obtenerRutaDeImagen());
                iController.cargarNombreProveedor(proveedorTmp.obtenerNombre());
                iController.cargarPaisYDepartamentoProveedor(direccionTmp.obtenerPais(), 
                        direccionTmp.obtenerDepartamento());
                
                nodos[i] = (Node) root;
                
                pnl_scroll.getChildren().add(nodos[i]);
                
            } catch (IOException ex) {
                Logger.getLogger(VentanaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    private void cargarItemsCarrito(){
        IEcoShop sistemaEcoshop = VentanaFXML.obtenerSistema();
        ICarrito carritoDelSistema = sistemaEcoshop.obtenerCarrito();
        ArrayList<Pair<IArticulo, Double>> listaArticulosEnCarrito;
        
        listaArticulosEnCarrito = carritoDelSistema.obtenerListaArticulos();
        
        pnl_scroll.getChildren().clear();

        Node[] nodos = new Node[listaArticulosEnCarrito.size()];
        
        for (int i = 0; i < nodos.length; i++) {
            try{
                Pair<IArticulo, Double> duplaTmp = listaArticulosEnCarrito.get(i);
                IArticulo articuloTmp = duplaTmp.getKey();
                Double pesoIngresado = duplaTmp.getValue();
                double precioDeSeleccion = articuloTmp.obtenerPrecioPorKG() * pesoIngresado;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ItemCarrito.fxml"));
                Parent root = loader.load();
                ItemCarritoController iController = loader.<ItemCarritoController>getController();
                
                iController.cargarNombreArticulo(articuloTmp.obtenerNombre());
                iController.cargarImagenArticulo(articuloTmp.obtenerRutaDeImagen());
                iController.cargarCantidadYPrecio(pesoIngresado, precioDeSeleccion);
                
                nodos[i] = (Node) root;
                
                pnl_scroll.getChildren().add(nodos[i]);
            } 
            catch (IOException ex) {
                Logger.getLogger(VentanaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    //ItemTicket
    private void refreshItemTicket() {
        pnl_scroll.getChildren().clear();

        Node[] nodes = new Node[4];

        for (int i = 0; i < 4; i++) {
            try {
                nodes[i] = (Node) FXMLLoader.load(getClass().getResource("ItemTicket.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                Logger.getLogger(VentanaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    private void clickBtnTodosLosArticulos(MouseEvent event) {
        cargarItemsTodosLosArticulos();
    }

    @FXML
    private void clickBtnMisCompras(MouseEvent event) {
        refreshItemTicket();
    }

    @FXML
    private void clickBtnCarrito(ActionEvent event) {
        cargarItemsCarrito();
    }
    

}
