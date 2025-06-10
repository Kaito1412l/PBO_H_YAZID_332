package com.praktikum.gui;

import com.praktikum.main.LoginSystem;
import com.praktikum.users.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginPane {
    private Stage stage;

    public LoginPane(Stage stage) {
        this.stage = stage;
    }

    public void showLoginScreen() {
        Label titleLabel = new Label("Login System Lost & Found");
        titleLabel.setFont(Font.font("Times New Roman", 24));
        titleLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #2C3E50;");

        Label loginLabel = new Label("Login Sistem Lost & Found");
        loginLabel.setFont(Font.font("Calibri", 16));
        loginLabel.setStyle("-fx-text-fill: #34495E;");

        ComboBox<String> userType = new ComboBox<>();
        userType.getItems().addAll("Admin", "Mahasiswa");
        userType.setValue("Mahasiswa");
        userType.setPrefWidth(250);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Masukkan Nama/NIM");
        usernameField.setMaxWidth(250);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Masukkan Password");
        passwordField.setMaxWidth(250);

        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(150);
        loginButton.setStyle("-fx-background-color: #2980B9; -fx-text-fill: white; -fx-font-weight: bold;");

        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        Button click = new Button("Click");
        click.setPrefWidth(150);
        click.setStyle("-fx-background-color: blue; -fx-text-fill: black; -fx-font-weight: bold;");

        click.setOnAction(e ->{
            System.out.println("Nur Muhammad Yazid Salim");
            errorLabel.setText("Nur Muhammad Yazid Salim");
            errorLabel.setFont(Font.font("Times New Roman", 20));
            errorLabel.setStyle("-fx-text-fill: blue");});

        loginButton.setOnAction(e -> {
            String role = userType.getValue();
            String username = usernameField.getText();
            String password = passwordField.getText();

            User user = LoginSystem.loginUser(role, username, password);

            if (user != null) {
                if (user instanceof Admin) {
                    new AdminDashboard(stage).showDashboard();
                } else {
                    new MahasiswaDashboard(stage).showDashboard();
                }
            } else {
                errorLabel.setText("Login gagal, periksa kredensial.");
            }
        });

        VBox layout = new VBox(12, titleLabel, loginLabel, userType, usernameField, passwordField, loginButton, click, errorLabel);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));
        layout.setStyle("-fx-background-color: #ECF0F1; -fx-border-radius: 10; -fx-background-radius: 10;");

        Scene scene = new Scene(layout, 400, 350);
        stage.setScene(scene);
        stage.setTitle("Login Lost & Found");
        stage.show();
    }
}
