package dominio;

import com.itextpdf.text.Document;

/**
 * Clase TicketVentaExpress - Tiene la informacion de Ticket y una VentaExpress 
 * asociada
 * @author Marcos Novelli - Matias Salles
 */
public class TicketVentaExpress extends Ticket{
    //Atributos
    private VentaExpress unaVentaExpress;
    
    //Constructores
    public TicketVentaExpress(){
        assert(false);
    }
   
    public TicketVentaExpress(VentaExpress unaVentaExpress){
        this.unaVentaExpress = unaVentaExpress;
        this.numeroIdentificador = -1; //Luego se cambia desde EcoShop 
        this.ticketElectronico = generarTicketElectronico(unaVentaExpress);
    }
    
    //Getter & Setter
    public VentaExpress getUnaVentaExpress() {
        return unaVentaExpress;
    }

    public void setUnaVentaExpress(VentaExpress unaVentaExpress) {
        this.unaVentaExpress = unaVentaExpress;
    }

    @Override
    protected Document generarTicketElectronico(Venta unaVenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
