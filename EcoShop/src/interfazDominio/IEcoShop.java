package interfazDominio;

import java.util.ArrayList;
/**
 * Interfaz IEcoShop - se listan las funcionalidades principales que 
 * necesitarán ser accedidas por la interfaz gráfica
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
     * @return Retorna una lista con todos los envases registrados en EcoShop
     */
    ArrayList<IEnvase> obtenerListaEnvases();
    
    /**
     * PRE: El articulo a buscar esta registrado
     * @param nombre Nombre del articulo a buscar
     * @return Retorna el primer articulo que coincida en nombre
     */
    IArticulo obtenerArticuloPorNombre(String nombre);
    
    /**
     * PRE: El envase a buscar esta registrado
     * @param nombre Nombre del envase a buscar
     * @return Retorna el primer envase que coincida en nombre
     */
    IEnvase obtenerEnvasePorNombre(String nombre);
    
    /**
     * 
     * @return Retorna el actual carrito del sistema
     */
    ICarrito obtenerCarrito();
    
    /**
     * 
     * @return Retorna una lista con todos los puntos de venta registrados
     */
    ArrayList<IPuntoDeVenta> obtenerListaPuntosDeVenta();
    
    /**
     * 
     * @return Retorna una lista con todos los articulos favoritos agregados
     * por el usuario
     */
    ArrayList<IArticulo> obtenerListaArticulosFavoritosPersonal();
    
    /**
     * 
     * @return  Retorna una lista con los "top 4" articulos preferidos globalmente
     */
    ArrayList<IArticulo> obtenerListaArticulosFavoritosGlobal();
    
    /**
     * 
     * @param unArticulo Articulo al cual guardar en un envase
     * @return Retorna una lista de envases que son aplicables(compatibles) con
     * el articulo por parametro
     */
    ArrayList<IEnvase> obtenerListaEnvasesAplicables(IArticulo unArticulo);
    
    /**
     * 
     * @return Retorna una lista con todas las pre ventas registradas
     */
    ArrayList<IPreVenta> obtenerListaPreVentas();
    
    /**
     * 
     * @return Retorna una lista con todos los tickets pre venta registrados
     */
    ArrayList<ITicketPreVenta> obtenerTicketsPreVenta();
    
    /**
     * 
     * @return Retorna una lista con los articulos mas vendidos en base a los 
     * tickets del sistema
     */
    ArrayList<IArticulo> obtenerArticulosMasVendidos();
    
    /**
     * 
     * @return Retorna la cantidad de envases reutilizados, basado en los tickets
     */
    int cantidadDeEnvasesReutilizados();
    
    /**
     * 
     * POS: Agrega al carrito el articulo y el peso seleccionado
     * @param unArticulo Articulo a agregar al carrito
     * @param peso Cantidad en kg seleccionada del articulo
     */
    void agregarAlCarrito(IArticulo unArticulo, double peso);
    
    /**
     * PRE: El articulo esta en el carrito
     * POS: Elimina del carrito "unArticulo"
     * @param unArticulo Articulo a sacar del carrito
     */
    void sacarDelCarrito(IArticulo unArticulo);
    
    /**
     *
     * @param productoABuscar String a buscar en los articulos del EcoShop
     * @param calficador
     * @return Retorna una lsita de articulos que contienen el string 
     * productoABuscar y coinciden con el calificador (Si el calificador es 
     * "Todos" entonces devuelve todos los que contienen el string productoABuscar,
     * si productoABuscar es "" entonces devuelve todos los que coincidan en el
     * calificador)
     */
    ArrayList<IArticulo> buscarProducto(String productoABuscar, String calficador);
    
    /**
     *
     * POS: Registra la PreVenta al sistema
     * @param unaPreVenta PreVenta a registrar
     * 
     */
    void registrarPreVenta(IPreVenta unaPreVenta);
    
    /**
     * 
     * POS: Crea un TicketPreVenta en base a la pre venta y lo registra en el 
     * sistema
     * @param unaPreVenta PreVenta a la cual se le genera el ticket
     */
    void generarTicket(IPreVenta unaPreVenta);
    
    /**
     * 
     * POS: Registra el articulo al sistema
     * @param unArticulo Articulo a registrar
     */
    void registrarArticulo(IArticulo unArticulo);
    
    /**
     * POS: Registra el envase el sistema
     * @param unEnvase Envase a registrar
     */
    void registrarEnvase(IEnvase unEnvase);
    
    /**
     * 
     * POS: Registra el proveedor al sistema
     * @param unProveedor Provedoor a registrar
     */
    void registrarProveedor(IProveedor unProveedor);
    
    /**
     * 
     * POS: Registra el punto de venta al sistema
     * @param unPuntoDeVenta Punto de Venta a registrar
     */
    void registrarPuntoDeVenta(IPuntoDeVenta unPuntoDeVenta);
    
    /**
     * POS: Registra la direccion al sistema
     * @param unaDireccion Direccion a registrar
     */
    void registrarDireccion(IDireccion unaDireccion);
    
    /**
     * 
     * @param unArticulo Articulo a buscar
     * @return Retorna true si el articulo esta en los favoritos agregados
     * por el usuario, false en caso contrario
     */
    boolean estaEnFavoritosPersonal(IArticulo unArticulo);
    
    /**
     * POS: Agrega el articulo a la lista de favoritos del usuario
     * @param unArticulo Articulo a añadir a los favoritos del usuario
     */
    void agregarAFavoritosPersonal(IArticulo unArticulo);
    
    /**
     * POS: Elimina el articulo de la lista de favoritos del usuario
     * @param unArticulo Articulo a eliminar de los favoritos del usuario
     */
    void sacarDeFavoritos(IArticulo unArticulo);
    
    /**
     * POS: Agrega el articulo a la lista de preferidos en el mundo
     * @param unArticulo Articulo a agregar a la lista de preferidos en el mundo
     */
    void agregarArticuloAFavoritosGlobal(IArticulo unArticulo);
    
    /**
     * PRE: El local a buscar esta registrado
     * @param numeroDelLocal Numero del local a buscar
     * @return Retorna el primer local que coincide en el numero de local
     */
    IPuntoDeVenta obtenerPuntoDeVentaPorNumeroDeLocal(int numeroDelLocal);
    
}
