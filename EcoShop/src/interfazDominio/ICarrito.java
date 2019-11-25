package interfazDominio;

import java.util.ArrayList;
import javafx.util.Pair;

/**
 * Interfaz ICarrito - Lista las funcionalidades que debe tener cualquier
 * implementacion, usa Pair para los articulos y envases elegidos por 
 * el usuario al igual que la cantidad (kg) del articulo elegido
 * @author Marcos Novelli - Matias Salles
 */
public interface ICarrito {
    
    /**
     * POS: Agrega al carrito el articulo y cantidad seleccionada por el usuario
     * @param unArticulo Articulo a agregar al carrito
     * @param pesoEnKg Cantidad en kg a agregar del articulo al carrito
     */
    void agregarArticulo(IArticulo unArticulo, double pesoEnKg);
    
    /**
     * POS: Agrega al carrito el envase al articulo seleccionado por el usuario
     * @param unArticulo Articulo al cual se le asocia el envase
     * @param unEnvase Envase seleccionado para aplicarle a unArticulo
     */
    void agregarEnvase(IArticulo unArticulo, IEnvase unEnvase);
    
    /**
     * 
     * @return Retorna una lista de pares donde cada par representa el articulo
     * en el carrito y la cantidad en kg seleccionada del mismo.
     */
    ArrayList<Pair<IArticulo, Double>> obtenerListaArticulos();
    
    /**
     * POS: Elimina el articulo del carrito, si es que este esta en el mismo
     * @param unArticulo Articulo a eliminar del carrito
     */
    void eliminarArticuloDelCarrito(IArticulo unArticulo);
    
    /**
     * PRE: El articulo se encuentra en el carrito
     * @param unArticulo Articulo a buscar en el carrito
     * @return Devuelve la posicion en la lista del articulo
     */
    int posicionDelArticuloEnElCarrito(IArticulo unArticulo);
    
    /**
     * 
     * @param unArticulo Articulo a buscar en el carrito
     * @return Retorna true si el articulo se encuentra en el carrito, false en
     * caso contrario
     */
    boolean articuloEstaEnElCarrito(IArticulo unArticulo);
    
    /**
     * POS: Elimina el envase asociado al articulo
     * @param unArticulo Articulo a buscar en el carrito
     */
    void eliminarEnvaseDelCarrito(IArticulo unArticulo);
    
    /**
     * PRE: El articulo se encuentra en el carrito
     * @param unArticulo Articulo a buscar en el carrito
     * @return Retorna el envase asociado al articulo
     */
    IEnvase obtenerEnvaseAsociadoAlArticulo(IArticulo unArticulo);
    
    /**
     * 
     * @param unArticulo Articulo a buscar en el carrito
     * @return Retorna true si el articulo tiene un envase asociado, false en
     * caso contrario
     */
    boolean articuloTieneEnvaseAsociado(IArticulo unArticulo);
    
    /**
     * 
     * @return Retorna true si todos los articulos en el carrito tienen un
     * envase asociado, false en caso contrario
     */
    boolean todosLosArticulosEnElCarritoTienenEnvaseAsociado();
    
    /**
     * 
     * @return Retorna la suma total del carrito
     */
    double obtenerPrecioTotal();
}
