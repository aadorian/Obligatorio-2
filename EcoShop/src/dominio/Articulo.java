package dominio;

import java.util.ArrayList;
/**
 * Clase Articulo - Contiene toda la informacion de los articulos necesaria 
 * para realizar las funcionalidades listadas del sistema
 * @author Marcos Novelli - Matias Salles
 */
public class Articulo {
    //Atributos
    private int codigoIdentificador; //Codigo identificador unico del articulo
    private double precio;
    private double densidad; //Para calcular cuantos envases son necesarios
    private Proveedor origenDelArticulo;
    private boolean organico;
    private ArrayList<Envase> envasesAplicables;

    //Getter & Setter
    public int getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public void setCodigoIdentificador(int codigoIdentificador) {
        this.codigoIdentificador = codigoIdentificador;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDensidad() {
        return densidad;
    }

    public void setDensidad(double densidad) {
        this.densidad = densidad;
    }

    public Proveedor getOrigenDelArticulo() {
        return origenDelArticulo;
    }

    public void setOrigenDelArticulo(Proveedor origenDelArticulo) {
        this.origenDelArticulo = origenDelArticulo;
    }

    public boolean isOrganico() {
        return organico;
    }

    public void setOrganico(boolean organico) {
        this.organico = organico;
    }

    public ArrayList<Envase> getEnvasesAplicables() {
        return envasesAplicables;
    }

    public void setEnvasesAplicables(ArrayList<Envase> envasesAplicables) {
        this.envasesAplicables = envasesAplicables;
    }
    
    
}
