package dominio;

import interfazDominio.IEnvase;
/**
 * Clase Envase - Contiene toda la informacion del envase
 * @author Marcos Novelli - Matias Salles
 */
public class Envase implements IEnvase{
    //Atributos
    private String nombreEnvase;
    private double largo;//Para calcular el volumen
    private double alto; //Para calcular el volumen
    private double ancho;//Para calcular el volumen
    private double volumen;//Para calcular cuantos envases son necesarios
    
    //Constructores
    public Envase(){
        this.nombreEnvase = "";
        this.largo = -1;
        this.alto = -1;
        this.ancho = -1;
        this.volumen = -1;
    }
    
    public Envase(String nombreEnvase, double largo, double alto, double ancho) {
        this.nombreEnvase = nombreEnvase;
        this.largo = largo;
        this.alto = alto;
        this.ancho = ancho;
        this.volumen = calcularVolumen(largo, alto, ancho);
    }
    
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
    
    /**
     * @param largo - Largo del envase
     * @param alto - Alto del envase
     * @param ancho - Ancho del envase
     * @return El volumen del envase (aproximamos todos los envases con el 
     * volumen de un rectangulo - largo*alto*ancho)
     */
    private double calcularVolumen(double largo, double alto, double ancho){
        return largo*alto*ancho;
    }
}
