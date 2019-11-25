package dominio;

import interfazDominio.IArticulo;
import interfazDominio.ICarrito;
import interfazDominio.IEnvase;
import java.util.ArrayList;
import javafx.util.Pair;
/**
 * Clase carrito - Implementacion de ICarrito
 * @author Marcos Novelli - Matias Salles
 */
public class Carrito implements ICarrito{
    //Atributos
    private ArrayList<Pair<IArticulo,Double>> listaArticulos; //Articlo y cantidad
    private ArrayList<Pair<IArticulo,IEnvase>> listaEnvases; //Articulo y Envase asociado
    private double precioTotal;

    //Constructores
    public Carrito() {
        listaArticulos = new ArrayList<>();
        listaEnvases = new ArrayList<>();
        precioTotal = 0;
    }

    public Carrito(ArrayList<Pair<IArticulo, Double>> listaArticulos, 
            ArrayList<Pair<IArticulo, IEnvase>> listaEnvases, double precioTotal) {
        this.listaArticulos = listaArticulos;
        this.listaEnvases = listaEnvases;
        this.precioTotal = precioTotal;
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
        //Precio del articulo a agregar
        double precioASumar = unArticulo.obtenerPrecioPorKG() * pesoEnKg;
        
        /*Si esta en el carrito no lo agregamos, sino que sumamos la cantidad que 
        lleva*/
        if(articuloEstaEnElCarrito(unArticulo)){
            //Var
            int posicionArticuloEnLista;
            Pair nuevaTuplaArticuloCantidad;
            Pair<IArticulo, Double> duplaArticulo;
            double kilosYaAgregados;
            double nuevoPeso;
            
            //Obtenemos cuantos kg ya habia seleccionado del articulo
            posicionArticuloEnLista = posicionDelArticuloEnElCarrito(unArticulo);
            duplaArticulo = listaArticulos.get(posicionArticuloEnLista);
            kilosYaAgregados = duplaArticulo.getValue();
            nuevoPeso = kilosYaAgregados + pesoEnKg;
            
            //Creamos la nueva tupla a agregar al carrito
            nuevaTuplaArticuloCantidad = new Pair(unArticulo, nuevoPeso);
            
            //Borramos la dupla anterior
            this.eliminarArticuloDelCarrito(unArticulo);
            //Agregamos la nueva dupla al carrito
            listaArticulos.add(nuevaTuplaArticuloCantidad);
        }
        else{
            // No esta en el carrito, creamos y agregamos una nueva dupla
            Pair nuevaTuplaArticuloCantidad = new Pair(unArticulo,pesoEnKg);
            
            listaArticulos.add(nuevaTuplaArticuloCantidad);
        }
        //Modificamos el precio total del carrito
        this.setPrecioTotal(this.getPrecioTotal() + precioASumar);
    }
    
    @Override
    public void agregarEnvase(IArticulo unArticulo, IEnvase unEnvase)
    {
        /*Si ya se habia seleccionado otro envase para el articulo, entonces
        eliminamos el envase anterior*/
        if(articuloTieneEnvaseAsociado(unArticulo))
            eliminarEnvaseDelCarrito(unArticulo);
        
        //Creamos la nueva dupla y la agregamos
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
            //Var
            Pair<IArticulo, Double> duplaTmp;
            IArticulo articuloTmp;
            double cantidadArticuloTmp;
            double precioARestar;
            
            duplaTmp = listaArticulos.get(i);
            articuloTmp = duplaTmp.getKey();
            cantidadArticuloTmp = duplaTmp.getValue();
            precioARestar = articuloTmp.obtenerPrecioPorKG() * cantidadArticuloTmp;
            
            //Si encuentro el articulo en la lista lo borro
            if(articuloTmp.sonIgualesPorId(unArticulo)){
                //Modificamos el precio total del carrito
                this.setPrecioTotal(this.getPrecioTotal() - precioARestar);
                
                listaArticulos.remove(i);
                break; //Salgo del for
            }
        }
    }

    @Override
    public int posicionDelArticuloEnElCarrito(IArticulo unArticulo) {
        
        for (int i = 0; i < listaArticulos.size(); i++) {
            //Var
            Pair<IArticulo, Double> duplaTmp;
            IArticulo articuloTmp;
            
            duplaTmp = listaArticulos.get(i);
            articuloTmp = duplaTmp.getKey();
            
            //Si encontramos el articulo retornamos su posicion
            if(articuloTmp.sonIgualesPorId(unArticulo)){
                return i;
            }
        }
        
        //Si no cumple la pre condicion paramos la ejecucion del programa
        assert(false);
        return -1;
    }

    @Override
    public boolean articuloEstaEnElCarrito(IArticulo unArticulo) {
        //Var
        boolean estaEnLaLista = false;
        
        for (int i = 0; i < listaArticulos.size() && !estaEnLaLista; i++) {
            //Var
            Pair<IArticulo, Double> duplaTmp = listaArticulos.get(i);
            IArticulo articuloTmp = duplaTmp.getKey();
            
            if(articuloTmp.sonIgualesPorId(unArticulo))
                estaEnLaLista = true;
        }
        
        return estaEnLaLista;
    }

    @Override
    public void eliminarEnvaseDelCarrito(IArticulo unArticulo) {
        
        for (int i = 0; i < listaEnvases.size(); i++) {
            //Var
            Pair<IArticulo, IEnvase> duplaTmp = listaEnvases.get(i);
            IArticulo articuloTmp = duplaTmp.getKey();
            
            //Si encontramos el articulo lo sacamos de la lista
            if(articuloTmp.sonIgualesPorId(unArticulo)){
                listaEnvases.remove(i);
                break; //Salgo del for
            }
        }
    }

    @Override
    public IEnvase obtenerEnvaseAsociadoAlArticulo(IArticulo unArticulo) {
        
        for (int i = 0; i < listaEnvases.size(); i++) {
            //Var
            Pair<IArticulo, IEnvase> duplaTmp = listaEnvases.get(i);
            IArticulo articuloTmp = duplaTmp.getKey();
            IEnvase envaseTmp = duplaTmp.getValue();
            
            //Si encontramos el articulo retornamos el envase (Value del pair)
            if(articuloTmp.sonIgualesPorNombre(unArticulo))
                return envaseTmp;
        }
        
        //Si no cumple la pre condicion paramos la ejecucion del programa
        assert(false);
        return null;
    }

    @Override
    public boolean articuloTieneEnvaseAsociado(IArticulo unArticulo) {
        //Var
        boolean estaEnLaLista = false;
        
        for (int i = 0; i < listaEnvases.size() && !estaEnLaLista; i++) {
            //Var
            Pair<IArticulo, IEnvase> duplaTmp = listaEnvases.get(i);
            IArticulo articuloTmp = duplaTmp.getKey();
            
            if(articuloTmp.sonIgualesPorNombre(unArticulo))
                estaEnLaLista = true;
        }
        
        return estaEnLaLista;
    }

    @Override
    public boolean todosLosArticulosEnElCarritoTienenEnvaseAsociado() {
        //Var
        boolean todosArticulosTienenEnvase = true;
        
        for (int i = 0; i < listaArticulos.size() && todosArticulosTienenEnvase; i++) {
            //Var
            Pair<IArticulo, Double> duplaTmp = listaArticulos.get(i);
            IArticulo articuloTmp = duplaTmp.getKey();
            
            if(!this.articuloTieneEnvaseAsociado(articuloTmp))
                todosArticulosTienenEnvase = false;
        }
        
        return todosArticulosTienenEnvase;
    }

    @Override
    public double obtenerPrecioTotal() {
        return this.getPrecioTotal();
    }
    
}
