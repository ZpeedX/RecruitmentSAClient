/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 * Class containing a register field where the user can enter credentials and
 * submit.
 *
 * @author Emil
 */
public class Register {

    private User newUser;
    private String filled = "";

    /**
     * Takes the Window to know where to place the register pop-up and then
     * creates the window will all required fields.
     *
     * @param owner
     */
    public Register(Window owner) {
        final Stage dialog = new Stage();

        dialog.setTitle("Enter Information: ");
        dialog.initOwner(owner);
        dialog.initStyle(StageStyle.UTILITY);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.setX(owner.getX() + owner.getWidth());
        dialog.setY(owner.getY());

        final TextField usernameField = new TextField();
        final PasswordField passField = new PasswordField();
        final PasswordField pass2Field = new PasswordField();
        final TextField userField = new TextField();
        final TextField surnameField = new TextField();
        final TextField ssnField = new TextField();
        final TextField emailField = new TextField();
        final Button submitButton = new Button("Submit");
        final Label usernameL = new Label("Username:");
        final Label passwordL = new Label("Password");
        final Label password2L = new Label("Password Again");
        final Label userL = new Label("First name");
        final Label surnameL = new Label("Surname");
        final Label ssnL = new Label("Social security number");
        final Label emailL = new Label("Email");
        submitButton.setDefaultButton(true);
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            /**
             * The button has a function that closes the window if no field is
             * empty and passwords match empty and the passwords match. And sets a  new User and the confirms everything is filled.
             *
             * @param t ActionEvent
             */
            @Override
            public void handle(ActionEvent t) {
                if (userField.getText().isEmpty() || passField.getText().isEmpty() || pass2Field.getText().isEmpty() || usernameField.getText().isEmpty() || surnameField.getText().isEmpty() || emailField.getText().isEmpty() || ssnField.getText().isEmpty()) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Missing credentials warning:");
                    alert.setContentText("Please fill in all the forms!");
                    alert.showAndWait();
                } else {
                    if (passField.getText().equals(pass2Field.getText())) {
                        newUser = new User(usernameField.getText(), passField.getText(), userField.getText(), surnameField.getText(), ssnField.getText(), emailField.getText());
                        filled = "done";
                        dialog.close();
                    } else {
                        passField.setText("");
                        pass2Field.setText("");
                        pass2Field.setPromptText("Paswords do not match");
                        passField.setPromptText("Paswords do not match");
                    }
                }

            }
        });
        usernameField.setMinHeight(TextField.USE_PREF_SIZE);
        usernameField.setPromptText("Username");

        passField.setMinHeight(TextField.USE_PREF_SIZE);
        passField.setPromptText("Password");

        pass2Field.setMinHeight(TextField.USE_PREF_SIZE);
        pass2Field.setPromptText("Password");

        userField.setMinHeight(TextField.USE_PREF_SIZE);
        userField.setPromptText("First name");

        surnameField.setMinHeight(TextField.USE_PREF_SIZE);
        surnameField.setPromptText("Surname");

        ssnField.setMinHeight(TextField.USE_PREF_SIZE);
        ssnField.setPromptText("Social security number");

        emailField.setMinHeight(TextField.USE_PREF_SIZE);
        emailField.setPromptText("Email");

        final VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER_RIGHT);
        layout.setStyle("-fx-background-color: azure; -fx-padding: 10;");
        layout.getChildren().setAll(
                usernameL,
                usernameField,
                passwordL,
                passField,
                password2L,
                pass2Field,
                userL,
                userField,
                surnameL,
                surnameField,
                ssnL,
                ssnField,
                emailL,
                emailField,
                submitButton
        );

        dialog.setScene(new Scene(layout));
        dialog.showAndWait();
    }

    /**
     * Returns the user created from the entered credentials.
     *
     * @return user from entered credentials
     */
    public User getUser() {
        return newUser;
    }

    /**
     * Returns a string confirming the user has been registered.
     *
     * @return string confirming registration
     */
    public String getFilled() {
        return filled;
    }

}
