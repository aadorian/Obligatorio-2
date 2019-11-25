package dominio;

import interfazDominio.IDireccion;
import interfazDominio.IPuntoDeVenta;
/**
 * Clase Punto de Venta - Implementacion de IPuntoDeVenta
 * @author Marcos Novelli - Matias Salles
 */
public class PuntoDeVenta implements IPuntoDeVenta{
    //Atributos
    private IDireccion direccionLocal;
    private int numeroDelLocal;//Numero del local unico 
    String rutaDeImagen;
    
    //Constructores
    public PuntoDeVenta(){
        this.direccionLocal = new Direccion();
        this.numeroDelLocal = -1;
        this.rutaDeImagen = "";
    }

    public PuntoDeVenta(int numeroDelLocal, String rutaDeImagen) {
        this.direccionLocal = new Direccion();
        this.numeroDelLocal = numeroDelLocal;
        this.rutaDeImagen = "";
    }
    
    public PuntoDeVenta(IDireccion direccionLocal, int numeroDelLocal) {
        this.direccionLocal = direccionLocal;
        this.numeroDelLocal = numeroDelLocal;
    }
    
    //Getter & Setter
    public IDireccion getDireccionLocal() {
        return direccionLocal;
    }

    public void setDireccionLocal(IDireccion direccionLocal) {
        this.direccionLocal = direccionLocal;
    }

    public int getNumeroDelLocal() {
        return numeroDelLocal;
    }

    public void setNumeroDelLocal(int numeroDelLocal) {
        this.numeroDelLocal = numeroDelLocal;
    }

    public String getRutaDeImagen() {
        return rutaDeImagen;
    }

    public void setRutaDeImagen(String rutaDeImagen) {
        this.rutaDeImagen = rutaDeImagen;
    }
    
    //
    //METODOS PUBLICOS
    //

    @Override
    public void modificarDireccion(IDireccion unaDireccion) {
        this.setDireccionLocal(unaDireccion);
    }

    @Override
    public IDireccion obtenerDireccionDelLocal() {
        return this.getDireccionLocal();
    }

    @Override
    public int obtenerNumeroDeLocal() {
        return this.getNumeroDelLocal();
    }

    @Override
    public String obtenerRutaDeImagen() {
        return this.getRutaDeImagen();
    }
    
    @Override
    public String toString() {
        return this.obtenerNumeroDeLocal() + " - " + this.obtenerDireccionDelLocal()
                .obtenerCalle();
    }
    
}
