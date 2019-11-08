package dominio;

import java.time.LocalDateTime;
/**
 * Clase abstracta Venta - Tiene la informacion necesaria para una venta 
 * (compartida por VentaExpress y PreVenta)
 * @author Marcos Novelli - Matias Salles
 */
public abstract class Venta {
    //Atributos
    protected Carrito carroCompras;
    protected PuntoDeVenta localDeVenta;
    protected LocalDateTime fechaDeVenta;
    protected double precioTotal;
    
    //Getter & Setter
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
