/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class Register {


    private User newUser;
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
            @Override
            public void handle(ActionEvent t) {
                if(passField.getText().equals(pass2Field.getText())){
                dialog.close();
                }else{
                    System.out.println("Passwords not the same");
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
        if(passField.getText().equals(pass2Field.getText())){
        newUser = new User(usernameField.getText(), passField.getText(), userField.getText(), surnameField.getText(), ssnField.getText(), emailField.getText());
        }
    }

    public User getUser() {
        return newUser;
    }


}
