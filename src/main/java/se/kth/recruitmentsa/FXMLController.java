package se.kth.recruitmentsa;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rest.RestCommunication;

public class FXMLController implements Initializable {
    
    @FXML
    private Label logged;
    @FXML
    private Button loginBtn;
    @FXML
    private Button registerBtn;
    @FXML
    private TextField userBox;
    @FXML
    private TextField passBox;
    
    
    @FXML
    private void loginHandler(ActionEvent event) {
        String s = RestCommunication.login(userBox.getText(), passBox.getText());
        System.out.println("You clicked me!");
        logged.setText("Hello World!");
    }
    @FXML
    private void registerHandler(ActionEvent event) {
        System.out.println("You clicked me!");
        logged.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
