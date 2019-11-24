package interfazDominio;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Interfaz IPreVenta 
 * @author Marcos Novelli - Matias Salles
 */
public interface IPreVenta {
    
    /**
     * 
     * @return Retorna la fecha en la cual la compra fue realizada
     */
    LocalDateTime obtenerFechaDeCompraRealizada();
    
    /**
     * 
     * @return Retorna la fecha elegida para el retiro de la compra
     */
    LocalDate obtenerFechaDeRetiro();
    
    /**
     * 
     * @return Retorna el monto total de la compra
     */
    double obtenerPrecioTotalDeCompra();
    
    /**
     * 
     * @return Retorna el carrito asociado a la compra
     */
    ICarrito obtenerCarritoAsociadoALaCompra();
    
    /**
     * 
     * @return Retorna el local elegido para el retiro de la compra
     */
    IPuntoDeVenta obtenerLocalDeRetiro();
}
