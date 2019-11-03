package dominio;

/**
 * Clase TicketVentaExpress - Tiene la informacion de Ticket y una VentaExpress 
 * asociada
 * @author Marcos Novelli - Matias Salles
 */
public class TicketVentaExpress extends Ticket{
    //Atributos
    private VentaExpress unaVentaExpress;
    
    //Getter & Setter
    public VentaExpress getUnaVentaExpress() {
        return unaVentaExpress;
    }

    public void setUnaVentaExpress(VentaExpress unaVentaExpress) {
        this.unaVentaExpress = unaVentaExpress;
    }
    
}
