/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author novhm
 */
public class HomeController implements Initializable {

    @FXML
    private VBox pnl_scroll;
    @FXML
    private JFXButton btnTodosLosArticulos;
    @FXML
    private JFXButton btnMisCompras;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refreshItem();
    }

    //Item
    private void refreshItem() {
        pnl_scroll.getChildren().clear();

        Node[] nodes = new Node[15];

        for (int i = 0; i < 15; i++) {
            try {
                nodes[i] = (Node) FXMLLoader.load(getClass().getResource("Item.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);
                
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    //ItemTicket
    private void refreshItemTicket() {
        pnl_scroll.getChildren().clear();

        Node[] nodes = new Node[4];

        for (int i = 0; i < 4; i++) {
            try {
                nodes[i] = (Node) FXMLLoader.load(getClass().getResource("ItemTicket.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    private void clickBtnTodosLosArticulos(MouseEvent event) {
        refreshItem();
    }

    @FXML
    private void clickBtnMisCompras(MouseEvent event) {
        refreshItemTicket();
    }
    

}
