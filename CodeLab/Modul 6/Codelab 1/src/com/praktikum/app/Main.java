package com.praktikum.app;

import com.praktikum.controller.AppController;
import javafx.application.Application;
import javafx.stage.Stage;
import com.praktikum.model.*;
import com.praktikum.view.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        AppModel model = new AppModel();
        AppView view = new AppView();
        new AppController(model, view);

        primaryStage.setTitle("Tebak Angka App");
        primaryStage.setScene(view.createScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
