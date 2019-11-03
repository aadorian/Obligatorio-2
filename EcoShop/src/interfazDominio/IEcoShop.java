package interfazDominio;

import java.util.ArrayList;
import java.util.Date;
/**
 * Interfaz del EcoShop, se listan las funcionalidades principales que 
 * necesitarán ser accedidas por la interfaz gráfica independiente de como se 
 * implemente la solución del mismo.
 * @author Marcos Novelli - Matias Salles
 */
public interface IEcoShop {
    
    /**
     * PRE: -
     * @return Retorna una lista con todos los articulos registrados en EcoShop
     */
    ArrayList<IArticulo> obtenerListaArticulos();
    
    /**
     * PRE: -
     * @param unArticulo Articulo al cual guardar en un envase
     * @return Retorna una lista de envases que son aplicables(compatibles) con
     * el articulo por parametro
     */
    ArrayList<IEnvase> obtenerListaEnvasesAplicables(IArticulo unArticulo);
    
    /**
     * PRE: -
     * @param unEnvase Envase a utilizar para guardar "unArticulo"
     * @param unArticulo Articulo al cual guardar en "unEnvase"
     * @param pesoArticulo Cantidad en gramos seleccionada de unArticulo
     * @return Retorna la cantidad de "unEnvase" necesarios para almacenar 
     * la cantidad (pesoArticulo) de "unArticulo"
     */
    int cantidadEnvasesNecesarios(IEnvase unEnvase, IArticulo unArticulo, 
            int pesoArticulo);
    
    //Funcion de mapa
    
    /**
     * PRE: -
     * @param unArticulo Articulo a agregar al carrito
     * @param peso Cantidad en gramos seleccionada del articulo
     * POS: Agrega al carrito el articulo y el peso seleccionado
     */
    void agregarAlCarrito(IArticulo unArticulo, double peso);
    
    /**
     * PRE: -
     * @param unEnvase Envase a agregar al carrito
     * @param cantidadEnvases Cantidad de "unEnvase" a agregar al carrito
     * POS: Agrega al carrito el envase y la cantidad necesaria de él.
     */
    void agregarAlCarrito(IEnvase unEnvase, int cantidadEnvases);
    
    /**
     * PRE: El articulo esta en el carrito
     * @param unArticulo Articulo a sacar del carrito
     * POS: Elimina del carrito "unArticulo"
     */
    void sacarDelCarrito(IArticulo unArticulo);
    
    /**
     * PRE: El envase esta en el carrito
     * @param unEnvase Envase a sacar del carrito
     * @param cantidadEnvases Cantidad de envases a sacar de "unEnvase"
     * POS: Elimina la cantidad de envases de "unEnvase" del carrito
     */
    void sacarDelCarrito(IEnvase unEnvase, int cantidadEnvases);
    
    /**
     * PRE: -
     * @param productoABuscar String a buscar en los articulos del EcoShop
     * @return Retorna una lsita de articulos que contienen el string 
     * productoABuscar
     */
    ArrayList<IArticulo> buscarProducto(String productoABuscar);
    
    /**
     * PRE: -
     * @param unCarrito Carrito con los articulos y envases a registrar en la 
     * PreVenta
     * @param fechaDeRetiro Fecha de retiro de la PreVenta
     * POS: Registra la PreVenta al EcoShop
     */
    void registrarPreVenta(ICarrito unCarrito, Date fechaDeRetiro);
    
    /**
     * PRE: -
     * @param unCarrito Carrito con los articulos y envases a registrar en la 
     * VentaExpress
     * POS: Registra la VentaExpress al EcoShop
     */
    void registrarVentaExpress(ICarrito unCarrito);
    
    /**
     * PRE: -
     * @param unaPreVenta PreVenta a la cual se le genera el ticket
     * POS: Crea un documento pdf (Ticket) de la PreVenta y lo registra
     * a EcoShop
     */
    void generarTicket(IPreVenta unaPreVenta);
    
    /**
     * PRE: -
     * @param unaVentaExpress VentaExpress a la cual se le genera el ticket
     * POS: Crea un documento pdf (Ticket) de la VentaExpress y lo registra 
     * a EcoShop
     */
    void generarTicket(IVentaExpress unaVentaExpress);
    
    /**
     * PRE: -
     * @return Retorna los envases en el Stock 
     */
    ArrayList<IEnvase> envasesEnStock();
    
    /**
     * PRE: El envase ya esta en el stock
     * @param unEnvase Envase a eliminar del stock
     * @param cantidadEnvases Cantidad de envases de "unEnvase" a eliminar
     */
    void eliminarEnvaseDelStock(IEnvase unEnvase, int cantidadEnvases);
    
    /**
     * PRE: -
     * @param unEnvase Envase a ingresar al stock
     * @param cantidadEnvases Cantidad de envases de "unEnvase" a agregar al 
     * stock
     * POS: Agrega la cantidad de envases de "unEnvase" al Stock
     */
    void ingresarEnvaseEnStock(IEnvase unEnvase, int cantidadEnvases);
    
    /**
     * PRE: -
     * @param unArticulo Articulo a registrar
     * POS: Registra el articulo a EcoShop
     */
    void registrarArticulo(IArticulo unArticulo);
    
    /**
     * PRE -
     * @param unProveedor Provedoor a registrar
     * POS: Registra el proveedor a EcoShop
     */
    void registrarProveedor(IProveedor unProveedor);
    
    /**
     * PRE -
     * @param unCajero Cajero a registrar
     * POS: Registra el cajero a EcoShop
     */
    void registrarCajero(ICajero unCajero);
    
    /**
     * PRE -
     * @param unPuntoDeVenta Punto de Venta a registrar
     * POS: Registra el punto de venta a EcoShop
     */
    void registrarPuntoDeVenta(IPuntoDeVenta unPuntoDeVenta);
    
    
}
