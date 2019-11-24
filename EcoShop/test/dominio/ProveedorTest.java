package dominio;

import interfazDominio.IDireccion;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ProveedorTest - Test unitario de Proveedor
 * @author Marcos Novelli - Matias Salles
 */
public class ProveedorTest {
    
    public ProveedorTest() {
    }

    @Test
    public void testGetNombreProveedor() {
        //Var
        String nuevoNombreDelProveedor = "Tienda Inglesa";
        Proveedor proveedor = new Proveedor(nuevoNombreDelProveedor);
        String nombreGetDelProveedor = proveedor.getNombreProveedor();
        
        assertEquals(nuevoNombreDelProveedor, nombreGetDelProveedor);
    }

    @Test
    public void testSetNombreProveedor() {
        //Var
        Proveedor proveedor = new Proveedor("Tienda Inglesa");
        String nuevoNombreDelProveedor = "Devoto";
        String nombreGetDelProveedor;
        
        proveedor.setNombreProveedor(nuevoNombreDelProveedor);
        nombreGetDelProveedor = proveedor.getNombreProveedor();
        
        assertEquals(nuevoNombreDelProveedor, nombreGetDelProveedor);
    }

    @Test
    public void testGetDireccionProveedor() {
        //Var
        IDireccion nuevadireccionProveedor = new Direccion();
        Proveedor proveedor = new Proveedor("Devoto", nuevadireccionProveedor);
        IDireccion direccionGetProveedor = proveedor.getDireccionProveedor();
        
        assertEquals(nuevadireccionProveedor, direccionGetProveedor);
    }

    @Test
    public void testSetDireccionProveedor() {
        //Var
        Proveedor proveedor = new Proveedor("Devoto", new Direccion());
        IDireccion nuevadireccionProveedor = new Direccion();
        IDireccion direccionGetProveedor;
        
        proveedor.setDireccionProveedor(nuevadireccionProveedor);
        direccionGetProveedor = proveedor.getDireccionProveedor();
        
        assertEquals(nuevadireccionProveedor, direccionGetProveedor);
    }

    @Test
    public void testModificarDireccion() {
        //Var
        Proveedor proveedor = new Proveedor("Devoto", new Direccion());
        IDireccion nuevadireccionProveedor = new Direccion();
        IDireccion direccionObtenerProveedor;
        
        proveedor.modificarDireccion(nuevadireccionProveedor);
        direccionObtenerProveedor = proveedor.obtenerDireccion();
        
        assertEquals(nuevadireccionProveedor, direccionObtenerProveedor);
    }

    @Test
    public void testObtenerNombre() {
        //Var
        String nuevoNombreProveedor = "Geant";
        Proveedor proveedor = new Proveedor(nuevoNombreProveedor);
        String obtenerNombre = proveedor.obtenerNombre();
        
        assertEquals(nuevoNombreProveedor, obtenerNombre);
    }

    @Test
    public void testObtenerDireccion() {
        //Var
        IDireccion nuevadireccionProveedor = new Direccion();
        Proveedor proveedor = new Proveedor("Devoto", nuevadireccionProveedor);
        IDireccion direccionObtenerProveedor = proveedor.obtenerDireccion();
        
        assertEquals(nuevadireccionProveedor, direccionObtenerProveedor);
    }
    
}
