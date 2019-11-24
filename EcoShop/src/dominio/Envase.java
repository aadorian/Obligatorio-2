package dominio;

import interfazDominio.IEnvase;
/**
 * Clase Envase - Implementacion de IEnvase
 * @author Marcos Novelli - Matias Salles
 */
public class Envase implements IEnvase{
    //Atributos
    private String nombreEnvase;
    private String rutaImagen;
    
    //Constructores
    public Envase(){
        this.nombreEnvase = "";
        this.rutaImagen = "";
    }
    
    public Envase(String nombreEnvase, String rutaImagen) {
        this.nombreEnvase = nombreEnvase;
        this.rutaImagen = rutaImagen;
    }
    
    //Getter & Setter
    public String getNombreEnvase() {
        return nombreEnvase;
    }

    public void setNombreEnvase(String nombreEnvase) {
        this.nombreEnvase = nombreEnvase;
    }
    
    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
    
    //
    //METODOS PUBLICOS
    //
    @Override
    public String obtenerNombre() {
        return this.getNombreEnvase();
    }
    
    @Override
    public boolean sonIguales(IEnvase unEnvase) {
        return this.obtenerNombre().equals(unEnvase.obtenerNombre());
    }
    
    @Override
    public String obtenerRutaImagen(){
        return this.getRutaImagen();
    }

}
