import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    private int targetNumber;
    private int attemptCount;
    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tebak Angka Advance");

        Label titleLabel = new Label("🎯 Tebak Angka 1–100");
        titleLabel.setFont(Font.font("Arial", 24));
        titleLabel.setTextFill(Color.web("#1A237E"));

        Label instructionLabel = new Label("Masukkan tebakanmu!");
        instructionLabel.setFont(Font.font("Arial", 16));
        instructionLabel.setTextFill(Color.web("#4A4A4A"));

        Label feedbackLabel = new Label();
        feedbackLabel.setFont(Font.font("Arial", 14));

        TextField inputField = new TextField();
        inputField.setPromptText("Masukkan angka di sini");
        inputField.setPrefWidth(200);
        inputField.setStyle("-fx-font-size: 14px;");

        Button actionButton = new Button("🎲 Coba Tebak!");
        actionButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 18px;");

        Label attemptLabel = new Label("Jumlah percobaan: 0");
        attemptLabel.setFont(Font.font("Arial", 12));
        attemptLabel.setTextFill(Color.web("#333333"));

        HBox inputBox = new HBox(10, inputField, actionButton);
        inputBox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(15, titleLabel, instructionLabel, feedbackLabel, inputBox, attemptLabel);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));
        layout.setStyle("-fx-background-color: #E3F2FD;");

        generateNewNumber();

        actionButton.setOnAction(e -> {
            String buttonText = actionButton.getText();
            if (buttonText.contains("Main Lagi")) {
                generateNewNumber();
                feedbackLabel.setText("");
                inputField.clear();
                attemptCount = 0;
                attemptLabel.setText("Jumlah percobaan: " + attemptCount);
                actionButton.setText("🎲 Coba Tebak!");
                actionButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");
            } else {
                String userInput = inputField.getText();
                try {
                    int guess = Integer.parseInt(userInput);
                    attemptCount++;
                    attemptLabel.setText("Jumlah percobaan: " + attemptCount);

                    int diff = Math.abs(guess - targetNumber);

                    if (guess == targetNumber) {
                        feedbackLabel.setText("✅ Tebakan benar!");
                        feedbackLabel.setTextFill(Color.web("#4CAF50"));
                        actionButton.setText("🔄 Main Lagi");
                        actionButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 14px;");
                    } else if (guess < targetNumber) {
                        if (diff <= 5) {
                            feedbackLabel.setText("⚡ Kurang sedikit!");
                            feedbackLabel.setTextFill(Color.web("#FF9800"));
                        } else {
                            feedbackLabel.setText("🔺 Terlalu kecil");
                            feedbackLabel.setTextFill(Color.web("#FF5722"));
                        }
                    } else {
                        if (diff <= 5) {
                            feedbackLabel.setText("⚡ Lebih sedikit!");
                            feedbackLabel.setTextFill(Color.web("#FF9800"));
                        } else {
                            feedbackLabel.setText("🔺 Terlalu besar");
                            feedbackLabel.setTextFill(Color.web("#FF5722"));
                        }
                    }
                    inputField.clear();
                } catch (NumberFormatException ex) {
                    feedbackLabel.setText("⚠ Masukkan angka yang valid!");
                    feedbackLabel.setTextFill(Color.web("#FF0000"));
                }
            }
        });

        Scene scene = new Scene(layout, 450, 320);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void generateNewNumber() {
        targetNumber = random.nextInt(100) + 1;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
