package dominio;

import interfazDominio.IArticulo;
import interfazDominio.ICarrito;
import interfazDominio.IDireccion;
import interfazDominio.IEnvase;
import interfazDominio.IPreVenta;
import interfazDominio.IPuntoDeVenta;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * TicketPreVentaTest
 * @author Marcos Novelli - Matias Salles
 */
public class TicketPreVentaTest {
    
    public TicketPreVentaTest() {
    }

    @Test
    public void testGetUnaPreVenta() {
        IPreVenta nuevaPreVenta = new PreVenta(null, null, null, 0, null);
        TicketPreVenta ticketPreVenta = new TicketPreVenta(nuevaPreVenta, 10);
        IPreVenta getPreVenta = ticketPreVenta.getUnaPreVenta();
        
        assertEquals(nuevaPreVenta, getPreVenta);
    }

    @Test
    public void testSetUnaPreVenta() {
        IPreVenta nuevaPreVenta1 = new PreVenta(null, null, null, 0, null);
        TicketPreVenta ticketPreVenta = new TicketPreVenta(nuevaPreVenta1, 10);
        IPreVenta nuevaPreVenta2 = new PreVenta(null, null, null, 0, null);
        IPreVenta getPreVenta;
        
        ticketPreVenta.setUnaPreVenta(nuevaPreVenta2);
        getPreVenta = ticketPreVenta.getUnaPreVenta();
        
        assertEquals(nuevaPreVenta2, getPreVenta);
    }

    @Test
    public void testGetNumeroIdentificador() {
        int nuevoNumero = 13;
        TicketPreVenta ticketPreVenta = new TicketPreVenta(null, nuevoNumero);
        int getNumeroIdentificador = ticketPreVenta.getNumeroIdentificador();
        
        assertEquals(nuevoNumero, getNumeroIdentificador);
    }

    @Test
    public void testSetNumeroIdentificador() {
        TicketPreVenta ticketPreVenta = new TicketPreVenta(null, 12);
        int nuevoNumero = 47;
        int getNumeroIdentificador;
        
        ticketPreVenta.setNumeroIdentificador(nuevoNumero);
        getNumeroIdentificador = ticketPreVenta.getNumeroIdentificador();
        
        assertEquals(nuevoNumero, getNumeroIdentificador);
    }

    @Test
    public void testGetContenidoTicketElectronico() {
        ArrayList<String> nuevaLista = new ArrayList<>();
        TicketPreVenta ticketPreVenta = new TicketPreVenta(null, 0, nuevaLista);
        ArrayList<String> getLista = ticketPreVenta.getContenidoTicketElectronico();
        
        assertEquals(nuevaLista, getLista);
    }

    @Test
    public void testSetTicketElectronico() {
        ArrayList<String> nuevaLista1 = new ArrayList<>();
        TicketPreVenta ticketPreVenta = new TicketPreVenta(null, 0, nuevaLista1);
        ArrayList<String> nuevaLista2 = new ArrayList<>();
        ArrayList<String> getLista;
        
        ticketPreVenta.setContenidoTicketElectronico(nuevaLista2);
        getLista = ticketPreVenta.getContenidoTicketElectronico();
        
        assertEquals(nuevaLista2, getLista);
    }

    @Test
    public void testObtenerNumeroDeTicket() {
        int nuevoNumero = 13;
        TicketPreVenta ticketPreVenta = new TicketPreVenta(null, nuevoNumero);
        int obtenerNumeroIdentificador = ticketPreVenta.obtenerNumeroDeTicket();
        
        assertEquals(nuevoNumero, obtenerNumeroIdentificador);
    }

    @Test
    public void testObtenerContenidoTicketPDF() {
        ArrayList<String> listaEsperada = new ArrayList<>();
        LocalDateTime fechaDeCompraRealizada = LocalDateTime.of(2019, 12, 3, 0, 0, 0);
        LocalDate fechaDeRetiro = LocalDate.of(2019, 12, 4);
        IDireccion nuevaDireccion = new Direccion("", "", "", "Cooper", "", 0, 0);
        IPuntoDeVenta localDeRetiro = new PuntoDeVenta(nuevaDireccion, 12);
        ICarrito carritoAsociadoALaVenta = new Carrito();
        IArticulo nuevoArticulo = new Articulo(30, null, null, "Manzana", "", "", 123);
        IEnvase nuevoEnvase = new Envase("Bolsa", "");
        DateTimeFormatter formatoTiempo = 
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        double cantidadALlevarKG = 2.0;


        carritoAsociadoALaVenta.agregarArticulo(nuevoArticulo, cantidadALlevarKG);
        carritoAsociadoALaVenta.agregarEnvase(nuevoArticulo, nuevoEnvase);
        IPreVenta nuevaPreVenta = new PreVenta(carritoAsociadoALaVenta, 
                localDeRetiro, fechaDeCompraRealizada, 
                carritoAsociadoALaVenta.obtenerPrecioTotal(), fechaDeRetiro);
        TicketPreVenta ticketPreVenta = new TicketPreVenta(nuevaPreVenta, 123);
        
        String vacio = "";
        
        listaEsperada.add("Compra realizada el: " + formatoTiempo.
                        format(fechaDeCompraRealizada));
        listaEsperada.add("Local de retiro: " + localDeRetiro.toString());
        listaEsperada.add("Fecha de retiro: " + fechaDeRetiro);
        listaEsperada.add(vacio);
        listaEsperada.add(vacio);
        listaEsperada.add("-------LISTADO DE COMPRA-------");
        listaEsperada.add(vacio);
        
        listaEsperada.add(nuevoArticulo.toString() + " x" + cantidadALlevarKG + "kg -  "
                    + "$" + nuevoArticulo.obtenerPrecioPorKG() * cantidadALlevarKG
                    + "    | " + nuevoEnvase.obtenerNombre());
        listaEsperada.add(vacio);
        listaEsperada.add("Precio Total: $" + 
                carritoAsociadoALaVenta.obtenerPrecioTotal());
        listaEsperada.add(vacio);
        listaEsperada.add("Gracias por su compra");
        
        ArrayList<String> getLista = ticketPreVenta.getContenidoTicketElectronico();
        
        for (int i = 0; i < listaEsperada.size(); i++) {
            System.out.println(listaEsperada.get(i));
        }
        
        for (int i = 0; i < getLista.size(); i++) {
            System.out.println(getLista.get(i));
        }
        
        assertArrayEquals(listaEsperada.toArray(), getLista.toArray());
        
        
    }

    @Test
    public void testObtenerPreVentaAsociada() {
        IPreVenta nuevaPreVenta = new PreVenta(null, null, null, 0, null);
        TicketPreVenta ticketPreVenta = new TicketPreVenta(nuevaPreVenta, 10);
        IPreVenta getPreVenta = ticketPreVenta.obtenerPreVentaAsociada();
        
        assertEquals(nuevaPreVenta, getPreVenta);
    }
    
}
