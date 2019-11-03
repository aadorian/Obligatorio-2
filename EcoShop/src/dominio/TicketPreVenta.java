package dominio;

/**
 * Clase TicketPreVenta - Tiene la informacion de Ticket y una PreVenta asociada
 * @author Marcos Novelli - Matias Salles
 */
public class TicketPreVenta extends Ticket{
    //Atributos
    private PreVenta unaPreVenta;
    
    //Getter & Setter
    public PreVenta getUnaPreVenta() {
        return unaPreVenta;
    }

    public void setUnaPreVenta(PreVenta unaPreVenta) {
        this.unaPreVenta = unaPreVenta;
    }
    
}
