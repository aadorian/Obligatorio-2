/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dominio.*;
import interfazDominio.*;
import java.util.ArrayList;
/**
 *
 * @author matia
 */
public class CargaDeDatos {
    //Atributos
    IEcoShop sistemaEcoShop;
    
    public CargaDeDatos(IEcoShop sistemaEcoShop) {
        this.sistemaEcoShop = sistemaEcoShop;
    }

    //Getter & Setter
    public IEcoShop getSistemaEcoShop() {
        return sistemaEcoShop;
    }

    public void setSistemaEcoShop(IEcoShop sistemaEcoShop) {
        this.sistemaEcoShop = sistemaEcoShop;
    }
    
    public void cargarSistema(){
        this.cargarDirecciones();
        this.cargarProveedores();
        this.cargarEnvases();
        this.cargarManzanaVerde();
        this.cargarManzanaRoja();
        this.cargarBanana();
    }
    
    /**
     * 
     */
    private void cargarDirecciones(){
        IDireccion d1 = new Direccion("Uruguay", "Montevideo", "Carrasco", "Costa Rica", 
                "Cooper", 2264, 11400);
        IDireccion d2 = new Direccion("Uruguay", "Canelones", "Los Cerrillos", 
                "Ruta 36 km 37", "-", 2342, 90001);
        IDireccion d3 = new Direccion("Argentina", "Buenos Aires", "La Paternal", 
                "Av. Juan B. Justo", "Av. San Martin", 1727, 1405);
        IDireccion d4 = new Direccion("Estados Unidos", "Florida", "Gainesville", 
                "717  Long Street", "-", 7483, 32601);
        
        sistemaEcoShop.registrarDireccion(d1);
        sistemaEcoShop.registrarDireccion(d2);
        sistemaEcoShop.registrarDireccion(d3);
        sistemaEcoShop.registrarDireccion(d4);
    }
    
    /**
     * 
     */
    private void cargarProveedores(){
        IProveedor p1 = new Proveedor("Las Acacias");
        IProveedor p2 = new Proveedor("La Serenísima");
        IProveedor p3 = new Proveedor("Los Nietitos");
        IProveedor p4 = new Proveedor("Granja Narbona");
        
        sistemaEcoShop.registrarProveedor(p1);
        sistemaEcoShop.registrarProveedor(p2);
        sistemaEcoShop.registrarProveedor(p3);
        sistemaEcoShop.registrarProveedor(p4);
    }
    
    private void cargarEnvases(){
        IEnvase e1 = new Envase("Bolsa Mediana", 20, 13, 30,
                "interfazGrafica/imagenes/BolsaMediana.jpg");
        IEnvase e2 = new Envase("Tupper Chico", 13, 12, 6, 
                "interfazGrafica/imagenes/TupperChico.jpg");
        IEnvase e3 = new Envase("Tupper Mediano", 18, 11, 11, 
                "interfazGrafica/imagenes/TupperMediano.jpg");
        IEnvase e4 = new Envase("Bolsa Grande", 21, 22, 54, 
                "interfazGrafica/imagenes/BolsaGrande.jpg");
        //IEnvase e5 = new Envase("Tapper Grande", 0, 0, 0);
        //IEnvase e6 = new Envase("Bolsa de Supermercado", 21, 22, 54);
        
        sistemaEcoShop.registrarEnvase(e1);
        sistemaEcoShop.registrarEnvase(e2);
        sistemaEcoShop.registrarEnvase(e3);
        sistemaEcoShop.registrarEnvase(e4);
        //sistemaEcoShop.registrarEnvase(e5);
        //sistemaEcoShop.registrarEnvase(e6);
    }
    
    /**
     * 
     */
    private void cargarManzanaRoja(){
        double densidadDeManzanaRoja = 947; 
        double precioPorKGManzanaRoja = 66;
        String rutaDeImagenManzanaRoja = "interfazGrafica/imagenes/manzanaRoja.jpg";
        String calificadorManzanaRoja = "Fruta";
        
        IArticulo manzanaRoja = new Articulo("Manzana Roja",rutaDeImagenManzanaRoja,
        precioPorKGManzanaRoja,densidadDeManzanaRoja,calificadorManzanaRoja);
        
        manzanaRoja.agregarEnvase(obtenerEnvase("Bolsa Mediana"));
        manzanaRoja.agregarEnvase(obtenerEnvase("Bolsa Grande"));
        
        sistemaEcoShop.registrarArticulo(manzanaRoja);
    }
    
    private void cargarManzanaVerde(){
        double densidadDeManzanaVerde = 947; 
        double precioPorKGManzanaVerde = 59;
        String rutaDeImagenManzanaVerde = "interfazGrafica/imagenes/manzanaVerde2.jpg";
        String calificadorManzanaVerde = "Fruta";
        
        IArticulo manzanaVerde = new Articulo("Manzana Verde",rutaDeImagenManzanaVerde,
        precioPorKGManzanaVerde,densidadDeManzanaVerde,calificadorManzanaVerde);
        
        manzanaVerde.agregarEnvase(obtenerEnvase("Bolsa Mediana"));
        manzanaVerde.agregarEnvase(obtenerEnvase("Bolsa Grande"));
        
        sistemaEcoShop.registrarArticulo(manzanaVerde);
    }
    
    private void cargarBanana(){
        double densidadDeBanana = 1382; 
        double precioPorKGBanana = 109;
        String rutaDeImagenBanana = "interfazGrafica/imagenes/banana.jpg";
        String calificadorBanana = "Fruta";
        
        IArticulo banana = new Articulo("Banana",rutaDeImagenBanana,
        precioPorKGBanana,densidadDeBanana,calificadorBanana);
        
        banana.agregarEnvase(obtenerEnvase("Bolsa Mediana"));
        banana.agregarEnvase(obtenerEnvase("Bolsa Grande"));
        
        sistemaEcoShop.registrarArticulo(banana);
    }
    
    /**
     * 
     * @param envaseABuscar
     * @return 
     */
    private IEnvase obtenerEnvase(String envaseABuscar){
        ArrayList<IEnvase> envasesSistema = sistemaEcoShop.obtenerListaEnvases();
        IEnvase envaseSoloNombre = new Envase(envaseABuscar,-1,-1,-1, "");
        
        for (int i = 0; i < envasesSistema.size(); i++) {
            IEnvase envaseTmp = envasesSistema.get(i);
            
            if(envaseTmp.sonIguales(envaseSoloNombre))
                return envaseTmp;
        }
        
        //Si no encontro se cae el programa
        assert(false);
        return null;
    }
    
}


