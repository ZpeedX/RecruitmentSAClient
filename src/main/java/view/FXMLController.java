package view;

import java.io.StringReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;
import model.Register;
import model.User;
import rest.RestCommunication;

/**
 * Controller handles all inputs from the user and calls functions needed
 *
 * @author Emil
 */
public class FXMLController implements Initializable {

    @FXML
    private Label logged;
    @FXML
    private Button loginBtn;
    @FXML
    private Button logoutBtn;
    @FXML
    private Button registerBtn;
    @FXML
    private TextField userBox;
    @FXML
    private TextField passBox;
    @FXML
    private Text userText;
    @FXML
    private Text passText;
    @FXML
    private GridPane gridPane;

    @FXML
    private void loginHandler(ActionEvent event) {
        Response response = RestCommunication.login(userBox.getText(), passBox.getText());
        JsonObject json = extractJsonObjFromResponse(response);
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            logged.setVisible(true);
            logged.setText("Welcome " + userBox.getText() + " Token: " + json.getString("token"));
            hideFields();
        } else {
            logged.setVisible(true);
            logged.setText("Invalid user credentials, please try again");
        }
    }

    private void hideFields() {
        logoutBtn.setVisible(true);
        loginBtn.setVisible(false);
        userBox.setVisible(false);
        passBox.setVisible(false);
        userText.setVisible(false);
        passText.setVisible(false);
        registerBtn.setVisible(false);
    }

    private void showFields() {
        logoutBtn.setVisible(false);
        loginBtn.setVisible(true);
        userBox.setVisible(true);
        passBox.setVisible(true);
        userText.setVisible(true);
        passText.setVisible(true);
        registerBtn.setVisible(true);
    }

    @FXML
    private void registerHandler(ActionEvent event) {
        Register reg = new Register(
                gridPane.getScene().getWindow()
        );
        User newUser = reg.getUser();
        if (reg.getFilled().equals("done")) {
            Response response = RestCommunication.register(newUser);
            JsonObject json = extractJsonObjFromResponse(response);
            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                logged.setVisible(true);
                logged.setText("Welcome " + newUser.getUsername() + " Token: " + json.getString("token"));
                hideFields();
            } else {
                unsuccessfulRegister(json);
            }
        }

    }
    private void unsuccessfulRegister(JsonObject json) {
        int errorCode = json.getInt("error", 0);

        switch (errorCode) {
            case 1:
                logged.setText("Username already taken, please try again");
                break;
            case 2:
                logged.setText("Social security number already registered");
                break;
            default:
                break;
        }
        logged.setVisible(true);
    }

    @FXML
    private void logoutHandler(ActionEvent event) {
        showFields();
        logged.setVisible(false);
    }

    /**
     * Sets the logout button and label to invisible at launch
     *
     * @param url unused
     * @param rb unused
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        logoutBtn.setVisible(false);
        logged.setVisible(false);
    }

    /**
     * Creates JsonObject from Response
     *
     * @param res Response from server
     * @return JsonObject with data from server
     */
    public JsonObject extractJsonObjFromResponse(Response res) {
        String s = res.readEntity(String.class);
        return Json.createReader(new StringReader(s)).readObject();

    }
}
