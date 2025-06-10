package com.praktikum.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        new LoginPane(primaryStage).showLoginScreen();
    }

    public static void main(String[] args) {launch(args);}
}
