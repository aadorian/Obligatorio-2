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
    private ArrayList<Pair<IArticulo,IEnvase>> listaEnvases; //Envase y Articulo asociado
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

    public ArrayList<Pair<IArticulo,IEnvase>> getListaEnvases() {
        return listaEnvases;
    }

    public void setListaEnvases(ArrayList<Pair<IArticulo,IEnvase>> listaEnvases) {
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
        double precioASumar = unArticulo.obtenerPrecioPorKG() * pesoEnKg;
        
        if(articuloEstaEnElCarrito(unArticulo)){
            int posicionArticuloEnLista = posicionDelArticuloEnElCarrito(unArticulo);
            Pair<IArticulo, Double> duplaArticulo = 
                    listaArticulos.get(posicionArticuloEnLista);
            Double kilosYaAgregados = duplaArticulo.getValue();
            double nuevoPeso = kilosYaAgregados + pesoEnKg;
            Pair nuevaTuplaArticuloCantidad = new Pair(unArticulo,nuevoPeso);
            
            this.eliminarArticuloDelCarrito(unArticulo);
            listaArticulos.add(nuevaTuplaArticuloCantidad);
        }
        else{
            Pair nuevaTuplaArticuloCantidad = new Pair(unArticulo,pesoEnKg);
            listaArticulos.add(nuevaTuplaArticuloCantidad);
        }
        
        this.setPrecioTotal(this.getPrecioTotal() + precioASumar);
    }
    
    @Override
    public void agregarEnvase(IArticulo unArticulo, IEnvase unEnvase)
    {
        if(articuloTieneEnvaseAsociado(unArticulo))
            eliminarEnvaseDelCarrito(unArticulo);
            
        Pair nuevaTuplaEnvaseCantidad = new Pair(unArticulo, unEnvase);
        
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

    @Override
    public boolean articuloEstaEnElCarrito(IArticulo unArticulo) {
        boolean estaEnLaLista = false;
        
        for (int i = 0; i < listaArticulos.size() && !estaEnLaLista; i++) {
            Pair<IArticulo, Double> duplaTmp = listaArticulos.get(i);
            IArticulo articuloTmp = duplaTmp.getKey();
            
            if(articuloTmp.sonIgualesPorNombre(unArticulo))
                estaEnLaLista = true;
        }
        
        return estaEnLaLista;
    }

    @Override
    public void eliminarEnvaseDelCarrito(IArticulo unArticulo) {
        for (int i = 0; i < listaEnvases.size(); i++) {
            Pair<IArticulo, IEnvase> duplaTmp = listaEnvases.get(i);
            
            if(duplaTmp.getKey().sonIgualesPorNombre(unArticulo)){
                listaEnvases.remove(i);
                break;
            }
        }
    }

    @Override
    public IEnvase obtenerEnvaseAsociadoAlArticulo(IArticulo unArticulo) {
        for (int i = 0; i < listaEnvases.size(); i++) {
            Pair<IArticulo, IEnvase> duplaTmp = listaEnvases.get(i);
            
            if(duplaTmp.getKey().sonIgualesPorNombre(unArticulo)){
                return duplaTmp.getValue();
            }
        }
        
        assert(false);
        return null;
    }

    @Override
    public boolean articuloTieneEnvaseAsociado(IArticulo unArticulo) {
        boolean estaEnLaLista = false;
        
        for (int i = 0; i < listaEnvases.size() && !estaEnLaLista; i++) {
            Pair<IArticulo, IEnvase> duplaTmp = listaEnvases.get(i);
            
            if(duplaTmp.getKey().sonIgualesPorNombre(unArticulo))
                estaEnLaLista = true;
        }
        return estaEnLaLista;
    }
    
}
