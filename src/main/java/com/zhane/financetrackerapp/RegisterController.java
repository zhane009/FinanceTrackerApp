package com.zhane.financetrackerapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Optional;

public class RegisterController {
    @FXML
    public Button registerBtn;
    @FXML
    public Button backLoginBtn;
    @FXML
    public TextField userTextField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public PasswordField rePasswordField;

    private void dialogue(String headerMsg, String contentMsg) {
        Stage secondaryStage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, 300, 300, Color.DARKGRAY);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(headerMsg);
        alert.setContentText(contentMsg);
        Optional<ButtonType> result = alert.showAndWait();
    }

    @FXML
    public void registerBtnHandler(ActionEvent actionEvent) {
        Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) registerBtn.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader();
            UserRepository myObj = new UserRepository();
            if (passwordField.getText().equals(rePasswordField.getText())
                    && (!userTextField.getText().isEmpty()
                    && !passwordField.getText().isEmpty()) ) {
                myObj.addDataToDB(userTextField.getText(), passwordField.getText());
                dialogue("Adding information to the database", "Successful!");
                String[] credentials = {userTextField.getText(), passwordField.getText()};
                loader.setLocation(getClass().getResource("secondary.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root, 640, 480);
                secondaryStage.setScene(scene);
//                SecondaryController controller = loader.getController();
//                secondaryStage.setTitle("Show all records");
//                controller.initialise(credentials);
//                String msg = "some data sent from Register Controller";
//                secondaryStage.setUserData(msg);
            } else {
                dialogue("Failed", "The Fields cannot be empty and the Passwords must match!");
                loader.setLocation(getClass().getResource("register.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root, 640, 480);
                secondaryStage.setScene(scene);
                secondaryStage.setTitle("Register a new User");
            }
            secondaryStage.show();
            primaryStage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void backLoginBtnHandler() {
        Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) registerBtn.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("primary-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Welcome!");
            secondaryStage.show();
            primaryStage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
