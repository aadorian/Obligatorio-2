/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazDominio;

/**
 *
 * @author Marcos Novelli - Matias Salles
 */
public interface IPuntoDeVenta {
    
    /**
     * 
     * @param unaDireccion 
     */
    void modificarDireccion(IDireccion unaDireccion);
    
    /**
     * 
     * @return 
     */
    IDireccion obtenerDireccionDelLocal();
    
    /**
     * 
     * @return 
     */
    int obtenerNumeroDeLocal();
    
    /**
     * 
     * @return 
     */
    String obtenerRutaDeImagen();
    
    /**
     *
     * @return
     */
    @Override
    String toString();
}
