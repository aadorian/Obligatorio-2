package dominio;

import interfazDominio.IProveedor;
import interfazDominio.IDireccion;
/**
 * Clase Proveedor - Tiene la informacion de un proveedor de ciertos articulos
 * @author Marcos Novelli - Matias Salles
 */
public class Proveedor implements IProveedor{
    //Atributos
    private String nombreProveedor;
    private IDireccion direccionProveedor;

    //Contructores
    public Proveedor(){
        this.nombreProveedor = "";
        this.direccionProveedor = new Direccion();
    }
    
    public Proveedor(String nombreProveedor, IDireccion direccionProveedor) {
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

    public IDireccion getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(IDireccion direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }
    
    
}
