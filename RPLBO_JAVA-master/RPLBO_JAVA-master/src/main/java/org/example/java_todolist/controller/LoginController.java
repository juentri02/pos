package org.example.java_todolist.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.java_todolist.database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @FXML
    public void handleRegisterRedirect(ActionEvent event) {
        try {
            // Muat file FXML Register
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/java_todolist/register.fxml"));
            AnchorPane registerPane = loader.load();

            // Buat scene baru dengan Register.fxml
            Scene registerScene = new Scene(registerPane);

            // Mendapatkan Stage dari event yang diteruskan
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(registerScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("admin") && password.equals("admin")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/java_todolist/home.fxml"));
                AnchorPane homePane = loader.load();

                // Kirim username ke HomeController
                HomeController controller = loader.getController();
                controller.setCurrentUsername(username);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(homePane);
                stage.setScene(scene);
                stage.show();

                System.out.println("Login berhasil sebagai admin.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Username atau password salah!");
        }
    }}

