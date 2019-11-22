package dominio;

import interfazDominio.ICarrito;
import interfazDominio.IPreVenta;
import interfazDominio.IPuntoDeVenta;
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 * Clase PreVenta - Tiene los atributos de Venta y una fecha de retiro de la 
 * compra
 * @author Marcos Novelli - Matias Salles
 */
public class PreVenta implements IPreVenta{
    //Atributos
    private LocalDate fechaDeRetiro;
    private ICarrito carroCompras;
    private IPuntoDeVenta localDeVenta;
    private LocalDateTime fechaDeVenta;
    private double precioTotal;

    //Constructores
    private PreVenta(){
        assert(false);
    }
    
    public PreVenta(ICarrito carroCompras, IPuntoDeVenta localDeVenta, 
            LocalDateTime fechaDeVenta, double precioTotal, LocalDate fechaDeretiro){
        this.carroCompras = carroCompras;
        this.localDeVenta = localDeVenta;
        this.fechaDeVenta = fechaDeVenta;
        this.precioTotal = precioTotal;
        this.fechaDeRetiro = fechaDeretiro;
    }
    
    
    //Getter & Setter
    public LocalDate getFechaDeRetiro() {
        return fechaDeRetiro;
    }

    public void setFechaDeRetiro(LocalDate fechaDeRetiro) {
        this.fechaDeRetiro = fechaDeRetiro;
    }
    
    public ICarrito getCarroCompras() {
        return carroCompras;
    }

    public void setCarroCompras(ICarrito carroCompras) {
        this.carroCompras = carroCompras;
    }

    public IPuntoDeVenta getLocalDeVenta() {
        return localDeVenta;
    }

    public void setLocalDeVenta(IPuntoDeVenta localDeVenta) {
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

    //
    //METODOS PUBLICOS
    //
    
    @Override
    public LocalDateTime obtenerFechaDeCompraRealizada() {
        return this.getFechaDeVenta();
    }

    @Override
    public LocalDate obtenerFechaDeRetiro() {
        return this.getFechaDeRetiro();
    }

    @Override
    public double obtenerPrecioTotalDeCompra() {
        return this.getPrecioTotal();
    }

    @Override
    public ICarrito obtenerCarritoAsociadoALaCompra() {
        return this.getCarroCompras();
    }

    @Override
    public IPuntoDeVenta obtenerLocalDeRetiro() {
        return this.getLocalDeVenta();
    }
    
    
    
}
