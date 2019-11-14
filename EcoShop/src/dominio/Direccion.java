package dominio;

import interfazDominio.IDireccion;
/**
 * Clase Direccion - tiene todos los datos necesarios de una direccion
 * @author Marcos Novelli - Matias Salles
 */
public class Direccion implements IDireccion{
    //Atributos
    private String pais;
    private String departamento;
    private String barrio;
    private String calle;
    private String esquina;
    private int numeroDeCasa;
    private int codigoPostal;

    //Constructores
    public Direccion(){
        this.pais = "";
        this.departamento = "";
        this.barrio = "";
        this.calle = "";
        this.esquina = "";
        this.numeroDeCasa = -1;
        this.codigoPostal = -1;
    }
    
    public Direccion(String pais, String departamento, String barrio, 
            String calle, String esquina, int numeroDeCasa, int codigoPostal) {
        this.pais = pais;
        this.departamento = departamento;
        this.barrio = barrio;
        this.calle = calle;
        this.esquina = esquina;
        this.numeroDeCasa = numeroDeCasa;
        this.codigoPostal = codigoPostal;
    }
    
    //Getter & Setter
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getEsquina() {
        return esquina;
    }

    public void setEsquina(String esquina) {
        this.esquina = esquina;
    }

    public int getNumeroDeCasa() {
        return numeroDeCasa;
    }

    public void setNumeroDeCasa(int numeroDeCasa) {
        this.numeroDeCasa = numeroDeCasa;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    
    
}
