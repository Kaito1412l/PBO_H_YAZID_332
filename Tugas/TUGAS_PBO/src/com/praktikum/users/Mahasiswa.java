package com.praktikum.users;

import com.praktikum.actions.*;
import com.praktikum.model.Item;
import com.praktikum.main.LoginSystem;

import java.util.InputMismatchException;
import java.util.Iterator;
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
        if (this.kuSiswa.equals(mUser ) && this.kpSiswa.equals(mPass))
        {displayInfo(kUser, kPass);
            displayAppMenu();}
        else
        {System.out.println("\nLogin Gagal! Nama atau NIM Salah.");}}

    //Override dari method displayInfo()
    @Override
    public void displayInfo(String kUser, String kPass) {
        System.out.println("\nLogin Berhasil Sebagai Mahasiswa");
        System.out.printf("Nama: %s\n", kUser);
        System.out.printf("Nim: %s\n", kPass);}

    // Method untuk menampilkan Menu
    @Override
    public void displayAppMenu() {
        boolean loop = true;
        int pilihan;
        do {displayMenuApp();
            try {System.out.print("Masukkan pilihan: ");
                 pilihan = inputMahasiswa.nextInt();
                 inputMahasiswa.nextLine();}
            catch (InputMismatchException e){
                 System.out.println("ERROR: Masukkan hanya angka!!");
                 inputMahasiswa.nextLine();
                 continue;}
                switch (pilihan) {
                    case 1:
                        reportItem();
                        break;
                    case 2:
                        reportItem();
                        break;
                    case 0:
                        loop = false;
                        LoginSystem.main(null);
                        break;
                    default:
                        System.err.println("Pilihan Tidak Valid\n");
                        loop = false;
                        break;}}
        while (loop);}

    @Override
    public void displayMenuApp(){
        System.out.println("\n============ADMIN MENU============");
        System.out.println("1. Laporkan Barang Hilang");
        System.out.println("2. Lihat Daftar Laporan");
        System.out.println("0: LogOut");}

    @Override
    public void viewReportedItems() {
        Iterator<Item> it_item = LoginSystem.reportedItem.iterator();
        int index = 1;
        boolean adaYangDilapor = true;
        while (it_item.hasNext()) {
            Item barang = it_item.next();
            if (barang.getStatus().equals("Reported"))
            {if (adaYangDilapor)
            {System.out.printf("%-5s %-25s %-40s %-30s\n", "NO", "NAMA", "DESKRIPSI", "LOKASI");
                adaYangDilapor = false;}
                System.out.printf("%-5d %-25s %-40s %-30s\n", index++, barang.getItemName(),
                        barang.getDescription(), barang.getLocation());}}
        if (adaYangDilapor)
        {System.out.println("Tidak ada barang berstatus 'Reported'...");}}

    @Override
    public void reportItem() {
        System.out.println("\n=======Laporan Barang Hilang=======");
        System.out.printf("Masukkan nama barang: ");
        String namaBarang = inputMahasiswa.nextLine();
        System.out.printf("Masukkan deskripsi barang: ");
        String deskripsiBarang = inputMahasiswa.nextLine();
        System.out.printf("Lokasi terakhir ditemukan: ");
        String lokasiTerakhir = inputMahasiswa.nextLine();
        LoginSystem.reportedItem.add(new Item(namaBarang,deskripsiBarang, lokasiTerakhir));
        System.out.println("=====================================\n");
        System.out.println("Barang: " + namaBarang);
        System.out.println("Deskripsi Barang: " + deskripsiBarang);
        System.out.println("Lokasi terakhir: " + lokasiTerakhir);
        System.out.println("=====================================\n");}
}