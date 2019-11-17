/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import dominio.EcoShop;
import interfazDominio.IEcoShop;
import interfazGrafica.*;
/**
 *
 * @author Marcos Novelli - Matias Salles
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IEcoShop unSistemaEcoshop = new EcoShop();
        CargaDeDatos cargadorDeDatos = new CargaDeDatos(unSistemaEcoshop);
        
        cargadorDeDatos.cargarSistema();
        
        VentanaMenuPrincipal unaVentanaMenuPrincipal;
        unaVentanaMenuPrincipal = new VentanaMenuPrincipal(unSistemaEcoshop);
        
        unaVentanaMenuPrincipal.comenzarVentanaPrincipal(args);
        // TODO code application logic here
    }
    
}
