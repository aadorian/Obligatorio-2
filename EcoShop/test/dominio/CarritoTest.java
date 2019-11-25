package dominio;

import interfazDominio.IArticulo;
import interfazDominio.IEnvase;
import java.util.ArrayList;
import javafx.util.Pair;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * CarritoTest
 * @author Marcos Novelli - Matias Salles
 */
public class CarritoTest {
    
    public CarritoTest() {
    }

    @Test
    public void testGetListaArticulos() {
        //Var
        ArrayList<Pair<IArticulo, Double>> nuevaLista = new ArrayList<>();
        Carrito carrito = new Carrito(nuevaLista, null, 0);
        ArrayList<Pair<IArticulo, Double>> getLista = carrito.getListaArticulos();
        
        assertEquals(nuevaLista, getLista);
    }

    @Test
    public void testSetListaArticulos() {
        //Var
        Carrito carrito = new Carrito(null, null, 0);
        ArrayList<Pair<IArticulo, Double>> nuevaLista = new ArrayList<>();
        ArrayList<Pair<IArticulo, Double>> getLista;
        
        carrito.setListaArticulos(nuevaLista);
        getLista = carrito.getListaArticulos();
        
        assertEquals(nuevaLista, getLista);
    }

    @Test
    public void testGetListaEnvases() {
        //Var
        ArrayList<Pair<IArticulo,IEnvase>> nuevaLista = new ArrayList<>();
        Carrito carrito = new Carrito(null,nuevaLista, 0);
        ArrayList<Pair<IArticulo, IEnvase>> getLista = carrito.getListaEnvases();
        
        assertEquals(nuevaLista, getLista);
    }

    @Test
    public void testSetListaEnvases() {
        //Var
        Carrito carrito = new Carrito(null,null, 0);
        ArrayList<Pair<IArticulo,IEnvase>> nuevaLista = new ArrayList<>();
        ArrayList<Pair<IArticulo, IEnvase>> getLista;
        
        carrito.setListaEnvases(nuevaLista);
        getLista = carrito.getListaEnvases();
        
        assertEquals(nuevaLista, getLista);
    }

    @Test
    public void testGetPrecioTotal() {
        //Var
        double nuevoPrecio = 1234;
        Carrito carrito = new Carrito(null,null, nuevoPrecio);
        double getPrecio = carrito.getPrecioTotal();
        
        assertEquals(nuevoPrecio, getPrecio, 0);
    }

    @Test
    public void testSetPrecioTotal() {
        //Var
        Carrito carrito = new Carrito(null,null, 0);
        double nuevoPrecio = 1234;
        double getPrecio;
        
        carrito.setPrecioTotal(nuevoPrecio);
        getPrecio = carrito.getPrecioTotal();
        
        assertEquals(nuevoPrecio, getPrecio, 0);
    }

    @Test
    public void testAgregarArticulo() {
        //Var
        ArrayList<Pair<IArticulo, Double>> nuevaLista = new ArrayList<>();
        Carrito carrito = new Carrito(nuevaLista, null, 0);
        ArrayList<Pair<IArticulo, Double>> getLista;
        
        carrito.agregarArticulo(new Articulo("Manzana"), 2);
        getLista = carrito.getListaArticulos();
        
        assertEquals(nuevaLista, getLista);
    }

    @Test
    public void testAgregarEnvase() {
        //Var
        ArrayList<Pair<IArticulo, IEnvase>> nuevaLista = new ArrayList<>();
        Carrito carrito = new Carrito(null, nuevaLista, 0);
        ArrayList<Pair<IArticulo, IEnvase>> getLista;
        
        carrito.agregarEnvase(new Articulo("Manzana"), new Envase("Bolsa", ""));
        getLista = carrito.getListaEnvases();
        
        assertEquals(nuevaLista, getLista);
    }

    @Test
    public void testObtenerListaArticulos() {
        //Var
        ArrayList<Pair<IArticulo, Double>> nuevaLista = new ArrayList<>();
        Carrito carrito = new Carrito(nuevaLista, null, 0);
        ArrayList<Pair<IArticulo, Double>> obtenerLista;
        
        obtenerLista = carrito.obtenerListaArticulos();
        
        assertEquals(nuevaLista, obtenerLista);
    }

    @Test
    public void testEliminarArticuloDelCarrito() {
        //Var
        ArrayList<Pair<IArticulo, Double>> nuevaLista = new ArrayList<>();
        Carrito carrito = new Carrito(nuevaLista, null, 0);
        ArrayList<Pair<IArticulo, Double>> getLista;
        IArticulo nuevoArticulo1 = new Articulo("Manzana");
        IArticulo nuevoArticulo2 = new Articulo("Banana");
        
        carrito.agregarArticulo(nuevoArticulo1, 2);
        carrito.agregarArticulo(nuevoArticulo2, 1);
        
        carrito.eliminarArticuloDelCarrito(nuevoArticulo1);
        getLista = carrito.getListaArticulos();
        
        assertArrayEquals(nuevaLista.toArray(), getLista.toArray());
    }

    @Test
    public void testPosicionDelArticuloEnElCarrito() {
        //Var
        ArrayList<Pair<IArticulo, Double>> nuevaLista = new ArrayList<>();
        Carrito carrito = new Carrito(nuevaLista, null, 0);
        IArticulo nuevoArticulo1 = new Articulo("Manzana");
        int obtenerPosicion;
        
        carrito.agregarArticulo(nuevoArticulo1, 1);
        obtenerPosicion = carrito.posicionDelArticuloEnElCarrito(nuevoArticulo1);
        
        assertEquals(obtenerPosicion, 0);
    }

    @Test
    public void testArticuloEstaEnElCarritoTrue() {
        //Var
        ArrayList<Pair<IArticulo, Double>> nuevaLista = new ArrayList<>();
        Carrito carrito = new Carrito(nuevaLista, null, 0);
        IArticulo nuevoArticulo1 = new Articulo("Manzana", "", 0, "", 1234);
        
        carrito.agregarArticulo(nuevoArticulo1, 1);
        
        assertTrue(carrito.articuloEstaEnElCarrito(nuevoArticulo1));
    }

    @Test
    public void testArticuloEstaEnElCarritoFalse() {
        //Var
        ArrayList<Pair<IArticulo, Double>> nuevaLista = new ArrayList<>();
        Carrito carrito = new Carrito(nuevaLista, null, 0);
        IArticulo nuevoArticulo1 = new Articulo("Manzana", "", 0, "", 1234);
        IArticulo nuevoArticulo2 = new Articulo("Banana", "", 0, "", 2345);
        
        carrito.agregarArticulo(nuevoArticulo1, 1);
        
        assertFalse(carrito.articuloEstaEnElCarrito(nuevoArticulo2));
    }
    
    @Test
    public void testEliminarEnvaseDelCarrito() {
        //Var
        ArrayList<Pair<IArticulo, IEnvase>> nuevaLista = new ArrayList<>();
        Carrito carrito = new Carrito(null, nuevaLista, 0);
        ArrayList<Pair<IArticulo, IEnvase>> getLista;
        IArticulo articulo1 = new Articulo("Banana", "", 0, "", 2345);
        IArticulo articulo2 = new Articulo("Banana", "", 0, "", 2345);
        IEnvase envase1 = new Envase("Tupper", "");
        IEnvase envase2 = new Envase("Bolsa", "");
        
        carrito.agregarEnvase(articulo1, envase1);
        carrito.agregarEnvase(articulo2, envase2);
        
        carrito.eliminarEnvaseDelCarrito(articulo1);
        getLista = carrito.getListaEnvases();
        
        assertArrayEquals(nuevaLista.toArray(), getLista.toArray());
    }

    @Test
    public void testObtenerEnvaseAsociadoAlArticulo() {
        //Var
        ArrayList<Pair<IArticulo, IEnvase>> nuevaLista = new ArrayList<>();
        Carrito carrito = new Carrito(null, nuevaLista, 0);
        IArticulo articulo1 = new Articulo("Banana", "", 0, "", 2345);
        IArticulo articulo2 = new Articulo("Banana", "", 0, "", 2345);
        IEnvase envase1 = new Envase("Tupper", "");
        IEnvase envase2 = new Envase("Bolsa", "");
        IEnvase obtenerEnvaseAsociado;
        
        carrito.agregarEnvase(articulo1, envase1);
        carrito.agregarEnvase(articulo2, envase2);
        obtenerEnvaseAsociado = carrito.obtenerEnvaseAsociadoAlArticulo(articulo2);
        
        assertEquals(envase2, obtenerEnvaseAsociado);
    }

    @Test
    public void testArticuloTieneEnvaseAsociadoTrue() {
        //Var
        ArrayList<Pair<IArticulo, IEnvase>> nuevaLista = new ArrayList<>();
        Carrito carrito = new Carrito(null, nuevaLista, 0);
        IArticulo articulo1 = new Articulo("Banana", "", 0, "", 2345);
        IEnvase envase1 = new Envase("Tupper", "");
        
        carrito.agregarEnvase(articulo1, envase1);
        
        assertTrue(carrito.articuloTieneEnvaseAsociado(articulo1));
    }

    @Test
    public void testArticuloTieneEnvaseAsociadoFalse() {
        //Var
        ArrayList<Pair<IArticulo, IEnvase>> nuevaLista = new ArrayList<>();
        Carrito carrito = new Carrito(null, nuevaLista, 0);
        IArticulo articulo1 = new Articulo("Banana", "", 0, "", 2345);
        IArticulo articulo2 = new Articulo("Manzana", "", 0, "", 2535);
        IEnvase envase1 = new Envase("Tupper", "");
        
        carrito.agregarEnvase(articulo1, envase1);
        
        assertFalse(carrito.articuloTieneEnvaseAsociado(articulo2));
    }
    
    @Test
    public void testTodosLosArticulosEnElCarritoTienenEnvaseAsociadoTrue() {
        //Var
        ArrayList<Pair<IArticulo, Double>> nuevaListaArticulos = new ArrayList<>();
        ArrayList<Pair<IArticulo, IEnvase>> nuevaListaEnvases = new ArrayList<>();
        Carrito carrito = new Carrito(nuevaListaArticulos, nuevaListaEnvases, 0);
        IArticulo articulo1 = new Articulo("Banana", "", 0, "", 2345);
        IArticulo articulo2 = new Articulo("Manzana", "", 0, "", 2535);
        IEnvase envase1 = new Envase("Tupper", "");
        IEnvase envase2 = new Envase("Bolsa", "");
        
        carrito.agregarArticulo(articulo1, 2);
        carrito.agregarArticulo(articulo2, 1);
        carrito.agregarEnvase(articulo1, envase1);
        carrito.agregarEnvase(articulo2, envase2);
        
        assertTrue(carrito.todosLosArticulosEnElCarritoTienenEnvaseAsociado());
    }
    
    @Test
    public void testTodosLosArticulosEnElCarritoTienenEnvaseAsociadoFalse() {
        //Var
        ArrayList<Pair<IArticulo, Double>> nuevaListaArticulos = new ArrayList<>();
        ArrayList<Pair<IArticulo, IEnvase>> nuevaListaEnvases = new ArrayList<>();
        Carrito carrito = new Carrito(nuevaListaArticulos, nuevaListaEnvases, 0);
        IArticulo articulo1 = new Articulo("Banana", "", 0, "", 2345);
        IArticulo articulo2 = new Articulo("Manzana", "", 0, "", 2535);
        IEnvase envase1 = new Envase("Tupper", "");
        
        carrito.agregarArticulo(articulo1, 2);
        carrito.agregarArticulo(articulo2, 1);
        carrito.agregarEnvase(articulo1, envase1);
        
        assertFalse(carrito.todosLosArticulosEnElCarritoTienenEnvaseAsociado());
    }
    
    @Test
    public void testObtenerPrecioTotal() {
        //Var
        double nuevoPrecio = 1234;
        Carrito carrito = new Carrito(null,null, nuevoPrecio);
        double obtenerPrecio = carrito.obtenerPrecioTotal();
        
        assertEquals(nuevoPrecio, obtenerPrecio, 0);
    }
    
}
