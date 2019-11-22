package dominio;

import com.itextpdf.text.Document;
import interfazDominio.IPreVenta;

/**
 * Clase TicketPreVenta - Tiene la informacion de Ticket y una PreVenta asociada
 * @author Marcos Novelli - Matias Salles
 */
public class TicketPreVenta{
    //Atributos
    private IPreVenta unaPreVenta;
    protected int numeroIdentificador;//Numero identificador unico
    protected Document ticketElectronico;
    
    //Constructores
    public TicketPreVenta(){
        assert(false);
    }
   
    public TicketPreVenta(IPreVenta unaPreVenta){
        this.unaPreVenta = unaPreVenta;
        this.numeroIdentificador = -1; //Luego se cambia desde EcoShop 
        this.ticketElectronico = generarTicketElectronico(unaPreVenta);
    }
    
    //Getter & Setter
    public IPreVenta getUnaPreVenta() {
        return unaPreVenta;
    }

    public void setUnaPreVenta(IPreVenta unaPreVenta) {
        this.unaPreVenta = unaPreVenta;
    }

    public int getNumeroIdentificador() {
        return numeroIdentificador;
    }

    public void setNumeroIdentificador(int numeroIdentificador) {
        this.numeroIdentificador = numeroIdentificador;
    }

    public Document getTicketElectronico() {
        return ticketElectronico;
    }

    public void setTicketElectronico(Document ticketElectronico) {
        this.ticketElectronico = ticketElectronico;
    }
    
    //
    //METODOS PRIVADOS
    //

    /**
     * 
     * @param unaPreVenta
     * @return 
     */
    private Document generarTicketElectronico(IPreVenta unaPreVenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
