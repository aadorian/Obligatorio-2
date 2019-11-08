package dominio;

import java.util.ArrayList;
import javafx.util.Pair;
/**
 * Clase carrito - contiene los articulos y envases elegidos por el usuario
 * al igual que la cantidad (gramos) del articulo elegido
 * @author Marcos Novelli - Matias Salles
 */
public class Carrito {
    //Atributos
    private ArrayList<Pair<Articulo,Integer>> listaArticulos; //Articlo y cantidad
    private ArrayList<Pair<Envase,Integer>> listaEnvases; //Envase y cantidad
    private double precioTotal;

    //Getter & Setter
    public ArrayList<Pair<Articulo, Integer>> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(ArrayList<Pair<Articulo, Integer>> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    public ArrayList<Pair<Envase, Integer>> getListaEnvases() {
        return listaEnvases;
    }

    public void setListaEnvases(ArrayList<Pair<Envase, Integer>> listaEnvases) {
        this.listaEnvases = listaEnvases;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
    private void agregarArticulo(Articulo unArticulo, int pesoEnGramos)
    {
        Pair nuevaTuplaArticuloCantidad = new Pair(unArticulo,pesoEnGramos);
        
        listaArticulos.add(nuevaTuplaArticuloCantidad);
    }
    
    private void agregarEnvase(Envase unEnvase, int cantidadEnvases)
    {
        Pair nuevaTuplaEnvaseCantidad = new Pair(unEnvase,cantidadEnvases);
        
        listaEnvases.add(nuevaTuplaEnvaseCantidad);
    }
}
