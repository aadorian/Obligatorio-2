package dominio;

import java.time.LocalDateTime;
import java.util.Date;
/**
 * Clase PreVenta - Tiene los atributos de Venta y una fecha de retiro de la 
 * compra
 * @author Marcos Novelli - Matias Salles
 */
public class PreVenta extends Venta{
    //Atributos
    private Date fechaDeRetiro;

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
    
    @Override
     public Carrito getCarroCompras() {
        return carroCompras;
    }
     
    @Override
    public void setCarroCompras(Carrito carroCompras) {
        this.carroCompras = carroCompras;
    }
    
    @Override
    public PuntoDeVenta getLocalDeVenta() {
        return localDeVenta;
    }
    
    @Override
    public void setLocalDeVenta(PuntoDeVenta localDeVenta) {
        this.localDeVenta = localDeVenta;
    }

    @Override
    public LocalDateTime getFechaDeVenta() {
        return fechaDeVenta;
    }

    @Override
    public void setFechaDeVenta(LocalDateTime fechaDeVenta) {
        this.fechaDeVenta = fechaDeVenta;
    }

    @Override
    public double getPrecioTotal() {
        return precioTotal;
    }

    @Override
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
    
    
}
