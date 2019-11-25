package dominio;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * DireccionTest
 * @author Marcos Novelli - Matias Salles
 */
public class DireccionTest {
    
    public DireccionTest() {
    }

    @Test
    public void testGetPais() {
        //Var
        String nuevoPais = "Uruguay";
        Direccion direccion = new Direccion(nuevoPais, "", "", "", "", 0, 0);
        String getPais = direccion.getPais();
        
        assertEquals(nuevoPais, getPais);
    }

    @Test
    public void testSetPais() {
        //Var
        Direccion direccion = new Direccion("Uruguay", "", "", "", "", 0, 0);
        String nuevoPais = "Argentina";
        String getPais;
        
        direccion.setPais(nuevoPais);
        getPais = direccion.getPais();
        
        assertEquals(nuevoPais, getPais);
    }

    @Test
    public void testGetDepartamento() {
        //Var
        String nuevoDepartamento = "Montevideo";
        Direccion direccion = new Direccion("", nuevoDepartamento, "", "", "", 0, 0);
        String getDepartamento = direccion.getDepartamento();
        
        assertEquals(nuevoDepartamento, getDepartamento);
    }

    @Test
    public void testSetDepartamento() {
        //Var
        Direccion direccion = new Direccion("", "Montevideo", "", "", "", 0, 0);
        String nuevoDepartamento = "Canelones";
        String getDepartamento;
        
        direccion.setDepartamento(nuevoDepartamento);
        getDepartamento = direccion.getDepartamento();
        
        assertEquals(nuevoDepartamento, getDepartamento);
    }

    @Test
    public void testGetBarrio() {
        //Var
        String nuevoBarrio = "Punta Gorda";
        Direccion direccion = new Direccion("", "", nuevoBarrio, "", "", 0, 0);
        String getBarrio = direccion.getBarrio();
        
        assertEquals(nuevoBarrio, getBarrio);
    }

    @Test
    public void testSetBarrio() {
        //Var
        Direccion direccion = new Direccion("", "", "Malvin", "", "", 0, 0);
        String nuevoBarrio = "Carrasco";
        String getBarrio;
        
        direccion.setBarrio(nuevoBarrio);
        getBarrio = direccion.getBarrio();
        
        assertEquals(nuevoBarrio, getBarrio);
    }

    @Test
    public void testGetCalle() {
        //Var
        String nuevaCalle = "Mercedes";
        Direccion direccion = new Direccion("", "", "", nuevaCalle, "", 0, 0);
        String getCalle = direccion.getCalle();
        
        assertEquals(nuevaCalle, getCalle);
    }

    @Test
    public void testSetCalle() {
        //Var
        Direccion direccion = new Direccion("", "", "", "Mercedes", "", 0, 0);
        String nuevaCalle = "Cuareim";
        String getCalle;
        
        direccion.setCalle(nuevaCalle);
        getCalle = direccion.getCalle();
        
        assertEquals(nuevaCalle, getCalle);
    }

    @Test
    public void testGetEsquina() {
        //Var
        String nuevaEsquina = "Cooper";
        Direccion direccion = new Direccion("", "", "", "", nuevaEsquina, 0, 0);
        String getEsquina = direccion.getEsquina();
        
        assertEquals(nuevaEsquina, getEsquina);
    }

    @Test
    public void testSetEsquina() {
        //Var
        Direccion direccion = new Direccion("", "", "", "Cooper", "", 0, 0);
        String nuevaEsquina = "Jamaica";
        String getEsquina;
        
        direccion.setEsquina(nuevaEsquina);
        getEsquina = direccion.getEsquina();
        
        assertEquals(nuevaEsquina, getEsquina);
    }

    @Test
    public void testGetNumeroDeCasa() {
        //Var
        int nuevoNumeroDeCasa = 1234;
        Direccion direccion = new Direccion("", "", "", "", "", nuevoNumeroDeCasa, 0);
        int getNumeroDeCasa = direccion.getNumeroDeCasa();
        
        assertEquals(nuevoNumeroDeCasa, getNumeroDeCasa);
    }

    @Test
    public void testSetNumeroDeCasa() {
        //Var
        Direccion direccion = new Direccion("", "", "", "", "", 1234, 0);
        int nuevoNumeroDeCasa = 9090;
        int getNumeroDeCasa;
        
        direccion.setNumeroDeCasa(nuevoNumeroDeCasa);
        getNumeroDeCasa = direccion.getNumeroDeCasa();
        
        assertEquals(nuevoNumeroDeCasa, getNumeroDeCasa);
    }

    @Test
    public void testGetCodigoPostal() {
        //Var
        int nuevoCodigoPostal = 11400;
        Direccion direccion = new Direccion("", "", "", "", "", 0, nuevoCodigoPostal);
        int getCodigoPostal = direccion.getCodigoPostal();
        
        assertEquals(nuevoCodigoPostal, getCodigoPostal);
    }

    @Test
    public void testSetCodigoPostal() {
        //Var
        Direccion direccion = new Direccion("", "", "", "", "", 0, 11400);
        int nuevoCodigoPostal = 11500;
        int getCodigoPostal;
        
        direccion.setCodigoPostal(nuevoCodigoPostal);
        getCodigoPostal = direccion.getCodigoPostal();
        
        assertEquals(nuevoCodigoPostal, getCodigoPostal);
    }

    @Test
    public void testObtenerPais() {
        //Var
        String nuevoPais = "Uruguay";
        Direccion direccion = new Direccion(nuevoPais, "", "", "", "", 0, 0);
        String obtenerPais = direccion.obtenerPais();
        
        assertEquals(nuevoPais, obtenerPais);
    }

    @Test
    public void testObtenerDepartamento() {
        //Var
        String nuevoDepartamento = "Montevideo";
        Direccion direccion = new Direccion("", nuevoDepartamento, "", "", "", 0, 0);
        String obtenerDepartamento = direccion.obtenerDepartamento();
        
        assertEquals(nuevoDepartamento, obtenerDepartamento);
    }

    @Test
    public void testObtenerCalle() {
        //Var
        String nuevaCalle = "Cooper";
        Direccion direccion = new Direccion("", "", "", nuevaCalle, "", 0, 0);
        String obtenerCalle = direccion.obtenerCalle();
        
        assertEquals(nuevaCalle, obtenerCalle);
    }

    @Test
    public void testObtenerBarrio() {
        //Var
        String nuevoBarrio = "Punta Carretas";
        Direccion direccion = new Direccion("", "", nuevoBarrio, "", "", 0, 0);
        String obtenerBarrio = direccion.obtenerBarrio();
        
        assertEquals(nuevoBarrio, obtenerBarrio);
    }

    @Test
    public void testObtenerCodigoPostal() {
        //Var
        int nuevoCodigoPostal = 11400;
        Direccion direccion = new Direccion("", "", "", "", "", 0, nuevoCodigoPostal);
        int obtenerCodigoPostal = direccion.obtenerCodigoPostal();
        
        assertEquals(nuevoCodigoPostal, obtenerCodigoPostal);
    }
    
}
