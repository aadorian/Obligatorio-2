package dominio;

import interfazDominio.*;
import java.util.ArrayList;
import java.util.Date;
/**
 * Clase Ecoshop - Contiene toda la informacion necesaria para mplementar todas 
 * las funcionalidades de IEcoshop
 * @author Marcos Novelli - Matias Salles
 */
public class EcoShop implements IEcoShop{
    //Atributos
    private ArrayList<Articulo> listaArticulos;
    private ArrayList<Envase> listaEnvases;
    private ArrayList<PuntoDeVenta> listaPuntosDeVenta;
    private ArrayList<PreVenta> listaPreVentas;
    private ArrayList<VentaExpress> listaVentasExpress;
    private ArrayList<TicketPreVenta> listaTicketsPreVenta;
    private ArrayList<TicketVentaExpress> listaTicketsVentaExpress;
    private ArrayList<Cajero> listaCajeros;
    private Carrito carritoDeCompras;
    private Stock stockEnvases;

    //Getter & Setter
    public ArrayList<Articulo> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(ArrayList<Articulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    public ArrayList<Envase> getListaEnvases() {
        return listaEnvases;
    }

    public void setListaEnvases(ArrayList<Envase> listaEnvases) {
        this.listaEnvases = listaEnvases;
    }

    public ArrayList<PuntoDeVenta> getListaPuntosDeVenta() {
        return listaPuntosDeVenta;
    }

    public void setListaPuntosDeVenta(ArrayList<PuntoDeVenta> listaPuntosDeVenta) {
        this.listaPuntosDeVenta = listaPuntosDeVenta;
    }

    public ArrayList<PreVenta> getListaPreVentas() {
        return listaPreVentas;
    }

    public void setListaPreVentas(ArrayList<PreVenta> listaPreVentas) {
        this.listaPreVentas = listaPreVentas;
    }

    public ArrayList<VentaExpress> getListaVentasExpress() {
        return listaVentasExpress;
    }

    public void setListaVentasExpress(ArrayList<VentaExpress> listaVentasExpress) {
        this.listaVentasExpress = listaVentasExpress;
    }

    public ArrayList<TicketPreVenta> getListaTicketsPreVenta() {
        return listaTicketsPreVenta;
    }

    public void setListaTicketsPreVenta(ArrayList<TicketPreVenta> listaTicketsPreVenta) {
        this.listaTicketsPreVenta = listaTicketsPreVenta;
    }

    public ArrayList<TicketVentaExpress> getListaTicketsVentaExpress() {
        return listaTicketsVentaExpress;
    }

    public void setListaTicketsVentaExpress(ArrayList<TicketVentaExpress> listaTicketsVentaExpress) {
        this.listaTicketsVentaExpress = listaTicketsVentaExpress;
    }

    public ArrayList<Cajero> getListaCajeros() {
        return listaCajeros;
    }

    public void setListaCajeros(ArrayList<Cajero> listaCajeros) {
        this.listaCajeros = listaCajeros;
    }

    public Carrito getCarritoDeCompras() {
        return carritoDeCompras;
    }

    public void setCarritoDeCompras(Carrito carritoDeCompras) {
        this.carritoDeCompras = carritoDeCompras;
    }

    public Stock getStockEnvases() {
        return stockEnvases;
    }

    public void setStockEnvases(Stock stockEnvases) {
        this.stockEnvases = stockEnvases;
    }
    
    //
    //METODOS
    //
    @Override
    public ArrayList<IArticulo> obtenerListaArticulos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<IEnvase> obtenerListaEnvasesAplicables(IArticulo unArticulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cantidadEnvasesNecesarios(IEnvase unEnvase, IArticulo unArticulo, int pesoArticulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarAlCarrito(IArticulo unArticulo, double peso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarAlCarrito(IEnvase unEnvase, int cantidadEnvases) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sacarDelCarrito(IArticulo unArticulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sacarDelCarrito(IEnvase unEnvase, int cantidadEnvases) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<IArticulo> buscarProducto(String productoABuscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrarPreVenta(ICarrito unCarrito, Date fechaDeRetiro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrarVentaExpress(ICarrito unCarrito) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void generarTicket(IPreVenta unaPreVenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void generarTicket(IVentaExpress unaVentaExpress) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<IEnvase> envasesEnStock() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarEnvaseDelStock(IEnvase unEnvase, int cantidadEnvases) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ingresarEnvaseEnStock(IEnvase unEnvase, int cantidadEnvases) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrarArticulo(IArticulo unArticulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrarProveedor(IProveedor unProveedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrarCajero(ICajero unCajero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrarPuntoDeVenta(IPuntoDeVenta unPuntoDeVenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   
}
