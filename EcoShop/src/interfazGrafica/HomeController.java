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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author novhm
 */
public class HomeController implements Initializable {
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
        refreshItem();
    }

    //Item
    private void refreshItem() {
        IEcoShop sistemaEcoshop = VentanaMenuPrincipal.obtenerSistema();
        ArrayList<IArticulo> listaArticulosSistema = sistemaEcoshop.obtenerListaArticulos();
        
        pnl_scroll.getChildren().clear();

        Node[] nodes = new Node[15];

        for (int i = 0; i < listaArticulosSistema.size(); i++) {
            try {
                IArticulo articuloTmp = listaArticulosSistema.get(i);
                IProveedor proveedorTmp = articuloTmp.obtenerOrigen();
                IDireccion direccionTmp = proveedorTmp.obtenerDireccion();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Item.fxml"));
                Parent root = loader.load();
                ItemController iController = loader.<ItemController>getController();

                iController.cargarNombreArticulo(articuloTmp.obtenerNombre());
                iController.cargarPrecioPorKG(articuloTmp.obtenerPrecioPorKG());
                iController.cargarImagen(articuloTmp.obtenerRutaDeImagen());
                iController.cargarNombreProveedor(proveedorTmp.obtenerNombre());
                iController.cargarPaisYDepartamentoProveedor(direccionTmp.obtenerPais(), 
                        direccionTmp.obtenerDepartamento());
                
                nodes[i] = (Node) root;
                
                pnl_scroll.getChildren().add(nodes[i]);
                
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    private void clickBtnTodosLosArticulos(MouseEvent event) {
        refreshItem();
    }

    @FXML
    private void clickBtnMisCompras(MouseEvent event) {
        refreshItemTicket();
    }
    

}
