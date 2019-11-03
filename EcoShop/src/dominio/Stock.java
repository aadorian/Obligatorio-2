package dominio;

import java.util.ArrayList;
/**
 * Clase Stock - Hace referencia al stock de envases que tienen todos los EcoShop
 * el cual esta disponible a los usuarios (por simplicidad asumimos que todos
 * los EcoShop (locales - puntos de venta) tienen el mismo Stock)
 * @author Marcos Novelli - Matias Salles
 */
public class Stock {
    //Atributos
    private ArrayList<Envase> listaEnvases;
    
    //Getter & Setter
    public ArrayList<Envase> getListaEnvases() {
        return listaEnvases;
    }

    public void setListaEnvases(ArrayList<Envase> listaEnvases) {
        this.listaEnvases = listaEnvases;
    }
    
}
