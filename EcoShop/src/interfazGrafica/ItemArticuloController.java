package interfazGrafica;

import com.jfoenix.controls.JFXButton;
import interfazDominio.IArticulo;
import interfazDominio.ICarrito;
import javafx.scene.control.Alert;
import interfazDominio.IEcoShop;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.util.Pair;

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
    private JFXButton favoritoArticuloBtn;
    @FXML
    private ImageView favoritoArticulo;
    boolean articuloEnFavoritos;
    Label cantidadArticulosEnCarrito;
    @FXML
    private Spinner<Integer> spinnerKilos;
    @FXML
    private Spinner<Integer> spinnerGramos;
    SpinnerValueFactory<Integer> spinnerValueKilos;
    SpinnerValueFactory<Integer> spinnerValueGramos;
    @FXML
    private Label labelError;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        labelError.setText("");
        
        spinnerValueKilos = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 20, 0);
        spinnerValueGramos = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9, 0);
        spinnerKilos.setValueFactory(spinnerValueKilos);
        spinnerGramos.setValueFactory(spinnerValueGramos);
    }    
    
    public void cargarImagen(String url){
        Image imagenACargar = new Image(url);
        imagenArticulo.setImage(imagenACargar);
    }
    
    public void cargarNombreArticulo(String nombre){
        nombreArticulo.setText(nombre);
    }
    
    public void cargarPrecioPorKG(double precio){
        String strPrecio = "$";
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
        agregarAlCarrito();
    }

    private void enterTextoPesoDelArticulo(KeyEvent event) {
        switch (event.getCode()) {
            case ENTER:
                agregarAlCarrito();
            default:
                break;
            }
    }
    
    private void agregarAlCarrito(){
        IEcoShop sistemaEcoShop = VentanaFXML.obtenerSistema();
        String kilosIngresados = spinnerKilos.getValue() + "";
        String gramosIngresados = spinnerGramos.getValue() + "";
        String pesoIngresado = kilosIngresados + "." + gramosIngresados;
        
        if(pesoIngresado.equals("0.0")){
            labelError.setText("Por favor ingrese un valor");
        }
        else{
            double pesoSeleccionado = Double.parseDouble(pesoIngresado);
            sistemaEcoShop.agregarAlCarrito(sistemaEcoShop.
                    obtenerArticuloPorNombre(nombreArticulo.getText()), pesoSeleccionado);
            spinnerValueKilos.setValue(0);
            spinnerValueGramos.setValue(0);
            labelError.setText("");
            agregarLabelArticulosEnCarrito();
        }
    }

    @FXML
    private void clickBtnFavoritoArticulo(MouseEvent event) {
        IEcoShop sistemaEcoShop = VentanaFXML.obtenerSistema();
        String strNombre = this.nombreArticulo.getText();
        
        favoritoArticulo.setImage(null);
        
        if (articuloEnFavoritos) {
            sistemaEcoShop.sacarDeFavoritos(sistemaEcoShop.obtenerArticuloPorNombre(strNombre));
            Image img = new Image("interfazGrafica/imagenes/favoritoVacia.png");
            favoritoArticulo.setImage(img);
            articuloEnFavoritos = false;
        } else {
            sistemaEcoShop.agregarAFavoritosPersonal(sistemaEcoShop.obtenerArticuloPorNombre(strNombre));
            Image img = new Image("interfazGrafica/imagenes/favoritoAmarilla.png");
            favoritoArticulo.setImage(img);
            articuloEnFavoritos = true;
        }
    }
    
    public void cargarEsFavorito(boolean esFavorito){
        favoritoArticulo.setImage(null);
        this.articuloEnFavoritos = esFavorito;
        
        if (esFavorito) {
            Image img = new Image("interfazGrafica/imagenes/favoritoAmarilla.png");
            favoritoArticulo.setImage(img);
        } else {
            Image img = new Image("interfazGrafica/imagenes/favoritoVacia.png");
            favoritoArticulo.setImage(img);
        }
    }
    
    public void cargarCantidadDeArticulosEnCarrito(Label esteLabel){
        this.cantidadArticulosEnCarrito = esteLabel;
    }
    
    private void agregarLabelArticulosEnCarrito(){
        IEcoShop sistemaEcoShop = VentanaFXML.obtenerSistema();
        ICarrito carritoSistema = sistemaEcoShop.obtenerCarrito();
        ArrayList<Pair<IArticulo,Double>> listaArticulosCarrito = carritoSistema.obtenerListaArticulos();
       
        int numeroLabel = listaArticulosCarrito.size();
        String strNumeroLabel = numeroLabel + "";
        
        cantidadArticulosEnCarrito.setText(strNumeroLabel);
    }


    
}
