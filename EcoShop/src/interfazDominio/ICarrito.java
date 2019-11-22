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
     * @param unArticulo
     * @param unEnvase 
     */
    void agregarEnvase(IArticulo unArticulo, IEnvase unEnvase);
    
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
    
    /**
     * 
     * @param unArticulo
     * @return 
     */
    int posicionDelArticuloEnElCarrito(IArticulo unArticulo);
    
    /**
     * 
     * @param unArticulo
     * @return 
     */
    boolean articuloEstaEnElCarrito(IArticulo unArticulo);
    
    /**
     * 
     * @param unArticulo 
     */
    void eliminarEnvaseDelCarrito(IArticulo unArticulo);
    
    /**
     * 
     * @param unArticulo
     * @return 
     */
    IEnvase obtenerEnvaseAsociadoAlArticulo(IArticulo unArticulo);
    
    /**
     * 
     * @param unArticulo
     * @return 
     */
    boolean articuloTieneEnvaseAsociado(IArticulo unArticulo);
}
