package dominio;

import com.itextpdf.text.Document;

/**
 * Clase TicketPreVenta - Tiene la informacion de Ticket y una PreVenta asociada
 * @author Marcos Novelli - Matias Salles
 */
public class TicketPreVenta extends Ticket{
    //Atributos
    private PreVenta unaPreVenta;
    
    //Constructores
    public TicketPreVenta(){
        assert(false);
    }
   
    public TicketPreVenta(PreVenta unaPreVenta){
        this.unaPreVenta = unaPreVenta;
        this.numeroIdentificador = -1; //Luego se cambia desde EcoShop 
        this.ticketElectronico = generarTicketElectronico(unaPreVenta);
    }
    
    //Getter & Setter
    public PreVenta getUnaPreVenta() {
        return unaPreVenta;
    }

    public void setUnaPreVenta(PreVenta unaPreVenta) {
        this.unaPreVenta = unaPreVenta;
    }

    @Override
    protected Document generarTicketElectronico(Venta unaVenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
