package com.zhane.financetrackerapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.zhane.financetrackerapp.RegisterController.dialogue;

public class PrimaryController {
    @FXML
    public Button primaryButton;

    @FXML
    private Button registerBtn;

    @FXML
    private TextField userTextField;

    @FXML
    private PasswordField passwordField;

    public void switchToSecondary() {
        Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) primaryButton.getScene().getWindow();
        try {
            UserRepository myObj = new UserRepository();
            if(myObj.validateUser(userTextField.getText(), passwordField.getText())){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("home-view.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root, 640, 480);
                secondaryStage.setScene(scene);
//                SecondaryController controller = loader.getController();
//                controller.initialise(credentials);
                secondaryStage.setTitle("Show Files");
//                secondaryStage.setUserData();
                secondaryStage.show();
                primaryStage.close();

            }
            else{
                dialogue("Invalid User Name / Password","Please try again!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void registerBtnHandler() {
        Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) registerBtn.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("register.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Register a new User");
            secondaryStage.show();
            primaryStage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}