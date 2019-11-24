package main;
import dominio.EcoShop;
import interfazDominio.IEcoShop;
import interfazGrafica.*;
/**
 * Main
 * @author Marcos Novelli - Matias Salles
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Var
        IEcoShop unSistemaEcoshop = new EcoShop();
        CargaDeDatos cargadorDeDatos = new CargaDeDatos(unSistemaEcoshop);
        
        //Cargamos el sistema
        cargadorDeDatos.cargarSistema();
        
        //Creamos la ventana
        VentanaFXML unaVentanaMenuPrincipal;
        unaVentanaMenuPrincipal = new VentanaFXML(unSistemaEcoshop);
        
        unaVentanaMenuPrincipal.comenzarVentanaPrincipal(args);

    }
    
}
