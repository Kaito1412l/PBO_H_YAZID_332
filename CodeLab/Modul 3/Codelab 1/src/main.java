import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //Menyatakan Objek
        karakterUmum brimstone = new pahlawan("Brimstone", 150);
        karakterUmum viper = new musuh("Viper", 200);

        //Menampilkan Status Awal Karakter
        System.out.println("Status awal:");
        System.out.println(brimstone.getNama() + " memiliki kesehatan: " + brimstone.getKesehatan());
        System.out.println(viper.getNama() + " memiliki kesehatan: " + viper.getKesehatan());

        //Memanggil Scanner Dan Menyatakan Variabel Pilihan & Boolean
        Scanner scan = new Scanner(System.in);
        int pilihan;
        boolean isPertarunganBerlanjut = true;

        //Melakukan Looping
        do {//Menampilkan Pilihan Penyerangan
            System.out.println("\n=== Pilih Karakter yang akan menyerang ===");
            System.out.println("1. Pahlawan - Brimstone");
            System.out.println("2. Musuh - Viper");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = scan.nextInt();

            switch (pilihan) {
                case 1: //Pahlawan Menyerang Musuh
                        System.out.println("Anda memilih Brimstone untuk menyerang Viper!");
                        brimstone.serang(viper);
                        //Memeriksa Kondisi Karakter
                        if (viper.getKesehatan() <= 0) {
                            System.out.println("Viper telah dikalahkan! Pahlawan menang!");
                            isPertarunganBerlanjut = false;}
                        break;
                case 2: //Musuh Menyerang Pahlawan
                        System.out.println("Anda memilih Viper untuk menyerang Brimstone!");
                        viper.serang(brimstone);
                        //Memeriksa Kondisi Karakter
                        if (brimstone.getKesehatan() <= 0) {
                            System.out.println("Brimstone telah dikalahkan! Musuh menang!");
                            isPertarunganBerlanjut = false;}
                        break;
                case 3: //Keluar
                        System.out.println("Pertarungan berakhir. Terima kasih telah bermain!");
                        isPertarunganBerlanjut = false;
                        break;
                default:// Pilihan tidak valid
                        System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                        break;}}
        //Memberhentikan Ketika Kondisi False
        while (isPertarunganBerlanjut);

        //Memulangkan Scanner
        scan.close();}}