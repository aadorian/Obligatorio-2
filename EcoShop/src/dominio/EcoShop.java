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
    private ArrayList<IArticulo> listaArticulos;
    private ArrayList<IEnvase> listaEnvases;
    private ArrayList<IPuntoDeVenta> listaPuntosDeVenta;
    private ArrayList<PreVenta> listaPreVentas;
    private ArrayList<IVentaExpress> listaVentasExpress;
    private ArrayList<ITicketPreVenta> listaTicketsPreVenta;
    private ArrayList<ITicketVentaExpress> listaTicketsVentaExpress;
    private ArrayList<ICajero> listaCajeros;
    private ArrayList<IProveedor> listaProveedores;
    private ICarrito carritoDeCompras;
    private IStock stockEnvases;

    //Getter & Setter
    public ArrayList<IProveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(ArrayList<IProveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }
    
    
    public ArrayList<IArticulo> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(ArrayList<IArticulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    public ArrayList<IEnvase> getListaEnvases() {
        return listaEnvases;
    }

    public void setListaEnvases(ArrayList<IEnvase> listaEnvases) {
        this.listaEnvases = listaEnvases;
    }

    public ArrayList<IPuntoDeVenta> getListaPuntosDeVenta() {
        return listaPuntosDeVenta;
    }

    public void setListaPuntosDeVenta(ArrayList<IPuntoDeVenta> listaPuntosDeVenta) {
        this.listaPuntosDeVenta = listaPuntosDeVenta;
    }

    public ArrayList<PreVenta> getListaPreVentas() {
        return listaPreVentas;
    }

    public void setListaPreVentas(ArrayList<PreVenta> listaPreVentas) {
        this.listaPreVentas = listaPreVentas;
    }

    public ArrayList<IVentaExpress> getListaVentasExpress() {
        return listaVentasExpress;
    }

    public void setListaVentasExpress(ArrayList<IVentaExpress> listaVentasExpress) {
        this.listaVentasExpress = listaVentasExpress;
    }

    public ArrayList<ITicketPreVenta> getListaTicketsPreVenta() {
        return listaTicketsPreVenta;
    }

    public void setListaTicketsPreVenta(ArrayList<ITicketPreVenta> listaTicketsPreVenta) {
        this.listaTicketsPreVenta = listaTicketsPreVenta;
    }

    public ArrayList<ITicketVentaExpress> getListaTicketsVentaExpress() {
        return listaTicketsVentaExpress;
    }

    public void setListaTicketsVentaExpress(ArrayList<ITicketVentaExpress> listaTicketsVentaExpress) {
        this.listaTicketsVentaExpress = listaTicketsVentaExpress;
    }

    public ArrayList<ICajero> getListaCajeros() {
        return listaCajeros;
    }

    public void setListaCajeros(ArrayList<ICajero> listaCajeros) {
        this.listaCajeros = listaCajeros;
    }

    public ICarrito getCarritoDeCompras() {
        return carritoDeCompras;
    }

    public void setCarritoDeCompras(ICarrito carritoDeCompras) {
        this.carritoDeCompras = carritoDeCompras;
    }

    public IStock getStockEnvases() {
        return stockEnvases;
    }

    public void setStockEnvases(IStock stockEnvases) {
        this.stockEnvases = stockEnvases;
    }
    
    //
    //METODOS
    //
    @Override
    public ArrayList<IArticulo> obtenerListaArticulos() {
        return this.getListaArticulos();
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
        this.listaArticulos.add(unArticulo);
    }

    @Override
    public void registrarProveedor(IProveedor unProveedor) {
        this.listaProveedores.add(unProveedor);
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
