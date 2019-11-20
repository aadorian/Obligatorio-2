package dominio;

import interfazDominio.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
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
    private ArrayList<IPreVenta> listaPreVentas;
    private ArrayList<IVentaExpress> listaVentasExpress;
    private ArrayList<ITicketPreVenta> listaTicketsPreVenta;
    private ArrayList<ITicketVentaExpress> listaTicketsVentaExpress;
    private ArrayList<ICajero> listaCajeros;
    private ArrayList<IProveedor> listaProveedores;
    private ArrayList<IDireccion> listaDirecciones;
    private ArrayList<IArticulo> listaFavoritosUsuario;
    private ArrayList<IArticulo> listaFavoritosGlobal;
    private ICarrito carritoDeCompras;
    private IStock stockEnvases;

    public EcoShop() {
        listaArticulos = new ArrayList<>();
        listaEnvases = new ArrayList<>();
        listaPuntosDeVenta = new ArrayList<>();
        listaPreVentas = new ArrayList<>();
        listaVentasExpress = new ArrayList<>();
        listaTicketsPreVenta = new ArrayList<>();
        listaTicketsVentaExpress = new ArrayList<>();
        listaCajeros = new ArrayList<>();
        listaProveedores = new ArrayList<>();
        listaDirecciones = new ArrayList<>();
        listaFavoritosUsuario = new ArrayList<>();
        listaFavoritosGlobal = new ArrayList<>();
        carritoDeCompras = new Carrito();
        stockEnvases = new Stock();
    }
    
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

    public ArrayList<IPreVenta> getListaPreVentas() {
        return listaPreVentas;
    }

    public void setListaPreVentas(ArrayList<IPreVenta> listaPreVentas) {
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

    public ArrayList<IDireccion> getListaDirecciones() {
        return listaDirecciones;
    }

    public void setListaDirecciones(ArrayList<IDireccion> listaDirecciones) {
        this.listaDirecciones = listaDirecciones;
    }

    public ArrayList<IArticulo> getListaFavoritosUsuario() {
        return listaFavoritosUsuario;
    }

    public void setListaFavoritosUsuario(ArrayList<IArticulo> listaFavoritosUsuario) {
        this.listaFavoritosUsuario = listaFavoritosUsuario;
    }

    public ArrayList<IArticulo> getListaFavoritosGlobal() {
        return listaFavoritosGlobal;
    }

    public void setListaFavoritosGlobal(ArrayList<IArticulo> listaFavoritosGlobal) {
        this.listaFavoritosGlobal = listaFavoritosGlobal;
    }
    
    //
    //METODOS
    //
    @Override
    public ArrayList<IArticulo> obtenerListaArticulos() {
        return this.getListaArticulos();
    }

    @Override
    public ArrayList<IEnvase> obtenerListaEnvases() {
        return this.getListaEnvases();
    }
    
    @Override
    public ArrayList<IEnvase> obtenerListaEnvasesAplicables(IArticulo unArticulo) {
        int posicionArticulo = listaArticulos.indexOf(unArticulo);
        
        return listaArticulos.get(posicionArticulo).obtenerEnvasesAplicables();
    }

    @Override
    public IArticulo obtenerArticuloPorNombre(String nombre) {
        for (int i = 0; i < this.listaArticulos.size(); i++) {
            IArticulo articuloTmp = this.listaArticulos.get(i);
            
            if(articuloTmp.obtenerNombre().equals(nombre))
                return articuloTmp;
        }
        
        //Si no lo encuentra se cae el programa
        assert(false);
        return null;
    }
    
    @Override
    public ICarrito obtenerCarrito() {
        return this.getCarritoDeCompras();
    }
    
    @Override
    public int cantidadEnvasesNecesarios(IEnvase unEnvase, IArticulo unArticulo, int pesoArticulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarAlCarrito(IArticulo unArticulo, double peso) {
        carritoDeCompras.agregarArticulo(unArticulo, peso);
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
    public ArrayList<IArticulo> buscarProducto(String productoABuscar, 
            String calificador) {
        ArrayList<IArticulo> productosQueCoinciden = new ArrayList<>();
        productoABuscar = productoABuscar.toLowerCase();
        
        for (int i = 0; i < this.listaArticulos.size(); i++) {
            IArticulo articuloTmp = this.listaArticulos.get(i);
            String nombreArticulo = articuloTmp.obtenerNombre().toLowerCase();
            
            if(calificador.equals("Todos") && nombreArticulo.
                    contains(productoABuscar))
                productosQueCoinciden.add(articuloTmp);
            else if(productoABuscar.equals("") && articuloTmp.obtenerCalificador().
                    equals(calificador))
                productosQueCoinciden.add(articuloTmp);
            else if(nombreArticulo.contains(calificador) &&
                    articuloTmp.obtenerCalificador().equals(calificador))
                productosQueCoinciden.add(articuloTmp);
        }
        
        return productosQueCoinciden;
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
        int nuevoCodigoIdentificador = numeroRandom(1000);
        
        while(codigoIdentificadorEnArticulosRepetido(nuevoCodigoIdentificador))
            nuevoCodigoIdentificador = numeroRandom(1000);
        
        unArticulo.modificarCodigoIdentificador(nuevoCodigoIdentificador);
        unArticulo.modificarOrigen(proveedorRandom());
        this.listaArticulos.add(unArticulo);
        
    }

    @Override
    public void registrarEnvase(IEnvase unEnvase) {
        this.listaEnvases.add(unEnvase);
    }
    
    @Override
    public void registrarProveedor(IProveedor unProveedor) {
        unProveedor.modificarDireccion(direccionRandom());
        this.listaProveedores.add(unProveedor);
    }

    @Override
    public void registrarCajero(ICajero unCajero) {
        this.listaCajeros.add(unCajero);
    }

    @Override
    public void registrarPuntoDeVenta(IPuntoDeVenta unPuntoDeVenta) {
        this.listaPuntosDeVenta.add(unPuntoDeVenta);
    }

    @Override
    public void registrarDireccion(IDireccion unaDireccion) {
        this.listaDirecciones.add(unaDireccion);
    }
    
    @Override
    public boolean estaEnFavoritos(IArticulo unArticulo) {
        boolean esta = false;
        
        for (int i = 0; i < this.listaFavoritosUsuario.size() && !esta; i++) {
            IArticulo articuloTmp = this.listaFavoritosUsuario.get(i);
            
            if(articuloTmp.sonIgualesPorNombre(unArticulo))
                esta = true;
        }
        
        return esta;
    }
    
    @Override
    public void agregarAFavoritos(IArticulo unArticulo) {
        this.listaFavoritosUsuario.add(unArticulo);
    }

    @Override
    public void sacarDeFavoritos(IArticulo unArticulo) {
        for (int i = 0; i < this.listaFavoritosUsuario.size(); i++) {
            IArticulo articuloTmp = this.listaFavoritosUsuario.get(i);
            if (unArticulo.sonIgualesPorId(articuloTmp)) {
                this.listaFavoritosUsuario.remove(i);
            }
        }
    }
    
   //
   //METODOS PRIVADOS
   //
   
   /**
    * 
    * @return 
    */
   private int numeroRandom(int hasta){
       Random generador = new Random();
       int retorno;
       
       retorno = generador.nextInt(hasta);
       
       return retorno;
   }
   
   /**
    * 
    * @param codigoABuscar
    * @return 
    */
    private boolean codigoIdentificadorEnArticulosRepetido(int codigoABuscar){
       boolean estaRepetido = false;
       
       for (int i = 0; i < this.listaArticulos.size() && !estaRepetido; i++) {
           int codigoTmp = this.listaArticulos.get(i).obtenerCodigoIdentificador();
           
           if(codigoTmp == codigoABuscar)
               estaRepetido = true;
       }
       
       return estaRepetido;
   }

    /**
     * 
     * @return 
     */
   private IProveedor proveedorRandom(){
       int largoListaDeProveedores = this.listaProveedores.size();
       int posicionDeProveedorARetornar = numeroRandom(largoListaDeProveedores);
       
       return this.listaProveedores.get(posicionDeProveedorARetornar);
   }
   
   /**
    * 
    * @return 
    */
   private IDireccion direccionRandom(){
       int largoListaDeDirecciones = this.listaDirecciones.size();
       int posicionDeDireccionARetornar = numeroRandom(largoListaDeDirecciones);
       
       return this.listaDirecciones.get(posicionDeDireccionARetornar);
   }


    



   

    
   
}

