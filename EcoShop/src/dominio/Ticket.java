package dominio;

/**
 * Clase abstracta Ticket - Tiene la informacion basica de un ticket compartida 
 * por TicketPreVenta y TicketVentaExpress
 * @author Marcos Novelli - Matias Salles
 */
public abstract class Ticket {
    //Atributos
    private int numeroIdentificador;//Numero identificador unico
    
    //Getter & Setter
    public int getNumeroIdentificador() {
        return numeroIdentificador;
    }

    public void setNumeroIdentificador(int numeroIdentificador) {
        this.numeroIdentificador = numeroIdentificador;
    }
    
}
