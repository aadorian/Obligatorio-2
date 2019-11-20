package dominio;

import interfazDominio.IArticulo;
import interfazDominio.ICarrito;
import interfazDominio.IEnvase;
import java.util.ArrayList;
import javafx.util.Pair;
/**
 * Clase carrito - contiene los articulos y envases elegidos por el usuario
 * al igual que la cantidad (gramos) del articulo elegido
 * @author Marcos Novelli - Matias Salles
 */
public class Carrito implements ICarrito{
    //Atributos
    private ArrayList<Pair<IArticulo,Double>> listaArticulos; //Articlo y cantidad
    private ArrayList<Pair<IEnvase,Double>> listaEnvases; //Envase y cantidad
    private double precioTotal;

    //Constructores
    public Carrito() {
        listaArticulos = new ArrayList<>();
        listaEnvases = new ArrayList<>();
        precioTotal = 0;
    }
    
    //Getter & Setter
    public ArrayList<Pair<IArticulo, Double>> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(ArrayList<Pair<IArticulo, Double>> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    public ArrayList<Pair<IEnvase, Double>> getListaEnvases() {
        return listaEnvases;
    }

    public void setListaEnvases(ArrayList<Pair<IEnvase, Double>> listaEnvases) {
        this.listaEnvases = listaEnvases;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
    @Override
    public void agregarArticulo(IArticulo unArticulo, double pesoEnKg)
    {
        //Checkear si ya existe
        
        Pair nuevaTuplaArticuloCantidad = new Pair(unArticulo,pesoEnKg);
        double precioASumar = unArticulo.obtenerPrecioPorKG() * pesoEnKg;
        
        this.setPrecioTotal(this.getPrecioTotal() + precioASumar);
        listaArticulos.add(nuevaTuplaArticuloCantidad);
    }
    
    @Override
    public void agregarEnvase(IEnvase unEnvase, double cantidadEnvases)
    {
        Pair nuevaTuplaEnvaseCantidad = new Pair(unEnvase,cantidadEnvases);
        
        listaEnvases.add(nuevaTuplaEnvaseCantidad);
    }

    @Override
    public ArrayList<Pair<IArticulo, Double>> obtenerListaArticulos() {
        return this.getListaArticulos();
    }

    @Override
    public void eliminarArticuloDelCarrito(IArticulo unArticulo) {
        
        for (int i = 0; i < listaArticulos.size(); i++) {
            Pair<IArticulo, Double> duplaTmp = listaArticulos.get(i);
            
            if(duplaTmp.getKey().sonIgualesPorNombre(unArticulo)){
                listaArticulos.remove(i);
                break;
            }
        }
    }

    @Override
    public int posicionDelArticuloEnElCarrito(IArticulo unArticulo) {
        
        for (int i = 0; i < listaArticulos.size(); i++) {
            Pair<IArticulo, Double> duplaTmp = listaArticulos.get(i);
            
            if(duplaTmp.getKey().sonIgualesPorNombre(unArticulo)){
                return i;
            }
        }
        
        assert(false);
        return -1;
    }
}
