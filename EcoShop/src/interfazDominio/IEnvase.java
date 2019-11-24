package interfazDominio;

/**
 * Interfaz IEnvase
 * @author Marcos Novelli - Matias Salles
 */
public interface IEnvase {
    
    /**
     * 
     * @return Retorna el nombre del envase
     */
    String obtenerNombre();
    
    /**
     * 
     * @param unEnvase Envase a comparar
     * @return Retorna si los envases son iguales en su nombre
     */
    boolean sonIguales(IEnvase unEnvase);
    
    /**
     * 
     * @return Retorna la ruta a la imagen asociada al envase
     */
    String obtenerRutaImagen();
}
