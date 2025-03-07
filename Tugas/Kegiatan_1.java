import java.util.Scanner;

public class Kegiatan_1 {
    //Menyatakan Variabel Final/CONST Untuk Username dan Password
    final String kuadmin = "admin332";
    final String kpadmin = "password332";
    final String kusiswa = "Nur Muhammad Yazid Salim";
    final String kpsiswa = "202410370110332";

    public static void main(String[] args) {
        //inisialisasi untuk memanggil kegiatan 1
        Kegiatan_1 program = new Kegiatan_1();
        program.runProgram();}

    public void runProgram() {
        //Memanggil Scanner
        Scanner scan = new Scanner(System.in);

        //Menampilkan Tampilan Awal atau Pilihan Program Login
        System.out.println("==========Program Dimulai==========");
        System.out.println("Pilih Login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");

        //Meminta Input Pilihan Login
        System.out.print("Masukkan Pilihan: ");
        int pilihan = scan.nextInt();
        //Membersihkan Buffer Input pada Scanner
        scan.nextLine();

        //Memproses Input Pilihan
        switch (pilihan){
            case 1 -> loginAdmin(scan);
            case 2 -> loginMahasiswa(scan);
            default ->System.out.println("\nPilihan tidak valid");}

        //Memulangkan Scanner
        scan.close();}

    //Method untuk login admin
    private void loginAdmin(Scanner scan) {
        //Memproses Pilihan Login Admin
        System.out.print("Masukkan Username: ");
        String user = scan.nextLine();
        System.out.print("Masukkan Password: ");
        String pass = scan.nextLine();

        //Melakukan Proses Validasi/Pengecekan Username dan Password
        if ((kuadmin.equals(user)) && (kpadmin.equals(pass)))
           {System.out.println("\nLogin Admin Berhasil");}
        else
           {System.out.println("\nLogin Gagal! Username atau Password Salah");}}

    //Method untuk login mahasiswa
    private void loginMahasiswa(Scanner scan) {
        //Memproses Pilihan Login Mahasiswa
        System.out.print("Masukkan Nama: ");
        String user = scan.nextLine();
        System.out.print("Masukkan NIM: ");
        String pass = scan.nextLine();

        //Melakukan Proses Validasi/Pengecekan Username dan Password
        if ((kusiswa.equals(user)) && (kpsiswa.equals(pass)))
           {//Menampilkan Data Login Mahasiswa
            System.out.println("\nLogin Mahasiswa Berhasil");
            System.out.println("Nama: " + kusiswa);
            System.out.println("NIM: " + kpsiswa);}
        else
           {System.out.println("\nLogin Gagal! Nama atau NIM Salah");}}
    }
