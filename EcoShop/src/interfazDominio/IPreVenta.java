/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazDominio;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Marcos Novelli - Matias Salles
 */
public interface IPreVenta {
    
    /**
     * 
     * @return 
     */
    LocalDateTime obtenerFechaDeCompraRealizada();
    
    /**
     * 
     * @return 
     */
    LocalDate obtenerFechaDeRetiro();
    
    /**
     * 
     * @return 
     */
    double obtenerPrecioTotalDeCompra();
    
    /**
     * 
     * @return 
     */
    ICarrito obtenerCarritoAsociadoALaCompra();
    
    /**
     * 
     * @return 
     */
    IPuntoDeVenta obtenerLocalDeRetiro();
}
