package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.util.Pair;
/**
 * Clase Stock - Hace referencia al stock de envases que tienen todos los EcoShop
 * el cual esta disponible a los usuarios (por simplicidad asumimos que todos
 * los EcoShop (locales - puntos de venta) tienen el mismo Stock)
 * @author Marcos Novelli - Matias Salles
 */
public class Stock {
    //Atributos
    private ArrayList<Pair<Envase,Integer>> listaEnvases;
    
    //Constructores
    public Stock(){
        listaEnvases = new ArrayList<>();
    }
    
    public Stock(ArrayList<Pair<Envase, Integer>> listaEnvases) {
        this.listaEnvases = listaEnvases;
    }
    
    //Getter & Setter
    public ArrayList<Pair<Envase,Integer>> getListaEnvases() {
        return listaEnvases;
    }

    public void setListaEnvases(ArrayList<Pair<Envase,Integer>> listaEnvases) {
        this.listaEnvases = listaEnvases;
    }
    
    private void agregarEnvase(Envase unEnvase, int cantidad)
    {
        Pair nuevaTuplaEnvaseCantidad = new Pair(unEnvase, cantidad);
        
        listaEnvases.add(nuevaTuplaEnvaseCantidad);
    }
}
