package com.praktikum.users;

import com.praktikum.actions.*;
import com.praktikum.model.Item;
import com.praktikum.main.LoginSystem;

import java.util.InputMismatchException;
import java.util.Iterator;
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
        System.out.println("\nMemulai proses Login Admin");
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
    public void displayMenuApp(){
        System.out.println("\n============ADMIN MENU============");
        System.out.println("1. Kelola Laporan Barang");
        System.out.println("2. Kelola Data Mahasiswa");
        System.out.println("0: LogOut");}

    @Override
    // Method untuk menampilkan Menu
    public void displayAppMenu (){
        // Menyatakan nilai loop awal
        boolean loop =  true;
        int pilihan;
        do {// Menampilkan pilihan menu
            displayMenuApp();

            try {// Meminta input pilihan Menu
                System.out.print("Masukkan pilihan: ");
                pilihan = inputAdmin.nextInt();
                inputAdmin.nextLine();}
            catch (InputMismatchException e){
                System.out.println("ERROR: Masukkan hanya angka!!");
                inputAdmin.nextLine();
                continue;}

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

    public void displayMenuManageUser () {
        System.out.println("\n===== KELOLA MAHASISWA =====");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Hapus Mahasiswa");
        System.out.println("3. Kembali");}

    public void tambahMahasiswa(){
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = inputAdmin.nextLine();

        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = inputAdmin.nextLine();

        LoginSystem.userList.add(new Mahasiswa(nama, nim));
        System.out.println("Mahasiswa berhasil ditambahkan!");}

    public void hapurMahasiswa(){
        Iterator<User>userIterator = LoginSystem.userList.iterator();
        System.out.print("Masukkan NIM Mahasiswa yang ingin dihapus: ");
        String targetNim = inputAdmin.nextLine();
        boolean ditemukan = false;

        while (userIterator.hasNext()) {
            User user = userIterator.next();
            if (user instanceof Mahasiswa && user.getNim().equals(targetNim)) {
                userIterator.remove();
                ditemukan = true;
                System.out.println("Mahasiswa dengan NIM " + targetNim + " berhasil dihapus.");
                break;}}

        if (!ditemukan)
        {System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");}}

    @Override
    public void manageUsers() {
        boolean loop = true;

        while (loop) {
            displayMenuManageUser();

            try {System.out.print("Masukkan pilihan: ");
                 int pilihan = inputAdmin.nextInt();
                 inputAdmin.nextLine();

                 switch (pilihan) {
                    case 1:
                        tambahMahasiswa();
                        break;
                    case 2:
                        hapurMahasiswa();
                        break;
                    case 3:
                        loop = false;
                        break;

                    default:
                        System.out.println("Pilihan tidak valid.");}}
            catch (InputMismatchException e) {
                System.out.println("ERROR: Input harus berupa angka!");
                inputAdmin.nextLine();}}
    }

    @Override
    public void manageItems() {
        boolean loop = true;
        int pilihan;
        while (loop) {
            try {System.out.println("\n1. Lihat Semua Laporan\n2. Tandai Barang Yang Diambil\n3. Kembali");
                 System.out.print("Masukkan pilihan: ");
                 pilihan = inputAdmin.nextInt();}
            catch (InputMismatchException e) {
                 System.out.println("ERROR: Hanya Masukkan Angka!!");
                 inputAdmin.nextLine();
                 continue;}

            switch (pilihan) {
                case 1:
                    Iterator<Item> it_item = LoginSystem.reportedItem.iterator();

                    if (it_item.hasNext()) {
                        int index = 1;
                        System.out.printf("%-5s %-25s %-40s %-30s %-30s\n", "NO", "NAMA", "DESKRIPSI", "LOKASI",
                                "STATUS");
                        while (it_item.hasNext()) {
                            Item barang = it_item.next();
                            System.out.printf("%-5d %-25s %-40s %-30s %-30s\n", index++, barang.getItemName(),
                                    barang.getDescription(), barang.getLocation(), barang.getStatus());}}
                    else {System.out.println("Tidak ada barang...");}
                    break;
                case 2:
                    int index = 0;
                    boolean adaReported = false;

                    Iterator<Item> iterator = LoginSystem.reportedItem.iterator();
                    System.out.printf("%-5s %-25s %-40s %-30s %-30s\n", "NO", "NAMA", "DESKRIPSI", "LOKASI", "STATUS");
                    while (iterator.hasNext()) {
                        Item barang = LoginSystem.reportedItem.get(index);
                        if ("Reported".equalsIgnoreCase(barang.getStatus()))
                           {System.out.printf("%-5d %-25s %-40s %-30s %-30s\n", index++, barang.getItemName(), barang.getDescription(), barang.getLocation(), barang.getStatus());
                            adaReported = true;}
                        index++;
                        iterator.next();}

                    if (!adaReported) {
                        System.out.println("Tidak ada barang yang masih berstatus 'Reported'.");
                        break;}

                    try {System.out.print("Masukkan nomor indeks barang yang ingin ditandai: ");
                         int inputIndex = inputAdmin.nextInt();
                         inputAdmin.nextLine();

                         Item barangDipilih = LoginSystem.reportedItem.get(inputIndex);

                         if ("Claimed".equalsIgnoreCase(barangDipilih.getStatus()))
                            {System.out.println("Barang sudah ditandai sebagai 'Claimed'.");}
                         else
                            {barangDipilih.setStatus("Claimed");
                             System.out.println("Barang berhasil ditandai sebagai 'Claimed'!");}}
                    catch (InputMismatchException e)
                        {System.out.println("ERROR: Input harus berupa angka!");
                         inputAdmin.nextLine();}
                    catch (IndexOutOfBoundsException e)
                        {System.out.println("ERROR: Indeks tidak valid. Pastikan angka sesuai daftar!");}

                    break;
                case 3:
                    loop = false;
                    break;
                default:
                    break;}}
    }
}