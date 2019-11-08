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
    private ArrayList<Envase> envasesAplicables;

    //Constructores
    public Articulo(){
        this.codigoIdentificador = -1;
        this.precio = -1;
        this.densidad = -1;
        this.origenDelArticulo = new Proveedor();
        this.envasesAplicables = new ArrayList<>();
    }
    
    public Articulo(double precio, double densidad, Proveedor origenDelArticulo, 
            ArrayList<Envase> envasesAplicables) {
        this.codigoIdentificador = -1; //Luego se settea en la clase EcoShop
        this.precio = precio;
        this.densidad = densidad;
        this.origenDelArticulo = origenDelArticulo;
        this.envasesAplicables = envasesAplicables;
    }
    
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

    public ArrayList<Envase> getEnvasesAplicables() {
        return envasesAplicables;
    }

    public void setEnvasesAplicables(ArrayList<Envase> envasesAplicables) {
        this.envasesAplicables = envasesAplicables;
    }
    
}
