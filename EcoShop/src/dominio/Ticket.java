package dominio;

import com.itextpdf.text.Document;
/**
 * Clase abstracta Ticket - Tiene la informacion basica de un ticket compartida 
 * por TicketPreVenta y TicketVentaExpress
 * @author Marcos Novelli - Matias Salles
 */
public abstract class Ticket {
    //Atributos
    protected int numeroIdentificador;//Numero identificador unico
    protected Document ticketElectronico;
    
    //Getter & Setter
    public int getNumeroIdentificador() {
        return numeroIdentificador;
    }

    public void setNumeroIdentificador(int numeroIdentificador) {
        this.numeroIdentificador = numeroIdentificador;
    }
    
    abstract protected Document generarTicketElectronico(Venta unaVenta);
}
