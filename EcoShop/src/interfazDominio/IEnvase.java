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
public interface IEnvase {
    
    /**
     * 
     * @return 
     */
    String obtenerNombre();
    
    /**
     * 
     * @param unEnvase
     * @return 
     */
    boolean sonIguales(IEnvase unEnvase);
}
