/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazGrafica;

import interfazDominio.IEcoShop;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.ImageIcon;

/**
 *
 * @author 
 */
public class VentanaFXML extends Application {
    //Atributos
    private static IEcoShop sistemaEcoShop;
    
    public VentanaFXML() {
    }

    public VentanaFXML(IEcoShop sistemaEcoShop) {
        VentanaFXML.sistemaEcoShop = sistemaEcoShop;
    }
    
    public static IEcoShop obtenerSistema(){
        return sistemaEcoShop;
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

    /**
     * @param args the command line arguments
     */
    public void comenzarVentanaPrincipal(String[] args) {
        launch(args);
    }
    
}
