package com.praktikum.gui;

import com.praktikum.model.Item;
import com.praktikum.main.LoginSystem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MahasiswaDashboard {
    private Stage stage;
    private ObservableList<Item> laporanList = FXCollections.observableArrayList();

    public MahasiswaDashboard(Stage stage) {
        this.stage = stage;
    }

    public void showDashboard() {
        Label welcomeLabel = new Label("Selamat datang");
        Label reportLabel = new Label("Laporkan Barang Hilang/Temuan");

        TextField namaField = new TextField();
        namaField.setPromptText("Nama Barang");

        TextField deskripsiField = new TextField();
        deskripsiField.setPromptText("Deskripsi");

        ComboBox<String> lokasiField = new ComboBox<>();
        lokasiField.getItems().addAll("Lab AB", "Lab CD", "Lab EF");
        lokasiField.setValue("Lab AB");

        Button laporkanButton = new Button("Laporkan");

        TableView<Item> laporanTable = new TableView<>();
        laporanTable.setItems(laporanList);

        TableColumn<Item, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        namaCol.setPrefWidth(150);

        TableColumn<Item, String> deskripsiCol = new TableColumn<>("Deskripsi");
        deskripsiCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        deskripsiCol.setPrefWidth(150);

        TableColumn<Item, String> lokasiCol = new TableColumn<>("Lokasi");
        lokasiCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        lokasiCol.setPrefWidth(150);

        laporanTable.getColumns().addAll(namaCol, deskripsiCol, lokasiCol);

        laporkanButton.setOnAction(e -> {
            String nama = namaField.getText();
            String deskripsi = deskripsiField.getText();
            String lokasi = lokasiField.getValue();

            if (!nama.isEmpty() && !deskripsi.isEmpty() && !lokasi.isEmpty()) {
                Item item = new Item(nama, deskripsi, lokasi, "Dilaporkan");
                laporanList.add(item);
                LoginSystem.reportedItem.add(item);

                namaField.clear();
                deskripsiField.clear();
            }
        });

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> new LoginPane(stage).showLoginScreen());

        HBox inputBox = new HBox(10, namaField, deskripsiField, lokasiField, laporkanButton);
        inputBox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10, welcomeLabel, reportLabel, inputBox, new Label("Daftar Laporan Anda"), laporanTable, logoutButton);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.TOP_LEFT);

        Scene scene = new Scene(layout, 700, 400);
        stage.setScene(scene);
    }
}
