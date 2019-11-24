package dominio;

import interfazDominio.*;
import java.util.ArrayList;
import java.util.Random;
import javafx.util.Pair;

/**
 * Clase Ecoshop - Implementacion de IEcoShop
 * @author Marcos Novelli - Matias Salles
 */
public class EcoShop implements IEcoShop{
    //Atributos
    private ArrayList<IArticulo> listaArticulos;
    private ArrayList<IEnvase> listaEnvases;
    private ArrayList<IPuntoDeVenta> listaPuntosDeVenta;
    private ArrayList<IPreVenta> listaPreVentas;
    private ArrayList<ITicketPreVenta> listaTicketsPreVenta;
    private ArrayList<IProveedor> listaProveedores;
    private ArrayList<IDireccion> listaDirecciones;
    private ArrayList<IArticulo> listaFavoritosUsuario;
    private ArrayList<IArticulo> listaFavoritosGlobal;
    private ICarrito carritoDeCompras;

    public EcoShop() {
        listaArticulos = new ArrayList<>();
        listaEnvases = new ArrayList<>();
        listaPuntosDeVenta = new ArrayList<>();
        listaPreVentas = new ArrayList<>();
        listaTicketsPreVenta = new ArrayList<>();
        listaProveedores = new ArrayList<>();
        listaDirecciones = new ArrayList<>();
        listaFavoritosUsuario = new ArrayList<>();
        listaFavoritosGlobal = new ArrayList<>();
        carritoDeCompras = new Carrito();
    }
    
    //Getter & Setter
    public ArrayList<IProveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(ArrayList<IProveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }
    
    
    public ArrayList<IArticulo> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(ArrayList<IArticulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    public ArrayList<IEnvase> getListaEnvases() {
        return listaEnvases;
    }

    public void setListaEnvases(ArrayList<IEnvase> listaEnvases) {
        this.listaEnvases = listaEnvases;
    }

    public ArrayList<IPuntoDeVenta> getListaPuntosDeVenta() {
        return listaPuntosDeVenta;
    }

    public void setListaPuntosDeVenta(ArrayList<IPuntoDeVenta> listaPuntosDeVenta) {
        this.listaPuntosDeVenta = listaPuntosDeVenta;
    }

    public ArrayList<IPreVenta> getListaPreVentas() {
        return listaPreVentas;
    }

    public void setListaPreVentas(ArrayList<IPreVenta> listaPreVentas) {
        this.listaPreVentas = listaPreVentas;
    }

    public ArrayList<ITicketPreVenta> getListaTicketsPreVenta() {
        return listaTicketsPreVenta;
    }

    public void setListaTicketsPreVenta(ArrayList<ITicketPreVenta> listaTicketsPreVenta) {
        this.listaTicketsPreVenta = listaTicketsPreVenta;
    }

    public ICarrito getCarritoDeCompras() {
        return carritoDeCompras;
    }

    public void setCarritoDeCompras(ICarrito carritoDeCompras) {
        this.carritoDeCompras = carritoDeCompras;
    }

    public ArrayList<IDireccion> getListaDirecciones() {
        return listaDirecciones;
    }

    public void setListaDirecciones(ArrayList<IDireccion> listaDirecciones) {
        this.listaDirecciones = listaDirecciones;
    }

    public ArrayList<IArticulo> getListaFavoritosUsuario() {
        return listaFavoritosUsuario;
    }

    public void setListaFavoritosUsuario(ArrayList<IArticulo> listaFavoritosUsuario) {
        this.listaFavoritosUsuario = listaFavoritosUsuario;
    }

    public ArrayList<IArticulo> getListaFavoritosGlobal() {
        return listaFavoritosGlobal;
    }

    public void setListaFavoritosGlobal(ArrayList<IArticulo> listaFavoritosGlobal) {
        this.listaFavoritosGlobal = listaFavoritosGlobal;
    }
    
    //
    //METODOS PUBLICOS
    //
    
    @Override
    public ArrayList<IArticulo> obtenerListaArticulos() {
        return this.getListaArticulos();
    }

    @Override
    public ArrayList<IEnvase> obtenerListaEnvases() {
        return this.getListaEnvases();
    }
    
    @Override
    public ArrayList<IEnvase> obtenerListaEnvasesAplicables(IArticulo unArticulo) {
        //Var
        int posicionArticulo = listaArticulos.indexOf(unArticulo);
        IArticulo articuloTmp = listaArticulos.get(posicionArticulo);
        
        return articuloTmp.obtenerEnvasesAplicables();
    }

    @Override
    public IArticulo obtenerArticuloPorNombre(String nombre) {
        
        for (int i = 0; i < this.listaArticulos.size(); i++) {
            //Var
            IArticulo articuloTmp = this.listaArticulos.get(i);
            
            if(articuloTmp.obtenerNombre().equals(nombre))
                return articuloTmp;
        }
        
        //Si no se cumple la pre condicion paramos la ejecucion del programa
        assert(false);
        return null;
    }
    
    @Override
    public ICarrito obtenerCarrito() {
        return this.getCarritoDeCompras();
    }

    @Override
    public void agregarAlCarrito(IArticulo unArticulo, double peso) {
        carritoDeCompras.agregarArticulo(unArticulo, peso);
    }

    @Override
    public void sacarDelCarrito(IArticulo unArticulo) {
        carritoDeCompras.eliminarArticuloDelCarrito(unArticulo);
        carritoDeCompras.eliminarEnvaseDelCarrito(unArticulo);
    }

    @Override
    public ArrayList<IArticulo> buscarProducto(String productoABuscar, 
            String calificador) {
        //Var
        ArrayList<IArticulo> productosQueCoinciden = new ArrayList<>();
        
        //Pasamos todo a lower case para hacer una busqueda case insensitive
        productoABuscar = productoABuscar.toLowerCase();
        
        for (int i = 0; i < this.listaArticulos.size(); i++) {
            //Var
            IArticulo articuloTmp = this.listaArticulos.get(i);
            String nombreArticulo = articuloTmp.obtenerNombre().toLowerCase();
            
            //Si buscamos por todos solo checkeamos el texto a buscar
            if(calificador.equals("Todos") && nombreArticulo.
                    contains(productoABuscar)){
                productosQueCoinciden.add(articuloTmp);
            }
            //Si no hay texto sumamos todos los que tengan el mismo calificador
            else if(productoABuscar.equals("") && articuloTmp.obtenerCalificador().
                    equals(calificador)){
                productosQueCoinciden.add(articuloTmp);
            }
            //En el ultimo caso checkeamos calificador y texto a buscar
            else if(nombreArticulo.contains(productoABuscar) &&
                    articuloTmp.obtenerCalificador().equals(calificador)){
                productosQueCoinciden.add(articuloTmp);
            }
        }
        
        return productosQueCoinciden;
    }

    @Override
    public void registrarPreVenta(IPreVenta unaPreVenta) {
        /*Creamos un nuevo carrito ya que el anterior queda registrado para la
        pre venta*/
        ICarrito nuevoCarrito = new Carrito();
        
        this.setCarritoDeCompras(nuevoCarrito);
        this.listaPreVentas.add(unaPreVenta);
    }

    @Override
    public void generarTicket(IPreVenta unaPreVenta) {
        //Var
        int numeroIdentificador = this.listaTicketsPreVenta.size(); //Arbitrario
        ITicketPreVenta nuevoTicket = new TicketPreVenta(unaPreVenta, 
                numeroIdentificador);
        
        this.listaTicketsPreVenta.add(nuevoTicket);
    }

    @Override
    public void registrarArticulo(IArticulo unArticulo) {
        //Le asignamos un proveedor al azar y registramos el articulo
        unArticulo.modificarOrigen(proveedorRandom());
        this.listaArticulos.add(unArticulo);
    }

    @Override
    public void registrarEnvase(IEnvase unEnvase) {
        this.listaEnvases.add(unEnvase);
    }
    
    @Override
    public void registrarProveedor(IProveedor unProveedor) {
        //Le asignamos una direccion al azar y registramos el proveedor
        unProveedor.modificarDireccion(direccionRandom());
        this.listaProveedores.add(unProveedor);
    }

    @Override
    public void registrarPuntoDeVenta(IPuntoDeVenta unPuntoDeVenta) {
        //Le asignamos una direccion al azar y registramos el punto de venta
        unPuntoDeVenta.modificarDireccion(direccionRandom());
        this.listaPuntosDeVenta.add(unPuntoDeVenta);
    }

    @Override
    public void registrarDireccion(IDireccion unaDireccion) {
        this.listaDirecciones.add(unaDireccion);
    }
    
    @Override
    public boolean estaEnFavoritosPersonal(IArticulo unArticulo) {
        //Var
        boolean estaEnLaLista = false;
        
        for (int i = 0; i < this.listaFavoritosUsuario.size() && !estaEnLaLista; i++) {
            IArticulo articuloTmp = this.listaFavoritosUsuario.get(i);
            
            if(articuloTmp.sonIgualesPorId(unArticulo))
                estaEnLaLista = true;
        }
        
        return estaEnLaLista;
    }
    
    @Override
    public void agregarAFavoritosPersonal(IArticulo unArticulo) {
        this.listaFavoritosUsuario.add(unArticulo);
    }

    @Override
    public void sacarDeFavoritos(IArticulo unArticulo) {
        
        for (int i = 0; i < this.listaFavoritosUsuario.size(); i++) {
            //Var
            IArticulo articuloTmp = this.listaFavoritosUsuario.get(i);
            
            if (unArticulo.sonIgualesPorId(articuloTmp)) {
                this.listaFavoritosUsuario.remove(i);
            }
        }
    }
    
    @Override
    public IEnvase obtenerEnvasePorNombre(String nombre) {
        
        for (int i = 0; i < this.listaEnvases.size(); i++) {
            //Var
            IEnvase envaseTmp = this.listaEnvases.get(i);
            
            if(envaseTmp.obtenerNombre().equals(nombre))
                return envaseTmp;
        }
        
        //Si no se cumple la pre condicion paramos la ejecucion del programa
        assert(false);
        return null;
    }
    
    @Override
    public ArrayList<IPuntoDeVenta> obtenerListaPuntosDeVenta() {
        return this.getListaPuntosDeVenta();
    }
    
    @Override
    public ArrayList<IArticulo> obtenerListaArticulosFavoritosPersonal() {
        return this.getListaFavoritosUsuario();
    }
    
    @Override
    public void agregarArticuloAFavoritosGlobal(IArticulo unArticulo) {
        this.listaFavoritosGlobal.add(unArticulo);
    }
    
    @Override
    public ArrayList<IArticulo> obtenerListaArticulosFavoritosGlobal() {
        return this.getListaFavoritosGlobal();
    }
    
    @Override
    public IPuntoDeVenta obtenerPuntoDeVentaPorNumeroDeLocal(int numeroDelLocal) {
        
        for (int i = 0; i < this.listaPuntosDeVenta.size(); i++) {
            //Var
            IPuntoDeVenta puntoDeVentaTmp = this.listaPuntosDeVenta.get(i);
            
            if(puntoDeVentaTmp.obtenerNumeroDeLocal() == numeroDelLocal)
                return puntoDeVentaTmp;
        }
        
        //Si no se cumple la pre condicion paramos la ejecucion del programa
        assert(false);
        return null;
    }
    
    @Override
    public ArrayList<IPreVenta> obtenerListaPreVentas() {
        return this.getListaPreVentas();
    }
    
    @Override
    public ArrayList<ITicketPreVenta> obtenerTicketsPreVenta() {
        return this.getListaTicketsPreVenta();
    }
    
    @Override
    public ArrayList<IArticulo> obtenerArticulosMasVendidos() {
        //Pares de articulo y veces que fue vendido
        ArrayList<Pair<IArticulo, Integer>> listaArticulosMasVendidos;
        
        listaArticulosMasVendidos = new ArrayList<>();
        //Copiamos la lista de articulos y seteamos las cantidad de veces 
        //vendido cada articulo.
        
        for (int i = 0; i < this.listaArticulos.size(); i++) {
            //Var
            IArticulo articuloTmp = this.listaArticulos.get(i);
            int cantidadDeVecesArticuloTmpFueVendido = 0;
            Pair nuevaDupla;
            
            //Sumamos todas las veces que fue vendido el articulo actual
            for (int j = 0; j < this.listaPreVentas.size(); j++) {
                //Var
                IPreVenta preVentaTmp = this.listaPreVentas.get(j);
                ICarrito carritoTmp = preVentaTmp.obtenerCarritoAsociadoALaCompra();
                
               if(carritoTmp.articuloEstaEnElCarrito(articuloTmp))
                   cantidadDeVecesArticuloTmpFueVendido++;
            }
            
            //Lo registramos en la lista
            nuevaDupla = new Pair(articuloTmp,cantidadDeVecesArticuloTmpFueVendido);
            listaArticulosMasVendidos.add(nuevaDupla);
        }
        
        //Ordenamos la lista de mayor a menor (articulos mas vendidos van primero)
        ordenarListaPorArticulosMasVendidos(listaArticulosMasVendidos);
        
        //Copiamos la lista a una nueva solo con los articulos
        ArrayList<IArticulo> listaRetorno = new ArrayList<>();
        
        for (int i = 0; i < listaArticulosMasVendidos.size(); i++) {
            //Var
            Pair<IArticulo, Integer> duplaTmp = listaArticulosMasVendidos.get(i);
            IArticulo articuloTmp = duplaTmp.getKey();
            
            listaRetorno.add(articuloTmp);
        }
        
        return listaRetorno;
    }
    
    @Override
    public int cantidadDeEnvasesReutilizados() {
        //Var
        int cantidadDeEnvases = 0;
        
        for (int i = 0; i < this.listaPreVentas.size(); i++) {
            //Var
            IPreVenta preVentaTmp = this.listaPreVentas.get(i);
            ICarrito carritoTmp = preVentaTmp.obtenerCarritoAsociadoALaCompra();
            
            cantidadDeEnvases += carritoTmp.obtenerListaArticulos().size();
        }
        
        return cantidadDeEnvases;
    }
    
   //
   //METODOS PRIVADOS
   //
   
   /**
    * @param hasta Numero max generado randomicamente
    * @return Retorna un numero random entre 0 (inclusivo) y hasta (exclusivo)
    */
   private int numeroRandom(int hasta){
       //Var
       Random generador = new Random();
       int retorno;
       
       retorno = generador.nextInt(hasta);
       
       return retorno;
   }

    /**
     * 
     * @return Retorna un proveedor al azar de la lista de proveedores
     */
   private IProveedor proveedorRandom(){
       //Var
       int largoListaDeProveedores = this.listaProveedores.size();
       int posicionDeProveedorARetornar = numeroRandom(largoListaDeProveedores);
       
       return this.listaProveedores.get(posicionDeProveedorARetornar);
   }
   
   /**
    * 
    * @return Retorna una direccion al azar de la lista de direcciones
    */
   private IDireccion direccionRandom(){
       //Var
       int largoListaDeDirecciones = this.listaDirecciones.size();
       int posicionDeDireccionARetornar = numeroRandom(largoListaDeDirecciones);
       
       return this.listaDirecciones.get(posicionDeDireccionARetornar);
   }

   /**
    * POS: Ordena la lista crecientemente de los mas vendidos a los menos vendidos
    * @param listaAOrdenar Lista de pares Articulo y cantidad de veces vendido
    * a ordenar
    */
    private void ordenarListaPorArticulosMasVendidos
        (ArrayList<Pair<IArticulo, Integer>> listaAOrdenar){
        //Var
        int largoDeListaAOrdenar = listaAOrdenar.size();
        
        //Utilizamos el algoritmo de bubble sort para ordenar la lista
        //por el Integer en el la dupla de la lista (de mayor a menor)
        for (int i = 0; i < largoDeListaAOrdenar - 1; i++) {
            for (int j = 0; j < largoDeListaAOrdenar - i - 1; j++) {
                //Var
                Pair<IArticulo, Integer> posJ;
                Pair<IArticulo, Integer> posSiguiente;
                int cantidadDeVecesVendidoPosJ;
                int cantidadDeVecesVendidoPosSiguiente;
                
                posJ = listaAOrdenar.get(j);
                posSiguiente = listaAOrdenar.get(j + 1);
                cantidadDeVecesVendidoPosJ = posJ.getValue();
                cantidadDeVecesVendidoPosSiguiente = posSiguiente.getValue();
                
                if(cantidadDeVecesVendidoPosJ < cantidadDeVecesVendidoPosSiguiente){
                    //Swapeamos j con j+1
                    listaAOrdenar.set(j, posSiguiente);
                    listaAOrdenar.set(j + 1, posJ);
                }
            }
        }
    }

        
}

