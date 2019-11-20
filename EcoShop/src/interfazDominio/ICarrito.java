/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazDominio;

import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author Marcos Novelli - Matias Salles
 */
public interface ICarrito {
    
    /**
     * 
     * @param unArticulo
     * @param pesoEnKg 
     */
    void agregarArticulo(IArticulo unArticulo, double pesoEnKg);
    
    /**
     * 
     * @param unEnvase
     * @param cantidadEnvases 
     */
    void agregarEnvase(IEnvase unEnvase, double cantidadEnvases);
    
    /**
     * 
     * @return 
     */
    ArrayList<Pair<IArticulo, Double>> obtenerListaArticulos();
    
    /**
     * 
     * @param unArticulo
     */
    void eliminarArticuloDelCarrito(IArticulo unArticulo);
    
    int posicionDelArticuloEnElCarrito(IArticulo unArticulo);
    
}
