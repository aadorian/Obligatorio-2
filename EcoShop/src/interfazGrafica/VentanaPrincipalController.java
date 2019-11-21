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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.ENTER;
import javafx.scene.input.KeyEvent;
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
    @FXML
    private ChoiceBox<String> choiceBoxCategoriasABuscar;
    @FXML
    private TextField txtFieldArticuloABuscar;
    @FXML
    private Label cantidadArticulosEnCarrito;
    @FXML
    private JFXButton btnMisFavoritos;
    private boolean estaEnSeccionTodosLosArticulos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        IEcoShop sistemaEcoShop = VentanaFXML.obtenerSistema();
        ArrayList<IArticulo> listaArticulosEnSistema = sistemaEcoShop.obtenerListaArticulos();
        
        cargarItemsArticulos(listaArticulosEnSistema, sistemaEcoShop);
        cargarCategoriasABuscar();
        
        
        cantidadArticulosEnCarrito.setText("");
        estaEnSeccionTodosLosArticulos = true;
    }

    /**
     *
     */
    private void cargarCategoriasABuscar() {
        choiceBoxCategoriasABuscar.getItems().add("Fruta               ");
        choiceBoxCategoriasABuscar.getItems().add("Verdura          ");
        choiceBoxCategoriasABuscar.getItems().add("Fruto Seco      ");
        choiceBoxCategoriasABuscar.getItems().add("Todos             ");

        choiceBoxCategoriasABuscar.setValue("Todos             ");
    }

    /**
     *
     */
    private void cargarItemsArticulos(ArrayList<IArticulo> listaACargar, 
            IEcoShop sistemaEcoShop) {
        Node[] nodos = new Node[listaACargar.size()];

        pnl_scroll.getChildren().clear();

        for (int i = 0; i < nodos.length; i++) {
            try {
                IArticulo articuloTmp = listaACargar.get(i);
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
                iController.cargarEsFavorito(sistemaEcoShop.estaEnFavoritos(articuloTmp));
                iController.setCantidadDeArticulosEnCarrito(cantidadArticulosEnCarrito);
                
                nodos[i] = (Node) root;

                pnl_scroll.getChildren().add(nodos[i]);

            } catch (IOException ex) {
                Logger.getLogger(VentanaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void cargarItemsCarrito() {
        IEcoShop sistemaEcoshop = VentanaFXML.obtenerSistema();
        ICarrito carritoDelSistema = sistemaEcoshop.obtenerCarrito();
        ArrayList<Pair<IArticulo, Double>> listaArticulosEnCarrito;
        ArrayList<IPuntoDeVenta> listaPuntosDeVenta;

        listaArticulosEnCarrito = carritoDelSistema.obtenerListaArticulos();
        listaPuntosDeVenta = sistemaEcoshop.obtenerListaPuntosDeVenta();

        pnl_scroll.getChildren().clear();

        Node[] nodos = new Node[listaArticulosEnCarrito.size()];
        
        //Cargo la barra de comprar
        try {            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BarraComprar.fxml"));
            Parent root = loader.load();
            BarraComprarController iController = loader.<BarraComprarController>getController();
            
            iController.cargarPuntosDeVenta(listaPuntosDeVenta);
            
            Node nodoBarraCargar = (Node) root;
            pnl_scroll.getChildren().add(nodoBarraCargar);
        } 
        catch (IOException ex) {
            Logger.getLogger(VentanaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < nodos.length; i++) {
            try {
                Pair<IArticulo, Double> duplaTmp = listaArticulosEnCarrito.get(i);
                IArticulo articuloTmp = duplaTmp.getKey();
                Double pesoIngresado = duplaTmp.getValue();
                double precioDeSeleccion = articuloTmp.obtenerPrecioPorKG() * pesoIngresado;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ItemCarrito.fxml"));
                Parent root = loader.load();
                ItemCarritoController iController = loader.<ItemCarritoController>getController();

                iController.cargarPanel(pnl_scroll);
                iController.cargarNombreArticulo(articuloTmp.obtenerNombre());
                iController.cargarImagenArticulo(articuloTmp.obtenerRutaDeImagen());
                iController.cargarCantidadYPrecio(pesoIngresado, precioDeSeleccion);
                iController.cargarEnvasesAplicables(articuloTmp.obtenerEnvasesAplicables());
                iController.setCantidadDeArticulosEnCarrito(cantidadArticulosEnCarrito);

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
        IEcoShop sistemaEcoShop = VentanaFXML.obtenerSistema();
        ArrayList<IArticulo> listaArticulosEnSistema = sistemaEcoShop.obtenerListaArticulos();

        cargarItemsArticulos(listaArticulosEnSistema, sistemaEcoShop);
        estaEnSeccionTodosLosArticulos = true;
    }

    @FXML
    private void clickBtnMisCompras(MouseEvent event) {
        refreshItemTicket();
        estaEnSeccionTodosLosArticulos = false;
    }

    @FXML
    private void clickBtnCarrito(ActionEvent event) {
        cargarItemsCarrito();
        estaEnSeccionTodosLosArticulos = false;
    }

    @FXML
    private void clickBtnBuscar(ActionEvent event) {
        if(estaEnSeccionTodosLosArticulos){
            buscarAtriculo();
        }
    }

    @FXML
    private void enterBuscar(KeyEvent event) {
        if(estaEnSeccionTodosLosArticulos){
            switch (event.getCode()) {
                case ENTER:
                    buscarAtriculo();
                default:
                    break;
            }
        }
    }

    private void buscarAtriculo() {
        IEcoShop sistemaEcoShop = VentanaFXML.obtenerSistema();

        String calificadorArticulo = choiceBoxCategoriasABuscar.getValue().trim();
        String articuloABuscar = txtFieldArticuloABuscar.getText().trim();
        ArrayList<IArticulo> articulosQueCoinciden;

        articulosQueCoinciden = sistemaEcoShop.buscarProducto(articuloABuscar,
                calificadorArticulo);

        cargarItemsArticulos(articulosQueCoinciden,sistemaEcoShop);

    }

    @FXML
    private void clickBtnMisFavoritos(MouseEvent event) {
        IEcoShop sistemaEcoShop = VentanaFXML.obtenerSistema();
        ArrayList<IArticulo> listaMisFavoritos = 
                sistemaEcoShop.obtenerListaArticulosFavoritosPersonal();

        cargarItemsArticulos(listaMisFavoritos, sistemaEcoShop);
        estaEnSeccionTodosLosArticulos = false;
    }

}
