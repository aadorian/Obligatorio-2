package dominio;

/**
 * Clase Envase - Contiene toda la informacion del envase
 * @author Marcos Novelli - Matias Salles
 */
public class Envase {
    //Atributos
    private String nombreEnvase;
    private double largo;//Para calcular el volumen
    private double alto; //Para calcular el volumen
    private double ancho;//Para calcular el volumen
    private double volumen;//Para calcular cuantos envases son necesarios
    
    //Getter & Setter
    public String getNombreEnvase() {
        return nombreEnvase;
    }

    public void setNombreEnvase(String nombreEnvase) {
        this.nombreEnvase = nombreEnvase;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }
    
}
