/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazDominio;

import java.util.ArrayList;

/**
 *
 * @author matia
 */
public interface ITicketPreVenta {
    
    /**
     * 
     * @return 
     */
    int obtenerNumeroDeTicket();
    
    /**
     * 
     * @return 
     */
    ArrayList<String> obtenerContenidoTicketPDF();
    
    /**
     * 
     * @return 
     */
    IPreVenta obtenerPreVentaAsociada();
}
