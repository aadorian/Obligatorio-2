package interfazGrafica;

import com.jfoenix.controls.JFXComboBox;
import interfazDominio.IArticulo;
import interfazDominio.ICarrito;
import interfazDominio.IEcoShop;
import interfazDominio.IEnvase;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

/**
 * FXML Controller class
 *
 * @author matia
 */
public class ItemCarritoController implements Initializable {

    private VBox pnl_scroll;
    @FXML
    private Label nombreArticulo;
    @FXML
    private ImageView imagenArticulo;
    @FXML
    private Label cantidadArticulo;
    @FXML
    private Label precioArticulo;
    @FXML
    private JFXComboBox<String> comboBoxEnvases;

    Label cantidadArticulosEnCarrito;
    @FXML
    private ImageView imagenEnvase;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO HERE
    }

    public void cargarPanel(VBox unPanel) {
        this.pnl_scroll = unPanel;
    }

    public void cargarNombreArticulo(String nombre) {
        nombreArticulo.setText(nombre);
    }

    public void cargarImagenArticulo(String url) {
        Image imagenACargar = new Image(url);
        imagenArticulo.setImage(imagenACargar);
    }

    public void cargarCantidadYPrecio(double cantidad, double precio) {
        String strCantidad = cantidad + " kg";
        String strPrecio = "$ " + precio;

        cantidadArticulo.setText(strCantidad);
        precioArticulo.setText(strPrecio);
    }

    public void cargarEnvasesAplicables(ArrayList<IEnvase> envasesAplicables) {
        ObservableList<String> listaEnvasesAplicables = FXCollections.observableArrayList();

        for (int i = 0; i < envasesAplicables.size(); i++) {
            listaEnvasesAplicables.add(envasesAplicables.get(i).obtenerNombre());
        }

        comboBoxEnvases.setItems(listaEnvasesAplicables);
    }

    @FXML
    private void sacarArticuloDelCarrito(ActionEvent event) {
        IEcoShop sistemaEcoshop = VentanaFXML.obtenerSistema();
        ICarrito carritoDelSistema = sistemaEcoshop.obtenerCarrito();
        IArticulo articuloAEliminar;
        int posicionDelArticuloEnElCarrito;

        articuloAEliminar = sistemaEcoshop.obtenerArticuloPorNombre(nombreArticulo.getText());
        posicionDelArticuloEnElCarrito = carritoDelSistema.posicionDelArticuloEnElCarrito(articuloAEliminar);

        carritoDelSistema.eliminarArticuloDelCarrito(articuloAEliminar);
        carritoDelSistema.eliminarEnvaseDelCarrito(articuloAEliminar);

        pnl_scroll.getChildren().remove(posicionDelArticuloEnElCarrito + 1);

        sacarLabelArticulosEnCarrito();
    }

    public void cargarCantidadDeArticulosEnCarrito(Label esteLabel) {
        this.cantidadArticulosEnCarrito = esteLabel;
    }

    private void sacarLabelArticulosEnCarrito() {
        IEcoShop sistemaEcoShop = VentanaFXML.obtenerSistema();
        ICarrito carritoSistema = sistemaEcoShop.obtenerCarrito();
        ArrayList<Pair<IArticulo, Double>> listaArticulosCarrito = carritoSistema.obtenerListaArticulos();

        if (listaArticulosCarrito.isEmpty()) {
            this.cantidadArticulosEnCarrito.setText("");
        } else {
            int numeroLabel = listaArticulosCarrito.size();
            String strNumeroLabel = numeroLabel + "";

            cantidadArticulosEnCarrito.setText(strNumeroLabel);
        }

    }

    @FXML
    private void mouseOcultarEnvase(MouseEvent event) {
        imagenEnvase.setImage(null);
    }

    @FXML
    private void mouseMostrarEnvase(MouseEvent event) {
        if(!comboBoxEnvases.getSelectionModel().isEmpty()){
            IEcoShop sistemaEcoShop = VentanaFXML.obtenerSistema();
            IEnvase envaseSeleccionado;
            Image envase;
            String strEnvaseSeleccionado = comboBoxEnvases.getValue();
            envaseSeleccionado = sistemaEcoShop.obtenerEnvasePorNombre(strEnvaseSeleccionado);
            
            envase = new Image(envaseSeleccionado.obtenerRutaImagen());
            
            imagenEnvase.setImage(envase);
        }
    }

    public void cargarEnvaseSeleccionado(IEnvase unEnvase){
        comboBoxEnvases.setValue(unEnvase.obtenerNombre());
    }

    @FXML
    private void clickComboBoxEnvases(ActionEvent event) {
        if(!comboBoxEnvases.getSelectionModel().isEmpty()){
            IEcoShop sistemaEcoShop = VentanaFXML.obtenerSistema();
            ICarrito carritoSistema = sistemaEcoShop.obtenerCarrito();
            String strEnvaseSeleccionado = comboBoxEnvases.getValue();
            IEnvase envaseSeleccionado;
            String strArticuloActual = nombreArticulo.getText();
            IArticulo articuloActual = sistemaEcoShop.obtenerArticuloPorNombre(strArticuloActual);
            envaseSeleccionado = sistemaEcoShop.obtenerEnvasePorNombre(strEnvaseSeleccionado);
            
            carritoSistema.agregarEnvase(articuloActual, envaseSeleccionado);
        }
    }
}
