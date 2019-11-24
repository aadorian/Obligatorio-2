package interfazGrafica;

import interfazDominio.IEcoShop;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * VentanaFXML
 * @author Marcos Novelli - Matias Salles 
 */
public class VentanaFXML extends Application {
    //Atributos
    private static IEcoShop sistemaEcoShop;
    
    //Constructores
    public VentanaFXML() {
    }

    public VentanaFXML(IEcoShop sistemaEcoShop) {
        VentanaFXML.sistemaEcoShop = sistemaEcoShop;
    }
    
    //
    //METODOS PUBLICOS
    //
    
    public static IEcoShop obtenerSistema(){
        return sistemaEcoShop;
    }
    
    public void comenzarVentanaPrincipal(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("VentanaPrincipal.fxml"));
        
        //Eliminar botones de minimizar, maximizar y cerrar
        //stage.initStyle(StageStyle.UNDECORATED);
        
        //Icono a la barra
        //stage.getIcons().add(new Image("@/images/organicLogo.png"));
       
       Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
}
