package dominio;

import interfazDominio.IEnvase;
import interfazDominio.IProveedor;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ArticuloTest
 * @author Marcos Novelli - Matias Salles
 */
public class ArticuloTest {
    
    public ArticuloTest() {
    }

    @Test
    public void testGetNombreArticulo() {
        //Var
        String nuevoNombre = "Manzana";
        Articulo articulo = new Articulo(nuevoNombre);
        String getNombre = articulo.getNombreArticulo();
        
        assertEquals(nuevoNombre, getNombre);
    }

    @Test
    public void testSetNombreArticulo() {
        //Var
        Articulo articulo = new Articulo("Banana");
        String nuevoNombre = "Pera";
        String getNombre;
        
        articulo.setNombreArticulo(nuevoNombre);
        getNombre = articulo.getNombreArticulo();
        
        assertEquals(nuevoNombre, getNombre);
    }

    @Test
    public void testGetRutaImagen() {
        //Var
        String nuevaRutaImagen = "\\imagenes\\imagen.jpg";
        Articulo articulo = new Articulo("", nuevaRutaImagen, 0, "", 0);
        String getRutaImagen = articulo.getRutaImagen();
        
        assertEquals(nuevaRutaImagen, getRutaImagen);
    }

    @Test
    public void testSetRutaImagen() {
        //Var
        Articulo articulo = new Articulo("", "\\imagen.jpg", 0, "", 0);
        String nuevaRutaImagen = "\\imagenes\\foto.png";
        String getRutaImagen;
        
        articulo.setRutaImagen(nuevaRutaImagen);
        getRutaImagen = articulo.getRutaImagen();
        
        assertEquals(nuevaRutaImagen, getRutaImagen);
    }

    @Test
    public void testGetCodigoIdentificador() {
        //Var
        int nuevoCodigo = 1234;
        Articulo articulo = new Articulo("", "", 0, "", nuevoCodigo);
        int getCodigo = articulo.getCodigoIdentificador();
        
        assertEquals(nuevoCodigo, getCodigo);
    }

    @Test
    public void testSetCodigoIdentificador() {
        //Var
        Articulo articulo = new Articulo("", "", 0, "", 1234);
        int nuevoCodigo = 4242;
        int getCodigo;
        
        articulo.setCodigoIdentificador(nuevoCodigo);
        getCodigo = articulo.getCodigoIdentificador();
        
        assertEquals(nuevoCodigo, getCodigo);
    }

    @Test
    public void testGetPrecioPorKG() {
        //Var
        double nuevoPrecio = 66.5;
        Articulo articulo = new Articulo("", "", nuevoPrecio, "", 0);
        double getPrecio = articulo.getPrecioPorKG();
        
        assertEquals(nuevoPrecio, getPrecio, 0);
    }

    @Test
    public void testSetPrecioPorKG() {
        //Var
        Articulo articulo = new Articulo("", "", 33.3, "", 0);
        double nuevoPrecio = 25.9;
        double getPrecio;
        
        articulo.setPrecioPorKG(nuevoPrecio);
        getPrecio = articulo.getPrecioPorKG();
        
        assertEquals(nuevoPrecio, getPrecio, 0);
    }

    @Test
    public void testGetOrigenDelArticulo() {
        //Var
        IProveedor nuevoOrigen = new Proveedor("Granja");
        Articulo articulo = new Articulo(0, nuevoOrigen, null, "", "", "",0);
        IProveedor getOrigen = articulo.getOrigenDelArticulo();
        
        assertEquals(nuevoOrigen, getOrigen);
    }

    @Test
    public void testSetOrigenDelArticulo() {
        //Var
        Articulo articulo = new Articulo(0, new Proveedor(), null, "", "", "",0);
        IProveedor nuevoOrigen = new Proveedor("Tienda Inglesa");
        IProveedor getOrigen;
        
        articulo.setOrigenDelArticulo(nuevoOrigen);
        getOrigen = articulo.getOrigenDelArticulo();
        
        assertEquals(nuevoOrigen, getOrigen);
    }

    @Test
    public void testGetEnvasesAplicables() {
        //Var
        ArrayList<IEnvase> nuevaLista = new ArrayList<>();
        Articulo articulo = new Articulo(0, null, nuevaLista, "", "", "",0);
        ArrayList<IEnvase> getLista = articulo.getEnvasesAplicables();
        
        assertEquals(nuevaLista, getLista);
    }

    @Test
    public void testSetEnvasesAplicables() {
        //Var
        Articulo articulo = new Articulo(0, null, new ArrayList<>(), "", "", "",0);
        ArrayList<IEnvase> nuevaLista = new ArrayList<>();
        ArrayList<IEnvase> getLista;
        
        articulo.setEnvasesAplicables(nuevaLista);
        getLista = articulo.getEnvasesAplicables();
        
        assertEquals(nuevaLista, getLista);
    }

    @Test
    public void testGetCalificador() {
        //Var
        String nuevoCalificador = "Fruta";
        Articulo articulo = new Articulo(0, null, null, "", "", nuevoCalificador,0);
        String getCalificador = articulo.getCalificador();
        
        assertEquals(nuevoCalificador, getCalificador);
    }

    @Test
    public void testSetCalificador() {
        //Var
        Articulo articulo = new Articulo(0, null, null, "", "", "Fruta",0);
        String nuevoCalificador = "Verdura";
        String getCalificador;
        
        articulo.setCalificador(nuevoCalificador);
        getCalificador = articulo.getCalificador();
        
        assertEquals(nuevoCalificador, getCalificador);
    }

    @Test
    public void testObtenerCodigoIdentificador() {
        //Var
        int nuevoCodigo = 1234;
        Articulo articulo = new Articulo("", "", 0, "", nuevoCodigo);
        int obtenerCodigo = articulo.obtenerCodigoIdentificador();
        
        assertEquals(nuevoCodigo, obtenerCodigo);
    }

    @Test
    public void testObtenerEnvasesAplicables() {
        //Var
        ArrayList<IEnvase> nuevaLista = new ArrayList<>();
        Articulo articulo = new Articulo(0, null, nuevaLista, "", "", "",0);
        ArrayList<IEnvase> obtenerLista = articulo.obtenerEnvasesAplicables();
        
        assertEquals(nuevaLista, obtenerLista);
    }

    @Test
    public void testObtenerNombre() {
        //Var
        String nuevoNombre = "Manzana";
        Articulo articulo = new Articulo(nuevoNombre);
        String obtenerNombre = articulo.obtenerNombre();
        
        assertEquals(nuevoNombre, obtenerNombre);
    }

    @Test
    public void testObtenerRutaDeImagen() {
        //Var
        String nuevaRutaImagen = "\\imagenes\\imagen.jpg";
        Articulo articulo = new Articulo("", nuevaRutaImagen, 0, "", 0);
        String obtenerRutaImagen = articulo.obtenerRutaDeImagen();
        
        assertEquals(nuevaRutaImagen, obtenerRutaImagen);
    }

    @Test
    public void testObtenerPrecioPorKG() {
        //Var
        double nuevoPrecio = 66.5;
        Articulo articulo = new Articulo("", "", nuevoPrecio, "", 0);
        double obtenerPrecio = articulo.obtenerPrecioPorKG();
        
        assertEquals(nuevoPrecio, obtenerPrecio, 0);
    }

    @Test
    public void testObtenerOrigen() {
        //Var
        IProveedor nuevoOrigen = new Proveedor("Granja");
        Articulo articulo = new Articulo(0, nuevoOrigen, null, "", "", "",0);
        IProveedor obtenerOrigen = articulo.obtenerOrigen();
        
        assertEquals(nuevoOrigen, obtenerOrigen);
    }

    @Test
    public void testSonIgualesPorNombreTrue() {
        String nombre1 = "Manzana";
        String nombre2 = "Manzana";
        Articulo articulo1 = new Articulo(nombre1);
        Articulo articulo2 = new Articulo(nombre2);
        
        assertTrue(articulo1.sonIgualesPorNombre(articulo2));
    }

        @Test
    public void testSonIgualesPorNombreFalse() {
        String nombre1 = "Manzana";
        String nombre2 = "Banana";
        Articulo articulo1 = new Articulo(nombre1);
        Articulo articulo2 = new Articulo(nombre2);
        
        assertFalse(articulo1.sonIgualesPorNombre(articulo2));
    }
    
    @Test
    public void testSonIgualesPorId() {
        int codigo1 = 1010;
        int codigo2 = 1010;
        Articulo articulo1 = new Articulo("", "", 0, "", codigo1);
        Articulo articulo2 = new Articulo("", "", 0, "", codigo2);
        
        assertTrue(articulo1.sonIgualesPorId(articulo2));
    }

    @Test
    public void testModificarOrigen() {
        int codigo1 = 1010;
        int codigo2 = 9999;
        Articulo articulo1 = new Articulo("", "", 0, "", codigo1);
        Articulo articulo2 = new Articulo("", "", 0, "", codigo2);
        
        assertFalse(articulo1.sonIgualesPorId(articulo2));
    }

    @Test
    public void testAgregarEnvase() {
        IEnvase nuevoEnvase = new Envase("Bolsa", "");
        ArrayList<IEnvase> nuevaLista = new ArrayList<>();
        Articulo articulo = new Articulo(0, null, nuevaLista, "", "", "", 0);
        ArrayList<IEnvase> getLista;
        
        articulo.agregarEnvase(nuevoEnvase);
        getLista = articulo.getEnvasesAplicables();
        
        assertEquals(nuevaLista.toArray(),getLista.toArray());
    }

    @Test
    public void testObtenerCalificador() {
        //Var
        String nuevoCalificador = "Fruta";
        Articulo articulo = new Articulo(0, null, null, "", "", nuevoCalificador,0);
        String getCalificador = articulo.getCalificador();
        
        assertEquals(nuevoCalificador, getCalificador);
    }

    @Test
    public void testToString() {
        String nuevoNombre = "Manzana";
        int nuevoCodigo = 1234;
        Articulo articulo = new Articulo(nuevoNombre, "", 0, "", nuevoCodigo);
        String toString = articulo.toString();
        String stringEsperado = nuevoNombre + " (" + nuevoCodigo + ") ";
        
        assertEquals(toString, stringEsperado);
    }
    
}
