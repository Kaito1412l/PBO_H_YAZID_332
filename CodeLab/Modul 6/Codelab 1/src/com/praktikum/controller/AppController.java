package com.praktikum.controller;

import javafx.scene.paint.Color;
import com.praktikum.model.AppModel;
import com.praktikum.view.AppView;

public class AppController {
    private final AppModel model;
    private final AppView view;

    public AppController(AppModel model, AppView view) {
        this.model = model;
        this.view = view;
        setupActions();}

    private void setupActions() {
        view.actionButton.setOnAction(e -> {
            String buttonText = view.actionButton.getText();

            if (buttonText.contains("Main Lagi")) {
                model.generateNewNumber();
                view.text3.setText("");
                view.inputField.clear();
                view.text4.setText("Jumlah percobaan: 0");
                view.actionButton.setText("🎲 Coba Tebak!");
                view.actionButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");}
            else {
                String userInput = view.inputField.getText();
                try {int guess = Integer.parseInt(userInput);
                    model.incrementAttempt();
                    view.text4.setText("Jumlah percobaan: " + model.getAttemptCount());

                    int diff = Math.abs(guess - model.getTargetNumber());

                    if (guess == model.getTargetNumber()) {
                        view.text3.setText("✅ Tebakan benar!");
                        view.text3.setTextFill(Color.web("#4CAF50"));
                        view.actionButton.setText("🔄 Main Lagi");
                        view.actionButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 14px;");}
                    else if (guess < model.getTargetNumber()) {
                        if (diff <= 5) {
                            view.text3.setText("⚡ Kurang sedikit!");
                            view.text3.setTextFill(Color.web("#FF9800"));}
                        else {
                            view.text3.setText("🔺 Terlalu kecil");
                            view.text3.setTextFill(Color.web("#FF5722"));}}
                    else {
                        if (diff <= 5) {
                            view.text3.setText("⚡ Lebih sedikit!");
                            view.text3.setTextFill(Color.web("#FF9800"));}
                        else {
                            view.text3.setText("🔺 Terlalu besar");
                            view.text3.setTextFill(Color.web("#FF5722"));}}

                    view.inputField.clear();}
                catch (NumberFormatException ex) {
                    view.text3.setText("⚠ Masukkan angka yang valid!");
                    view.text3.setTextFill(Color.web("#FF0000"));}}
        });
    }
}
