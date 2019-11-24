package interfazDominio;

/**
 * Interfaz IProveedor
 * @author Marcos Novelli - Matias Salles
 */
public interface IProveedor {
    
    /**
     * POS: Modifica la direccion vieja del proveedor con la nueva
     * @param unaDireccion Direccion nueva del proveedor
     */
    void modificarDireccion(IDireccion unaDireccion);
    
    /**
     * 
     * @return Retorna el nombre del proveedor
     */
    String obtenerNombre();
    
    /**
     * 
     * @return Retorna la direccion del proveedor
     */
    IDireccion obtenerDireccion();
    
}
