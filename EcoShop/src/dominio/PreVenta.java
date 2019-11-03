package dominio;

import java.util.Date;
/**
 * Clase PreVenta - Tiene los atributos de Venta y una fecha de retiro de la 
 * compra
 * @author Marcos Novelli - Matias Salles
 */
public class PreVenta extends Venta{
    //Atributos
    private Date fechaDeRetiro;

    //Getter & Setter
    public Date getFechaDeRetiro() {
        return fechaDeRetiro;
    }

    public void setFechaDeRetiro(Date fechaDeRetiro) {
        this.fechaDeRetiro = fechaDeRetiro;
    }
    
}
