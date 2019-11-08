package dominio;

import java.time.LocalDateTime;
/**
 * Clase VentaExpress - Tiene los atributos de Venta y un cajero asociado a la 
 * compra
 * @author Marcos Novelli - Matias Salles
 */
public class VentaExpress extends Venta{
    //Atributos
    private Cajero unCajero;
    
    //Constructores
    private VentaExpress(){
        assert(false);
    }
    
    public VentaExpress(Carrito carroCompras, PuntoDeVenta localDeVenta, 
            LocalDateTime fechaDeVenta, double precioTotal, Cajero unCajero){
        this.carroCompras = carroCompras;
        this.localDeVenta = localDeVenta;
        this.fechaDeVenta = fechaDeVenta;
        this.precioTotal = precioTotal;
        this.unCajero = unCajero;
    }
    
    //Getter & Setter
    public Cajero getUnCajero() {
        return unCajero;
    }

    public void setUnCajero(Cajero unCajero) {
        this.unCajero = unCajero;
    }
    
}
