import java.util.Scanner;

public class mahasiswa {
    //Menyatakan Variabel Final/CONST Untuk Username dan Password
    final String kusiswa = "Nur Muhammad Yazid Salim";
    final String kpsiswa = "202410370110332";
    Scanner inputMahasiswa =  new Scanner(System.in);

    //Method untuk login mahasiswa
    void login() {
        //Memproses Pilihan Login Mahasiswa
        System.out.print("Masukkan Nama: ");
        String mUser = inputMahasiswa.nextLine();
        System.out.print("Masukkan NIM: ");
        String mPass = inputMahasiswa.nextLine();

        //Melakukan Proses Validasi/Pengecekan Username dan Password
        if ((kusiswa.equals(mUser)) && (kpsiswa.equals(mPass)))
           {//Menampilkan Data Login Mahasiswa yang login
            displayInfo();}
        else
        {System.out.println("\nLogin Gagal! Nama atau NIM Salah.");}

        //Memulangkan Scanner
        inputMahasiswa.close();}

    //Method Untuk Info Mahasiswa
    void displayInfo(){
        System.out.println("\nLogin Mahasiswa Berhasil.\n");
        System.out.println("Menampilkan Info Mahasiswa:");
        System.out.println("Nama: " + kusiswa);
        System.out.println("NIM: " + kpsiswa);}
}