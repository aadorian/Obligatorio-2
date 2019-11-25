package dominio;

import interfazDominio.ICarrito;
import interfazDominio.IPuntoDeVenta;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * PreVentaTest
 * @author Marcos Novelli - Matias Salles
 */
public class PreVentaTest {
    
    public PreVentaTest() {
    }

    @Test
    public void testGetFechaDeRetiro() {
        //Var
        LocalDate nuevaFechaDeRetiro = LocalDate.of(2019, 12, 1);
        PreVenta preVenta = new PreVenta(null, null, null, 0, nuevaFechaDeRetiro);
        LocalDate getFechaDeRetiro = preVenta.getFechaDeRetiro();

        assertEquals(nuevaFechaDeRetiro, getFechaDeRetiro);
    }

    @Test
    public void testSetFechaDeRetiro() {
        //Var
        PreVenta preVenta = new PreVenta(null, null, null, 0, LocalDate.of(2019, 12, 20));
        LocalDate nuevaFechaDeRetiro = LocalDate.of(2019, 11, 25);
        LocalDate getFechaDeRetiro;

        preVenta.setFechaDeRetiro(nuevaFechaDeRetiro);
        getFechaDeRetiro = preVenta.getFechaDeRetiro();
        
        assertEquals(nuevaFechaDeRetiro, getFechaDeRetiro);
    }

    @Test
    public void testGetCarroCompras() {
        //Var
        ICarrito nuevoCarrito = new Carrito();
        PreVenta preVenta = new PreVenta(nuevoCarrito, null, null, 0, null);
        ICarrito getCarrito = preVenta.getCarroCompras();

        assertEquals(nuevoCarrito, getCarrito);
    }

    @Test
    public void testSetCarroCompras() {
        //Var
        PreVenta preVenta = new PreVenta(new Carrito(), null, null, 0, null);
        ICarrito nuevoCarrito = new Carrito();
        ICarrito getCarrito;
        
        preVenta.setCarroCompras(nuevoCarrito);
        getCarrito = preVenta.getCarroCompras();

        assertEquals(nuevoCarrito, getCarrito);
    }

    @Test
    public void testGetLocalDeVenta() {
        //Var
        IPuntoDeVenta nuevoPuntoDeVenta = new PuntoDeVenta();
        PreVenta preVenta = new PreVenta(null, nuevoPuntoDeVenta, null, 0, null);
        IPuntoDeVenta getPuntoDeVenta = preVenta.getLocalDeVenta();

        assertEquals(nuevoPuntoDeVenta, getPuntoDeVenta);
    }

    @Test
    public void testSetLocalDeVenta() {
        //Var
        PreVenta preVenta = new PreVenta(null, new PuntoDeVenta(), null, 0, null);
        IPuntoDeVenta nuevoPuntoDeVenta = new PuntoDeVenta();
        IPuntoDeVenta getPuntoDeVenta;

        preVenta.setLocalDeVenta(nuevoPuntoDeVenta);
        getPuntoDeVenta = preVenta.getLocalDeVenta();
        
        assertEquals(nuevoPuntoDeVenta, getPuntoDeVenta);
    }

    @Test
    public void testGetFechaDeVenta() {
        //Var
        LocalDateTime nuevaFechaDeVenta = LocalDateTime.now();
        PreVenta preVenta = new PreVenta(null, null, nuevaFechaDeVenta, 0, null);
        LocalDateTime getFechaDeventa = preVenta.getFechaDeVenta();

        assertEquals(nuevaFechaDeVenta, getFechaDeventa);
    }

    @Test
    public void testSetFechaDeVenta() {
        //Var
        PreVenta preVenta = new PreVenta(null, null, LocalDateTime.now(), 0, null);
        LocalDateTime nuevaFechaDeVenta = LocalDateTime.of(2019, 12, 10, 9, 3);
        LocalDateTime getFechaDeventa;
        
        preVenta.setFechaDeVenta(nuevaFechaDeVenta);
        getFechaDeventa = preVenta.getFechaDeVenta();

        assertEquals(nuevaFechaDeVenta, getFechaDeventa);
    }

    @Test
    public void testGetPrecioTotal() {
        //Var
        double nuevoPrecioTotal = 1000;
        PreVenta preVenta = new PreVenta(null, null, null, nuevoPrecioTotal, null);
        double getPrecioTotal = preVenta.getPrecioTotal();
        
        assertEquals(nuevoPrecioTotal, getPrecioTotal,0);
    }

    @Test
    public void testSetPrecioTotal() {
        //Var
        PreVenta preVenta = new PreVenta(null, null, null, 1000, null);
        double nuevoPrecioTotal = 2200;
        double getPrecioTotal;
        
        preVenta.setPrecioTotal(nuevoPrecioTotal);
        getPrecioTotal = preVenta.getPrecioTotal();
        
        assertEquals(nuevoPrecioTotal, getPrecioTotal,0);
    }

    @Test
    public void testObtenerFechaDeCompraRealizada() {
        //Var
        LocalDateTime nuevaFechaDeVenta = LocalDateTime.now();
        PreVenta preVenta = new PreVenta(null, null, nuevaFechaDeVenta, 0, null);
        LocalDateTime obtenerFechaDeVenta = preVenta.obtenerFechaDeCompraRealizada();

        assertEquals(nuevaFechaDeVenta, obtenerFechaDeVenta);
    }

    @Test
    public void testObtenerFechaDeRetiro() {
        //Var
        LocalDate nuevaFechaDeRetiro = LocalDate.of(2019, 12, 1);
        PreVenta preVenta = new PreVenta(null, null, null, 0, nuevaFechaDeRetiro);
        LocalDate obtenerFechaDeRetiro = preVenta.obtenerFechaDeRetiro();

        assertEquals(nuevaFechaDeRetiro, obtenerFechaDeRetiro);
    }

    @Test
    public void testObtenerPrecioTotalDeCompra() {
        //Var
        double nuevoPrecioTotal = 1000;
        PreVenta preVenta = new PreVenta(null, null, null, nuevoPrecioTotal, null);
        double obtenerPrecioTotal = preVenta.obtenerPrecioTotalDeCompra();
        
        assertEquals(nuevoPrecioTotal, obtenerPrecioTotal,0);
    }

    @Test
    public void testObtenerCarritoAsociadoALaCompra() {
        //Var
        ICarrito nuevoCarrito = new Carrito();
        PreVenta preVenta = new PreVenta(nuevoCarrito, null, null, 0, null);
        ICarrito obtenerCarrito = preVenta.obtenerCarritoAsociadoALaCompra();

        assertEquals(nuevoCarrito, obtenerCarrito);
    }

    @Test
    public void testObtenerLocalDeRetiro() {
        //Var
        IPuntoDeVenta nuevoPuntoDeVenta = new PuntoDeVenta();
        PreVenta preVenta = new PreVenta(null, nuevoPuntoDeVenta, null, 0, null);
        IPuntoDeVenta obtenerPuntoDeVenta = preVenta.obtenerLocalDeRetiro();

        assertEquals(nuevoPuntoDeVenta, obtenerPuntoDeVenta);
    }
    
}
