package interfazDominio;

import java.util.ArrayList;

/**
 * Interfaz ITicketPreVenta
 * @author Marcos Novelli - Matias Salles
 */
public interface ITicketPreVenta {
    
    /**
     * 
     * @return Retorna el numero de ticket
     */
    int obtenerNumeroDeTicket();
    
    /**
     * 
     * @return Retorna una lista de String que contienen el contenido del ticket
     * electronico
     */
    ArrayList<String> obtenerContenidoTicketPDF();
    
    /**
     * 
     * @return Retorna la pre venta asociada al ticket
     */
    IPreVenta obtenerPreVentaAsociada();
}
