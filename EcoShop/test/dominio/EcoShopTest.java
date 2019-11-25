package dominio;

import interfazDominio.IArticulo;
import interfazDominio.ICarrito;
import interfazDominio.IDireccion;
import interfazDominio.IEnvase;
import interfazDominio.IPreVenta;
import interfazDominio.IProveedor;
import interfazDominio.IPuntoDeVenta;
import interfazDominio.ITicketPreVenta;
import java.util.ArrayList;
import javafx.util.Pair;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matia
 */
public class EcoShopTest {
    
    public EcoShopTest() {
    }

    @Test
    public void testGetListaProveedores() {
        //Var
        ArrayList<IProveedor> nuevaLista = new ArrayList<>();
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, nuevaLista, 
                null, null, null, null);
        ArrayList<IProveedor> getLista = ecoShop.getListaProveedores();
        
        assertEquals(getLista, nuevaLista);
    }

    @Test
    public void testSetListaProveedores() {
        //Var
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, null, null, null);
        ArrayList<IProveedor> nuevaLista = new ArrayList<>();
        ArrayList<IProveedor> getLista;
        
        ecoShop.setListaProveedores(nuevaLista);
        getLista = ecoShop.getListaProveedores();
        
        assertEquals(getLista, nuevaLista);
    }

    @Test
    public void testGetListaArticulos() {
        //Var
        ArrayList<IArticulo> nuevaLista = new ArrayList<>();
        EcoShop ecoShop = new EcoShop(nuevaLista, null, null, null, null, null, 
                null, null, null, null);
        ArrayList<IArticulo> getLista = ecoShop.getListaArticulos();
        
        assertEquals(getLista, nuevaLista);
    }

    @Test
    public void testSetListaArticulos() {
        //Var
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, null, null, null);
        ArrayList<IArticulo> nuevaLista = new ArrayList<>();
        ArrayList<IArticulo> getLista;
        
        ecoShop.setListaArticulos(nuevaLista);
        getLista = ecoShop.getListaArticulos();
        
        assertEquals(getLista, nuevaLista);
    }

    @Test
    public void testGetListaEnvases() {
        //Var
        ArrayList<IEnvase> nuevaLista = new ArrayList<>();
        EcoShop ecoShop = new EcoShop(null, nuevaLista, null, null, null, null, 
                null, null, null, null);
        ArrayList<IEnvase> getLista = ecoShop.getListaEnvases();
        
        assertEquals(getLista, nuevaLista);
    }

    @Test
    public void testSetListaEnvases() {
        //Var
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, null, null, null);
        ArrayList<IEnvase> nuevaLista = new ArrayList<>();
        ArrayList<IEnvase> getLista;
        
        ecoShop.setListaEnvases(nuevaLista);
        getLista = ecoShop.getListaEnvases();
        
        assertEquals(getLista, nuevaLista);
    }

    @Test
    public void testGetListaPuntosDeVenta() {
        //Var
        ArrayList<IPuntoDeVenta> nuevaLista = new ArrayList<>();
        EcoShop ecoShop = new EcoShop(null, null, nuevaLista, null, null, null, 
                null, null, null, null);
        ArrayList<IPuntoDeVenta> getLista = ecoShop.getListaPuntosDeVenta();
        
        assertEquals(getLista, nuevaLista);
    }

    @Test
    public void testSetListaPuntosDeVenta() {
        //Var
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, null, null, null);
        ArrayList<IPuntoDeVenta> nuevaLista = new ArrayList<>();
        ArrayList<IPuntoDeVenta> getLista;
        
        ecoShop.setListaPuntosDeVenta(nuevaLista);
        getLista = ecoShop.getListaPuntosDeVenta();
        
        assertEquals(getLista, nuevaLista);
    }

    @Test
    public void testGetListaPreVentas() {
        //Var
        ArrayList<IPreVenta> nuevaLista = new ArrayList<>();
        EcoShop ecoShop = new EcoShop(null, null, null, nuevaLista, null, null, 
                null, null, null, null);
        ArrayList<IPreVenta> getLista = ecoShop.getListaPreVentas();
        
        assertEquals(getLista, nuevaLista);
    }

    @Test
    public void testSetListaPreVentas() {
        //Var
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, null, null, null);
        ArrayList<IPreVenta> nuevaLista = new ArrayList<>();
        ArrayList<IPreVenta> getLista;
        
        ecoShop.setListaPreVentas(nuevaLista);
        getLista = ecoShop.getListaPreVentas();
        
        assertEquals(getLista, nuevaLista);
    }

    @Test
    public void testGetListaTicketsPreVenta() {
        //Var
        ArrayList<ITicketPreVenta> nuevaLista = new ArrayList<>();
        EcoShop ecoShop = new EcoShop(null, null, null, null, nuevaLista, null, 
                null, null, null, null);
        ArrayList<ITicketPreVenta> getLista = ecoShop.getListaTicketsPreVenta();
        
        assertEquals(getLista, nuevaLista);
    }

    @Test
    public void testSetListaTicketsPreVenta() {
        //Var
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, null, null, null);
        ArrayList<ITicketPreVenta> nuevaLista = new ArrayList<>();
        ArrayList<ITicketPreVenta> getLista;
        
        ecoShop.setListaTicketsPreVenta(nuevaLista);
        getLista = ecoShop.getListaTicketsPreVenta();
        
        assertEquals(getLista, nuevaLista);
    }

    @Test
    public void testGetCarritoDeCompras() {
        //Var
        ICarrito nuevoCarrito = new Carrito();
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, null, null, nuevoCarrito);
        ICarrito getCarrito = ecoShop.getCarritoDeCompras();
        
        assertEquals(nuevoCarrito, getCarrito);
    }

    @Test
    public void testSetCarritoDeCompras() {
        //Var
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, null, null, null);
        ICarrito nuevoCarrito = new Carrito();
        ICarrito getCarrito;
        
        ecoShop.setCarritoDeCompras(nuevoCarrito);
        getCarrito = ecoShop.getCarritoDeCompras();
        
        assertEquals(nuevoCarrito, getCarrito);
    }

    @Test
    public void testGetListaDirecciones() {
        //Var
        ArrayList<IDireccion> nuevaLista = new ArrayList<>();
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                nuevaLista, null, null, null);
        ArrayList<IDireccion> getLista = ecoShop.getListaDirecciones();
        
        assertEquals(getLista, nuevaLista);
    }

    @Test
    public void testSetListaDirecciones() {
        //Var
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, null, null, null);
        ArrayList<IDireccion> nuevaLista = new ArrayList<>();
        ArrayList<IDireccion> getLista;
        
        ecoShop.setListaDirecciones(nuevaLista);
        getLista = ecoShop.getListaDirecciones();
        
        assertEquals(getLista, nuevaLista);
    }

    @Test
    public void testGetListaFavoritosUsuario() {
        //Var
        ArrayList<IArticulo> nuevaLista = new ArrayList<>();
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, nuevaLista, null, null);
        ArrayList<IArticulo> getLista = ecoShop.getListaFavoritosUsuario();
        
        assertEquals(getLista, nuevaLista);
    }

    @Test
    public void testSetListaFavoritosUsuario() {
        //Var
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, null, null, null);
        ArrayList<IArticulo> nuevaLista = new ArrayList<>();
        ArrayList<IArticulo> getLista;
        
        ecoShop.setListaFavoritosUsuario(nuevaLista);
        getLista = ecoShop.getListaFavoritosUsuario();
        
        assertEquals(getLista, nuevaLista);
    }

    @Test
    public void testGetListaFavoritosGlobal() {
        //Var
        ArrayList<IArticulo> nuevaLista = new ArrayList<>();
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, null, nuevaLista, null);
        ArrayList<IArticulo> getLista = ecoShop.getListaFavoritosGlobal();
        
        assertEquals(getLista, nuevaLista);
    }

    @Test
    public void testSetListaFavoritosGlobal() {
        //Var
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, null, null, null);
        ArrayList<IArticulo> nuevaLista = new ArrayList<>();
        ArrayList<IArticulo> getLista;
        
        ecoShop.setListaFavoritosGlobal(nuevaLista);
        getLista = ecoShop.getListaFavoritosGlobal();
        
        assertEquals(getLista, nuevaLista);
    }

    @Test
    public void testObtenerListaArticulos() {
        //Var
        ArrayList<IArticulo> nuevaLista = new ArrayList<>();
        EcoShop ecoShop = new EcoShop(nuevaLista, null, null, null, null, null, 
                null, null, null, null);
        ArrayList<IArticulo> obtenerLista = ecoShop.obtenerListaArticulos();
        
        assertEquals(obtenerLista, nuevaLista);
    }

    @Test
    public void testObtenerListaEnvases() {
        //Var
        ArrayList<IEnvase> nuevaLista = new ArrayList<>();
        EcoShop ecoShop = new EcoShop(null, nuevaLista, null, null, null, null, 
                null, null, null, null);
        ArrayList<IEnvase> obtenerLista = ecoShop.obtenerListaEnvases();
        
        assertEquals(obtenerLista, nuevaLista);
    }

    @Test
    public void testObtenerListaEnvasesAplicables() {
        ArrayList<IEnvase> nuevaListaEnvasesAplicables = new ArrayList<>();
        IArticulo nuevoArticulo = new Articulo(0, null, nuevaListaEnvasesAplicables, 
                "Manzana", "", "", 0);
        EcoShop ecoShop = new EcoShop();
        IEnvase envase1 = new Envase("Bolsa", "");
        IEnvase envase2 = new Envase("Tupper", "");
        ArrayList<IEnvase> getLista;
        
        nuevoArticulo.agregarEnvase(envase1);
        nuevoArticulo.agregarEnvase(envase2);
        ecoShop.registrarArticulo(nuevoArticulo);
        getLista = ecoShop.obtenerListaEnvasesAplicables(nuevoArticulo);
        
        assertArrayEquals(nuevaListaEnvasesAplicables.toArray(), getLista.toArray());
    }

    @Test
    public void testObtenerArticuloPorNombre() {
        IArticulo nuevoArticulo1 = new Articulo(0, null, null, "Manzana", "", "", 0);
        IArticulo nuevoArticulo2 = new Articulo(0, null, null, "Banana", "", "", 0);
        EcoShop ecoShop = new EcoShop();
        IArticulo obtenerArticulo;
        
        ecoShop.registrarArticulo(nuevoArticulo1);
        ecoShop.registrarArticulo(nuevoArticulo2);
        obtenerArticulo = ecoShop.obtenerArticuloPorNombre("Manzana");
        
        assertEquals(obtenerArticulo, nuevoArticulo1);
    }

    @Test
    public void testObtenerCarrito() {
        //Var
        ICarrito nuevoCarrito = new Carrito();
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, null, null, nuevoCarrito);
        ICarrito obtenerCarrito = ecoShop.obtenerCarrito();
        
        assertEquals(nuevoCarrito, obtenerCarrito);
    }

    @Test
    public void testAgregarAlCarrito() {
        //Var
        ArrayList<Pair<IArticulo, Double>> listaArticulosCarrito = new ArrayList<>();
        ICarrito nuevoCarrito = new Carrito(listaArticulosCarrito, null, 0);
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, null, null, nuevoCarrito);
        ArrayList<Pair<IArticulo, Double>> getLista;
        
        ecoShop.agregarAlCarrito(new Articulo("Manzana"), 1);
        getLista = nuevoCarrito.obtenerListaArticulos();
        
        assertArrayEquals(listaArticulosCarrito.toArray(), getLista.toArray());
    }

    @Test
    public void testSacarDelCarrito() {
        //Var
        ArrayList<Pair<IArticulo, Double>> listaArticulosCarrito = new ArrayList<>();
        ICarrito nuevoCarrito = new Carrito(listaArticulosCarrito, new ArrayList<>(), 0);
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, null, null, nuevoCarrito);
        IArticulo articulo1 = new Articulo("Manzana", "", 0, "", 2345);
        IArticulo articulo2 = new Articulo("Banana", "", 0, "", 1234);
        ArrayList<Pair<IArticulo, Double>> getLista;
        
        ecoShop.agregarAlCarrito(articulo1, 1);
        ecoShop.agregarAlCarrito(articulo2, 3);
        
        ecoShop.sacarDelCarrito(articulo2);
        getLista = nuevoCarrito.obtenerListaArticulos();
        
        assertArrayEquals(listaArticulosCarrito.toArray(), getLista.toArray());
    }

    @Test
    public void testBuscarProductoTextoVacio() {
        ArrayList<IArticulo> listaEsperada = new ArrayList<>();
        EcoShop ecoShop = new EcoShop();
        IArticulo articulo1 = new Articulo(0, null, null, "Manzana", "", "Fruta", 1234);
        IArticulo articulo2 = new Articulo(0, null, null, "Banana", "", "Fruta", 2345);
        IArticulo articulo3 = new Articulo(0, null, null, "Zanahoria", "", "Verdura", 3456);
        String calificador = "Fruta";
        ArrayList<IArticulo> getLista;
        
        ecoShop.registrarArticulo(articulo1);
        ecoShop.registrarArticulo(articulo2);
        ecoShop.registrarArticulo(articulo3);
        
        listaEsperada.add(articulo1);
        listaEsperada.add(articulo2);
        getLista = ecoShop.buscarProducto("", calificador);
        
        assertArrayEquals(listaEsperada.toArray(), getLista.toArray());
    }

    @Test
    public void testBuscarProductoCalificadorTodos() {
        ArrayList<IArticulo> listaEsperada = new ArrayList<>();
        EcoShop ecoShop = new EcoShop();
        IArticulo articulo1 = new Articulo(0, null, null, "Manzana", "", "Fruta", 1234);
        IArticulo articulo2 = new Articulo(0, null, null, "Banana", "", "Fruta", 2345);
        IArticulo articulo3 = new Articulo(0, null, null, "Zanahoria", "", "Verdura", 3456);
        String textoABuscar = "zana";
        ArrayList<IArticulo> getLista;
        
        ecoShop.registrarArticulo(articulo1);
        ecoShop.registrarArticulo(articulo2);
        ecoShop.registrarArticulo(articulo3);
        
        listaEsperada.add(articulo1);
        listaEsperada.add(articulo3);
        getLista = ecoShop.buscarProducto(textoABuscar, "Todos");
        
        assertArrayEquals(listaEsperada.toArray(), getLista.toArray());
    }
    
    @Test
    public void testBuscarProductoCalificadorPorTextoYCalificador() {
        ArrayList<IArticulo> listaEsperada = new ArrayList<>();
        EcoShop ecoShop = new EcoShop();
        IArticulo articulo1 = new Articulo(0, null, null, "Manzana", "", "Fruta", 1234);
        IArticulo articulo2 = new Articulo(0, null, null, "Banana", "", "Fruta", 2345);
        IArticulo articulo3 = new Articulo(0, null, null, "Zanahoria", "", "Verdura", 3456);
        String textoABuscar = "BanA";
        String calificador = "Fruta";
        ArrayList<IArticulo> getLista;
        
        ecoShop.registrarArticulo(articulo1);
        ecoShop.registrarArticulo(articulo2);
        ecoShop.registrarArticulo(articulo3);
        
        listaEsperada.add(articulo2);
        getLista = ecoShop.buscarProducto(textoABuscar, calificador);
        
        assertArrayEquals(listaEsperada.toArray(), getLista.toArray());
    }
    
    @Test
    public void testRegistrarPreVenta() {
        ArrayList<IPreVenta> listaEsperada = new ArrayList<>();
        IPreVenta nuevaPreVenta = new PreVenta(null, null, null, 0, null);
        EcoShop ecoShop = new EcoShop();
        ArrayList<IPreVenta> getLista;
        
        ecoShop.registrarPreVenta(nuevaPreVenta);
        listaEsperada.add(nuevaPreVenta);
        getLista = ecoShop.getListaPreVentas();
        
        assertArrayEquals(listaEsperada.toArray(), getLista.toArray());
    }

    @Test
    public void testGenerarTicket() {
        IPreVenta nuevaPreVenta = new PreVenta(null, null, null, 0, null);
        EcoShop ecoShop = new EcoShop();
        ArrayList<ITicketPreVenta> getLista;
        
        ecoShop.registrarPreVenta(nuevaPreVenta);
        ecoShop.generarTicket(nuevaPreVenta);
        getLista = ecoShop.getListaTicketsPreVenta();
        
        ITicketPreVenta ticketGenerado = getLista.get(0);
        int numeroIdentificadorDelTicket = ticketGenerado.obtenerNumeroDeTicket();
        
        assertEquals(numeroIdentificadorDelTicket, 0);
    }

    @Test
    public void testRegistrarArticulo() {
        ArrayList<IArticulo> listaEsperada = new ArrayList<>();
        IArticulo nuevoArticulo = new Articulo(0, null, null, "Kiwi", "", "", 1234);
        EcoShop ecoShop = new EcoShop();
        ArrayList<IArticulo> getLista;
        
        ecoShop.registrarArticulo(nuevoArticulo);
        listaEsperada.add(nuevoArticulo);
        getLista = ecoShop.getListaArticulos();
        
        assertArrayEquals(listaEsperada.toArray(), getLista.toArray());
    }

    @Test
    public void testRegistrarEnvase() {
        ArrayList<IEnvase> listaEsperada = new ArrayList<>();
        IEnvase nuevoEnvase = new Envase("Bolsa", "");
        EcoShop ecoShop = new EcoShop();
        ArrayList<IEnvase> getLista;
        
        ecoShop.registrarEnvase(nuevoEnvase);
        listaEsperada.add(nuevoEnvase);
        getLista = ecoShop.getListaEnvases();
        
        assertArrayEquals(listaEsperada.toArray(), getLista.toArray());
    }

    @Test
    public void testRegistrarProveedor() {
        ArrayList<IProveedor> listaEsperada = new ArrayList<>();
        IProveedor nuevoProveedor = new Proveedor("Granja", null);
        EcoShop ecoShop = new EcoShop();
        ArrayList<IProveedor> getLista;
        
        ecoShop.registrarProveedor(nuevoProveedor);
        listaEsperada.add(nuevoProveedor);
        getLista = ecoShop.getListaProveedores();
        
        assertArrayEquals(listaEsperada.toArray(), getLista.toArray());
    }

    @Test
    public void testRegistrarPuntoDeVenta() {
        ArrayList<IPuntoDeVenta> listaEsperada = new ArrayList<>();
        IPuntoDeVenta nuevoPuntoDeVenta = new PuntoDeVenta(null, 12);
        EcoShop ecoShop = new EcoShop();
        ArrayList<IPuntoDeVenta> getLista;
        
        ecoShop.registrarPuntoDeVenta(nuevoPuntoDeVenta);
        listaEsperada.add(nuevoPuntoDeVenta);
        getLista = ecoShop.getListaPuntosDeVenta();
        
        assertArrayEquals(listaEsperada.toArray(), getLista.toArray());
    }

    @Test
    public void testRegistrarDireccion() {
        ArrayList<IDireccion> listaEsperada = new ArrayList<>();
        IDireccion nuevaDireccion = new Direccion();
        EcoShop ecoShop = new EcoShop();
        ArrayList<IDireccion> getLista;
        
        ecoShop.registrarDireccion(nuevaDireccion);
        listaEsperada.add(nuevaDireccion);
        getLista = ecoShop.getListaDirecciones();
        
        assertArrayEquals(listaEsperada.toArray(), getLista.toArray());
    }

    @Test
    public void testEstaEnFavoritosPersonalTrue() {
        //Var
        ArrayList<IArticulo> nuevaLista = new ArrayList<>();
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, nuevaLista, null, null);
        IArticulo articulo1 = new Articulo(0, null, null, "Manzana", "", "", 1234);
        IArticulo articulo2 = new Articulo(0, null, null, "Kiwi", "", "", 2345);
        
        ecoShop.agregarAFavoritosPersonal(articulo1);
        ecoShop.agregarAFavoritosPersonal(articulo2);
        
        assertTrue(ecoShop.estaEnFavoritosPersonal(articulo2));
    }

    @Test
    public void testEstaEnFavoritosPersonalFalse() {
        //Var
        ArrayList<IArticulo> nuevaLista = new ArrayList<>();
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, nuevaLista, null, null);
        IArticulo articulo1 = new Articulo(0, null, null, "Manzana", "", "", 1234);
        IArticulo articulo2 = new Articulo(0, null, null, "Kiwi", "", "", 2345);
        
        ecoShop.agregarAFavoritosPersonal(articulo1);
        
        assertFalse(ecoShop.estaEnFavoritosPersonal(articulo2));
    }
    
    @Test
    public void testAgregarAFavoritosPersonal() {
        //Var
        ArrayList<IArticulo> listaEsperada = new ArrayList<>();
        ArrayList<IArticulo> nuevaLista = new ArrayList<>();
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, nuevaLista, null, null);
        IArticulo articulo1 = new Articulo(0, null, null, "Manzana", "", "", 1234);
        IArticulo articulo2 = new Articulo(0, null, null, "Kiwi", "", "", 2345);
        ArrayList<IArticulo> getLista;
        
        ecoShop.agregarAFavoritosPersonal(articulo1);
        ecoShop.agregarAFavoritosPersonal(articulo2);
        listaEsperada.add(articulo1);
        listaEsperada.add(articulo2);
        getLista = ecoShop.getListaFavoritosUsuario();
        
        assertArrayEquals(listaEsperada.toArray(), getLista.toArray());
    }

    @Test
    public void testSacarDeFavoritos() {
        //Var
        ArrayList<IArticulo> listaEsperada = new ArrayList<>();
        ArrayList<IArticulo> nuevaLista = new ArrayList<>();
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, nuevaLista, null, null);
        IArticulo articulo1 = new Articulo(0, null, null, "Manzana", "", "", 1234);
        IArticulo articulo2 = new Articulo(0, null, null, "Kiwi", "", "", 2345);
        ArrayList<IArticulo> getLista;
        
        ecoShop.agregarAFavoritosPersonal(articulo1);
        ecoShop.agregarAFavoritosPersonal(articulo2);
        ecoShop.sacarDeFavoritos(articulo1);
        
        listaEsperada.add(articulo2);
        getLista = ecoShop.getListaFavoritosUsuario();
        
        assertArrayEquals(listaEsperada.toArray(), getLista.toArray());
    }

    @Test
    public void testObtenerEnvasePorNombre() {
        EcoShop ecoShop = new EcoShop();
        IEnvase envase1 = new Envase("Bolsa", "");
        IEnvase envase2 = new Envase("Tupper", "");
        String envaseARecuperar = "Tupper";
        IEnvase getEnvase;
        
        ecoShop.registrarEnvase(envase1);
        ecoShop.registrarEnvase(envase2);
        getEnvase = ecoShop.obtenerEnvasePorNombre(envaseARecuperar);
        
        assertEquals(envase2, getEnvase);
    }

    @Test
    public void testObtenerListaPuntosDeVenta() {
        //Var
        ArrayList<IPuntoDeVenta> nuevaLista = new ArrayList<>();
        EcoShop ecoShop = new EcoShop(null, null, nuevaLista, null, null, null, 
                null, null, null, null);
        ArrayList<IPuntoDeVenta> obtenerLista = ecoShop.obtenerListaPuntosDeVenta();
        
        assertEquals(obtenerLista, nuevaLista);
    }

    @Test
    public void testObtenerListaArticulosFavoritosPersonal() {
        //Var
        ArrayList<IArticulo> nuevaLista = new ArrayList<>();
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, nuevaLista, null, null);
        ArrayList<IArticulo> obtenerLista = ecoShop.obtenerListaArticulosFavoritosPersonal();
        
        assertEquals(obtenerLista, nuevaLista);
    }

    @Test
    public void testAgregarArticuloAFavoritosGlobal() {
        //Var
        ArrayList<IArticulo> listaEsperada = new ArrayList<>();
        ArrayList<IArticulo> nuevaLista = new ArrayList<>();
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, null, nuevaLista, null);
        IArticulo articulo1 = new Articulo(0, null, null, "Manzana", "", "", 1234);
        IArticulo articulo2 = new Articulo(0, null, null, "Kiwi", "", "", 2345);
        ArrayList<IArticulo> getLista;
        
        ecoShop.agregarArticuloAFavoritosGlobal(articulo1);
        ecoShop.agregarArticuloAFavoritosGlobal(articulo2);
        listaEsperada.add(articulo1);
        listaEsperada.add(articulo2);
        getLista = ecoShop.getListaFavoritosGlobal();
        
        assertArrayEquals(listaEsperada.toArray(), getLista.toArray());
    }

    @Test
    public void testObtenerListaArticulosFavoritosGlobal() {
        //Var
        ArrayList<IArticulo> nuevaLista = new ArrayList<>();
        EcoShop ecoShop = new EcoShop(null, null, null, null, null, null, 
                null, null, nuevaLista, null);
        ArrayList<IArticulo> obtenerLista = ecoShop.obtenerListaArticulosFavoritosGlobal();
        
        assertEquals(obtenerLista, nuevaLista);
    }

    @Test
    public void testObtenerPuntoDeVentaPorNumeroDeLocal() {
        EcoShop ecoShop = new EcoShop();
        IPuntoDeVenta puntoDeVenta1 = new PuntoDeVenta(null, 12);
        IPuntoDeVenta puntoDeVenta2 = new PuntoDeVenta(null, 49);
        int puntoDeVentaARecuperar = 12;
        IPuntoDeVenta getPuntoDeVenta;
        
        ecoShop.registrarPuntoDeVenta(puntoDeVenta1);
        ecoShop.registrarPuntoDeVenta(puntoDeVenta2);
        getPuntoDeVenta = 
                ecoShop.obtenerPuntoDeVentaPorNumeroDeLocal(puntoDeVentaARecuperar);
        
        assertEquals(puntoDeVenta1, getPuntoDeVenta);
    }

    @Test
    public void testObtenerListaPreVentas() {
        //Var
        ArrayList<IPreVenta> nuevaLista = new ArrayList<>();
        EcoShop ecoShop = new EcoShop(null, null, null, nuevaLista, null, null, 
                null, null, null, null);
        ArrayList<IPreVenta> obtenerLista = ecoShop.obtenerListaPreVentas();
        
        assertEquals(obtenerLista, nuevaLista);
    }

    @Test
    public void testObtenerTicketsPreVenta() {
        //Var
        ArrayList<ITicketPreVenta> nuevaLista = new ArrayList<>();
        EcoShop ecoShop = new EcoShop(null, null, null, null, nuevaLista, null, 
                null, null, null, null);
        ArrayList<ITicketPreVenta> obtenerLista = ecoShop.obtenerTicketsPreVenta();
        
        assertEquals(obtenerLista, nuevaLista);
    }

    @Test
    public void testObtenerArticulosMasVendidos() {
        EcoShop ecoShop = new EcoShop();
        ICarrito nuevoCarrito1 = new Carrito();
        ICarrito nuevoCarrito2 = new Carrito();
        IArticulo articulo1 = new Articulo(60, null, null, "Manzana", "", "", 1234);
        IArticulo articulo2 = new Articulo(109, null, null, "Banana", "", "", 2345);
        IEnvase envase1 = new Envase("Bolsa", "");
        IEnvase envase2 = new Envase("Tupper", "");
        double precioTotal1;
        double precioTotal2;
        ArrayList<IArticulo> listaEsperada = new ArrayList<>();
        ArrayList<IArticulo> getLista;
        
        nuevoCarrito1.agregarArticulo(articulo1, 1.2);
        nuevoCarrito1.agregarArticulo(articulo2, 2);
        nuevoCarrito1.agregarEnvase(articulo1, envase1);
        nuevoCarrito1.agregarEnvase(articulo2, envase2);
        precioTotal1 = nuevoCarrito1.obtenerPrecioTotal();
        
        nuevoCarrito2.agregarArticulo(articulo1, 1.2);
        nuevoCarrito2.agregarEnvase(articulo1, envase1);
        precioTotal2 = nuevoCarrito2.obtenerPrecioTotal();
        
        IPreVenta preVenta1 = 
                new PreVenta(nuevoCarrito1, null, null, precioTotal1, null);
        IPreVenta preVenta2 = 
                new PreVenta(nuevoCarrito2, null, null, precioTotal2, null);
        
        ecoShop.registrarArticulo(articulo1);
        ecoShop.registrarArticulo(articulo2);
        
        ecoShop.registrarPreVenta(preVenta1);
        ecoShop.registrarPreVenta(preVenta2);
        
        ecoShop.generarTicket(preVenta1);
        ecoShop.generarTicket(preVenta2);
        
        listaEsperada.add(articulo1);
        listaEsperada.add(articulo2);
        getLista = ecoShop.obtenerArticulosMasVendidos();
        
        assertArrayEquals(listaEsperada.toArray(), getLista.toArray());
    }

    @Test
    public void testCantidadDeEnvasesReutilizados() {
        EcoShop ecoShop = new EcoShop();
        ICarrito nuevoCarrito1 = new Carrito();
        ICarrito nuevoCarrito2 = new Carrito();
        IArticulo articulo1 = new Articulo(60, null, null, "Manzana", "", "", 1234);
        IArticulo articulo2 = new Articulo(109, null, null, "Banana", "", "", 2345);
        IEnvase envase1 = new Envase("Bolsa", "");
        IEnvase envase2 = new Envase("Tupper", "");
        double precioTotal1;
        double precioTotal2;
        int cantidadEsperada;
        int getCantidad;
        
        nuevoCarrito1.agregarArticulo(articulo1, 1.2);
        nuevoCarrito1.agregarArticulo(articulo2, 2);
        nuevoCarrito1.agregarEnvase(articulo1, envase1);
        nuevoCarrito1.agregarEnvase(articulo2, envase2);
        precioTotal1 = nuevoCarrito1.obtenerPrecioTotal();
        
        nuevoCarrito2.agregarArticulo(articulo1, 1.2);
        nuevoCarrito2.agregarEnvase(articulo1, envase1);
        precioTotal2 = nuevoCarrito2.obtenerPrecioTotal();
        
        IPreVenta preVenta1 = 
                new PreVenta(nuevoCarrito1, null, null, precioTotal1, null);
        IPreVenta preVenta2 = 
                new PreVenta(nuevoCarrito2, null, null, precioTotal2, null);
        
        ecoShop.registrarArticulo(articulo1);
        ecoShop.registrarArticulo(articulo2);
        
        ecoShop.registrarPreVenta(preVenta1);
        ecoShop.registrarPreVenta(preVenta2);
        
        ecoShop.generarTicket(preVenta1);
        ecoShop.generarTicket(preVenta2);
        
        cantidadEsperada = 3;
        getCantidad = ecoShop.cantidadDeEnvasesReutilizados();
        
        assertEquals(cantidadEsperada, getCantidad);
    }
    
    
}
