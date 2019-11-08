package dominio;

/**
 * Clase Punto de Venta - Contiene la informacion de los puntos de venta EcoShop
 * , hace referencia a los locales
 * @author Marcos Novelli - Matias Salles
 */
public class PuntoDeVenta {
    //Atributos
    private Direccion direccionLocal;
    private int numeroDelLocal;//Numero del local unico 
    
    //Constructores
    public PuntoDeVenta(){
        this.direccionLocal = new Direccion();
        this.numeroDelLocal = -1;
    }
    
    public PuntoDeVenta(Direccion direccionLocal, int numeroDelLocal) {
        this.direccionLocal = direccionLocal;
        this.numeroDelLocal = numeroDelLocal;
    }
    
    //Getter & Setter
    public Direccion getDireccionLocal() {
        return direccionLocal;
    }

    public void setDireccionLocal(Direccion direccionLocal) {
        this.direccionLocal = direccionLocal;
    }

    public int getNumeroDelLocal() {
        return numeroDelLocal;
    }

    public void setNumeroDelLocal(int numeroDelLocal) {
        this.numeroDelLocal = numeroDelLocal;
    }
    
}
