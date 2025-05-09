package com.praktikum.users;

import com.praktikum.actions.*;
import java.util.Scanner;


//Menyatakan sebagai SubClass dari com.praktikum.users.User
public class Mahasiswa extends User implements MahasiswaActions {
    //Menyatakan variabel Final/CONST untuk Username dan Password
    private final String kuSiswa = "Nur Muhammad Yazid Salim";
    private final String kpSiswa = "202410370110332";
    private Scanner inputMahasiswa = new Scanner(System.in);

    //Menyatakan Atribut dari superClass
    public Mahasiswa(String kUser, String kPass) {
        super(kUser, kPass);}

    //Override atau lanjutan dari Login di SuperClass
    @Override
    public void login() {
        System.out.printf("\nMemulai proses Login Mahasiswa\n");
        System.out.print("Masukkan Nama: ");
        String mUser  = inputMahasiswa.nextLine();
        System.out.print("Masukkan NIM: ");
        String mPass = inputMahasiswa.nextLine();

        //Melakukan proses pengecekan input com.praktikum.users.User dan Pass
        if (this.kuSiswa.equals(mUser ) && this.kpSiswa.equals(mPass))
        {displayInfo(kUser, kPass);
         displayAppMenu();}
        else
        {System.out.println("\nLogin Gagal! Nama atau NIM Salah.");}
    }

    //Override dari method displayInfo()
    @Override
    public void displayInfo(String kUser, String kPass) {
        System.out.println("\nLogin Berhasil Sebagai Mahasiswa");
        System.out.printf("Nama: %s\n", kUser);
        System.out.printf("Nim: %s\n", kPass);
    }

    @Override
    public void displayMenu(){
        System.out.println("\n============ADMIN MENU============");
        System.out.println("1. Laporkan Barang Hilang");
        System.out.println("2. Lihat Daftar Laporan");
        System.out.println("0: LogOut");}

    @Override
    // Method untuk menampilkan Menu
    public void displayAppMenu() {
        // Menyatakan nilai loop awal
        boolean loop = true;
        do {// Menampilkan pilihan Menu
            displayMenu();

            // Meminta input pilihan Menu
            System.out.print("Masukkan pilihan: ");
            int pilihan = inputMahasiswa.nextInt();
            inputMahasiswa.nextLine();

            // Memproses input pilihan Menu
            switch (pilihan) {
                case 1:
                    reportItem();
                    break;
                case 2:
                    viewReportedItems();
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
    public void reportItem() {
        System.out.println("\n=======Laporan Barang Hilang=======");
        System.out.println("Masukkan nama barang: ");
        String namaBarang = inputMahasiswa.nextLine();

        System.out.println("Masukkan deskripsi barang: ");
        String deskripsiBarang = inputMahasiswa.nextLine();

        System.out.println("Lokasi terakhir ditemukan: ");
        String lokasiTerakhir = inputMahasiswa.nextLine();

        System.out.println("=====================================\n");
        System.out.println("Barang: " + namaBarang);
        System.out.println("Deskripsi Barang: " + deskripsiBarang);
        System.out.println("Lokasi terakhir: " + lokasiTerakhir);
        System.out.println("=====================================\n");}

    @Override
    public void viewReportedItems() {
        System.err.println(">> Fitur Lihat Laporan Belum Tersedia <<\n");}
}