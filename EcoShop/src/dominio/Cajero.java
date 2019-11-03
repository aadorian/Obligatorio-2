package dominio;

/**
 * Clase Cajero - contiene la informacion de el cajero responsable de la caja
 * para realizar la Venta Express
 * @author Marcos Novelli - Matias Salles
 */
public class Cajero {
    //Atributos
    private String nombre;
    private String apellido;
    private int numeroEmpleado; //Numero de empleado unico

    //Getter & Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }
    
    
}
