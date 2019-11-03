package dominio;

/**
 * Clase VentaExpress - Tiene los atributos de Venta y un cajero asociado a la 
 * compra
 * @author Marcos Novelli - Matias Salles
 */
public class VentaExpress extends Venta{
    //Atributos
    private Cajero unCajero;
    
    //Getter & Setter
    public Cajero getUnCajero() {
        return unCajero;
    }

    public void setUnCajero(Cajero unCajero) {
        this.unCajero = unCajero;
    }
    
}
