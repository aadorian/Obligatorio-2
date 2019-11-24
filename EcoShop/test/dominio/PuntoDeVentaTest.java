package dominio;

import interfazDominio.IDireccion;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcos Novelli - Matias Salles
 */
public class PuntoDeVentaTest {
    
    public PuntoDeVentaTest() {
    }

    @Test
    public void testGetDireccionLocal() {
        //Var
        IDireccion nuevaDireccion = new Direccion();
        PuntoDeVenta puntoDeVenta = new PuntoDeVenta(nuevaDireccion, 0);
        IDireccion getDireccion = puntoDeVenta.getDireccionLocal();
        
        assertEquals(nuevaDireccion, getDireccion);
    }

    @Test
    public void testSetDireccionLocal() {
        //Var
        PuntoDeVenta puntoDeVenta = new PuntoDeVenta(new Direccion(), 0);
        IDireccion nuevaDireccion = new Direccion();
        IDireccion getDireccion;
        
        puntoDeVenta.setDireccionLocal(nuevaDireccion);
        getDireccion = puntoDeVenta.getDireccionLocal();
        
        assertEquals(nuevaDireccion, getDireccion);
    }

    @Test
    public void testGetNumeroDelLocal() {
        //Var
        int nuevoNumeroLocal = 12;
        PuntoDeVenta puntoDeVenta = new PuntoDeVenta(nuevoNumeroLocal, "");
        int getNumeroLocal = puntoDeVenta.getNumeroDelLocal();
        
        assertEquals(nuevoNumeroLocal, getNumeroLocal);
    }

    @Test
    public void testSetNumeroDelLocal() {
        //Var
        PuntoDeVenta puntoDeVenta = new PuntoDeVenta(12, "");
        int nuevoNumeroLocal = 34;
        int getNumeroLocal;
        
        puntoDeVenta.setNumeroDelLocal(nuevoNumeroLocal);
        getNumeroLocal = puntoDeVenta.getNumeroDelLocal();
        
        assertEquals(nuevoNumeroLocal, getNumeroLocal);
    }

    @Test
    public void testGetRutaDeImagen() {
        //Var
        String nuevaRutaImagen = "\\imagenes\\imagen.jpg";
        PuntoDeVenta puntoDeVenta = new PuntoDeVenta(0, nuevaRutaImagen);
        String getRutaImagen = puntoDeVenta.getRutaDeImagen();
        
        assertEquals(nuevaRutaImagen, getRutaImagen);
    }

    @Test
    public void testSetRutaDeImagen() {
        //Var
        PuntoDeVenta puntoDeVenta = new PuntoDeVenta(0, "\\imagenes\\imagen.jpg");
        String nuevaRutaImagen = "\\imagenes\\foto.jpg";
        String getRutaImagen;
        
        puntoDeVenta.setRutaDeImagen(nuevaRutaImagen);
        getRutaImagen = puntoDeVenta.getRutaDeImagen();
        
        assertEquals(nuevaRutaImagen, getRutaImagen);
    }

    @Test
    public void testModificarDireccion() {
        //Var
        PuntoDeVenta puntoDeVenta = new PuntoDeVenta(new Direccion(), 0);
        IDireccion nuevaDireccion = new Direccion();
        IDireccion obtenerDireccion;
        
        puntoDeVenta.modificarDireccion(nuevaDireccion);
        obtenerDireccion = puntoDeVenta.obtenerDireccionDelLocal();
        
        assertEquals(nuevaDireccion, obtenerDireccion);
    }

    @Test
    public void testObtenerDireccionDelLocal() {
        //Var
        IDireccion nuevaDireccion = new Direccion();
        PuntoDeVenta puntoDeVenta = new PuntoDeVenta(nuevaDireccion, 0);
        IDireccion obtenerDireccion = puntoDeVenta.obtenerDireccionDelLocal();
        
        assertEquals(nuevaDireccion, obtenerDireccion);
    }

    @Test
    public void testObtenerNumeroDeLocal() {
        //Var
        int nuevoNumeroLocal = 12;
        PuntoDeVenta puntoDeVenta = new PuntoDeVenta(nuevoNumeroLocal, "");
        int obtenerNumeroLocal = puntoDeVenta.obtenerNumeroDeLocal();
        
        assertEquals(nuevoNumeroLocal, obtenerNumeroLocal);
    }

    @Test
    public void testObtenerRutaDeImagen() {
        //Var
        String nuevaRutaImagen = "\\imagenes\\imagen.jpg";
        PuntoDeVenta puntoDeVenta = new PuntoDeVenta(0, nuevaRutaImagen);
        String obtenerRutaImagen = puntoDeVenta.obtenerRutaDeImagen();
        
        assertEquals(nuevaRutaImagen, obtenerRutaImagen);
    }

    @Test
    public void testToString() {
        //Var
        int nuevoNumeroLocal = 12;
        IDireccion nuevaDireccion = new Direccion("", "", "", "Cooper", "", 0, 0);
        PuntoDeVenta puntoDeVenta = new PuntoDeVenta(nuevaDireccion, nuevoNumeroLocal);
        String toString = puntoDeVenta.toString();
        String strEsperado = puntoDeVenta.obtenerNumeroDeLocal() + " - "
                + nuevaDireccion.obtenerCalle();
        
        assertEquals(strEsperado, toString);
    }
    
}
