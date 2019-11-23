/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazDominio;

/**
 *
 * @author matia
 */
public interface IDireccion {
    
    /**
     * 
     * @return 
     */
    String obtenerPais();
    
    /**
     * 
     * @return 
     */
    String obtenerDepartamento();
    
    /**
     * 
     * @return 
     */
    String obtenerCalle();
    
    /**
     * 
     * @return 
     */
    String obtenerBarrio();
    
    /**
     * 
     * @return 
     */
    int obtenerCodigoPostal();
}
