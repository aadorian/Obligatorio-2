/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazDominio;

import java.util.ArrayList;


/**
 *
 * @author Marcos Novelli - Matias Salles
 */
public interface IArticulo {
    
    /**
     * 
     * @return 
     */
    String obtenerNombre();
    
    /**
     * 
     * @return 
     */
    String obtenerCalificador();
    
    /**
     * 
     * @return 
     */
    String obtenerRutaDeImagen();
    
    /**
     * 
     * @return 
     */
    double obtenerPrecioPorKG();
    
    /**
     * 
     * @return 
     */
    double obtenerDensidad();
    
    /**
     * 
     * @return 
     */
    IProveedor obtenerOrigen();
    
    /**
     * 
     * @param unProveedor 
     */
    void modificarOrigen(IProveedor unProveedor);
    
    /**
     * PRE: -
     * @return devuelve el codigo identificador del articulo
     */
    int obtenerCodigoIdentificador();
    
    /**
     * 
     * @param nuevoCodigo
     */
    void modificarCodigoIdentificador(int nuevoCodigo);
    
    /**
     * 
     * @return 
     */
    ArrayList<IEnvase> obtenerEnvasesAplicables();
    
    /**
     * 
     * @param unEnvase
     */
    void agregarEnvase(IEnvase unEnvase);
    
    /**
     * 
     * @param unArticulo
     * @return 
     */
    boolean sonIgualesPorNombre(IArticulo unArticulo); 
    
    /**
     * 
     * @param unArticulo
     * @return 
     */
    boolean sonIgualesPorId(IArticulo unArticulo);
    
    /**
     *
     * @return
     */
    @Override
    String toString();
}
