package interfazGrafica;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

/**
 * ItemTicketController
 *
 * @author Marcos Novelli - Matias Salles
 */
public class ItemTicketController implements Initializable {
    //Atributos
    @FXML
    private Label compraEnLocal;
    @FXML
    private Label montoDeCompra;
    @FXML
    private Label fechaDeCompra;
    @FXML
    private Label fechaDeRetiro;
    @FXML
    private JFXButton btnDescargarTicket;
    @FXML
    private Label lugarDeRetiro;
    @FXML
    private Label numeroDeTicket;
    private ArrayList<String> contenidoTicketPDF;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    //
    //METODOS PUBLICOS
    //
    
    public void cargarCompraEnLocal(int numeroDeLocal){
        String strAMostrar = "Compra en local n°" + numeroDeLocal;
        
        compraEnLocal.setText(strAMostrar);
    }
    
    public void cargarMontoDeCompra(double monto){
        String strAMostrar = "$" + monto;
        
        montoDeCompra.setText(strAMostrar);
    }
    
    public void cargarFechaDeCompra(LocalDateTime fecha){
        String strAMostrar = fecha.format(DateTimeFormatter.ISO_DATE);
        
        fechaDeCompra.setText(strAMostrar);
    }
    
    public void cargarFechaDeRetiro(LocalDate fecha){
        String strAMostrar = fecha.format(DateTimeFormatter.ISO_DATE);
        
        fechaDeRetiro.setText(strAMostrar);
    }
    
    public void cargarLugarDeRetiro(String calle){
        lugarDeRetiro.setText(calle);
    }
    
    public void cargarNumeroDeticket(int numero){
        String strAMostrar = numero + "";
        
        numeroDeTicket.setText(strAMostrar);
    }
    
    public void cargarTicketPDF(ArrayList<String> contenidoTicket){
        contenidoTicketPDF = contenidoTicket;
    }
    
    //
    //EVENTOS
    //
    
    @FXML
    private void clickBtnDescargarTicket(MouseEvent event) throws DocumentException {
        try{
            FileChooser fc = new FileChooser();
            
            fc.setInitialDirectory(new File("C:\\"));
            fc.getExtensionFilters().
                    add(new FileChooser.ExtensionFilter("Archivos PDF", "*.pdf"));
                    
            File archivoElegido = fc.showSaveDialog(null);
            
            if (archivoElegido != null) {
                FileOutputStream archivo = new FileOutputStream(archivoElegido.getPath()+ ".pdf");
                Document ticketPDF = new Document();
                
                PdfWriter.getInstance(ticketPDF, archivo);
                ticketPDF.open();
                
                for (int i = 0; i < contenidoTicketPDF.size(); i++) {
                    String strTmp = contenidoTicketPDF.get(i);
                            
                    if(strTmp.equals("")){
                        Paragraph nuevoParrafo = new Paragraph(Chunk.NEWLINE);
                        ticketPDF.add(nuevoParrafo);
                    }
                    else{
                        Paragraph nuevoParrafo = new Paragraph(strTmp);
                        ticketPDF.add(nuevoParrafo);
                    }
                }
                
                ticketPDF.close();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Error al crear el PDF");
        }
    }
    
}
