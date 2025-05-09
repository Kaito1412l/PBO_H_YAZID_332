package com.praktikum.users;

import com.praktikum.actions.*;
import java.util.Scanner;

//Menyatakan sebagai SubClass dari com.praktikum.users.User
public class Admin extends User implements AdminActions {
    //Menyatakan variabel Final/CONST untuk Username dan Password
    private final String kuAdmin = "admin332";
    private final String kpAdmin = "password332";
    private Scanner inputAdmin = new Scanner(System.in);

    //Menyatakan Atribut dari superClass
    public Admin(String kUser, String kPass) {
        super(kUser, kPass);}

    //Override atau lanjutan dari Login di SuperClass
    @Override
    public void login() {
        System.out.printf("\nMemulai proses Login Admin\n");
        System.out.print("Masukkan Username: ");
        String aUser  = inputAdmin.nextLine();
        System.out.print("Masukkan Password: ");
        String aPass = inputAdmin.nextLine();

        //Melakukan proses pengecekan input com.praktikum.users.User dan Pass
        if (kuAdmin.equals(aUser ) && kpAdmin.equals(aPass))
        {displayInfo(kUser, kPass);
         displayAppMenu();}
        else
        {System.out.println("\nLogin Gagal! Username atau Password Salah.");}
    }

    //Override dari method displayInfo()
    @Override
    public void displayInfo(String nama, String nim) {
        System.out.printf("\nBerhasil Login Sebagai Admin\n");
        System.out.printf("Username: %s\n", nama);
        System.out.printf("Password: %s\n", nim);}

    @Override
    // Method untuk pilihan Menu
    public void displayMenu(){
        System.out.println("\n============ADMIN MENU============");
        System.out.println("1. Kelola Laporan Barang");
        System.out.println("2. Kelola Data Mahasiswa");
        System.out.println("0: LogOut");}

    @Override
    // Method untuk menampilkan Menu
    public void displayAppMenu (){
        // Menyatakan nilai loop awal
        boolean loop =  true;
        do {// Menampilkan pilihan menu
            displayMenu();

            // Meminta input pilihan Menu
            System.out.print("Masukkan pilihan: ");
            int pilihan = inputAdmin.nextInt();
            inputAdmin.nextLine();

            // Memproses input pilihan Menu
            switch (pilihan) {
                case 1:
                    manageItems();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    System.err.println("Pilihan Tidak Valid\n");
                    loop = false;
                    break;}}
        while (loop);
    }

    @Override
    public void manageUsers() {
        System.err.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<\n");}

    @Override
    public void manageItems() {
        System.err.println(">> Fitur Kelola Barang Belum Tersedia <<\n");}
}