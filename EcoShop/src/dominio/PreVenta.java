package dominio;

import java.time.LocalDateTime;
import java.util.Date;
/**
 * Clase PreVenta - Tiene los atributos de Venta y una fecha de retiro de la 
 * compra
 * @author Marcos Novelli - Matias Salles
 */
public class PreVenta {
    //Atributos
    private Date fechaDeRetiro;
    private Carrito carroCompras;
    private PuntoDeVenta localDeVenta;
    private LocalDateTime fechaDeVenta;
    private double precioTotal;

    //Constructores
    private PreVenta(){
        assert(false);
    }
    
    public PreVenta(Carrito carroCompras, PuntoDeVenta localDeVenta, 
            LocalDateTime fechaDeVenta, double precioTotal, Date fechaDeretiro){
        this.carroCompras = carroCompras;
        this.localDeVenta = localDeVenta;
        this.fechaDeVenta = fechaDeVenta;
        this.precioTotal = precioTotal;
        this.fechaDeRetiro = fechaDeretiro;
    }
    
    
    //Getter & Setter
    public Date getFechaDeRetiro() {
        return fechaDeRetiro;
    }

    public void setFechaDeRetiro(Date fechaDeRetiro) {
        this.fechaDeRetiro = fechaDeRetiro;
    }
    
    public Carrito getCarroCompras() {
        return carroCompras;
    }

    public void setCarroCompras(Carrito carroCompras) {
        this.carroCompras = carroCompras;
    }

    public PuntoDeVenta getLocalDeVenta() {
        return localDeVenta;
    }

    public void setLocalDeVenta(PuntoDeVenta localDeVenta) {
        this.localDeVenta = localDeVenta;
    }

    public LocalDateTime getFechaDeVenta() {
        return fechaDeVenta;
    }

    public void setFechaDeVenta(LocalDateTime fechaDeVenta) {
        this.fechaDeVenta = fechaDeVenta;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
    
    
}
