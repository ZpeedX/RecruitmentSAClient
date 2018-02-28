package se.kth.recruitmentsa;

import java.io.StringReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;
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
        Response response = RestCommunication.login(userBox.getText(), passBox.getText());
        JsonObject json = extractJsonObjFromResponse(response);
        System.out.println(json.getString("token"));
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
    
    public JsonObject extractJsonObjFromResponse(Response res){
        String s = res.readEntity(String.class);
        return Json.createReader(new StringReader(s)).readObject();
 
    }
}
