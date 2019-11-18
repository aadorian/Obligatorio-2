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
    public void agregarArticulo(IArticulo unArticulo, double pesoEnKg);
    
    /**
     * 
     * @param unEnvase
     * @param cantidadEnvases 
     */
    public void agregarEnvase(IEnvase unEnvase, double cantidadEnvases);
    
    /**
     * 
     * @return 
     */
    public ArrayList<Pair<IArticulo, Double>> obtenerListaArticulos();
    
}
