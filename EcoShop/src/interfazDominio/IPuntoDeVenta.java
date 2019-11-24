package interfazDominio;

/**
 * Interfaz IPuntoDeVenta
 * @author Marcos Novelli - Matias Salles
 */
public interface IPuntoDeVenta {
    
    /**
     * POS: Modifica la direccion vieja del punto de venta con la nueva
     * @param unaDireccion Direccion nueva del punto de venta
     */
    void modificarDireccion(IDireccion unaDireccion);
    
    /**
     * 
     * @return Retorna la direccion del Punto de Venta
     */
    IDireccion obtenerDireccionDelLocal();
    
    /**
     * 
     * @return Retorna el numero del Punto de Venta
     */
    int obtenerNumeroDeLocal();
    
    /**
     * 
     * @return Retorna la ruta a la imagen asociada con el Punto de Venta
     */
    String obtenerRutaDeImagen();
    
    /**
     *
     * @return Retorna un string de la siguiente forma:
     * [numero de local] - [calle]
     */
    @Override
    String toString();
}
