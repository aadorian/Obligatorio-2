package interfazDominio;

import java.util.ArrayList;

/**
 * Interfaz IArticulo - Lista las funcionalidades que debe tener cualquier
 * implementacion.
 * @author Marcos Novelli - Matias Salles
 */
public interface IArticulo {
    
    /**
     * 
     * @return Retorna el nombre del articulo
     */
    String obtenerNombre();
    
    /**
     * 
     * @return Retorna el calificador del articulo 
     * (ej: Fruta, Verdura, Fruto Seco)
     */
    String obtenerCalificador();
    
    /**
     * 
     * @return Retorna la ruta a la imagen asociada al articulo
     */
    String obtenerRutaDeImagen();
    
    /**
     * 
     * @return Retorna el precio por kilogramo del articulo
     */
    double obtenerPrecioPorKG();
    
    /**
     * 
     * @return Retorna el origen del articulo (un IProveedor)
     */
    IProveedor obtenerOrigen();
    
    /**
     * POS: Modifica el origen actual del articulo por unProveedor
     * @param unProveedor Proveedor a colocar como origen del articulo
     */
    void modificarOrigen(IProveedor unProveedor);
    
    /**
     * 
     * @return Retorna el codigo identificador del articulo (debe ser unico)
     */
    int obtenerCodigoIdentificador();
    
    /**
     * 
     * @return Retorna una lista con los envases aplicables al articulo
     */
    ArrayList<IEnvase> obtenerEnvasesAplicables();
    
    /**
     * POS: Agrega unEnvase como envase aplicable al articulo
     * @param unEnvase Envase a agregar como envase aplicable al articulo
     */
    void agregarEnvase(IEnvase unEnvase);
    
    /**
     * 
     * @param unArticulo Articulo a comparar con this
     * @return Retorna true si ambos articulos tienen el mismo nombre, false en
     * caso contrario
     */
    boolean sonIgualesPorNombre(IArticulo unArticulo); 
    
    /**
     * 
     * @param unArticulo Articulo a comparar con this
     * @return Retorna true si ambos articulos tienen el mismo codigo identificador,
     * false en caso contrario
     */
    boolean sonIgualesPorId(IArticulo unArticulo);
    
    /**
     *
     * @return Retorna un string que contiene el nombre del articulo y su
     * codigo identificador de la siguiente forma: [nombre] ([codigo identificador])
     */
    @Override
    String toString();
}
