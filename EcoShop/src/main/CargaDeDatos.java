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
    
    /**
     * 
     */
    private void cargarDirecciones()
    {
        IDireccion d1 = new Direccion("Uruguay", "Montevideo", "Carrasco", "Costa Rica", 
                "Cooper", 2264, 11400);
        IDireccion d2 = new Direccion("Uruguay", "Canelones", "Los Cerrillos", 
                "Ruta 36 km 37", "-", 2342, 90001);
        IDireccion d3 = new Direccion("Argentina", "Buenos Aires", "La Paternal", 
                "Av. Juan B. Justo", "Av. San Martin", 1727, 1405);;
        IDireccion d4 = new Direccion("Estados Unidos", "Florida", "Gainesville", "717  Long Street", 
                "-", 7483, 32601);;
        
        sistemaEcoShop.registrarDireccion(d1);
        sistemaEcoShop.registrarDireccion(d2);
        sistemaEcoShop.registrarDireccion(d3);
        sistemaEcoShop.registrarDireccion(d4);
    }
    
}


