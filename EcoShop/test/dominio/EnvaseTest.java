package dominio;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * EnvaseTest
 * @author Marcos Novelli - Matias Salles
 */
public class EnvaseTest {
    
    public EnvaseTest() {
    }

    @Test
    public void testGetNombreEnvase() {
        //Var
        String nuevoNombre = "Bolsa Grande";
        Envase envase = new Envase(nuevoNombre, "");
        String getNombre = envase.getNombreEnvase();
        
        assertEquals(nuevoNombre, getNombre);
    }

    @Test
    public void testSetNombreEnvase() {
        //Var
        Envase envase = new Envase("Bolsa Grande", "");
        String nuevoNombre = "Tupper Chico";
        String getNombre;
        
        envase.setNombreEnvase(nuevoNombre);
        getNombre = envase.getNombreEnvase();
        
        assertEquals(nuevoNombre, getNombre);
    }

    @Test
    public void testGetRutaImagen() {
        //Var
        String nuevaRutaImagen = "\\imagenes\\imagen.jpg";
        Envase envase = new Envase("", nuevaRutaImagen);
        String getRutaImagen = envase.getRutaImagen();
        
        assertEquals(nuevaRutaImagen, getRutaImagen);
    }

    @Test
    public void testSetRutaImagen() {
        //Var
        Envase envase = new Envase("", "\\imagenes\\imagen.jpg");
        String nuevaRutaImagen = "\\imagenes\\foto.png";
        String getRutaImagen;
        
        envase.setRutaImagen(nuevaRutaImagen);
        getRutaImagen = envase.getRutaImagen();
        
        assertEquals(nuevaRutaImagen, getRutaImagen);
    }

    @Test
    public void testObtenerNombre() {
        //Var
        String nuevoNombre = "Bolsa Grande";
        Envase envase = new Envase(nuevoNombre, "");
        String obtenerNombre = envase.obtenerNombre();
        
        assertEquals(nuevoNombre, obtenerNombre);
    }

    @Test
    public void testSonIgualesTrue() {
        //Var
        String nombre1 = "Bolsa Grande";
        String nombre2 = "Bolsa Grande";
        Envase envase1 = new Envase(nombre1, "");
        Envase envase2 = new Envase(nombre2, "");
        
        assertTrue(envase1.sonIguales(envase2));
    }

    @Test
    public void testSonIgualesFalse() {
        //Var
        String nombre1 = "Bolsa Chica";
        String nombre2 = "Bolsa Grande";
        Envase envase1 = new Envase(nombre1, "");
        Envase envase2 = new Envase(nombre2, "");
        
        assertFalse(envase1.sonIguales(envase2));
    }
    
    @Test
    public void testObtenerRutaImagen() {
        //Var
        String nuevaRutaImagen = "\\imagenes\\imagen.jpg";
        Envase envase = new Envase("", nuevaRutaImagen);
        String obtenerRutaImagen = envase.obtenerRutaImagen();
        
        assertEquals(nuevaRutaImagen, obtenerRutaImagen);
    }
    
}
