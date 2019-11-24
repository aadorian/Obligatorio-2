package interfazDominio;

/**
 *Interfaz IDireccion - Tiene todos las funcionalidades que debe tener cualquier
 * implementacion, incluyendo la mayoria de los datos que conforman una direccion
 * @author Marcos Novelli - Matias Salles
 */
public interface IDireccion {
    
    /**
     * 
     * @return Retorna el Pais de la direccion
     */
    String obtenerPais();
    
    /**
     * 
     * @return Retorna el Departamento/Provincia/Estado de la direccion
     */
    String obtenerDepartamento();
    
    /**
     * 
     * @return Retorna la Calle de la direccion
     */
    String obtenerCalle();
    
    /**
     * 
     * @return Retorna el Barrio de la direccion
     */
    String obtenerBarrio();
    
    /**
     * 
     * @return Retorna el codigo postal de la direccion
     */
    int obtenerCodigoPostal();
}
