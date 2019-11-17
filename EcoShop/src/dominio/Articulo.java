package dominio;

import java.util.ArrayList;
import interfazDominio.IArticulo;
import interfazDominio.IProveedor;
import interfazDominio.IEnvase;
/**
 * Clase Articulo - Contiene toda la informacion de los articulos necesaria 
 * para realizar las funcionalidades listadas del sistema
 * @author Marcos Novelli - Matias Salles
 */
public class Articulo implements IArticulo{
    //Atributos
    private String nombreArticulo;
    private String rutaImagen; //Path en donde se encuentra la imagen del articulo
    private int codigoIdentificador; //Codigo identificador unico del articulo
    private double precioPorKG; 
    private double densidad; //Para calcular cuantos envases son necesarios
    private IProveedor origenDelArticulo;
    private ArrayList<IEnvase> envasesAplicables;
    

    //Constructores
    public Articulo(){
        this.nombreArticulo = "";
        this.rutaImagen = "";
        this.codigoIdentificador = -1;
        this.precioPorKG = -1;
        this.densidad = -1;
        this.origenDelArticulo = new Proveedor();
        this.envasesAplicables = new ArrayList<>();
    }

    public Articulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
        this.rutaImagen = "";
        this.codigoIdentificador = -1;
        this.precioPorKG = -1;
        this.densidad = -1;
        this.origenDelArticulo = new Proveedor();
        this.envasesAplicables = new ArrayList<>();
    }
    
    public Articulo(double precio, double densidad, IProveedor origenDelArticulo, 
            ArrayList<IEnvase> envasesAplicables, String nombreArticulo,
            String rutaImagen) {
        this.nombreArticulo = nombreArticulo;
        this.rutaImagen = rutaImagen;
        this.codigoIdentificador = -1; //Luego se settea en la clase EcoShop
        this.precioPorKG = precio;
        this.densidad = densidad;
        this.origenDelArticulo = origenDelArticulo;
        this.envasesAplicables = envasesAplicables;
    }

    //Getter & Setter
    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }
    
    public void setRutaImagen(String rutaImagen) {    
        this.rutaImagen = rutaImagen;
    }

    public int getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public void setCodigoIdentificador(int codigoIdentificador) {
        this.codigoIdentificador = codigoIdentificador;
    }

    public double getPrecioPorKG() {
        return precioPorKG;
    }

    public void setPrecioPorKG(double precio) {
        this.precioPorKG = precio;
    }

    public double getDensidad() {
        return densidad;
    }

    public void setDensidad(double densidad) {
        this.densidad = densidad;
    }

    public IProveedor getOrigenDelArticulo() {
        return origenDelArticulo;
    }

    public void setOrigenDelArticulo(IProveedor origenDelArticulo) {
        this.origenDelArticulo = origenDelArticulo;
    }

    public ArrayList<IEnvase> getEnvasesAplicables() {
        return envasesAplicables;
    }

    public void setEnvasesAplicables(ArrayList<IEnvase> envasesAplicables) {
        this.envasesAplicables = envasesAplicables;
    }

    //
    //METODOS PUBLICOS
    //
    
    @Override
    public int obtenerCodigoIdentificador() {
        return this.getCodigoIdentificador();
    }

    @Override
    public ArrayList<IEnvase> obtenerEnvasesAplicables() {
        return this.getEnvasesAplicables();
    }

    @Override
    public String obtenerNombre() {
        return this.getNombreArticulo();
    }

    @Override
    public String obtenerRutaDeImagen() {
        return this.getRutaImagen();
    }

    @Override
    public double obtenerPrecioPorKG() {
        return this.getPrecioPorKG();
    }

    @Override
    public double obtenerDensidad() {
        return this.getDensidad();
    }

    @Override
    public IProveedor obtenerOrigen() {
        return this.getOrigenDelArticulo();
    }

    @Override
    public boolean sonIguales(IArticulo unArticulo) {
        return this.obtenerNombre().equals(unArticulo.obtenerNombre());
    }

    @Override
    public void modificarCodigoIdentificador(int nuevoCodigo) {
        this.setCodigoIdentificador(nuevoCodigo);
    }

    @Override
    public void modificarOrigen(IProveedor unProveedor) {
        this.setOrigenDelArticulo(unProveedor);
    }
    
    
    
}
