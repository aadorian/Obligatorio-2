package dominio;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import interfazDominio.IArticulo;
import interfazDominio.ICarrito;
import interfazDominio.IEnvase;
import interfazDominio.IPreVenta;
import interfazDominio.IPuntoDeVenta;
import interfazDominio.ITicketPreVenta;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.util.Pair;

/**
 * Clase TicketPreVenta - Tiene la informacion de Ticket y una PreVenta asociada
 * @author Marcos Novelli - Matias Salles
 */
public class TicketPreVenta implements ITicketPreVenta{
    //Atributos
    private IPreVenta unaPreVenta;
    protected int numeroIdentificador;//Numero identificador unico
    protected Document ticketElectronico;
    
    //Constructores
    public TicketPreVenta(){
        assert(false);
    }
   
    public TicketPreVenta(IPreVenta unaPreVenta, int numeroIdentificador){
        this.unaPreVenta = unaPreVenta;
        this.numeroIdentificador = numeroIdentificador;
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
        double precioTotalDeCompra;
        ICarrito carritoAsociadoALaVenta;
        LocalDateTime fechaDeCompraRealizada;
        LocalDate fechaDeRetiro;
        IPuntoDeVenta localDeRetiro;
        DateTimeFormatter formatoTiempo;
        Document ticketPdf;
        
        precioTotalDeCompra = unaPreVenta.obtenerPrecioTotalDeCompra();
        carritoAsociadoALaVenta = unaPreVenta.obtenerCarritoAsociadoALaCompra();
        fechaDeCompraRealizada = unaPreVenta.obtenerFechaDeCompraRealizada();
        fechaDeRetiro = unaPreVenta.obtenerFechaDeRetiro();
        localDeRetiro = unaPreVenta.obtenerLocalDeRetiro();
        formatoTiempo = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        
        try{
            ticketPdf = new Document();
            ticketPdf.open();
            
            Paragraph pSaltoDeLinea = new Paragraph("");
            Paragraph pListadoDeCompra = 
                    new Paragraph("-------LISTADO DE COMPRA-------");
            Paragraph pFechaDeCompra = 
                    new Paragraph("Compra realizada el: " + formatoTiempo.
                            format(fechaDeCompraRealizada));
            Paragraph pLocalDeRetiro =
                    new Paragraph("Local de retiro: " + localDeRetiro.toString());
            Paragraph pFechaDeRetiro = 
                    new Paragraph("Fecha de retiro: " + fechaDeRetiro);
            
            ticketPdf.add(pFechaDeCompra);
            ticketPdf.add(pLocalDeRetiro);
            ticketPdf.add(pFechaDeRetiro);
            ticketPdf.add(pSaltoDeLinea);
            ticketPdf.add(pSaltoDeLinea);
            ticketPdf.add(pListadoDeCompra);
            ticketPdf.add(pSaltoDeLinea);
            
            ArrayList<Pair<IArticulo, Double>> listaArticulosEnCarrito;
            
            listaArticulosEnCarrito = carritoAsociadoALaVenta.obtenerListaArticulos();
            
            for (int i = 0; i < listaArticulosEnCarrito.size(); i++) {
                Pair<IArticulo, Double> duplaTmp = listaArticulosEnCarrito.get(i);
                IArticulo articuloTmp = duplaTmp.getKey();
                double pesoTmp = duplaTmp.getValue();
                String articuloToStr = articuloTmp.toString();
                double precioTotal = articuloTmp.obtenerPrecioPorKG() * pesoTmp;
                IEnvase envaseAsociadoAlArticulo = carritoAsociadoALaVenta.
                        obtenerEnvaseAsociadoAlArticulo(articuloTmp);
                String strEnvase;
                String stringAImprimir;
                Paragraph pArticulo;
                
                strEnvase = "Envase reutilizado: " + 
                        envaseAsociadoAlArticulo.obtenerNombre();
                stringAImprimir = articuloToStr + " - x" + pesoTmp + "kg -"
                        + "$" + precioTotal + "    // " + strEnvase;
                
                pArticulo = new Paragraph(stringAImprimir);
                ticketPdf.add(pArticulo);
            }
            
            String strPrecioTotalDeCompra = 
                    "Precio Total: $" + precioTotalDeCompra;
            String agradecimiento = "Gracias por su compra";
            Paragraph pPrecioTotalDeCompra = new Paragraph(strPrecioTotalDeCompra);
            Paragraph pAgradecimiento = new Paragraph(agradecimiento);
            
            ticketPdf.add(pSaltoDeLinea);
            ticketPdf.add(pPrecioTotalDeCompra);
            ticketPdf.add(pSaltoDeLinea);
            ticketPdf.add(pAgradecimiento);
            
            ticketPdf.close();
            
            return ticketPdf;
        }
        catch(DocumentException e){
            System.out.println("Error durante la creacion del PDF");
            
            return null;
        }
    }

}
