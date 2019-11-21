package dominio;

import interfazDominio.IDireccion;
import interfazDominio.IPuntoDeVenta;
/**
 * Clase Punto de Venta - Contiene la informacion de los puntos de venta EcoShop
 * , hace referencia a los locales
 * @author Marcos Novelli - Matias Salles
 */
public class PuntoDeVenta implements IPuntoDeVenta{
    //Atributos
    private IDireccion direccionLocal;
    private int numeroDelLocal;//Numero del local unico 
    
    //Constructores
    public PuntoDeVenta(){
        this.direccionLocal = new Direccion();
        this.numeroDelLocal = -1;
    }

    public PuntoDeVenta(int numeroDelLocal) {
        this.direccionLocal = new Direccion();
        this.numeroDelLocal = numeroDelLocal;
    }
    
    public PuntoDeVenta(Direccion direccionLocal, int numeroDelLocal) {
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

    
}
