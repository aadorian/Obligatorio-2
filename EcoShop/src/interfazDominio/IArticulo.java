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
    
    void modificarOrigen(IProveedor unProveedor);
    
    /**
     * PRE: -
     * @return devuelve el codigo identificador del articulo
     */
    int obtenerCodigoIdentificador();
    
    /**
     * 
     */
    void modificarCodigoIdentificador(int nuevoCodigo);
    
    /**
     * 
     * @return 
     */
    ArrayList<IEnvase> obtenerEnvasesAplicables();
    
    /**
     * 
     * @param unArticulo
     * @return 
     */
    boolean sonIguales(IArticulo unArticulo); 
    
}
