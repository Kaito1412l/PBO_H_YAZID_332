package com.praktikum.main;

import com.praktikum.users.*;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        //Inisialisasi untuk memanggil loginSystem
        LoginSystem program = new LoginSystem();
        program.runProgram();
    }

    public void runProgram() {
        // Memanggil Class com.praktikum.users.Admin dan com.praktikum.users.Mahasiswa
        User admin = new Admin("Admin", "NIMAdmin");
        User mahasiswa = new Mahasiswa("Nur Muhammad Yazid Salim", "202410370110332");
        //Memanggil Scanner
        Scanner scan = new Scanner(System.in);

        //Menampilkan tmpilan awal atau pilihan program Login
        displayPilihan();

        //Meminta Input pilihan Login
        System.out.print("Masukkan Pilihan: ");
        int pilihan = scan.nextInt();
        scan.nextLine();

        //Memproses Input pilihan
        switch (pilihan) {
            case 1 -> admin.login();
            case 2 -> mahasiswa.login();
            default -> System.out.println("\nPilihan tidak valid");}

        //Memulangkan Scanner
        scan.close();
    }

    //Method untuk pilihan Login
    void displayPilihan() {
        System.out.println("\n==========Program Dimulai==========");
        System.out.println("Pilihan Login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");}
}