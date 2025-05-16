package com.manajemen.app;
import com.manajemen.stok.Barang;
import com.manajemen.exception.StokTidakCukupException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManajemenStok {
    private static final ArrayList<Barang> daftarBarang = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            int pilihan = tampilkanMenu();
            switch (pilihan) {
                case 1:
                    tambahBarangBaru();
                    break;
                case 2:
                    tampilkanSemuaBarang();
                    break;
                case 3:
                    kurangiStokBarang();
                    break;
                case 0:
                    System.out.println("\n========== Program berakhir ==========");
                    running = false;
                    break;
                default:
                    System.out.println("\nPilihan tidak valid.");}}
        scanner.close();
    }


    public static int tampilkanMenu() {
        System.out.println("\n========== Menu Manajemen Stok ==========");
        System.out.println("1. Tambah Barang Baru");
        System.out.println("2. Tampilkan Semua Barang");
        System.out.println("3. Kurangi Stok Barang");
        System.out.println("0. Keluar");
        System.out.print("Masukkan Pilihan: ");

        try
            {return scanner.nextInt();}
        catch (InputMismatchException e)
            {System.out.print("\nInput harus berupa angka!");
             scanner.nextLine();
             return -1;}}


    public static void tambahBarangBaru() {
        scanner.nextLine();
        System.out.print("\nMasukkan nama barang: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan stok awal: ");

        try
            {int stok = scanner.nextInt();
             scanner.nextLine();
             daftarBarang.add(new Barang(nama, stok));
             System.out.println("\nBarang '" + nama + "' berhasil ditambahkan.");}
        catch (InputMismatchException e)
            {System.out.println("\nInput stok harus berupa angka!");
             scanner.nextLine();}}


    public static void tampilkanSemuaBarang() {
        if (daftarBarang.isEmpty())
            {System.out.println("\nStok barang kosong.");}
        else
            {System.out.println("\n----- Daftar Barang -----");
             for (int i = 0; i < daftarBarang.size(); i++)
                {Barang b = daftarBarang.get(i);
                 System.out.println((i + 1) + ". Nama: " + b.getNama() + "  Stok: " + b.getStok());}}}


    public static void kurangiStokBarang() {
        if (daftarBarang.isEmpty())
            {System.out.println("\nTidak ada barang untuk dikurangi stok.");
             return;}

        tampilkanSemuaBarang();

        try {System.out.print("\nMasukkan nomor indeks barang: ");
             int index = scanner.nextInt();
             index -= 1;

             if (index < 0 || index >= daftarBarang.size())
                {throw new IndexOutOfBoundsException();}

             System.out.print("Masukkan jumlah stok yang akan diambil: ");
             int jumlah = scanner.nextInt();
             scanner.nextLine();

             Barang barang = daftarBarang.get(index);

             if (jumlah > barang.getStok())
                {throw new StokTidakCukupException("\nStok untuk " + barang.getNama() + " hanya tersisa " + barang.getStok());}

            barang.setStok(barang.getStok() - jumlah);
            if (barang.getStok() == 0)
                {daftarBarang.remove(index);
                 System.out.println("Stok barang habis, barang '" + barang.getNama() + "' dihapus dari daftar.");}
            else
                {System.out.println("Stok barang '" + barang.getNama() + "' berhasil dikurangi. Sisa stok: " + barang.getStok());}}
        catch (InputMismatchException e)
            {System.out.println("\nInput harus berupa angka!");
             scanner.nextLine();}
        catch (IndexOutOfBoundsException e)
            {System.out.println("\nIndeks barang tidak valid!");}
        catch (StokTidakCukupException e)
            {System.out.println(e.getMessage());}
    }
}