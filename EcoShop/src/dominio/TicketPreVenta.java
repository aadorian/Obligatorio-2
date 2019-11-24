package dominio;

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
 * Clase TicketPreVenta - Implementacion de ITicketPreVenta
 * @author Marcos Novelli - Matias Salles
 */
public class TicketPreVenta implements ITicketPreVenta{
    //Atributos
    private IPreVenta unaPreVenta;
    protected int numeroIdentificador;//Numero identificador unico
    protected ArrayList<String> contenidoTicketElectronico;
    
    //Constructores
    public TicketPreVenta(){
        assert(false); //No podemos generar un TicketPreVenta sin parametros
    }
   
    public TicketPreVenta(IPreVenta unaPreVenta, int numeroIdentificador){
        this.unaPreVenta = unaPreVenta;
        this.numeroIdentificador = numeroIdentificador;
        this.contenidoTicketElectronico = generarContenidoTicketElectronico(unaPreVenta);
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

    public ArrayList<String> getContenidoTicketElectronico() {
        return contenidoTicketElectronico;
    }

    public void setTicketElectronico(ArrayList<String> contenidoTicketElectronico) {
        this.contenidoTicketElectronico = contenidoTicketElectronico;
    }
    
    //
    //METODOS PRIVADOS
    //

    /**
     * 
     * @param unaPreVenta PreVenta para generar el contenido del ticket electronico
     * @return Retorna una lista con la informacion de la compra para luego generar
     * un ticket PDF
     */
    private ArrayList<String> generarContenidoTicketElectronico(IPreVenta unaPreVenta) {
        //Var
        double precioTotalDeCompra;
        ICarrito carritoAsociadoALaVenta;
        LocalDateTime fechaDeCompraRealizada;
        LocalDate fechaDeRetiro;
        IPuntoDeVenta localDeRetiro;
        DateTimeFormatter formatoTiempo;
        ArrayList<String> contenidoTicketPdf = new ArrayList<>();
        
        precioTotalDeCompra = unaPreVenta.obtenerPrecioTotalDeCompra();
        carritoAsociadoALaVenta = unaPreVenta.obtenerCarritoAsociadoALaCompra();
        fechaDeCompraRealizada = unaPreVenta.obtenerFechaDeCompraRealizada();
        fechaDeRetiro = unaPreVenta.obtenerFechaDeRetiro();
        localDeRetiro = unaPreVenta.obtenerLocalDeRetiro();
        formatoTiempo = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        
        String saltoDeLinea = "";
        String introListadoDeCompra = "-------LISTADO DE COMPRA-------";
        String fechaDeCompra ="Compra realizada el: " + formatoTiempo.
                        format(fechaDeCompraRealizada);
        String strLocalDeRetiro = "Local de retiro: " + localDeRetiro.toString();
        String strFechaDeRetiro = "Fecha de retiro: " + fechaDeRetiro;

        contenidoTicketPdf.add(fechaDeCompra);
        contenidoTicketPdf.add(strLocalDeRetiro);
        contenidoTicketPdf.add(strFechaDeRetiro);
        contenidoTicketPdf.add(saltoDeLinea);
        contenidoTicketPdf.add(saltoDeLinea);
        contenidoTicketPdf.add(introListadoDeCompra);
        contenidoTicketPdf.add(saltoDeLinea);

        ArrayList<Pair<IArticulo, Double>> listaArticulosEnCarrito;

        listaArticulosEnCarrito = carritoAsociadoALaVenta.obtenerListaArticulos();

        for (int i = 0; i < listaArticulosEnCarrito.size(); i++) {
            //Var
            Pair<IArticulo, Double> duplaTmp = listaArticulosEnCarrito.get(i);
            IArticulo articuloTmp = duplaTmp.getKey();
            double pesoTmp = duplaTmp.getValue();
            String articuloToStr = articuloTmp.toString();
            double precioTotal = articuloTmp.obtenerPrecioPorKG() * pesoTmp;
            IEnvase envaseAsociadoAlArticulo = carritoAsociadoALaVenta.
                    obtenerEnvaseAsociadoAlArticulo(articuloTmp);
            String strEnvase;
            String stringAImprimir;

            strEnvase = envaseAsociadoAlArticulo.obtenerNombre();
            stringAImprimir = articuloToStr + " x" + pesoTmp + "kg -  "
                    + "$" + precioTotal + "    | " + strEnvase;

            contenidoTicketPdf.add(stringAImprimir);
        }

        String strPrecioTotalDeCompra = 
                "Precio Total: $" + precioTotalDeCompra;
        String agradecimiento = "Gracias por su compra";

        contenidoTicketPdf.add(saltoDeLinea);
        contenidoTicketPdf.add(strPrecioTotalDeCompra);
        contenidoTicketPdf.add(saltoDeLinea);
        contenidoTicketPdf.add(agradecimiento);

        return contenidoTicketPdf;
    }

    @Override
    public int obtenerNumeroDeTicket() {
        return this.getNumeroIdentificador();
    }

    @Override
    public ArrayList<String> obtenerContenidoTicketPDF() {
        return this.getContenidoTicketElectronico();
    }

    @Override
    public IPreVenta obtenerPreVentaAsociada() {
        return this.getUnaPreVenta();
    }

}
