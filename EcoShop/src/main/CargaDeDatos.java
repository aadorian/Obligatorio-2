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
    
}


