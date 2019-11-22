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
     * 
     * @return 
     */
    ArrayList<IEnvase> obtenerListaEnvases();
    
    /**
     * 
     * @param nombre
     * @return 
     */
    IArticulo obtenerArticuloPorNombre(String nombre);
    
    /**
     * 
     * @param nombre
     * @return 
     */
    IEnvase obtenerEnvasePorNombre(String nombre);
    
    /**
     * 
     * @return 
     */
    ICarrito obtenerCarrito();
    
    /**
     * 
     * @return 
     */
    ArrayList<IPuntoDeVenta> obtenerListaPuntosDeVenta();
    
    /**
     * 
     * @return 
     */
    ArrayList<IArticulo> obtenerListaArticulosFavoritosPersonal();
    
    /**
     * 
     * @return 
     */
    ArrayList<IArticulo> obtenerListaArticulosFavoritosGlobal();
    
    /**
     * PRE: -
     * @param unArticulo Articulo al cual guardar en un envase
     * @return Retorna una lista de envases que son aplicables(compatibles) con
     * el articulo por parametro
     */
    ArrayList<IEnvase> obtenerListaEnvasesAplicables(IArticulo unArticulo);
    
    /**
     * 
     * @return 
     */
    ArrayList<IPreVenta> obtenerListaPreVentas();
    
    /**
     * PRE: -
     * @param unEnvase Envase a utilizar para guardar "unArticulo"
     * @param unArticulo Articulo al cual guardar en "unEnvase"
     * @param pesoArticulo Cantidad en kg seleccionada de unArticulo
     * @return Retorna la cantidad de "unEnvase" necesarios para almacenar 
     * la cantidad (pesoArticulo) de "unArticulo"
     */
    int cantidadEnvasesNecesarios(IEnvase unEnvase, IArticulo unArticulo, 
            int pesoArticulo);
    
    //Funcion de mapa
    
    /**
     * PRE: -
     * POST: Agrega al carrito el articulo y el peso seleccionado
     * @param unArticulo Articulo a agregar al carrito
     * @param peso Cantidad en kg seleccionada del articulo
     */
    void agregarAlCarrito(IArticulo unArticulo, double peso);
    
    /**
     * PRE: -
     * POST: Agrega al carrito el envase y la cantidad necesaria de él.
     * @param unEnvase Envase a agregar al carrito
     * @param cantidadEnvases Cantidad de "unEnvase" a agregar al carrito
     */
    void agregarAlCarrito(IEnvase unEnvase, int cantidadEnvases);
    
    /**
     * PRE: El articulo esta en el carrito
     * POST: Elimina del carrito "unArticulo"
     * @param unArticulo Articulo a sacar del carrito
     */
    void sacarDelCarrito(IArticulo unArticulo);
    
    /**
     * PRE: El envase esta en el carrito
     * POST: Elimina la cantidad de envases de "unEnvase" del carrito
     * @param unEnvase Envase a sacar del carrito
     * @param cantidadEnvases Cantidad de envases a sacar de "unEnvase"
     */
    void sacarDelCarrito(IEnvase unEnvase, int cantidadEnvases);
    
    /**
     * PRE: -
     * @param productoABuscar String a buscar en los articulos del EcoShop
     * @param calficador
     * @return Retorna una lsita de articulos que contienen el string 
     * productoABuscar y coinciden con el calificador (Si el calificador es 
     * "Todos" entonces devuelve todos los que contienen el string productoABuscar)
     */
    ArrayList<IArticulo> buscarProducto(String productoABuscar, String calficador);
    
    /**
     * PRE: -
     * POST: Registra la PreVenta al EcoShop
     * @param unaPreVenta
     * @param unCarrito Carrito con los articulos y envases a registrar en la 
     * PreVenta
     * @param fechaDeRetiro Fecha de retiro de la PreVenta
     * 
     */
    void registrarPreVenta(IPreVenta unaPreVenta);
    
    /**
     * PRE: -
     * POST: Crea un documento pdf (Ticket) de la PreVenta y lo registra
     * a EcoShop
     * @param unaPreVenta PreVenta a la cual se le genera el ticket
     */
    void generarTicket(IPreVenta unaPreVenta);
    
    /**
     * PRE: -
     * POST: Registra el articulo a EcoShop
     * @param unArticulo Articulo a registrar
     */
    void registrarArticulo(IArticulo unArticulo);
    
    /**
     * 
     * @param unEnvase
     */
    void registrarEnvase(IEnvase unEnvase);
    
    /**
     * PRE -
     * POST: Registra el proveedor a EcoShop
     * @param unProveedor Provedoor a registrar
     */
    void registrarProveedor(IProveedor unProveedor);
    
    /**
     * PRE -
     * POST: Registra el punto de venta a EcoShop
     * @param unPuntoDeVenta Punto de Venta a registrar
     */
    void registrarPuntoDeVenta(IPuntoDeVenta unPuntoDeVenta);
    
    /**
     * 
     * @param unaDireccion 
     */
    void registrarDireccion(IDireccion unaDireccion);
    
    /**
     * 
     * @param unArticulo
     * @return 
     */
    boolean estaEnFavoritosPersonal(IArticulo unArticulo);
    
    /**
     * 
     * @param unArticulo 
     */
    void agregarAFavoritosPersonal(IArticulo unArticulo);
    
    /**
     * 
     * @param unArticulo 
     */
    void sacarDeFavoritos(IArticulo unArticulo);
    
    /**
     * 
     * @param unArticulo 
     */
    void agregarArticuloAFavoritosGlobal(IArticulo unArticulo);
    
    /**
     * 
     * @param numeroDelLocal
     * @return 
     */
    IPuntoDeVenta obtenerPuntoDeVentaPorNumeroDeLocal(int numeroDelLocal);
    
}
