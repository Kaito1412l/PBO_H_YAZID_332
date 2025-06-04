package com.praktikum.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AppView {
    public Label text1 = new Label("🎯 Tebak Angka 1–100");
    public Label text2 = new Label("Masukkan tebakanmu!");
    public Label text3 = new Label();
    public TextField inputField = new TextField();
    public Button actionButton = new Button("🎲 Coba Tebak!");
    public Label text4 = new Label("Jumlah percobaan: 0");
    public VBox layout;

    public AppView() {
        text1.setFont(Font.font("Arial", 24));
        text1.setTextFill(Color.web("#1A237E"));

        text2.setFont(Font.font("Arial", 16));
        text2.setTextFill(Color.web("#4A4A4A"));

        text3.setFont(Font.font("Arial", 14));

        inputField.setPromptText("Masukkan angka di sini");
        inputField.setPrefWidth(200);
        inputField.setStyle("-fx-font-size: 14px;");

        actionButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");

        text4.setFont(Font.font("Arial", 12));
        text4.setTextFill(Color.web("#333333"));

        HBox inputBox = new HBox(10, inputField, actionButton);
        inputBox.setAlignment(Pos.CENTER);

        layout = new VBox(15, text1, text2, text3, inputBox, text4);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));
        layout.setStyle("-fx-background-color: #E3F2FD;");}

    public Scene createScene() {
        return new Scene(layout, 450, 320);}
}
