package interfazGrafica;

import com.jfoenix.controls.JFXButton;
import interfazDominio.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.ENTER;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

/**
 * VentanaPrincipalController
 *
 * @author Marcos Novelli - Matias Salles
 */
public class VentanaPrincipalController implements Initializable {
    //Atributos
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
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private JFXButton btnFavoritosGlobal;
    @FXML
    private Label labelSeccionActiva;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Var
        IEcoShop sistemaEcoShop = VentanaFXML.obtenerSistema();
        ArrayList<IArticulo> listaArticulosEnSistema = sistemaEcoShop.obtenerListaArticulos();
        
        //Como seccion principal cargamos todos los articulos
        cargarItemsArticulos(listaArticulosEnSistema, sistemaEcoShop);
        cargarCategoriasABuscar();
        
        labelSeccionActiva.setText("Todos los artículos");
        cantidadArticulosEnCarrito.setText("");
        estaEnSeccionTodosLosArticulos = true;
    }

    //
    //METODOS PRIVADOS
    //
    
    private void cargarCategoriasABuscar() {
        choiceBoxCategoriasABuscar.getItems().add("Fruta               ");
        choiceBoxCategoriasABuscar.getItems().add("Verdura          ");
        choiceBoxCategoriasABuscar.getItems().add("Fruto Seco      ");
        choiceBoxCategoriasABuscar.getItems().add("Todos             ");

        choiceBoxCategoriasABuscar.setValue("Todos             ");
    }


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
                iController.cargarEsFavorito(sistemaEcoShop.estaEnFavoritosPersonal(articuloTmp));
                iController.cargarCantidadDeArticulosEnCarrito(cantidadArticulosEnCarrito);
                
                nodos[i] = (Node) root;

                pnl_scroll.getChildren().add(nodos[i]);

            } catch (IOException ex) {
                Logger.getLogger(VentanaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        scrollPane.setVvalue(0); //Pone el scroll panel al principio
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
            iController.cargarLabelCantidadItemsEnCarrito(cantidadArticulosEnCarrito);
            iController.cargarPanel(pnl_scroll);
            
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
                iController.cargarCantidadDeArticulosEnCarrito(cantidadArticulosEnCarrito);
                
                if(carritoDelSistema.articuloTieneEnvaseAsociado(articuloTmp))
                    iController.cargarEnvaseSeleccionado(carritoDelSistema.
                        obtenerEnvaseAsociadoAlArticulo(articuloTmp));

                nodos[i] = (Node) root;
                pnl_scroll.getChildren().add(nodos[i]);
            } 
            catch (IOException ex) {
                Logger.getLogger(VentanaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        scrollPane.setVvalue(0); //Pone el scroll panel al principio
    }

    private void cargarItemsTickets() {
        IEcoShop sistemaEcoshop = VentanaFXML.obtenerSistema();
        ArrayList<ITicketPreVenta> listaTicketsPreVentas = 
                sistemaEcoshop.obtenerTicketsPreVenta();
        
        pnl_scroll.getChildren().clear();

        Node[] nodos = new Node[listaTicketsPreVentas.size()];

        for (int i = 0; i < nodos.length; i++) {
            try {
                ITicketPreVenta ticketPreVentaTmp = listaTicketsPreVentas.get(i);
                IPreVenta preVentaTmp = ticketPreVentaTmp.obtenerPreVentaAsociada();
                LocalDate fechaDeRetiro = preVentaTmp.obtenerFechaDeRetiro();
                IPuntoDeVenta localDeVenta = preVentaTmp.obtenerLocalDeRetiro();
                LocalDateTime fechaDeVenta = preVentaTmp.obtenerFechaDeCompraRealizada();
                double precioTotal = preVentaTmp.obtenerPrecioTotalDeCompra();
                int numeroTicket = ticketPreVentaTmp.obtenerNumeroDeTicket();
                ArrayList<String> ticketPDF = ticketPreVentaTmp.obtenerContenidoTicketPDF();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ItemTicket.fxml"));
                Parent root = loader.load();
                ItemTicketController iController = loader.<ItemTicketController>getController();
                
                iController.cargarCompraEnLocal(localDeVenta.obtenerNumeroDeLocal());
                iController.cargarFechaDeCompra(fechaDeVenta);
                iController.cargarMontoDeCompra(precioTotal);
                iController.cargarFechaDeRetiro(fechaDeRetiro);
                iController.cargarNumeroDeticket(numeroTicket);
                iController.cargarTicketPDF(ticketPDF);
                iController.cargarLugarDeRetiro(localDeVenta.
                        obtenerDireccionDelLocal().obtenerCalle());
                
                nodos[i] = (Node) root;
                pnl_scroll.getChildren().add(nodos[i]);

            } catch (IOException ex) {
                Logger.getLogger(VentanaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        scrollPane.setVvalue(0);
        estaEnSeccionTodosLosArticulos = false;
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
    
    //
    //EVENTOS
    //
    
    @FXML
    private void clickBtnTodosLosArticulos(MouseEvent event) {
        IEcoShop sistemaEcoShop = VentanaFXML.obtenerSistema();
        ArrayList<IArticulo> listaArticulosEnSistema = sistemaEcoShop.obtenerListaArticulos();

        labelSeccionActiva.setText("Todos los artículos");
        cargarItemsArticulos(listaArticulosEnSistema, sistemaEcoShop);
        estaEnSeccionTodosLosArticulos = true;
    }

    @FXML
    private void clickBtnMisCompras(MouseEvent event) {
        labelSeccionActiva.setText("Mis Compras");
        cargarItemsTickets();
        estaEnSeccionTodosLosArticulos = false;
    }

    @FXML
    private void clickBtnCarrito(ActionEvent event) {
        labelSeccionActiva.setText("Carrito");
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

    @FXML
    private void clickBtnMisFavoritos(MouseEvent event) {
        IEcoShop sistemaEcoShop = VentanaFXML.obtenerSistema();
        ArrayList<IArticulo> listaMisFavoritos = 
                sistemaEcoShop.obtenerListaArticulosFavoritosPersonal();

        labelSeccionActiva.setText("Mis favoritos (agrega o elimina artículos "
                + "a tu lista de favoritos presionando la estrella arriba a la "
                + "derecha de cada articulo)");
        cargarItemsArticulos(listaMisFavoritos, sistemaEcoShop);
        estaEnSeccionTodosLosArticulos = false;
    }

    @FXML
    private void clickBtnFavoritosGlobal(MouseEvent event) {
        IEcoShop sistemaEcoShop = VentanaFXML.obtenerSistema();
        ArrayList<IArticulo> listaFavoritosGlobal = 
                sistemaEcoShop.obtenerListaArticulosFavoritosGlobal();
        
        labelSeccionActiva.setText("Favoritos en el mundo");
        cargarItemsArticulos(listaFavoritosGlobal, sistemaEcoShop);
        estaEnSeccionTodosLosArticulos = false;
    }

    @FXML
    private void clickBtnPuntosDeVenta(MouseEvent event) {
        IEcoShop sistemaEcoShop = VentanaFXML.obtenerSistema();
        ArrayList<IPuntoDeVenta> listaPuntosDeVenta = sistemaEcoShop.obtenerListaPuntosDeVenta();
        
        pnl_scroll.getChildren().clear();

        Node[] nodos = new Node[listaPuntosDeVenta.size()];
        
        for (int i = 0; i < nodos.length; i++) {
            try{
                IPuntoDeVenta puntoDeVentaTmp = listaPuntosDeVenta.get(i);
                IDireccion direccionTmp = puntoDeVentaTmp.obtenerDireccionDelLocal();
                int numeroDeLocalTmp = puntoDeVentaTmp.obtenerNumeroDeLocal();
                String departamento = direccionTmp.obtenerDepartamento();
                String barrio = direccionTmp.obtenerBarrio();
                String calle = direccionTmp.obtenerCalle();
                int codigoPostal = direccionTmp.obtenerCodigoPostal();
                String rutaDeImagenLocal = puntoDeVentaTmp.obtenerRutaDeImagen();
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ItemPuntoDeVenta.fxml"));
                Parent root = loader.load();
                ItemPuntoDeVentaController iController = loader.<ItemPuntoDeVentaController>getController();
                
                iController.cargarBarrio(barrio);
                iController.cargarCalle(calle);
                iController.cargarCodigoPostal(codigoPostal);
                iController.cargarDepartamento(departamento);
                iController.cargarNumeroDeLocal(numeroDeLocalTmp);
                iController.cargarImagenLocal(rutaDeImagenLocal);
                
                nodos[i] = (Node) root;
                pnl_scroll.getChildren().add(nodos[i]);
            }
            catch(IOException e){
                Logger.getLogger(VentanaPrincipalController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        scrollPane.setVvalue(0);
        estaEnSeccionTodosLosArticulos = false;
        
        int cantidadEnvasesReutilizados = sistemaEcoShop.cantidadDeEnvasesReutilizados();
        labelSeccionActiva.setText("Puntos de venta - realize su compra aquí "
                + "o ven a visitarnos, ya evitamos más de " + cantidadEnvasesReutilizados
                + " bolsas contaminando el medio ambiente. ¡Sumate!");
    }

    @FXML
    private void clickBtnMasVendidos(MouseEvent event) {
        IEcoShop sistemaEcoShop = VentanaFXML.obtenerSistema();
        ArrayList<IArticulo> listaMasVendidos = sistemaEcoShop.obtenerArticulosMasVendidos();
        
        labelSeccionActiva.setText("Artículos mas vendidos");
        cargarItemsArticulos(listaMasVendidos, sistemaEcoShop);
        estaEnSeccionTodosLosArticulos = false;
    }

}
