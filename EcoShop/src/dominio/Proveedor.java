package dominio;

/**
 * Clase Proveedor - Tiene la informacion de un proveedor de ciertos articulos
 * @author Marcos Novelli - Matias Salles
 */
public class Proveedor {
    //Atributos
    private String nombreProveedor;
    private Direccion direccionProveedor;

    //Contructores
    public Proveedor(){
        this.nombreProveedor = "";
        this.direccionProveedor = new Direccion();
    }
    
    public Proveedor(String nombreProveedor, Direccion direccionProveedor) {
        this.nombreProveedor = nombreProveedor;
        this.direccionProveedor = direccionProveedor;
    }
    
    //Getter & Setter
    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public Direccion getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(Direccion direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }
    
    
}
