package app;

import perpustakaan.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Memanggil Class Buku dan Anggota
        Buku bukuNonFiksi = new NonFiksi("Madilog", "Tan Malaka");
        Buku bukuFiksi = new Fiksi("Hainuwele: Sang Putri Kelapa", "Lilis Hu");

        Anggota anggota1 = new Anggota("Nur Muhammad Yazid Salim", "332");
        Anggota anggota2 = new Anggota("Reyhan Aditya Prasetyo", "358");

        // Memanggil Scanner
        Scanner scanner = new Scanner(System.in);

        // Menampilkan info Buku dan Anggota
        System.out.println();
        bukuNonFiksi.displayInfo();
        bukuFiksi.displayInfo();
        System.out.println();

        System.out.println("Anggota: 1. " + anggota1.getNama() + " (ID: " + anggota1.getIdAnggota() + ")");
        System.out.println("Anggota: 2. " + anggota2.getNama() + " (ID: " + anggota2.getIdAnggota() + ")");

        // Meminta input pilihan anggota
        System.out.print("Pilih anggota (1 atau 2): ");
        int pilihanAnggota = scanner.nextInt();
        scanner.nextLine();

        // Memproses input pilihan anggota
        Anggota anggotaTerpilih;
        if (pilihanAnggota == 1)
           {anggotaTerpilih = anggota1;}
        else if (pilihanAnggota == 2)
                {anggotaTerpilih = anggota2;}
        else
            {System.out.println("Pilihan anggota tidak valid.");
             scanner.close();
             return;}

        // Menampilkan pilihan proses
        System.out.println("\nPilih aksi:");
        System.out.println("1. Pinjam buku");
        System.out.println("2. Kembalikan buku");

        // Meminta input pilihan proses
        System.out.print("Masukkan pilihan (1 atau 2): ");
        int pilihanAksi = scanner.nextInt();
        scanner.nextLine();

        // Memproses input pilihan proses peminjaman
        if (pilihanAksi == 1)
            // Menampilikan pilihan buku
           {System.out.println("\nPilih buku yang ingin dipinjam:");
            System.out.println("1. " + bukuNonFiksi.getJudul());
            System.out.println("2. " + bukuFiksi.getJudul());

            // Meminta input pilihan buku
            System.out.print("Masukkan pilihan buku (1 atau 2): ");
            int pilihanBuku = scanner.nextInt();
            scanner.nextLine();

            // Memproses input pilihan buku
            String judulBuku;
            if (pilihanBuku == 1)
               {judulBuku = bukuNonFiksi.getJudul();}
            else if (pilihanBuku == 2)
                    {judulBuku = bukuFiksi.getJudul();}
            else
                {System.out.println("Pilihan buku tidak valid.");
                 scanner.close();
                 return;}

            // Meminta input durasi peminjaman
            System.out.print("\nMasukkan durasi peminjaman (hari): ");
            int durasi = scanner.nextInt();
            scanner.nextLine();

            // Menampilkan data akhir
            System.out.println();
            anggotaTerpilih.pinjamBuku(judulBuku, durasi);}

        // Memproses input pilihan proses peminjaman
        else if (pilihanAksi == 2)
                // Menampilkan pilihan buku
                {System.out.println("\nPilih buku yang ingin dikembalikan:");
                 System.out.println("1. " + bukuNonFiksi.getJudul());
                 System.out.println("2. " + bukuFiksi.getJudul());

                 // Meminta input pilihan buku
                 System.out.print("Masukkan pilihan buku (1 atau 2): ");
                 int pilihanBuku = scanner.nextInt();
                 scanner.nextLine();

                 // Memproses input pilihan buku
                 String judulBuku;
                 if (pilihanBuku == 1)
                    {judulBuku = bukuNonFiksi.getJudul();}
                 else if (pilihanBuku == 2)
                         {judulBuku = bukuFiksi.getJudul();}
                 else
                    {System.out.println("Pilihan buku tidak valid.");
                     scanner.close();
                     return;}

                 // Menampilkan data akhir
                 System.out.println();
                 anggotaTerpilih.kembalikanBuku(judulBuku);}
        else
            {System.out.println("Pilihan aksi tidak valid.");}

        // Memulangkan Scanner
        scanner.close();
    }
}