package com.praktikum.gui;

import com.praktikum.model.*;
import com.praktikum.main.LoginSystem;
import com.praktikum.users.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AdminDashboard {
    private Stage stage;
    private ObservableList<Item> itemList = FXCollections.observableArrayList(LoginSystem.reportedItem);
    private ObservableList<Mahasiswa> mahasiswaList = FXCollections.observableArrayList();

    public AdminDashboard(Stage stage) {
        this.stage = stage;

        for (User u : LoginSystem.userList) {
            if (u instanceof Mahasiswa) {
                mahasiswaList.add((Mahasiswa) u);
            }
        }
    }

    public void showDashboard() {
        Label welcome = new Label("Halo, Administrator admin");

        // ============== TABEL ITEM ==============
        TableView<Item> itemTable = new TableView<>(itemList);

        TableColumn<Item, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));

        TableColumn<Item, String> lokasiCol = new TableColumn<>("Lokasi");
        lokasiCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<Item, String> deskripsiCol = new TableColumn<>("Deskripsi");
        deskripsiCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Item, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        itemTable.getColumns().addAll(namaCol, deskripsiCol, lokasiCol, statusCol);
        itemTable.setPrefWidth(350);
        itemTable.setPrefHeight(200);

        Button markClaimedBtn = new Button("Tandai Claimed");
        markClaimedBtn.setOnAction(e -> {
            Item selected = itemTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                selected.setStatus("Claimed");
                itemTable.refresh();
            }
        });

        VBox leftPane = new VBox(10,
                new Label("Laporan Barang"),
                itemTable,
                markClaimedBtn
        );

        // ============== TABEL MAHASISWA ==============
        TableView<Mahasiswa> mahasiswaTable = new TableView<>(mahasiswaList);

        TableColumn<Mahasiswa, String> namaMhsCol = new TableColumn<>("Nama");
        namaMhsCol.setCellValueFactory(new PropertyValueFactory<>("nama"));

        TableColumn<Mahasiswa, String> nimCol = new TableColumn<>("NIM");
        nimCol.setCellValueFactory(new PropertyValueFactory<>("nim"));

        mahasiswaTable.getColumns().addAll(namaMhsCol, nimCol);
        mahasiswaTable.setPrefWidth(300);
        mahasiswaTable.setPrefHeight(200);

        TextField namaInput = new TextField();
        namaInput.setPromptText("Nama Mahasiswa");

        TextField nimInput = new TextField();
        nimInput.setPromptText("NIM");

        Button tambahBtn = new Button("Add");
        tambahBtn.setOnAction(e -> {
            DataStore.userList.add(new Mahasiswa(namaInput.getText(), nimInput.getText()));
            mahasiswaTable.setItems(FXCollections.observableArrayList(
                    DataStore.userList.stream().filter(u -> u instanceof Mahasiswa).map(u -> (Mahasiswa) u).toList()
            ));
            namaInput.clear(); nimInput.clear();
        });

        Button hapusBtn = new Button("Delete");
        hapusBtn.setOnAction(e -> {
            Mahasiswa selected = mahasiswaTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                mahasiswaList.remove(selected);
                LoginSystem.userList.remove(selected);
            }
        });

        HBox formBox = new HBox(10, namaInput, nimInput, tambahBtn, hapusBtn);

        VBox rightPane = new VBox(10,
                new Label("Data Mahasiswa"),
                mahasiswaTable,
                formBox
        );

        HBox mainLayout = new HBox(20, leftPane, rightPane);
        mainLayout.setPadding(new Insets(15));

        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> new LoginPane(stage).showLoginScreen());

        VBox root = new VBox(10, welcome, mainLayout, logoutBtn);
        root.setPadding(new Insets(15));

        Scene scene = new Scene(root, 800, 450);
        stage.setScene(scene);
    }
}
